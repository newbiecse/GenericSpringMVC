package com.learnspring.generic.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String name;

//	@ElementCollection(targetClass=Product.class)
	@OneToMany(/*fetch = FetchType.LAZY,*/ mappedBy = "category", cascade=CascadeType.ALL)
//	@JoinTable(
//            name="PRODUCT",
//            joinColumns = @JoinColumn( name="CATEGORY_ID"),
//            inverseJoinColumns = @JoinColumn( name="ID")
//    )
	private Set<Product> product;

	/** getter & setter */
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
	public String toString() {
		return "id=" + id + ", name=" + name;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}