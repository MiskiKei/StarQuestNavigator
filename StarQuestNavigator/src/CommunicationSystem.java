
public class CommunicationSystem {

	private boolean Connected = false;
	private String command;

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
			this.command = command;
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

	// SETTER AND GETTER

	public boolean isConnected() {
		return Connected;
	}

	public void setConnected(boolean connected) {
		Connected = connected;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
