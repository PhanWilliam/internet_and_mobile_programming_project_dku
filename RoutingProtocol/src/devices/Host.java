package devices;

import data.Data;
import protocols.ConnectLink;

public class Host implements ConnectLink{

	private String ip_address;
	private int port;
	private VirtualLink virtualLink;
	
	public Host(String ip_address, int port){
		System.out.println(this + " created.");
		this.ip_address = ip_address;
		this.port = port;
	}
	
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public void connect(VirtualLink virtualLink) {
		// System.out.println("Connected: " + this + "and" + virtualLink);
		this.virtualLink = virtualLink;
	}		
	
	public void sendData(Data data) {
		this.virtualLink.sendData(data, this);
		System.out.println(this + " sending package to " + data.getAddress());
	}
	
}
