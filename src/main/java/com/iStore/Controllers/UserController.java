package com.iStore.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStore.Entity.Cart;
import com.iStore.Entity.OrderDetails;
import com.iStore.Entity.Orders;
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
	public List<Cart> getAllFromCart(@PathVariable int userId) {
		return cartrepo.findAllByUserId(userId);
	}

	@PostMapping("/cart/{productId}")
	public Cart addToCart(@PathVariable int userId, @PathVariable int productId) {

		Cart cart = new Cart();
		cart.setProdId(productId);
		cart.setUserId(userId);
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
	public List<OrderDetails> getAllFromOrders(@PathVariable int userId) {
		List<Orders> orderlist = ordersrepo.findAllByUserId(userId);
		List<OrderDetails> orderdetaillist = new ArrayList<OrderDetails>();
		for (int i = 0; i < orderlist.size(); i++) {
			// Orders orders = orderlist.get(i);
			// OrderDetails orderdetails = ordetrepo.findByOrders(orders);
			// orderdetaillist.add(orderdetails);
			orderdetaillist.add(ordetrepo.findByOrderId(orderlist.get(i).getOrderId()));
		}
		return orderdetaillist;
	}

	@PostMapping("/orders")
	public void addToOrders(@PathVariable int userId) {
		List<Cart> cartlist = cartrepo.findAllByUserId(userId);
		Orders orders = new Orders();
		orders.setUserId(userId);
		ordersrepo.save(orders);
		int id = orders.getOrderId();
		for (int i = 0; i < cartlist.size(); i++) {
			OrderDetails orderdetails = new OrderDetails();
			orderdetails.setOrderId(id);
			orderdetails.setProductId(cartlist.get(i).getProdId());
			ordetrepo.save(orderdetails);
		}
	}

}
