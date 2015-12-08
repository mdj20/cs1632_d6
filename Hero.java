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
		
		help(); // display help string
		boolean game = true; // game toggle

		
		while (game){
		
			game = gameLoop();
			
		}
		
		
		
	}
	
	private boolean gameLoop(){
		
		boolean value = true;
		String line = ""; // line scanned from user
		String response = "";
		
		// print out room name and attribute names
		System.out.println("You are in "+_world.currentLocationName());
		System.out.println("You See:\n"+_world.roomAttributes());
		
		
		line = promptString("Command: "); // prompt user input
		String split[] = line.split(" ",2); // split line into command and target
		
		String command = split[0];
		String target = (split.length>1)?split[1] : "";
		
		// command branch
		
		if(command.equalsIgnoreCase("look")){
			if (!target.equalsIgnoreCase("")){
				response = _world.look(target);
			}
			else{ 
				response = _world.look();
			}
		}
		else if( command.equalsIgnoreCase("") )
		else if( command.equalsIgnoreCase("move")){
			
		}
		
		
		
		
		
		
		return value;
	}
	
	
	// print help message
	private void help(){
		System.out.println("Type one or more words, to guide your hero to your beverage ingredients.\n\n" +
							"Syntax :(command) (target)\n\n" +
							"Possible Commands:\n\n" +
							"look:\nwill give greater detail to target and look for (command without target will look at the room).\n\n" +
							"move:\nmove hero in the direction of target (Target must specify direction: north, south, east or west).\n\n" +
							"open:\nwill open locked chest or door. must have key.\n\n" +
							"drink:\nWill attempt to drink the quest beverage. \n\n" +
							"help:\nWill display this message."
				); 
	}
	
	private String promptString(){
		return promptString(null);
	}
	
	private String promptString(String prompt){
		if (prompt != null){
			System.out.println(prompt);
		}
		String value = scanner.nextLine();
		return value;
	}
	
	
	
	
	
	
	
} 
