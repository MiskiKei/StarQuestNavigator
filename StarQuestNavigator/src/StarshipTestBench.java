public class StarshipTestBench {

    public static void main(String[] args) {
        System.out.println("Starting the testbench for class Starship");

        // Test Case 1: Checking if getRemFuel returns the correct initial value
        Starship ship1 = new Starship("gold", 1998, 85.0, 3456);
        double result = ship1.getRemFuel();
        if (result != 85.0) {
            System.out.println("Problem with getRemFuel");
        }

        // Test Case 2: Testing refuel method
        ship1.refuel(20.0);
        result = ship1.getRemFuel();
        if (result != 105.0) {
            System.out.println("Problem with refuel method");
        }

        // Test Case 3: Testing changeVelocity method
        ship1.setVelocity(50.0);
        result = ship1.getVelocity();
        if (result != 50.0) {
            System.out.println("Problem with changeVelocity method");
        }

        // Test Case 4: Testing setDestination method
        ship1.setDestination(100.0, 200.0);
        double[] destination = ship1.getDestination();
        if (destination[0] != 100.0 || destination[1] != 200.0) {
            System.out.println("Problem with setDestination method");
        }

        // Test Case 5: Testing toggleAutoPilot method
        ship1.setAutoPilot(true);
        if (!ship1.isAutoPilot()) {
            System.out.println("Problem with toggleAutoPilot method");
        }
        
        System.out.println("Testbench completed successfully.");
    }
}
