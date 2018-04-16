package main;

import networks.Network;
import networks.Network1;
import protocols.ShortestPath;

public class Main {

	private Network network;
	private ShortestPath shortestPath;
	Main(){
		// this.network = new Network1();		
		// System.out.println("");
		shortestPath = new ShortestPath();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
