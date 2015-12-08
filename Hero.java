import java.util.Scanner;

/*
 *  The Hero class is essentially a user interface,
 *  
 *  It will parse commands provide help and report the game messages back to the user 
 */


public class Hero {

	private World _world;
	boolean _game;
	Scanner scanner;
	
	Hero(World world){
		_world = world ;
		_game = false;
	}
	
	
	// Start's game
	public void start(){
		scanner = new Scanner(System.in);
	
		// game start message
		System.out.println("Welcome to Beverage Quest!");
		
		help();
		
		
		System.out.println();
		
		
		
		
	}
	
	// print help message
	private void help(){
		System.out.println("Type one or more words, to guide your hero to your beverage ingredients.\n\n" +
							"Syntax :(command) (target)\n\n" +
							"Possible Commands:\n\n" +
							"look:\nwill give greater detail to target and look for (command without target will look at the room).\n\n" +
							"go:\nmove hero in the direction of target (Target must specify direction: north, south, east or west).\n\n" +
							"open:\nwill open locked chest or door. must have key.\n\n" +
							"drink:\nWill attempt to drink the quest beverage. \n\n" +
							"help:\nWill display this message."
				); 
	}
	
	
	
	
	
	
	
} 
