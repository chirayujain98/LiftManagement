import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Elevator extends Thread {
    private int id;
    private int currentFloor;
    private volatile boolean isRunning;
    private BlockingQueue<Integer> floorRequest = new LinkedBlockingQueue<>();
    Elevator(int id) {
        this.id = id;
        isRunning = true;
    }
    public void addFloorRequest(int floor) {
        floorRequest.add(floor);
    }

    public boolean isIdle() {
        return floorRequest.isEmpty();
    }

    public void run() {
        while (isRunning) {
            try {
            Integer targetFloor = floorRequest.take();
            while(targetFloor != currentFloor) {
                if(currentFloor < targetFloor) {
                    currentFloor++;
                }else{
                    currentFloor--;
                }
                Thread.sleep(500);
                System.out.println("The lift of id " + id + "is at floor " + currentFloor); 
            }
            System.out.println("The lift of id " + id + " reached destination floor " + currentFloor);
            Thread.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println("Exception caught in lift " + e.getMessage());
            }
        }
    }

    public void stopElevator() {
        isRunning = false;
    }
    public int getEleveatorId() {
        return this.id;
    }

}