package com.iStore.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStore.Entity.Cart;
import com.iStore.Entity.OrderDetails;
import com.iStore.Entity.Orders;
import com.iStore.Entity.Products;
import com.iStore.Entity.User;
import com.iStore.Repository.CartRepo;
import com.iStore.Repository.OrderDetailsRepo;
import com.iStore.Repository.OrdersRepo;
import com.iStore.Repository.ProductsRepo;
import com.iStore.Repository.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/{userId}")
public class UserController {

	@Autowired
	UserRepo userrepo;
	@Autowired
	CartRepo cartrepo;
	@Autowired
	ProductsRepo prodrepo;
	@Autowired
	OrdersRepo ordersrepo;
	@Autowired
	OrderDetailsRepo ordetrepo;

	@GetMapping("")
	public User getProfile(@PathVariable int userId) {
		return userrepo.findById(userId).orElse(new User());
	}

	@PostMapping("")
	public User setProfile(User user) {
		userrepo.save(user);
		return user;
	}

	@GetMapping("/cart")
	public List<Products> getAllFromCart(@PathVariable int userId) {
		List<Cart> cartlist = cartrepo.findAllByUserId(userId);
		List<Products> productlist = new ArrayList<>();
		for (int i = 0; i < cartlist.size(); i++) {
			Cart cart = cartlist.get(i);
			Products products = prodrepo.findById(cart.getProdId()).orElse(null);
			products.setProductNos(cart.getProductNos());
			productlist.add(products);
		}
		return productlist;
	}
	
	@GetMapping("/cart/{productId}")
	public boolean isInCart(@PathVariable int userId, @PathVariable int productId) {
		List<Cart> cartlist = cartrepo.findAllByUserId(userId);
		for(int i=0;i<cartlist.size();i++) {
			if(productId == cartlist.get(i).getProdId()) {
				return true;
			}
		}
		return false;
	}

	@PostMapping("/cart/{productId}")
	public Cart addToCart(@PathVariable int userId, @PathVariable int productId) {

		Cart cart = new Cart();
		cart.setProdId(productId);
		cart.setUserId(userId);
		cart.setProductNos(1);
		cartrepo.save(cart);
		return cart;

	}

	@DeleteMapping("/cart/{cartId}")
	public void deleteFromCart(@PathVariable int userId, @PathVariable int cartId) {
		cartrepo.deleteById(cartId);
	}

	@DeleteMapping("/cart")
	public void deleteFromCart(@PathVariable int userId) {
		List<Cart> cartlist = cartrepo.findAllByUserId(userId);
		for (int i = 0; i < cartlist.size(); i++) {
			cartrepo.deleteById(cartlist.get(i).getCartId());
		}
	}

	@GetMapping("/orders")
	public List<Products> getAllFromOrders(@PathVariable int userId) {
		List<Orders> orderlist = ordersrepo.findAllByUserId(userId);
		List<Products> productslist = new ArrayList<Products>();
		for (int i = 0; i < orderlist.size(); i++) {
			int id = orderlist.get(i).getOrderId();
			List<OrderDetails> orderdetails = ordetrepo.findAllByOrderId(id);
			for (int j = 0; j < orderdetails.size(); j++) {
				Products product = prodrepo.findById((orderdetails.get(j)).getProductId()).orElse(null); 
				product.setProductNos((orderdetails.get(j)).getProductNos());
				productslist.add(product);
				System.out.println(productslist);
			}
		}
		System.out.println(productslist);
		return productslist;
	}

	@PostMapping("/orders")
	public void addToOrders(@PathVariable int userId, @RequestBody List<Products> products) {
		Orders orders = new Orders();
		orders.setUserId(userId);
		ordersrepo.save(orders);
		int id = orders.getOrderId();
		for (int i = 0; i < products.size(); i++) {
			OrderDetails orderdetails = new OrderDetails();
			orderdetails.setOrderId(id);
			orderdetails.setProductId(products.get(i).getProductId());
			orderdetails.setProductNos(products.get(i).getProductNos());
			ordetrepo.save(orderdetails);
		}
	}

}
