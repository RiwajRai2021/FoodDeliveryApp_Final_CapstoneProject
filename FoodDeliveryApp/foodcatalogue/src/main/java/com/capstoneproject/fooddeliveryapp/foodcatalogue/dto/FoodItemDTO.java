package com.capstoneproject.fooddeliveryapp.foodcatalogue.dto;



public class FoodItemDTO {

	private int id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private Long  price;
	private Integer restaurantId;
	private Integer quantity;

	public FoodItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItemDTO(int id, String itemName, String itemDescription, boolean isVeg, Long price, Integer restaurantId,
			Integer quantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.isVeg = isVeg;
		this.price = price;
		this.restaurantId = restaurantId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FoodItemDTO [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", isVeg="
				+ isVeg + ", price=" + price + ", restaurantId=" + restaurantId + ", quantity=" + quantity + "]";
	}

}
