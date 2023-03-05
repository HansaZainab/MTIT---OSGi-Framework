package adminproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class AdminProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Admin Producer Start");
		AdminProducer Adminproducer = (AdminProducer) new ProducerAdmin();
		publishServiceRegistration = context.registerService(AdminProducer.class.getName(), Adminproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Admin Producer Stop");
		publishServiceRegistration.unregister();
	}

}

