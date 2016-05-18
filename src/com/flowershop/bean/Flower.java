package com.flowershop.bean;

public class Flower {
	private Integer flowerId = 0;
	private String flowerName = "鲜花";
	private String flowerCategary = "-1";
	private String flowerPicture = "";
	private String flowerDescribe = "";
	private String flowePrice = "";
	public Integer getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getFlowerCategary() {
		return flowerCategary;
		/*if(Integer.valueOf(flowerCategary) == 0)
			return "爱情鲜花";
		else if(Integer.valueOf(flowerCategary) == 1)
			return "亲情鲜花";
		else if(Integer.valueOf(flowerCategary) == 2)
			return "友情鲜花";
		else
			return "鲜花";*/
	}
	public void setFlowerCategary(String flowerCategary) {
		this.flowerCategary = flowerCategary;
	}
	public String getFlowerPicture() {
		return flowerPicture;
	}
	public void setFlowerPicture(String flowerPicture) {
		this.flowerPicture = flowerPicture;
	}
	public String getFlowerDescribe() {
		return flowerDescribe;
	}
	public void setFlowerDescribe(String flowerDescribe) {
		this.flowerDescribe = flowerDescribe;
	}
	public String getFlowePrice() {
		return flowePrice;
	}
	public void setFlowePrice(String flowePrice) {
		this.flowePrice = flowePrice;
	}
	
	
}
