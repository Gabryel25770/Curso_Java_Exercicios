package entities;

public class OrderItem {
	private int quantity;
	private double price;
	private Product product;
	
	public OrderItem() {} 
	
	public OrderItem(int quantity, double price, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public double subTotal() {
		setPrice(product.getPrice()*quantity);
		return getPrice();
	}
	
}
