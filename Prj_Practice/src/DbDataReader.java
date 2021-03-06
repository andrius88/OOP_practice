
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDataReader {
	
	List<Dish> dishList1 = new ArrayList<Dish>();
	List<Dish> dishList2 = new ArrayList<Dish>();
	List<Dish> dishList3 = new ArrayList<Dish>();
	List<Dish> dishList4 = new ArrayList<Dish>();
	List<DishCategory> mainList = new ArrayList<DishCategory>();
	
	public void readDishData(){
		
		String id, catId;
		String dishName, dishDescription, pictureFileName;
		float dishPrice;
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/cofee","root","sysop");  
			  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from patiekalai");  
			while(rs.next()){  
				id = rs.getString(1);
	            catId = rs.getString(2);
	            dishName = rs.getString(3);
	            dishPrice = rs.getFloat(4);
	            dishDescription = rs.getString(5);
	            pictureFileName = rs.getString(6);
	            makeDishLists(id, catId, dishName, dishPrice, dishDescription, pictureFileName);
			}
			con.close();  
			}catch(Exception e)
				{ System.out.println(e);}
		
		//System.out.println(id + " " + catId + " " + dishName );
			
		
	}
	
	public void makeDishLists(String id, String catId, String  dishName, float dishPrice, String  dishDescription, String pictureFileName){
		
		Dish anyDish = new Dish();
		anyDish.setId(id);
		anyDish.setCatId(catId);
		anyDish.setDishName(dishName);
		anyDish.setDishPrice(dishPrice);
		anyDish.setDishDescription(dishDescription);
		anyDish.setPictureFileName(pictureFileName);
		
		switch(catId) {
		  case "kat1":
			dishList1.add(anyDish);
		    break;
		  case "kat2":
			dishList2.add(anyDish);
		    break;
		  case "kat3":
			dishList3.add(anyDish);
			break;
		  case "kat4":
			dishList4.add(anyDish);
			break;
		}
		
		/*for (int k=0; k< dishList1.size(); k++){
			System.out.println(dishList1.get(k).getId() + " " + dishList1.get(k).getCatId());
		}*/
			
	}
	
	public List<DishCategory> readMainList(){
		String readLine, categoryName;
		int catId;
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/cofee","root","sysop");  
			  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from kategorijos");  
			while(rs.next()){  
				catId = rs.getInt(1);
				categoryName = rs.getString(2);
				
				DishCategory dishCat = new DishCategory();
	    		dishCat.setCategoryID(catId);
	    		dishCat.setCategoryName(categoryName);
	    		
	    		switch(catId) {
		  		  case 1:
		  			dishCat.dishList = this.dishList1;
		  			mainList.add(dishCat);
		  		    break;
		  		  case 2:
		  			dishCat.dishList = this.dishList2;
		  			mainList.add(dishCat);
		  		    break;
		  		  case 3:
		  			dishCat.dishList = this.dishList3;
		  			mainList.add(dishCat);
		  			break;
		  		  case 4:
		  			dishCat.dishList = this.dishList4;
		  			mainList.add(dishCat);
		  			break;
		  		}	
			}
			
			con.close();  
			}catch(Exception e)
				{ System.out.println(e);}
		
		return mainList;
		
	}

}
