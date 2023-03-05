package itemsproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class ItemsProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Items Producer Start");
		ItemsProducer itemproducer = (ItemsProducer) new ProducerItems();
		publishServiceRegistration = context.registerService(ItemsProducer.class.getName(), itemproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Item Producer Stop");
		publishServiceRegistration.unregister();
	}

}