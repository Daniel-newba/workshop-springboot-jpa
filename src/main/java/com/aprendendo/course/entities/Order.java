package com.aprendendo.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.aprendendo.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	private Integer orderstatus;

	
	public Order() {
		
	}

	public Order(Long id, Instant moment, User client, OrderStatus orderstatus) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderstatus(orderstatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public OrderStatus getOrderstatus() {
		return OrderStatus.valueOf(orderstatus);
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		if (orderstatus != null) {
		this.orderstatus = orderstatus.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
}
