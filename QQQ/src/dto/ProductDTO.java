package dto;

import java.io.Serializable;

public class ProductDTO implements Serializable{
	private String productId;
	private String productName;
	private int price;
	private int quantity;
	private String imageName;
	private String description;
	
	public ProductDTO() {
		
	}

	public ProductDTO(String productId, String productName, int price) {
		
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public ProductDTO(String productId, String productName, int price, int quantity) {
		
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public ProductDTO(String productId, String productName, int price, String imageName, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.imageName = imageName;
		this.description = description;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", imageName=" + imageName + ", description=" + description + "]";
	}

	

	
}
