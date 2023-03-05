package customerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import customerproducer.OnlineBuyingPublish;


public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
System.out.println("Consumer Started");
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("!!!!! Let's do ONLINE SHOPPING !!!!!");
		System.out.print("Enter Your Full Name:");
		String Fname = scn.nextLine();
		System.out.println("1. Grocery Packages\n2. Clothes");
		System.out.print("Please Select the thing number: ");
		int thing = scn.nextInt();
		switch(thing) {
			case 1:
					serviceReference = bundleContext.getServiceReference(OnlineBuyingPublish.class.getName());
					OnlineBuyingPublish singleroompublish = (OnlineBuyingPublish)bundleContext.getService(serviceReference);
					singleroompublish.OnlineBuyingReserveHandle(Fname);
			        break;
			        
//			case 2:
//					serviceReference = context.getServiceReference(BackhoePublish.class.getName());
//					BackhoePublish backhoePublish = (BackhoePublish)bundleContext.getService(serviceReference);
//					backhoePublish.backhoeReserveHandle(Fname);
//					break;
//			case 3:
//					serviceReference = context.getServiceReference(LorryPublish.class.getName());
//					LorryPublish lorryPublish = (LorryPublish)bundleContext.getService(serviceReference);
//					lorryPublish.LorryReserveHandle(Fname);
//					break;
//			case 4: 
//					serviceReference = context.getServiceReference(CarPublish.class.getName());
//					CarPublish carPublish = (CarPublish)bundleContext.getService(serviceReference);
//					carPublish.CarReserveHandle(Fname);
//					break;
			
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Consumer Stoped");
		bundleContext.ungetService(serviceReference);
	}

}
