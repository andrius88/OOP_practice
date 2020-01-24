import javax.swing.*;


public class JButtonPlus extends  JButton{
	
	private String dishName;
	private float price;
	
	JButtonPlus(String name){
		super(name);
	}
	
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
