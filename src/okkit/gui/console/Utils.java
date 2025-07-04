package okkit.gui.console;

public class Utils {
	
	public static Character cHAR2char(Character a) {
		
		return String.valueOf(a).toLowerCase().charAt(0);
	}
	
	public static String cHAR2string(Character a) {
		
		return String.valueOf(a).toLowerCase();
	}
	
	public static Character sTRING2char(String a) {
		
		return a.trim().toLowerCase().charAt(0);
	}
	
	public static String sTRING2string(String a) {
		
		return a.trim().toLowerCase();
	}

}
