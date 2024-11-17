package com.xeno.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String Name;
    private String email;
    private String phone;

	private Double totalSpending;
    private Integer visits;
    private LocalDate lastVisitDate;
	    
    private String segmentName; // Ensure this field exists
    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Corder> orders;

    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    public Double getTotalSpending() {
		return totalSpending;
	}

	public void setTotalSpending(Double totalSpending) {
		this.totalSpending = totalSpending;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public LocalDate getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(LocalDate lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Corder> getOrders() {
		return orders;
	}

	public void setOrders(List<Corder> orders) {
		this.orders = orders;
	}
    public Customer() {}

    public Customer(String name, String email, String phone, Double totalSpending, Integer visits, LocalDate lastVisitDate) {
        this.Name = name;
        this.email = email;
        this.phone = phone;
        this.totalSpending = totalSpending;
        this.visits = visits;
        this.lastVisitDate = lastVisitDate;
    }


}
