package com.learnspring.generic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Size(min=2, max=30)
	private String name;
	
	private Float price;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
//	@NotEmpty
	@JoinColumn(name="category_id")	
	private Category category;
	
	//Hibernate requires no-args constructor
    public Product(){
    	
    }
     
    public Product(int id, String name, Category c){
        this.id = id;
        this.name = name;
        this.category = c;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "category_id", nullable = false)
//	public Category getCategory() {
//		return category;
//	}
//	
//	public void setCategory(Category category) {
//		this.category = category;
//	}
}
