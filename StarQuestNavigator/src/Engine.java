
public class Engine {

	private boolean EngineRunning = false;

	public void startEngine() {
		if (!EngineRunning) {
			System.out.println("Engine started.");
			EngineRunning = true;
		} else {
			System.out.println("Engine is already running.");
		}
	}

	public void stopEngine() {
		if (EngineRunning) {
			System.out.println("Engine stopped.");
			EngineRunning = false;
		} else {
			System.out.println("Engine is already stopped.");
		}
	}

	public void increaseThrottle() {
		System.out.println("Throttle increased.");
	}

	public void decreaseThrottle() {
		System.out.println("Throttle decreased.");
	}
	
	//SETTER AND GETTER

	public boolean isEngineRunning() {
		return EngineRunning;
	}

	public void setEngineRunning(boolean engineRunning) {
		EngineRunning = engineRunning;
	}

}
