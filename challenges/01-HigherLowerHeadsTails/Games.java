import java.util.Random;
import java.util.Scanner;

public class Games {
	Scanner scanner;
	static int randomNumber;

	final int CONST_MIN_HG = 0;
	final int CONST_MAX_HG = 100;

	static int MIN_HG = 0;
	static int MAX_HG = 100;
	
	public static void main(String[] args) {
		Games games = new Games();
		games.run();
	}

	public int validateInput(String message, int min, int max) {
		int input = -1;
		System.out.println(message);
		scanner = new Scanner(System.in);
		try {
			input = scanner.nextInt();
			if (!validateRange(min, max, input)) {
				return -1;
			}

		} catch (Exception e) {
			System.out.println("Please, enter a valid number.");
			return -1;
		}
		return input;
	}

	public void run() {
		int aux;
		do {
			aux = validateInput("Welcome to mini games. Type for play: 1-Higher/Lower 2-Toss a coin. 3- EXIT.", 1, 3);
		} while (aux == -1);
		if (aux == 1) {
			randomNumber = generateRandomNumber(CONST_MAX_HG);
			higherLower();
		} else if (aux == 2) {
			randomNumber = generateRandomNumber(1);
			headTail();
		} else {
			exit();
		}
	}

	public void higherLower() {
		int aux;
		do {
			aux = validateInput("Choice one number entry " + MIN_HG + "/" + MAX_HG + ".", CONST_MIN_HG, CONST_MAX_HG);
		} while (aux == -1);
		if (!verifyRange(randomNumber, aux)) {
			higherLower();
		}
		playAgain();
	}

	public boolean verifyRange(int random, int input) {
		if (input == random) {
			System.out.println("The number right is " + input + " /O/ You win!! /O/");
			return true;
		} else if (input < random) {
			System.out.println("Most higher.");
			MIN_HG = input;
			return false;
		} else {
			System.out.println("Most lower.");
			MAX_HG = input;
			return false;
		}
	}

	public void headTail() {
		int aux;
		do {
			aux = validateInput("Choice a side of coin: 0 for head and 1 for tail. ", 0, 1);
		} while (aux == -1);
		if (randomNumber == aux) {
			System.out.println("You win!");
			playAgain();
		} else {
			System.out.println("You lose =/");
			playAgain();
		}
	}

	public boolean validateRange(int min, int max, int value) {
		if (value < min || value > max) {
			return false;
		}
		return true;
	}

	public int generateRandomNumber(int max) {
		return new Random().nextInt(max);
	}

	public void playAgain() {
		int aux;
		do {
			aux = validateInput("Do you like back to main menu? Type 0 for YES and 1 for EXIT.", 0, 1);
		} while (aux == -1);
		if (aux == 0) {
			run();
		} else {
			exit();
		}
	}
	public void exit() {
		System.out.println("Good Bye.");
		System.exit(0);
	}
}