import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		try {
		outputStats();	
		} catch(Exception error){
			System.out.println("\nPlease enter a valid sentence");
			outputStats();
		}
	}
	
	public static void outputStats(){
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("Enter sentence/word for statistics: \n");
		String input = sc.nextLine();
		System.out.println("\n\tSTATISTICS");
		System.out.println("\t__________\n");
		System.out.println("\n1. number of different letters: " + findNumOfDifferentLetters(input));
		System.out.println("2. number of vowels: " + findNumOfVowels(input));
		System.out.println("3. number of uppercase letters: " + findNumOfUpperCaseLetters(input));
		System.out.println("4. number of most frequent letter: " + findNumOfMostFrequentLetter(input));
		System.out.println("5. longest word: " + findLongestWord(input) + "\n");
		}
	}
	
	public static String findLongestWord(String input){
		String[] newArr = input.split(" ");
		int tmpVal = 0;
		String maxVal = "";
		for(int i = 0 ; i < newArr.length ; i++){
			newArr[i] = newArr[i].replaceAll("[^a-zA-Z]", "");
			tmpVal = newArr[i].length();
			if(tmpVal > maxVal.length()) {
				maxVal = newArr[i];
			}
		}
		return maxVal;
	}
	
	public static int findNumOfMostFrequentLetter(String input){
		input = input.toLowerCase();
		input = input.replaceAll("[^a-z]", "");
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0 ; i < input.length() ; i++) {
			char ch = input.charAt(i);
			if(!(map.containsKey(ch))){
				map.put(ch, 1);
			} else {
				int updatedVal = map.get(ch)+1;
				map.put(ch, updatedVal);
			}
		}
		int maxVal = 0;
		for(char key: map.keySet()) {
			int val = map.get(key);
			if(val > maxVal){
				maxVal = val;
			}
		}
		return maxVal;
	}
	
	public static int findNumOfUpperCaseLetters(String input) {
		input = input.replaceAll("[^A-Z]", "");
		return input.length();
	}
	
	public static int findNumOfVowels(String input) {
		input = input.toLowerCase();
		int numOfVowels = 0;
		for(int i = 0 ; i < input.length() ; i++) {
			char ch = input.charAt(i);
			if("aeiouAEIOU".indexOf(ch) != -1) {
				numOfVowels++;
			}
		}
		return numOfVowels;
	}
	
	public static int findNumOfDifferentLetters(String input) {
		input = input.replaceAll("[^a-zA-Z]", "");
		input = input.toLowerCase();
		List<Character> list = new ArrayList<>();
		for(int i = 0 ; i < input.length() ; i++) {
			char ch = input.charAt(i);
			if(!(list.contains(ch))) {
				list.add(ch);
			}
		}
		return list.size();
	}
	
}
