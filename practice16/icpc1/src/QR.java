//Alan
//No, runtime error.
//Problem: digits starting with 0 (e.g. "092") would be parsed as "92" and the program would look for more digits.

import java.util.*;

public class QR {
	static String alphanums = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:";
	static String hex2bin(char input) {
		if (input == '0') return "0000";
		if (input == '1') return "0001";
		if (input == '2') return "0010";
		if (input == '3') return "0011";
		if (input == '4') return "0100";
		if (input == '5') return "0101";
		if (input == '6') return "0110";
		if (input == '7') return "0111";
		if (input == '8') return "1000";
		if (input == '9') return "1001";
		if (input == 'A') return "1010";
		if (input == 'B') return "1011";
		if (input == 'C') return "1100";
		if (input == 'D') return "1101";
		if (input == 'E') return "1110";
		if (input == 'F') return "1111";
		return "ERROR";
	}
	static char bin2hex (String input) {
		if (input.equals("0000")) return '0';
		if (input.equals("0001")) return '1';
		if (input.equals("0010")) return '2';
		if (input.equals("0011")) return '3';
		if (input.equals("0100")) return '4';
		if (input.equals("0101")) return '5';
		if (input.equals("0110")) return '6';
		if (input.equals("0111")) return '7';
		if (input.equals("1000")) return '8';
		if (input.equals("1001")) return '9';
		if (input.equals("1010")) return 'A';
		if (input.equals("1011")) return 'B';
		if (input.equals("1100")) return 'C';
		if (input.equals("1101")) return 'D';
		if (input.equals("1110")) return 'E';
		if (input.equals("1111")) return 'F';
		return 'Z';
	}
	static int bin2int(String input) {
		int val = 0;
		for (int i = 0; i<input.length(); i++) {
			if (input.charAt(input.length()-i-1) == '1') val += Math.pow(2, i);
		}
		return val;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numsets = sc.nextInt();
		for (int z = 0; z<numsets; z++) {
			String allout = "";
			int decoded = 0;
			sc.nextInt();
			String hextape = sc.next().trim();
			//System.out.println(hextape);
			String bintape = "";
			for (int i = 0; i<hextape.length(); i++) bintape += hex2bin(hextape.charAt(i));
			String mode = "";
			String count = "";
			while (!bintape.isEmpty()) {
				//Main processing here
				mode = bintape.substring(0, 4);
				bintape = bintape.substring(4);
				if (mode.equals("0001")) {
					count = bintape.substring(0,10);
					bintape = bintape.substring(10);
					int digitsleft = bin2int(count);
					decoded += digitsleft;
					String curnumstring = "";
					String outnum = "";
					while (digitsleft > 0) {
						if (digitsleft > 2) {
							curnumstring = bintape.substring(0,10);
							bintape = bintape.substring(10);
						} else if (digitsleft == 2) {
							curnumstring = bintape.substring(0,7);
							bintape = bintape.substring(7);
						} else {
							curnumstring = bintape.substring(0,4);
							bintape = bintape.substring(4);
						}
						outnum += String.valueOf(bin2int(curnumstring));
						//System.out.println(String.valueOf(bin2int(curnumstring)));
						digitsleft -= String.valueOf(bin2int(curnumstring)).length();
					}
					allout += outnum;
					//System.out.println(outnum);
					
				} else if (mode.equals("0010")) {
					count = bintape.substring(0,9);
					bintape = bintape.substring(9);
					int charsleft = bin2int(count);
					decoded += charsleft;
					String curcharstring = "";
					String outalphanum = "";
					while (charsleft > 0) {
						if (charsleft == 1) {
							curcharstring = bintape.substring(0,6);
							bintape = bintape.substring(6);
							outalphanum += alphanums.charAt(bin2int(curcharstring));
							charsleft -= 1;
						} else {
							curcharstring = bintape.substring(0,11);
							bintape = bintape.substring(11);
							outalphanum += alphanums.charAt(bin2int(curcharstring)/45);
							outalphanum += alphanums.charAt(bin2int(curcharstring)%45);
							charsleft -= 2;
						}
						
					}
					allout += outalphanum;
					//System.out.println(outalphanum);
				} else if (mode.equals("0100")) {
					count = bintape.substring(0,8);
					bintape = bintape.substring(8);
					int binsleft = bin2int(count);
					decoded += binsleft;
					String curbinstring = "";
					int curbinint = 0;
					String outbin = "";
					while (binsleft > 0) {
						curbinstring = bintape.substring(0,8);
						bintape = bintape.substring(8);
						curbinint = bin2int(curbinstring);
						if (curbinint >= 0x20 && curbinint <=0x76) {
							outbin += Character.valueOf((char) curbinint);
							if (Character.valueOf((char) curbinint) == '\\') outbin += '\\'; 
						}
						else {
							outbin += "\\";
							outbin += bin2hex(curbinstring.substring(0,4));
							outbin += bin2hex(curbinstring.substring(4,8));
						}
						binsleft -= 1;
					}
					allout += outbin;
					//System.out.println(outbin);
				} else if (mode.equals("1000")) {
					count = bintape.substring(0,8);
					bintape = bintape.substring(8);
					int kanjileft = bin2int(count);
					decoded += kanjileft;
					String outkanji = "";
					String curkanjistring = "";
					while (kanjileft > 0) {
						curkanjistring = bintape.substring(0,13);
						bintape = bintape.substring(13);
						//System.out.println(curkanjistring);
						outkanji += "#";
						outkanji += curkanjistring.charAt(0);
						outkanji += bin2hex(curkanjistring.substring(1,5));
						outkanji += bin2hex(curkanjistring.substring(5,9));
						outkanji += bin2hex(curkanjistring.substring(9,13));
						kanjileft -= 1;
					}
					allout += outkanji;
					//System.out.println(outkanji);
				} else {
					break;
				}
			}
			System.out.println(String.valueOf(z+1) + " " + String.valueOf(decoded) + " " + allout);
		}
	}
	
}
