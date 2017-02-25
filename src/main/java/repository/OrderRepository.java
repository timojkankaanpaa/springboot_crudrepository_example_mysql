package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	List<Order> findById(int id);
}
