import java.util.Scanner;
import java.util.ArrayList;

public class Pigdice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int players = 0;
		boolean flag = false;
		
		//Validate the input
		while(flag == false) {
			//Get the number of players
			System.out.println("Hello, welcome to Pig Dice the game! How many players? ");
			if(scan.hasNextInt()) {
				
				//Gotta be more than 0
				int nextInt = scan.nextInt();
				if(nextInt > 0) {
					players = nextInt;
					flag = true;
				}
			}
			else {
				System.out.println("That wasn't an integer. Try again. \n");
				scan.next();
			}
		}
		System.out.println("Alright, starting with " + players + " players. \n");
		
		//Start the game
		play(players, scan);
		
		scan.close();
	}
	
	public static void play(int group, Scanner scan) {
		//Set the number of strategies available.
		final int STRATEGIES = 5;
		
		//Construct the dice- accepts an int as an arg for number of sides, but defaults to 6.
		Dice dice = new Dice();
		
		//Create an array of players and initialize them to defaults.
		ArrayList<Player> players = new ArrayList<Player>();
		for(int count = 0; count < group; count++) {
			players.add(new Player(count));
			System.out.println("Player " + players.get(count).getNumber() + "  is alive! ");
		}
		
		/*****Print strategy options here. Modify Player.java to add strategies. *****/
		System.out.println("Each strategy is numbered 0 - " + (STRATEGIES - 1) + ". They are as follows: ");
		System.out.println(">> Enter '0' for a human player. ");
		System.out.println(">> Strategy 1 is a basic strategy where the AI rolls until 20+ points and holds unless the current max is 75+.");
		System.out.println(">> Strategy 2 is a basic strategy where the AI, after 3 successful rolls, will randomly decide to roll or hold. ");
		System.out.println(">> Strategy 3 is similar to strategy 2, except it's a little gutsier and will attempt 5 successful rolls. ");
		System.out.println(">> Strategy 4 is like a mix between strategies 1 and 3. After turn points are >= 20 and while max points are still less than 75, it will randomly hold or roll. ");
		
		//Get the strategy for each player
		for(int count = 0; count < players.size(); count++) {
			System.out.println("\nWhat strategy would you like player " + players.get(count).getNumber() + " to use? ");

			//Validate the strategy is a real strategy.
			boolean flag = false;
			while(flag == false) {
				if(scan.hasNextInt()) {
					int nextInt = scan.nextInt();
					if (nextInt < STRATEGIES) {
						players.get(count).setStrategy(nextInt);
						flag = true;
					}
				}
				else {
					System.out.println("That wasn't an option. Try again. ");
					scan.next();
				}
			}
		}
		
		//Here is where the rules for the game are programmatically defined.
		int max = 0;
		while(max < 100) {
			
			//Begin the round
			for(int count = 0; count < players.size(); count++) {
				String choice = null;
				System.out.println(">> Beginning Player " + players.get(count).getNumber() + "'s turn. ");
				
				//Set the points for the turn to 0
				players.get(count).setTurnPoints(0);
				
				//Determine whether the player chooses to roll or hold.
				players.get(count).setMax(max);
				while(choice != "h") {
					choice = players.get(count).choose();
					if(choice == "r") {
						int roll = dice.roll();
						System.out.println("   A " + roll + " was rolled. ");
						players.get(count).setTurnPoints(players.get(count).getTurnPoints() + roll);
						
						//Increment the player's built in iterator.
						players.get(count).incIter();
						
						//If the player rolls a 1, their turn is over and they gain 0 points this round.
						if(roll == 1) {
							players.get(count).setTurnPoints(0);
							break;
						}
					}
				}
				
				//Check if the player held or not.
				if(choice == "h") {
					System.out.println("   The player has held. ");
				}
				
				//End the turn and add any accumulated points to the player's pool.
				players.get(count).addPoints(players.get(count).getTurnPoints());
				System.out.println("   Player " + players.get(count).getNumber() + "'s turn is now over. Their total is " + players.get(count).getPoints() + ". \n");
				
				//Reset the player's built in iterator.
				players.get(count).resetIter();
				
				//Update the max score if necessary.
				if(max < players.get(count).getPoints()) {
					max = players.get(count).getPoints();
				}
				
				//If someone won, stop the game and announce the winner.
				if(max >= 100) {
					System.out.println("Player " + players.get(count).getNumber() + " wins with " + max + " points! End scores: ");
					
					//Announce the final scores.
					for(int iter = 0; iter < group; iter++) {
						System.out.println("Player " + players.get(iter).getNumber() + " had " + players.get(iter).getPoints() + " points. ");
					}
					break;
				}
			}
		}
		
	}
	
}

























