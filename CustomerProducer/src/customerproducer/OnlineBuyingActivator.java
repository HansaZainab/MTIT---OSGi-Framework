package customerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class OnlineBuyingActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Online Shopping Service Started !!!");
		OnlineBuyingPublish publisherservice = new OnlineBuyingImpl();
		serviceRegistration = bundleContext.registerService(OnlineBuyingPublish.class.getName(), publisherservice, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Online Shopping service stop !!!");
		serviceRegistration.unregister();
	}

}
