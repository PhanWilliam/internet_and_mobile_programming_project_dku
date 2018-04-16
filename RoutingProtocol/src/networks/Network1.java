package networks;

import data.Data;
import devices.Host;
import devices.Router;
import devices.VirtualLink;

public class Network1 extends Network{	
	
	private Router r1;
	private Router r2;
	private Router r3;
	private Router r4;
	private Router r5;
	
	private Host h1;
	private Host h2;
	private Host h3;
	private Host h4;
	private Host h5;
	
	private VirtualLink vl1;
	private VirtualLink vl2;
	private VirtualLink vl3;
	private VirtualLink vl4;
	private VirtualLink vl5;
	
	private VirtualLink vl6;
	private VirtualLink vl7;
	private VirtualLink vl8;
	private VirtualLink vl9;
	
	@Override
	public void init() {
		System.out.println();System.out.println();
		System.out.println("============================");
		System.out.println("Creating Routers");
		System.out.println("============================");
		r1 = new Router();
		r2 = new Router();
		r3 = new Router();
		r4 = new Router();
		r5 = new Router();
		
		System.out.println();System.out.println();
		System.out.println("============================");
		System.out.println("Creating Host");
		System.out.println("============================");
		h1 = new Host("192.168.1.0", 8888);
		h2 = new Host("192.168.2.0", 8888);
		h3 = new Host("192.168.3.0", 8888);
		h4 = new Host("192.168.4.0", 8888);
		h5 = new Host("192.168.5.0", 8888);		
	}
	
	public void connect() {
		System.out.println();System.out.println();
		System.out.println("============================");
		System.out.println("Establishing Connection");
		System.out.println("============================");
		vl1 = new VirtualLink(h1, r1);
		vl2 = new VirtualLink(h2, r2);
		vl3 = new VirtualLink(h3, r3);
		vl4 = new VirtualLink(h4, r4);
		vl5 = new VirtualLink(h5, r5);
		
		vl6 = new VirtualLink(r1, r2, 1);
		vl7 = new VirtualLink(r1, r3, 4);
		vl8 = new VirtualLink(r3, r4, 5);
		vl9 = new VirtualLink(r3, r5, 2);
		
		vl1.link();
		vl2.link();
		vl3.link();
		vl4.link();
		vl5.link();
		vl6.link();
		vl7.link();
		vl8.link();
		vl9.link();
				
		System.out.println("Successful");		
		System.out.println("");System.out.println("");
	}
	
	public void turnOn() {
		System.out.println();System.out.println();
		System.out.println("============================");
		System.out.println("Turning Router On");
		System.out.println("============================");
		r1.turnOn();		
		r2.turnOn();
		r3.turnOn();
		r4.turnOn();
		r5.turnOn();
	}
	
	public void testSend() {
		h1.sendData(new Data("192.168.5.1", "Hello World"));
	}

}
