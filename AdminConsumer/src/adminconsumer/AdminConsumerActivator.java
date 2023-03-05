package adminconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import adminproducer.AdminProducer;
import itemsproducer.ItemsProducer;

public class AdminConsumerActivator implements BundleActivator {

	ServiceReference serviceReference, serviceReferenceItems;
	Scanner sc = new Scanner(System.in);
	String decision = "y";
	boolean itemsSaveSuccMsg = false;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Adamin Consumer Service");
		serviceReference = context.getServiceReference(AdminProducer.class.getName());
		AdminProducer adminproducer = (AdminProducer) context.getService(serviceReference);
		
		serviceReferenceItems = context.getServiceReference(ItemsProducer.class.getName());
		ItemsProducer itemsproducer =(ItemsProducer) context.getService(serviceReferenceItems);
		
			
		System.out.println(adminproducer.myName());
		
		System.out.println("Choose a Option ?\n"
				+ "1. Add  Items\n"
				+ "2. Add a Delivery Person\n");
		String option = sc.next();
		int optionI = Integer.parseInt(option);
	
		switch (optionI) {
		  case 1:{
			  System.out.println("_________________________________ Online Shop Add Items _________________________________\n");
				System.out.println("Enter Item ID ?");
				String sID = sc.next();
				System.out.println("Enter Item Name ?");
				String sName = sc.next();
				System.out.println("Item Categorys :Clothes\tCosmetics\tElectronics\tFurnitures\tGroceryEnter\n Item Category ?");
				String sCategory = sc.next();
				System.out.println("Enter Item Price ?");
				String sPrice = sc.next();
				System.out.println("Enter Item Qty ?");
				String sQty = sc.next();
				
			  itemsproducer.addBItems(sID, sName , sCategory, sPrice, sQty);
			  break;
		  }
		  case 2:{
			  	System.out.println("_________________________________ Online Shop diver Registration _________________________________\n");
				System.out.println("Enter Your Name ?");
				String sName = sc.next();
				System.out.println("Enter Your Phone Number ?");
				String sPhone = sc.next();
				System.out.println("Enter Your User Name ?");
				String sUserName = sc.next();
				System.out.println("Enter Your Password ?");
				String sPassword = sc.next();

				adminproducer.insertDeliveryPreson(sName, sPhone , sUserName, sPassword);
				System.out.println(adminproducer.DeliveryPresonDisplay());	

		    break;
		   }
		  default:{
			  System.out.println("Wrong Input !!!");
			  break;
		  }
		  
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}