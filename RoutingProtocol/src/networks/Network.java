package networks;

import java.util.Vector;

import devices.Router;

public abstract class Network {
	protected Vector<Router> routers;	
	
	public Network(){
		this.routers = new Vector<Router>();
		this.init();
		this.turnOn();
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		this.connect();
		this.testSend();
	}
	
	public abstract void init();
	public abstract void turnOn();
	public abstract void connect();
	public abstract void testSend();
}
