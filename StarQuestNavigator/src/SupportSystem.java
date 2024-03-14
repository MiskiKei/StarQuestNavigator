
public class SupportSystem {

	private boolean Monitoring = false;
	private boolean LightsOn = false;
	private boolean isShieldsActivated = false;
	private int temperature = 50;

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

	// SETTER AND GETTER

	public boolean isMonitoring() {
		return Monitoring;
	}

	public void setMonitoring(boolean monitoring) {
		Monitoring = monitoring;
	}

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

	public boolean isLightsOn() {
		return LightsOn;
	}

	public void setLightsOn(boolean lightsOn) {
		LightsOn = lightsOn;
	}
}
