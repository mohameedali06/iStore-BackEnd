package com.iStore.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iStore.Entity.Products;
import com.iStore.Repository.ProductsRepo;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductsRepo prodrepo;

	@GetMapping("")
	public List<Products> getAllProducts() {
		return prodrepo.findAll();
	}

	@GetMapping("/{productId}")
	public Optional<Products> getProduct(@PathVariable int productId) {
		return prodrepo.findById(productId);
	}

}
