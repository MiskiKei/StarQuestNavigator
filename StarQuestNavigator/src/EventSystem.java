import java.util.Random;

public class EventSystem {
	
	private SupportSystem supportSystem;
	private static Random randGen = new Random();
	
	public EventSystem(SupportSystem supportSystem) {
		this.supportSystem = supportSystem;
	}


	private void exploreIcePlanetEvent() {
		supportSystem.setRegulateTemperature(-150);
		System.out.println("Exploring a new area... Brrr! Encountered an ice planet!");
		supportSystem.autoRegulateTemperature(); 
	}


	private void handleLavaPlanetEvent() {
		supportSystem.setRegulateTemperature(500);
		System.out.println("Exploring a new area... Oh no! Encountered a lava planet!");
		supportSystem.autoRegulateTemperature(); 
	}

	
	private void exploreDesertPlanetEvent() {
		supportSystem.setRegulateTemperature(100);
		System.out.println("Exploring a new area... Scorching heat! Encountered a desert planet!");
		supportSystem.autoRegulateTemperature(); 
	}

	private void exploreForestPlanetEvent() {
		supportSystem.setRegulateTemperature(80);
		System.out.println("Exploring a new area... Fresh air and lush vegetation! Encountered a forest planet!");
		supportSystem.autoRegulateTemperature(); 
	}

	// Method to explore random events
	public void exploreRandomEvents() {
		int randomValue = randGen.nextInt(100) + 1; 

		if (randomValue <= 30) {
			handleLavaPlanetEvent();
		} else if (randomValue <= 60) {
			exploreIcePlanetEvent();
		} else if (randomValue <= 80) {
			exploreDesertPlanetEvent();
		} else if(randomValue <= 90) {
			exploreForestPlanetEvent();
		}else {
			System.out.println("Exploring a new area and a bit of space... Nothing unusual found.");
		}
	}
}
