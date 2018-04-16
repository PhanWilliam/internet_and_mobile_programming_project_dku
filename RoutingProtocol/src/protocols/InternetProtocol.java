package protocols;

public class InternetProtocol {
	
	String IP_address;
	
	public static String createIP(String b3) {
		return "192.168." + b3 + ".2";
	}
	
}
