import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.nio.file.*;
import java.nio.charset.*;

public class Assignment2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//reading the file
		Scanner in = new Scanner(System.in);
		String filename = "neighbor-dump.txt";
		byte[] bytes = Files.readAllBytes(Paths.get(filename));
		//Scanner inputString = new Scanner(new File(filename));
		
		String input = new String(bytes, Charset.forName("UTF-8"));
		int countPANids = 0;
		int countMAC = 0;
		
		String regex1 = "[Pp]ANID.+";///PANID
		
		
		String regex2 = "[0-9]{6}[a-z]{2}[a-z0-9]{7}[a-z0-9]{1}";//MACID
		
		String regex3 = "[0-9]{6}[a-z]{2}[a-z0-9]{7}[a-z0-9]{1}";//MACID
		
		String regex4 = "-[0-9]*\\.[0-9]*";// RF RSSI M
		
		Pattern pattern1 = Pattern.compile(regex1);//PANID
		Pattern pattern2 = Pattern.compile(regex2);//MACID
		Pattern pattern3 = Pattern.compile(regex3);//this is for displaying the MACID
		Pattern pattern4 = Pattern.compile(regex4);//pattern for RF RSSI M

		
		Matcher matcher1 = pattern1.matcher(input);//displaying PANID
		Matcher matcher2 = pattern1.matcher(input);//this for counting the PANID
		
		
		Matcher matcher3 = pattern2.matcher(input);//this id for counting the MACID
		Matcher matcher4 = pattern3.matcher(input);
		
		Matcher matcher5 = pattern3.matcher(input);//displaying the MACID with RF RSSI M
		Matcher matcher6 = pattern4.matcher(input);//displaying the RF RSSI M
		
		//This is for troubleshooting purposes only
		//System.out.println(Pattern.matches("[0-9]{6}[a-z]{2}[a-z0-9]{7}[a-z0-9]{1}","000781fe00002f76"));
		//000781fe0000614e , 000781fe0000326f , 000781fe00002f76 , 000781fe0000313e
		//System.out.println(Pattern.matches("-[0-9]*\\.[0-9]*", "-25.5"));///("^-[0-9]{2,6}", "-45"));
		
				
		
		//PANID
		while (matcher2.find()) {
			String match2 = matcher2.group();
			countPANids ++;
		}
		
		System.out.println("- List of PANIDs (Total of "+countPANids + (")"));
		//List of PANID
		while(matcher1.find()) {
			
			String match = matcher1.group();
			
			System.out.println(match);
			
		}
		//MACID
		while (matcher3.find()) {
			String match3 = matcher3.group();
			countMAC++;
		}
		
		System.out.println("- List of MAC Addresses (Total of "+countMAC + (")"));
		// List of MACID
		while(matcher4.find()) {
			String match = matcher4.group();
			System.out.println(match);
		}
								
		System.out.println("- List of RF_RSSI_M values for each MAC address  ");
		
		//List of MACID plus RF RSSI M
		while(matcher5.find() && matcher6.find()) {
			String match = matcher5.group();
			String match2 = matcher6.group();
			System.out.println(match + " " + match2);
		}
		


	}

}
