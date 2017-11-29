package pl.kolton.shopbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", ");
		if (code != null) {
			builder.append("code=");
			builder.append(code);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (brand != null) {
			builder.append("brand=");
			builder.append(brand);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		builder.append("unitPrice=");
		builder.append(unitPrice);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", purchases=");
		builder.append(purchases);
		builder.append(", views=");
		builder.append(views);
		builder.append("]");
		return builder.toString();
	}

	// Uniqe, random code for each product
	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	/*
	 * Private fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String code;

	@NotBlank(message = "Proszę podać nazwę produktu!")
	private String name;

	@NotBlank(message = "Proszę podać markę produktu!")
	private String brand;

	@NotBlank(message = "Proszę podać opis produktu!")
	private String description;

	@Column(name = "unit_price")
	@Min(value = 1, message="Cena nie może być niższa niż 1PLN!")
	private double unitPrice;

	private int quantity;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;

	@Column(name = "supplier_id")
	@JsonIgnore
	private int supplierId;

	private int purchases;

	private int views;

	@Transient
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
