import java.util.*;


public class MainApp {

	public static void main(String[] args) {
		
		DbDataReader DbDatareader = new DbDataReader();
		DbDatareader.readDishData();									//Reading file 'patieklai.txt'
		
		List<DishCategory> mainList =  DbDatareader.readMainList(); 	//makeMainList();  //Reading file 'kategorijos.txt'
		
		/*List<Dish> dishCat1 =  mainList.get(0).getDishList();			// just for testing
		
		for (int i = 0; i < dishCat1.size(); i++){						
			//System.out.println("Id: " + dishCat1.get(i).getId());
			//System.out.println("CatId: " + dishCat1.get(i).getCatId());
		}*/
		
		JavaWindow javaWin = new JavaWindow(mainList);

	}

}
