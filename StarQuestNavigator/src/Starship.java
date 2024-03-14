import java.util.Random;

public class Starship {
    private String material = "Steel";
    private int years = 2300;
    private double remFuel = 250;
    private long pos = 939017861;
    private double velocity = 2500.00;
    private double destX = 1254654.0;
    private double destY = 6558454.0;
    private boolean autoPilot = false;
    private double maxFuelCapacity = 10000000;
    private double totalDistanceTraveled = 0;
    
    private Engine engine;
    private CommunicationSystem communicationSystem;
    private SupportSystem supportSystem;
    private EventSystem eventSystem;

    private static Random randGen = new Random();

    //Constructor
    public Starship(String material, int years, double remFuel, long pos) {
    	
    	// INITIALIZE SUBSYSTEMS
    	engine = new Engine();
    	communicationSystem = new CommunicationSystem();
    	supportSystem = new SupportSystem();
    	eventSystem = new EventSystem(supportSystem);
    	
    	this.material = material;
    	this.years = years;
    	this.remFuel = remFuel;
    	this.pos = pos;
    }
    
    public Starship() {
    	//Generic Constructor
    	
    }

    public Engine getEngine() {
        return engine;
    }
    
    public CommunicationSystem getCommunicationSystem() {
    	return communicationSystem;
    }
    
    public SupportSystem getSupportSystem() {
    	return supportSystem;
    }
    
    public EventSystem getEventSystem() {
    	return eventSystem;
    }
    
    //Operation Functions
    public void operate() {
        operateEngine();
        System.out.println();
        operateCommunication();
        System.out.println();
        operateMonitoring();
        System.out.println();
        operateEvents();
        System.out.println();
        double randomDistance = randGen.nextDouble() * 1000; 
        travel(randomDistance);
    }

    private void operateEngine() {
    	engine.startEngine();
    	engine.increaseThrottle();
    }

    private void operateCommunication() {
    	communicationSystem.communicate();
    	communicationSystem.sendCommand("Go to destination");
    	communicationSystem.receiveData();
    	communicationSystem.disconnect();
    }

    private void operateMonitoring() {
    	supportSystem.monitorLifeSupport();
    	supportSystem.adjustOxygenLevel(80);
    	supportSystem.turnOnLights();
    }

    private void operateEvents() {
    	eventSystem.exploreRandomEvents();
    }
   
    //Travel Logic Based Off of Fuel
    public void travel(double distance) {
        double fuelConsumptionRate = 0.01;
        double fuelNeeded = distance * fuelConsumptionRate;

        if (remFuel >= fuelNeeded) {
            updatePositionAndFuel(distance, fuelNeeded);
            displayTravelMessage(distance);
        } else {
            System.out.println("Not enough fuel to travel the specified distance.");
        }
    }
    
    private void updatePositionAndFuel(double distance, double fuelNeeded) {
        pos += distance;
        remFuel -= fuelNeeded;
        totalDistanceTraveled += distance;
    }
    
	private void displayTravelMessage(double distance) {
		int distanceFactor = (int) (distance / 100);

		switch (distanceFactor) {
		case 0:
			System.out.println("Traveled a short distance! Remaining Fuel: " + remFuel + "."); // 0 - 99.99 units
			break;
		case 1:
			System.out.println("Traveled a moderate distance! Remaining Fuel: " + remFuel + "."); // 100 - 199.99 units
			break;
		case 2:
			System.out.println("Traveled a considerable distance! Remaining Fuel: " + remFuel + "."); // 200 - 299.99 units
			break;
		default:
			System.out.println("Traveled a significant distance! Remaining Fuel: " + remFuel + "."); // 300 units or more
		}
	}


    public void refuel(double fuelAmount) {
        if (remFuel + fuelAmount <= maxFuelCapacity) {
            remFuel += fuelAmount;
        } else {
            System.out.println("Cannot refuel. Maximum fuel capacity reached.");
        }
    }

    public void calculateDistanceToBeTraveled(long initialPosition, long nextPosition) {
        double distance = Math.abs(nextPosition - initialPosition);
        totalDistanceTraveled += distance;
    }

    public double calculateETA() {
        if (velocity == 0) {
            System.out.println("Cannot calculate ETA. Velocity is zero.");
            return -1;
        }

        double distanceToDestination = getTotalDistanceTraveled();
        double eta = distanceToDestination / velocity;

        return Math.round(eta * 100.0) / 100.0;
    }
	
    
    //SETTERS AND GETTERS 

	public double getRemFuel() {
		return remFuel;
	}
	
	public void setRemFuel(double remFuel) {
		this.remFuel = remFuel;
	}

	public long getPos() {
		return pos;
	}

	public void setPos(long pos) {
		this.pos = pos;
	}

	public double getTotalDistanceTraveled() {
		return totalDistanceTraveled;
	}

	public void setTotalDistanceTraveled(double totalDistanceTraveled) {
		this.totalDistanceTraveled = totalDistanceTraveled;
	}

	public void setVelocity(double inputVelocity) {
		velocity = inputVelocity;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setDestination(double x, double y) {
		destX = x;
		destY = y;
	}

	public double[] getDestination() {
		return new double[] { destX, destY };
	}

	public void setAutoPilot(boolean enableAutoPilot) {
		autoPilot = enableAutoPilot;
	}

	public boolean isAutoPilot() {
		return autoPilot;
	}
	
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    
}
