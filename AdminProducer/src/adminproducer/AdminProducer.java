package adminproducer;


public interface AdminProducer {
	public String myName();
	public void insertDeliveryPreson(String name , String phone , String userName, String password);
	public String DeliveryPresonDisplay();
	public void ViewAllRecord();
	
	
}