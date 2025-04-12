import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ElevatorController {
    private List<Elevator> elevatorList;
    private BlockingQueue<PersonRequest> requestQueue;

    public void startController(int floor) {
        // Keep assigning requests to best elevator
        try {
            while(!Thread.currentThread().isInterrupted()) {
                PersonRequest personRequest = requestQueue.take();
                Elevator elevator = getBestElevator(personRequest);
                elevator.addFloorRequest(personRequest.getDestinationFloor());r

            }

        }catch(Exception e) {
            System.out.println("Exception caught");
            Thread.currentThread().interrupt();
        }
    }

    public Elevator getBestElevator(PersonRequest personRequest) {

        // We can have some advance logic as well to select the best elevator.
        for(Elevator elevator : elevatorList) {
            if(elevator.isIdle()) {
                return elevator;
            }
        }
        return elevatorList.get(0);
    }

}
