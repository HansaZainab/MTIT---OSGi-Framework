package delivery_consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import deliverysystem.DeliverySystemPublish;

public class DeliveryConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
System.out.println("Consumer Started");
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("!!!!! Welcome to the Delivery Service !!!!!");
		System.out.print("Enter Your Address:");
		String Yaddress = scn.nextLine();
		System.out.println("1.Enter in to Delivery ");
		System.out.print("Please Enter Your LandMarks : ");
		int deliveryType = scn.nextInt();
		switch(deliveryType) {
			case 1:
					serviceReference = bundleContext.getServiceReference(DeliverySystemPublish.class.getName());
					DeliverySystemPublish deliversystempublish = (DeliverySystemPublish)bundleContext.getService(serviceReference);
					deliversystempublish.DeliverSystemReserveHandle(Yaddress);
			        break;
			        
//			case 2:
//					serviceReference = context.getServiceReference(BackhoePublish.class.getName());
//					BackhoePublish backhoePublish = (BackhoePublish)bundleContext.getService(serviceReference);
//					backhoePublish.backhoeReserveHandle(Address);
//					break;
//			case 3:
//					serviceReference = context.getServiceReference(LorryPublish.class.getName());
//					LorryPublish lorryPublish = (LorryPublish)bundleContext.getService(serviceReference);
//					lorryPublish.LorryReserveHandle(Address);
//					break;
//			case 4: 
//					serviceReference = context.getServiceReference(CarPublish.class.getName());
//					CarPublish carPublish = (CarPublish)bundleContext.getService(serviceReference);
//					carPublish.CarReserveHandle(Address);
//					break;
			
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Consumer Stoped");
		bundleContext.ungetService(serviceReference);
	}

}
