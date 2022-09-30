package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;

@Controller
public class ProductAndOrderServiceController {
	@Autowired
	private RestTemplate template;
	private Product productsArray[];
	private Order ordersArray[];
	public ProductAndOrderServiceController() {
		super();
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getWelcomePage() {
		return "index";
	}

	// <------------------------Product
	// Controller------------------------------------->

	@RequestMapping(path = "/product-home", method = RequestMethod.GET)
	public String getProductHomePage() {
		return "producthomepage";
	}

	@RequestMapping(path = "/order-home", method = RequestMethod.GET)
	public String getOrderHomePage() {
		return "orderhomepage";
	}

	@GetMapping(path = "/list/products")
	public String getAllProducts(Model model) {
		productsArray = this.template.getForObject("http://localhost:5050/api/products", Product[].class);
		model.addAttribute("list", productsArray);
		return "showallproducts";
	}

	@GetMapping(path = "/list/available")
	public String getProductsWithInventoryGreaterThanZero(Model model) {
		productsArray = this.template.getForObject("http://localhost:5050/api/products/available", Product[].class);
		model.addAttribute("list", productsArray);
		return "showallproducts";
	}

	@GetMapping(path = "/list/not-available")
	public String getProductsWithInventoryEqualToZero(Model model) {
		productsArray = this.template.getForObject("http://localhost:5050/api/products/not-available", Product[].class);
		model.addAttribute("list", productsArray);
		return "showallproducts";
	}

	@RequestMapping(path = "/save", method = RequestMethod.GET)
	public String initAddPage(Model model) {
		model.addAttribute("product", new Product());
		return "addproduct";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String addOrUpdateProduct(@ModelAttribute("product") Product product, Model model) {
		productsArray = this.template.getForObject("http://localhost:5050/api/products", Product[].class);
		HttpEntity<Product> request = new HttpEntity<>(product);
		this.template.postForObject("http://localhost:5050/api/products/add", request,Product.class);
		boolean needToUpdate=false;
		for (Product eachProduct : productsArray) {
			if(eachProduct.getProductId()==product.getProductId()) {
				needToUpdate=true;
				break;
			}
		}
		if(needToUpdate) {
			model.addAttribute("message", "one Record updated");
		}
		else {
			model.addAttribute("message", "one Record Added");
			
		}
		return "addproduct";
	}

	@RequestMapping(path = "/list/merchant", method = RequestMethod.GET)
	public String initSearchMerchant() {
		return "searchbymerchant";
	}

	@RequestMapping(path = "/list/merchant", method = RequestMethod.POST)
	public String searchByProductMerchant(@RequestParam("productMerchant") String productMerchant, Model model) {
		String message = new StringBuilder("Order with Given Product Merchant Name: ").append(productMerchant).append(" Not Found")
	.toString();
		productsArray= this.template.postForObject("http://localhost:5050/api/products/byMerchant",productMerchant, Product[].class);
		System.out.println(productsArray.length);
		if(productsArray.length!=0) {
			model.addAttribute("list",productsArray);
			return "showallproducts";
		}
		else {
			model.addAttribute("message", message);
			return "failure";
		}
	}

	// ------------------------Order Controller-----------------------------

	@GetMapping(path = "/list/orders")
	public String getAllOrders(Model model) {
		model.addAttribute("list", this.template.getForObject("http://localhost:8080/api/orders", Order[].class));
		return "showallorders";
	}
	
	@RequestMapping(path = "/saveOrder", method = RequestMethod.GET)
	public String initAddOrder(Model model) {
		LocalDate date=LocalDate.now();
		model.addAttribute("order", new Order(0, "",date, new Product(0)));
		return "addorder";
		
	}
	
	@RequestMapping(path = "/saveOrder", method = RequestMethod.POST)
	public String addOrUpdateOrder(@ModelAttribute("order") Order order, Model model) {
		ordersArray = this.template.getForObject("http://localhost:8080/api/orders", Order[].class);
		HttpEntity<Order> request = new HttpEntity<>(order);
		this.template.postForObject("http://localhost:8080/api/orders/add", request,Order.class);
		boolean needToUpdate=false;
		for (Order eachOrder : ordersArray) {
			if(eachOrder.getOrderId()==order.getOrderId()) {
				needToUpdate=true;
				break;
			}
		}
		if(needToUpdate) {
			model.addAttribute("message", "one Record updated");
		}
		else {
			model.addAttribute("message", "one Record Added");
			
		}
		return "addorder";
	}	
		
	
	@RequestMapping(path = "/list/user", method = RequestMethod.GET)
	public String initSearchByUsers() {
		return "searchbyuser";
	}

	@RequestMapping(path = "/list/user", method = RequestMethod.POST)
	public String searchByOrderUser(@RequestParam("user") String user, Model model) {
		Order[] orderList;
		String message = new StringBuilder("Order with Given user name: ").append(user).append(" Not Found").toString();
		orderList = this.template.postForObject("http://localhost:8080/api/orders/byUser", user, Order[].class);
		if (orderList.length != 0) {
			model.addAttribute("list", orderList);
			return "showallorders";
		} else {
			model.addAttribute("message", message);
			return "failure";
		}

	}

	@RequestMapping(path = "/orderId", method = RequestMethod.GET)
	public String initSearchById() {
		return "searchbyorderid";
	}

	@RequestMapping(path = "/orderId", method = RequestMethod.POST)
	public String searchByOrderId(@RequestParam("orderId") int orderId, Model model) {
		List<Order> orderList = new ArrayList<>();
		String message = new StringBuilder("Order with Given OrderId: ").append(orderId).append(" Not Found")
				.toString();
		orderList.add(this.template.postForObject("http://localhost:8080/api/orders/byOrderId", orderId, Order.class));
		if (orderList.get(0).getOrderId()!=0) {
			model.addAttribute("list", orderList);
			return "showallorders";
		} else {
			model.addAttribute("message", message);
			return "failure";
		}

	}

}
