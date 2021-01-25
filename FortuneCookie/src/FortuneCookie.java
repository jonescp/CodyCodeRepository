import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class FortuneCookie {

	public static void main(String[] args) throws IOException {
		PrintIntroductoryDialogue();
		PlaceCookie();
		
	}

	private static void PrintIntroductoryDialogue() {
		
		System.out.println("Welcome to The Fortune Cookie; Created by Cody Jones");
		System.out.println("------------------------------------------------------------------");
		System.out.println("You are going to be entering three single digit numbers below so ");
		System.out.println("the program can gauge your luck and give you your proper fortune.");
		System.out.println("-------------------------------------------------------------------");

	}

	private static int GetUserInput() {
		
		Scanner Input = new Scanner(System.in);
		int userInput = Input.nextInt();
		int firstDigit = Integer.parseInt(Integer.toString(userInput).substring(0, 1)); 
		//https://stackoverflow.com/questions/2967898/retrieving-the-first-digit-of-a-number
		return firstDigit;
	}

	private static int DoTheMath() {
		System.out.println("Please enter your first number");
		int userFirstNumber = GetUserInput();
		System.out.println("Please enter your second number");
		int userSecondNumber = GetUserInput();
		System.out.println("Please enter your third number");
		int userThirdNumber = GetUserInput();
		DisplaySortedNumbers(userFirstNumber, userSecondNumber, userThirdNumber);
		int userSum = userFirstNumber + userSecondNumber + userThirdNumber;
		//FIX THE FOLLOWING MATH SOMETIME
		if(userSum > 20) {
			userSum -= 10;
		}
		else if(userSum == 0) {
			userSum += 1;
		}
		return (userSum - 1);
		
	}

	private static String ChooseTheirOmen() {
		
		int userChoice = DoTheMath();
		String[] fortunes = new String[] 
				{
				"A feather in the hand is better than a bird in the air.",
				"A short pencil is usually better than a long memory any day.",
				"A golden egg of opportunity falls into your lap this month",
				"A fresh start will put you on your way.",
				"A faithful friend is a strong defense.",
				"A smile is your personal welcome mat.",
				"A soft voice may be awfully persuasive.",
				"Advice is like kissing. It costs nothing and is a pleasant thing to do.",
				"All the effort you are making will ultimately pay off",
				"Because you demand more from yourself, others respect you deeply.",
				"First think of what you want to do; then do what you have to do.",
				"Feeding a cow with roses does not get extra appreciation",
				"Fear and desire are two sides of the same coin.",
				"Expect much of yourself and little of others.",
				"Education is the ability to meet life’s situations.",
				"I learn by going where I have to go.",
				"If you continually give, you will continually have",
				"Imagination rules the world.",
				"It is better to deal with problems before they arise.",
				"It is honorable to stand up for what is right, however unpopular it seems." 
				};
		
		String fortuneGiven = "";
		for(int i = 0; i < userChoice; i++) {
			fortuneGiven = fortunes[i];
		}
		return fortuneGiven;
	}

	private static void PlaceCookie() throws IOException {
		String fortuneGiven = ChooseTheirOmen();
		
        String filename = "C:\\Users\\blade\\Desktop\\Fortunes.txt"; // TODO change to work for all Desktops and add date maybe?
        File file = new File(filename);
        FileWriter fWrite;
 
        if (!file.exists()) {
            file.createNewFile();
            fWrite = new FileWriter(filename);
            fWrite.write(fortuneGiven);
            fWrite.close();
            System.out.println("The Fortune You Seek....");
            System.out.print("Has Magically Materialized On ");
            System.out.println("Your Desktop!");
        } else {
          
            System.out.println("Delete your previous fortune and try again");
        }
		
	}
	
	public static void DisplaySortedNumbers(int firstNum, int secondNum, int thirdNum) {
		int[] numbersSorted = new int[] 
				{
				firstNum, secondNum, thirdNum
				};
		Arrays.sort(numbersSorted);
		System.out.println("Numbers sorted for sake of assignment: " + Arrays.toString(numbersSorted));
	}
}