package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Order;
import repository.OrderRepository;
import view.Application;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository repository;
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
    @RequestMapping("/test")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }
    
	@RequestMapping("/orders")
	public Iterable<Order> getOrders(@RequestParam(value="name", defaultValue="1") String name)  {
	    return repository.findAll();
	}
	
	@RequestMapping("/order")
	public Order getOrder(@RequestParam(value="id", defaultValue="7") int id)  {
	    return repository.findOne(id);
	}	
}