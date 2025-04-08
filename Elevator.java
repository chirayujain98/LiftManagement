
public class Elevator extends Thread {
    private int id;
    private int currentFloor;
    boolean isRunning;

    Elevator() {
        isRunning = true;
    }

    public void run() {
        while (isRunning) {

        }
    }

    public void stopElevator() {
        isRunning = false;
    }

}