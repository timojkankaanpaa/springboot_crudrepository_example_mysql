package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * The persistent class for the `ORDER` database table.
 * 
 */
@Entity
@Table(name="`ORDER`")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int customer;

	private Timestamp date;

	private int payment;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer() {
		return this.customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public Timestamp getDate() {
		return this.date;
	}

	
	public String getDateString() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyy");
		return format1.format(date.getTime());
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getPayment() {
		return this.payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		Calendar start = Calendar.getInstance();
		start.setTimeInMillis(date.getTime() );
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyy");
		return "Order [id=" + id + ", customer=" + customer + ", date=" + format1.format(start.getTime()) + ", payment=" + payment + "]";
	}

}