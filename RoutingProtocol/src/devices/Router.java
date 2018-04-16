package devices;

import java.util.Vector;

import data.Data;
import protocols.ConnectLink;
import protocols.RoutingTable;
import protocols.ShortestPath;

public class Router implements ConnectLink, Runnable{
	
	private Vector<VirtualLink> virtualLinks;
	private RoutingTable routingTable;
	private ShortestPath shortestPath;
	public Thread thread;
	private Data data;
	private int clock = 0;
	
	public Router() {
		System.out.println(this + " created.");
		this.virtualLinks = new Vector<VirtualLink>();
		this.routingTable = new RoutingTable();
		this.shortestPath = new ShortestPath();
		thread = new Thread(this);
		data = new Data();
	}
	
	@Override
	public void connect(VirtualLink virtualLink) {
		// System.out.println("Connected: " + this + "and" + virtualLink);
		this.virtualLinks.add(virtualLink);
	}

	@Override
	public void run() {		
		System.out.println(this + " turned on.");
		synchronized(this) {
			while(true) {
//				try {
//					thread.sleep(500);
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
				// if(clock++ %1000000 == 0)
					// System.out.println(this + " is running.");
			}
		}		
	}

	public void turnOn() {
		this.thread.start();
	}
	
	public void receive(Data data, Object sender) {
		System.out.println(this + " receive " + data.getContent() + " from " + sender.getClass());
		this.data = data;
	}
}
