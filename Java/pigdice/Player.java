import java.util.Scanner;

public class Player {

	Scanner str = new Scanner(System.in);
	private int points;
	private int turnPoints;
	private int strategy;
	private int max;
	private int number;
	private int iter;
	final int ROOF = 75;
	final int FLOOR = 20;
	final int BASEMENT = 10;
	
	public Player(int val) {
		points = 0;
		turnPoints = 0;
		strategy = 0;
		max = 0;
		number = val;
		iter = 0;
	}
	
	public int getPoints() {
		return points;
	}
	public int getTurnPoints() {
		return turnPoints;
	}
	public int getMax() {
		return max;
	}
	public int getNumber() {
		return number;
	}
	public int getIter() {
		return iter;
	}
	public void addPoints(int val) {
		points += val;
	}
	public void setTurnPoints(int val) {
		turnPoints = val;
	}
	public void setStrategy(int strat) {
		strategy = strat;
	}
	public void setMax(int val) {
		max = val;
	}
	public void setNumber(int val) {
		number = val;
	}
	public void resetIter() {
		iter = 0;
	}
	public void incIter() {
		iter++;
	}
	public void aiIntro() {
		System.out.println("   Player " + this.getNumber() + "'s turn points are " + this.getTurnPoints() + ". Their total is " + this.getPoints() + ". ");
		System.out.println("   The max points any player currently has is " + this.getMax() + ". ");
	}
	
	/*****MODIFY THIS AREA TO MODIFY THE STRATEGIES*****/
	//Determine whether to roll or hold based on the strategy for this player.
	public String choose() {
		String choice = null;
		
		switch (strategy) {
		
		//Strategy 0 is a user-defined strategy
		case 0:
			System.out.println("   Your turn points are " + this.getTurnPoints() + ". Your total is " + this.getPoints() + ". ");
			System.out.println("   The max points any player currently has is " + this.getMax() + ". (H)old or (R)oll?");
			System.out.println("   Enter 'h' to hold and 'r' to roll. ");
			boolean flag = false;
			while(!flag) {
				if(this.str.hasNextLine()) {
					choice = this.str.nextLine();
				}
				if(choice.contains("r")) {
					choice = "r";
					flag = true;
				}
				else if(choice.contains("h")) {
					choice = "h";
					flag = true;
				}
				else {
					System.out.println("  Enter an h or an r. \n");
					System.out.println(choice);
				}
			}
			break;
			
		//Strategy 1 is a basic strategy where the AI rolls until 20+ points and holds unless the current max is 75+.
		case 1:
			this.aiIntro();
			if(this.getTurnPoints() < FLOOR || this.getMax() >= ROOF) {
				if(this.getTurnPoints() >= (100 - this.getPoints())) {
					choice = "h";					
				}
				else {
					choice = "r";
				}
			}
			else {
				choice = "h";
			}
			break;
		
		//Strategy 2 is a basic strategy where the AI, after 3 successful rolls, will randomly decide to roll or hold.
		case 2:
			this.aiIntro();
			if(this.getPoints() == 0 && this.getTurnPoints() >= (BASEMENT / 2)) {
				choice = "h";
			}
			if(this.getIter() > 3) {
				Dice die = new Dice(2);
				int roll = die.roll();
				
				if(roll == 1) {
					choice = "h";
				}
				else if(roll == 2) {
					choice = "r";
				}
			}
			else {
				choice = "r";
			}
			break;
			
		//Strategy 3 is similar to strategy 2, except it's a little gutsier and will attempt 5 successful rolls.
		case 3:
			this.aiIntro();
			if(this.getIter() > 5) {
				Dice die = new Dice(2);
				int roll = die.roll();
				
				if(roll == 1) {
					choice = "h";
				}
				else if(roll == 2) {
					choice = "r";
				}
			}
			else if(this.getPoints() < BASEMENT && this.getTurnPoints() > BASEMENT) {
				choice = "h";
			}
			else {
				choice = "r";
			}
			break;
			
		/*Strategy 4 is like a mix between strategies 1 and 3. After turn points are >= 20 and while max points are still less than 75, it will randomly hold or roll.
		Unless their total is zero, in which case they'll hold at 10 points. */
		case 4:
			this.aiIntro();
			if(this.getPoints() == 0 && this.getTurnPoints() >= (BASEMENT / 2)) {
				choice = "h";
			}
			else if(this.getTurnPoints() < FLOOR || this.getMax() >= ROOF) {
				if(this.getTurnPoints() >= (100 - this.getPoints())) {
					choice = "h";					
				}
				else {
					choice = "r";
				}
			}
			else if(this.getTurnPoints() > FLOOR && this.getMax() <= ROOF) {
				Dice die = new Dice(2);
				int roll = die.roll();
				
				if(roll == 1) {
					choice = "h";
				}
				else if(roll == 2) {
					choice = "r";
				}
			}
			else {
				choice = "h";
			}
			break;
			
		}

		return choice;
	}

}






