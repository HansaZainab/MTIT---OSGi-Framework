package deliverysystem;

import java.util.Scanner;

public class DeliverySystemPublishImpl implements DeliverySystemPublish {
	
	
	private final int Express_DeliveryCharges = 700;
	private final int Normal_DeliveryCharges = 300;
	



	private int DeliveryType;
	private int numOfKm;
	 
	private double totalBill;


		public void DeliverSystemReserveHandle(String Yaddress) {
			
				Scanner scan = new Scanner(System.in);
				
					System.out.println("\n====Delivery Charges====");
					System.out.println("Select Delivery type\n 1. Express Delivery \n 2. Non E/P Delivery ");
					System.out.print("Enter Delivery Type:");
				    DeliveryType = scan.nextInt();
					System.out.print("Enter number of Hours:");
					numOfKm = scan.nextInt();
					

					totalBill = calculatetotalbill(DeliveryType,numOfKm);
					System.out.println("\n-----Your Bill-----");
					System.out.println("Your Address: " + Yaddress);
					System.out.println("Your Totall Delivery Charge is: Rs." + totalBill);
					System.out.println("!!!Wear Mask and Stay Safe!!!");
					System.out.println("Have a Great Year");
}           


		private double calculatetotalbill(int  DeliveryType, int numOfHours) {
			
			
				double r = 0;
				if(DeliveryType == 1) {
					
						r = (Express_DeliveryCharges * numOfKm);
					
				}
				else if (DeliveryType == 2) {
					
						r = (Normal_DeliveryCharges * numOfKm);
					
				}
				else {
					System.out.println("INVALID DELIVERY TYPE!");
				}

				return r;
		}

			
		}

			
	
	
	



