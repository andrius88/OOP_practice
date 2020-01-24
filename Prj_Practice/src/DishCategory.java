import java.util.*;

public class DishCategory {
	
	private int categoryID;
	private String categoryName;
	List<Dish> dishList = new ArrayList<Dish>();

	
	public List<Dish> getDishList(){
		return this.dishList;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
