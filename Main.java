import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<PersonRequest> requestQueue = new LinkedBlockingQueue<>();

        // Create elevators
        Elevator e1 = new Elevator(1);
        Elevator e2 = new Elevator(2);

        // Start elevator threads
        e1.start();
        e2.start();

        List<Elevator> elevators = Arrays.asList(e1, e2);

        // Create and start controller
        ElevatorController controller = new ElevatorController(elevators, requestQueue);
        Thread controllerThread = new Thread(() -> controller.startController(0));
        controllerThread.start();

        // Simulate person requests
        Thread requestSimulator = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < 3; i++) {
                int from = rand.nextInt(3);
                int to;
                do {
                    to = rand.nextInt(3);
                } while (to == from);

                PersonRequest request = new PersonRequest(from, to, requestQueue);
                new Thread(request).start();

                try {
                    Thread.sleep(1000); // Simulate time between requests
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        requestSimulator.start();

        // Optional: Let the simulation run for a while then shut down
        try {
            Thread.sleep(20000); // Run simulation for 20 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Shutdown sequence
        System.out.println("Shutting down elevators and controller...");

        e1.stopElevator();
        e2.stopElevator();
        controllerThread.interrupt();

    }

}
