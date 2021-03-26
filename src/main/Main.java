package main;


public class Main {
	
	public static Controller controller = new Controller();
	public static APIController aPIController = new APIController();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String response = controller.initialize();
		if (response.equals("Y")) {
			aPIController.getRandomPopularRecipe();
		}
//		aPIController.GetRandomPopularRecipe();
	}

}
