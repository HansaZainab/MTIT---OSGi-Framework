package customerproducer;

import java.util.Scanner;


public class OnlineBuyingImpl implements OnlineBuyingPublish {
	private final int SugarMilkpowderTealeaves = 1500;
	private final int FloursaultRice = 1800;
	private final int StrawberriesIcecream = 800;
	private final int ChipsCoc = 600;
	



	private int GroceryPackType;
	private int noOfGroceryPack;
	 
	private double totalBill;


		public void OnlineBuyingReserveHandle(String Fname) {
			
				Scanner scan = new Scanner(System.in);
				
					System.out.println("\n====ONLINE GROCERY SHOPPING====");
					System.out.println("Select item type\n 1. Sugar,Milk Powder, Tea Leaves \n 2. Flour, Sault, Rice \n 3.Strawberries, Ice-Cream \n 4.Chips and Coca-cola ");
					System.out.print("Enter Grocery Package Number:");
					GroceryPackType = scan.nextInt();
					System.out.print("Enter number of Grocery Packages:");
					noOfGroceryPack = scan.nextInt();
					

					totalBill = calculatetotalbill(GroceryPackType,noOfGroceryPack);
					System.out.println("\n-----Your Bill-----");
					System.out.println("Name: " + Fname);
					System.out.println("Your Totall Bill is: Rs." + totalBill);
					System.out.println("!!!Have a good meal!!!");
}


		private double calculatetotalbill(int GroceryPackType, int noOfGroceryPack) {
			
			
				double r = 0;
				if(GroceryPackType == 1) {
					
						r = (SugarMilkpowderTealeaves * noOfGroceryPack);
					
				}
				else if (GroceryPackType == 2) {
					
						r = (FloursaultRice * noOfGroceryPack);
					
				}
				else if (GroceryPackType == 3) {
					
					r = (StrawberriesIcecream * noOfGroceryPack);
			    }
				
				else if (GroceryPackType == 4) {
					
					r = (ChipsCoc * noOfGroceryPack);
				}
				
				else {
					System.out.println("INVALID Grocery TYPE!");
				}

				return r;
		}
	
	
	
	

}
