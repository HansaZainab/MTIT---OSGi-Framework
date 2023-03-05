package deliverysystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DeliverySystemActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Delivery System Service Started !!!");
		DeliverySystemPublish publisherservice = new DeliverySystemPublishImpl();
		serviceRegistration = bundleContext.registerService(DeliverySystemPublish.class.getName(), publisherservice, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Delivery System service stop !!!");
		serviceRegistration.unregister();
	}

}
