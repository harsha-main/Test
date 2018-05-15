
import java.util.ArrayList;
import java.util.Scanner;

public class TameThrones1 {
	static ArrayList<String> allies = new ArrayList<>();

	static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Type exit to end the program");
		String command = scanner.nextLine();
		while (!command.equals("exit")) {
			analyzeCommand(command);
			command = scanner.nextLine();
		}
	}

	static void rulerWho() {
		if(allies.size()>2)System.out.println(StringConstants.ruler_name);
		else System.out.println("None");
	}

	static void listAllies() {
		if(allies.size()==0){
			System.out.println("None");return;
		}
		for(String str:allies){
			System.out.print(str+" " );
		}
		
	}

	static void analyzeCommand(String text) {
		if (text.toLowerCase().equals(StringConstants.ruler)) {
			rulerWho();
			return;
		} else if (text.toLowerCase().equals(StringConstants.allies)) {
			listAllies();
			return;
		}
		String name = text.split(",")[0];
		if (StringConstants.map.keySet().contains(name)) {
			addKingdom(text);
			return;
		}
		System.out.println("Invalid Command");
	}

	static void addKingdom(String command) {
		String name = command.split(",")[0];
		if (allies.contains(name))
			return;
		else {
			if (decodeMessage(command)) 
				allies.add(name); 
		}
	}

	static boolean decodeMessage(String message) {
		String part[] = message.split(",");
		String emblem = StringConstants.map.get(part[0]);
		char c[] = part[1].toLowerCase().toCharArray();
		int a[] = new int[26];
		for (char k : c) {
			int d = (int) k;
			if (d > 96 && d < 123) {
				a[d - 97]++;
			}
		}
		char echars[] = emblem.toLowerCase().toCharArray();
		for (char k : echars) {
			int d = (int) k;
			if (a[d-97] >=1)
				a[d-97]--;
			else{ 
				return false;}
		}
		return true;

	}
}
