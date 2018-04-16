package devices;

import data.Data;

// each link can be classified either with
// router - router
// or host - router
class LinkType{
	
	private String type;

	LinkType(String type){
		this.type = type;
	}
	
	public static LinkType HR() {
		return new LinkType("HR");
	}
	
	public static LinkType RR() {
		return new LinkType("RR");
	}
	
	public String getType() {
		return this.type;
	}
	
}

public class VirtualLink {

	private Host host = null;
	private Router router1 = null;
	private Router router2 = null;
	private LinkType linkType;
	private int metric_distance = 0;
	
	public VirtualLink(Host host, Router router1) {
		// System.out.println(this + " established.");
		this.host = host;
		this.router1 = router1;
		this.linkType = LinkType.HR();
		this.metric_distance = 1;
	}
	
	public VirtualLink(Router router1, Router router2, int metric_distance) {		
		this.router1 = router1;
		this.router2 = router2;
		this.linkType = LinkType.RR();
		this.metric_distance = metric_distance;
	}
	
	public void link() {
		// System.out.println(this + " established.");
		if(this.linkType.getType().equals(LinkType.HR().getType())) {
			host.connect(this);
			router1.connect(this);			
		}else if(this.linkType.getType().equals(LinkType.RR().getType())){
			router1.connect(this);
			router2.connect(this);
		}
	}
	
	public void sendData(Data data, Object sender) {
		System.out.println(sender + " transfering package to " + data.getAddress());
		if(sender instanceof Host) {
			router1.receive(data, sender);			
		}else{			
			router2.receive(data, sender);
		}
	}
	
}
