import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Creating a Starship with default values
		Starship myStarship = new Starship("Steel", 2022, 1000, 789012893);

	       while (true) {
	            System.out.println("\n==== Starship Game ====");
	            System.out.println("1. Operate Starship");
	            System.out.println("2. Refuel Starship");
	            System.out.println("3. Change Velocity");
	            System.out.println("4. Set Destination");
	            System.out.println("5. Toggle AutoPilot");
	            System.out.println("6. Turn On/Turn Off Lights");
	            System.out.println("7. Connect/Disconnect Shields");
	            System.out.println("8. Display Starship Status");
	            System.out.println("9. Connect/Disconnect from Communication Center");
	            System.out.println("10. Send Message");
	            System.out.println("11. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	            case 1:
	                operateStarship(myStarship);
	                break;
	            case 2:
	                refuelStarship(scanner, myStarship);
	                break;
	            case 3:
	                changeVelocity(scanner, myStarship);
	                break;
	            case 4:
	                setDestination(scanner, myStarship);
	                break;
	            case 5:
	                toggleAutoPilot(myStarship);
	                break;
	            case 6:
	                toggleLights(scanner, myStarship);
	                break;
	            case 7:
	                toggleShields(scanner, myStarship);
	                break;
	            case 8:
	                displayStarshipStatus(myStarship);
	                break;
	            case 9:
	                connectToCommunicationCenter(scanner, myStarship);
	                break;
	            case 10:
	                sendMessage(scanner, myStarship);
	                break;
	            case 11:
	                System.out.println("Congratulations, Captain! You've navigated through uncharted territories for the first time. Until our next adventure, farewell!");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	       }
	}

	
	private static void sendMessage(Scanner scanner, Starship starship) {
	    CommunicationSystem communicationSystem = starship.getCommunicationSystem();
	    if (communicationSystem != null) {
	        System.out.print("Enter your message: ");
	        scanner.nextLine(); // Consume newline character
	        String message = scanner.nextLine(); // Read the message
	        System.out.println();
	        communicationSystem.sendCommand(message);
	    } else {
	        System.out.println("Error: Communication system not available.");
	    }
	}

    private static void connectToCommunicationCenter(Scanner scanner, Starship starship) {
        System.out.print("Do you want to connect or disconnect from the communication center? (1. Connect / 2. Disconnect): ");
        int connectChoice = scanner.nextInt();
        boolean connect = connectChoice == 1;

        if (connect) {
            starship.getCommunicationSystem().communicate();
            System.out.println("Connected to the communication center.");
        } else {
            starship.getCommunicationSystem().disconnect();
            System.out.println("Disconnected from the communication center.");
        }
    }
    
    private static void toggleLights(Scanner scanner, Starship starship) {
        System.out.print("Do you want to turn on or off the lights? (1. Turn On / 2. Turn Off): ");
        int lightsChoice = scanner.nextInt();
        boolean turnOn = lightsChoice == 1;

        if (turnOn) {
            starship.getSupportSystem().turnOnLights();
        } else {
            starship.getSupportSystem().turnOffLights();
        }
    }
    
    private static void toggleShields(Scanner scanner, Starship starship) {
        System.out.print("Do you want to activate or deactivate the shields? (1. Activate / 2. Deactivate): ");
        int shieldsChoice = scanner.nextInt();
        boolean activate = shieldsChoice == 1;

        if (activate) {
            starship.getSupportSystem().activateShields();
        } else {
            starship.getSupportSystem().deactivateShields();
        }
    }



	private static void operateStarship(Starship starship) {
		System.out.println("\nOperating Starship...");
		starship.operate();
		System.out.println("Starship operation completed.");
	}

	private static void refuelStarship(Scanner scanner, Starship starship) {
		System.out.println("Current Remaining Fuel: " + starship.getRemFuel() + "/10000000");
		System.out.print("Enter the amount of fuel to refuel: ");
		double fuelAmount = scanner.nextDouble();
		starship.refuel(fuelAmount);
		System.out.println("Starship refueled successfully.");
	}

	private static void changeVelocity(Scanner scanner, Starship starship) {
		System.out.print("Enter new velocity: ");
		double newVelocity = scanner.nextDouble();
		starship.setVelocity(newVelocity);
		System.out.println("Velocity changed to " + newVelocity);
	}

	private static void setDestination(Scanner scanner, Starship starship) {
		System.out.print("Enter X coordinate for destination: ");
		double destX = scanner.nextDouble();
		System.out.print("Enter Y coordinate for destination: ");
		double destY = scanner.nextDouble();
		starship.setDestination(destX, destY);
		System.out.println("Destination set to (" + destX + ", " + destY + ")");
	}

	private static void toggleAutoPilot(Starship starship) {
		starship.setAutoPilot(!starship.isAutoPilot());
		System.out.println("AutoPilot toggled to " + starship.isAutoPilot());
	}

	private static void displayStarshipStatus(Starship starship) {
		System.out.println("\n==== Starship Status ====");
		System.out.println("Material: " + starship.getMaterial());
		System.out.println("Years: " + starship.getYears());
		System.out.println("Remaining Fuel: " + starship.getRemFuel() + " out of 10000000");
		System.out.println("Position: " + starship.getPos());
		System.out.println("Velocity: " + starship.getVelocity());
		System.out.println("Destination: " + starship.getDestination()[0] + ", " + starship.getDestination()[1]);
		System.out.println("Current Command: " + starship.getCommunicationSystem().getCommand());
		System.out.println("AutoPilot: " + starship.isAutoPilot());
		System.out.println("Total Distance Traveled: " + starship.getTotalDistanceTraveled());
		System.out.println("Is Engine Running: " + starship.getEngine().isEngineRunning());
		System.out.println("Is Connected: " + starship.getCommunicationSystem().isConnected());
		System.out.println("Is Monitoring: " + starship.getSupportSystem().isMonitoring());
		System.out.println("Is Lights On: " + starship.getSupportSystem().isLightsOn());
		System.out.println("Is Shields Activated: " + starship.getSupportSystem().isShieldsActivated());
		System.out.println("Regulated Temperature: " + starship.getSupportSystem().getRegulateTemperature());
	}
}
