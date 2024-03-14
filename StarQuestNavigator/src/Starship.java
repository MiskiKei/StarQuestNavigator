import java.util.Random;

public class Starship {
    private String material;
    private int years;
    private double remFuel;
    private long pos;
    private double velocity = 2500.00;
    private double destX = 1254654.0;
    private double destY = 6558454.0;
    private boolean autoPilot = false;
    private double maxFuelCapacity = 10000000;
    private double totalDistanceTraveled = 0;

    private boolean Connected = false;
    private boolean Monitoring = false;
    private boolean LightsOn = false;
    private boolean isShieldsActivated = false;
    private int temperature = 50; 
    
    
    private Engine engine;

    private static Random randGen = new Random();

    public Starship(String inputMat, int inputYear, double inputRemFuel, long inputPos) {
    	
    	// INITIALIZE SUBSYSTEMS
    	engine = new Engine();
    	
        material = inputMat;
        if (inputYear > 1999 && inputYear < 2900) {
            years = inputYear;
        } else {
            years = 1999;
        }
        remFuel = inputRemFuel;
        pos = inputPos;
        
    }

    public Engine getEngine() {
        return engine;
    }
    
    public void operate() {
        operateEngine();
        System.out.println();
        operateCommunication();
        System.out.println();
        operateMonitoring();
        System.out.println();
        operateControls();
        System.out.println();
        double randomDistance = randGen.nextDouble() * 1000; 
        travel(randomDistance);
    }

    private void operateEngine() {
    	engine.startEngine();
    	engine.increaseThrottle();
    }

    private void operateCommunication() {
        communicate();
        sendCommand("Go to destination");
        receiveData();
        disconnect();
    }

    private void operateMonitoring() {
        monitorLifeSupport();
        adjustOxygenLevel(80);
    }

    private void operateControls() {
        turnOnLights();
        exploreRandomEvents();
    }
   
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

	public void autoRegulateTemperature() {
		int criticalHighTemperature = 500;
		int criticalLowTemperature = -100;

		if (getRegulateTemperature() >= criticalHighTemperature) {
			System.out.println("Temperature is too high. Initiating automatic temperature regulation.");
			setRegulateTemperature(getRegulateTemperature() - 450);
			System.out.println("New Temperature: " + getRegulateTemperature() + " degrees");
			activateShields();
		} else if (getRegulateTemperature() <= criticalLowTemperature) {
			System.out.println("Temperature is too low. Initiating automatic temperature regulation.");
			setRegulateTemperature(getRegulateTemperature() + 210);
			System.out.println("New Temperature: " + getRegulateTemperature() + " degrees");
			activateShields();
		} else {
			System.out.println("Temperature is within safe limits. No action needed.");
		}
	}

   

    public void communicate() {
        if (!Connected) {
            System.out.println("Communicating with base.");
            Connected = true;
        } else {
            System.out.println("Already connected to base.");
        }
    }

    public void disconnect() {
        if (Connected) {
            System.out.println("Communication disconnected.");
            Connected = false;
        } else {
            System.out.println("Not currently connected.");
        }
    }

    public void sendCommand(String command) {
        if (Connected) {
            System.out.println("Sending command: " + command);
            System.out.println("Command sent successfully.");
        } else {
            System.out.println("Error: Not connected. Unable to send command.");
        }
    }

    public void receiveData() {
        if (Connected) {
            System.out.println("Receiving data from base....Data received successfully.");
        } else {
            System.out.println("Error: Not connected. Unable to receive data.");
        }
    }

    public void monitorLifeSupport() {
        if (!Monitoring) {
            System.out.println("Life support systems monitored.");
            Monitoring = true;
        } else {
            System.out.println("Life support systems are already being monitored.");
        }
    }

    public void stopMonitoringLifeSupport() {
        if (Monitoring) {
            System.out.println("Stopping life support system monitoring.");
            Monitoring = false;
        } else {
            System.out.println("Life support systems are not currently being monitored.");
        }
    }

    public void adjustOxygenLevel(int percentage) {
        System.out.println("Adjusting oxygen level to " + percentage + "%.");
    }

    public void activateShields() {
        if (!isShieldsActivated()) {
            System.out.println("Shields activated.");
            setShieldsActivated(true);
        } else {
            System.out.println("Shields are already activated.");
        }
    }

    public void deactivateShields() {
        if (isShieldsActivated()) {
            System.out.println("Shields deactivated.");
            setShieldsActivated(false);
        } else {
            System.out.println("Shields are already deactivated.");
        }
    }

    public void turnOnLights() {
        if (!LightsOn) {
            System.out.println("Lights turned on.");
            LightsOn = true;
        } else {
            System.out.println("Lights are already on.");
        }
    }

    public void turnOffLights() {
        if (LightsOn) {
            System.out.println("Lights turned off.");
            LightsOn = false;
        } else {
            System.out.println("Lights are already off.");
        }
    }
    private void exploreIcePlanetEvent() {
    	setRegulateTemperature(-150);
        System.out.println("Exploring a new area... Brrr! Encountered an ice planet!");
        autoRegulateTemperature(); 
    }

    private void handleLavaPlanetEvent() {
    	setRegulateTemperature(500);
        System.out.println("Exploring a new area... Oh no! Encountered a lava planet!");
        autoRegulateTemperature(); 
    }

    private void exploreRandomEvents() {
        int randomValue = randGen.nextInt(100) + 1; 

        if (randomValue <= 45) {
            handleLavaPlanetEvent();
        } else if (randomValue <= 75) {
            exploreIcePlanetEvent();
        } else {
            handleNormalExploration();
        }
    }

    private void handleNormalExploration() {
        System.out.println("Exploring a new area... Nothing unusual found.");
    }

    
    //SETTERS AND GETTERS 
    
	public boolean isShieldsActivated() {
		return isShieldsActivated;
	}

	public void setShieldsActivated(boolean isShieldsActivated) {
		this.isShieldsActivated = isShieldsActivated;
	}

	public int getRegulateTemperature() {
		return temperature;
	}

	public void setRegulateTemperature(int regulateTemperature) {
		this.temperature = regulateTemperature;
	}

	public boolean isConnected() {
		return Connected;
	}

	public void setConnected(boolean connected) {
		Connected = connected;
	}

	public boolean isMonitoring() {
		return Monitoring;
	}

	public void setMonitoring(boolean monitoring) {
		Monitoring = monitoring;
	}

	public boolean isLightsOn() {
		return LightsOn;
	}

	public void setLightsOn(boolean lightsOn) {
		LightsOn = lightsOn;
	}

	public double getRemFuel() {
		return remFuel;
	}

	public long getPos() {
		return pos;
	}

	public double getTotalDistanceTraveled() {
		return totalDistanceTraveled;
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
