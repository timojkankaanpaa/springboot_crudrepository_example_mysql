package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Order;
import repository.OrderRepository;

	@Controller
	public class OrderController {
	
	@Autowired
	private OrderRepository repository;

	@RequestMapping("/")
	@ResponseBody
	public String test() {
		Order order = new Order();
	    repository.save(order);
	    return "hello";
	}
}