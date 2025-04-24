import java.util.concurrent.BlockingQueue;

public class PersonRequest implements Runnable{
    private int sourceFloor;
    private int destinationFloor;
    private final BlockingQueue<PersonRequest> requestQueue;
    
    public PersonRequest(int source, int destination, BlockingQueue<PersonRequest> queue) {
        this.sourceFloor = source;
        this.destinationFloor = destination;
        this.requestQueue = queue;
    }




    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }



    public void run() {
        try {
        System.out.println("Person requesting elevator from Floor " + sourceFloor +
                               " to Floor " + destinationFloor);

        requestQueue.put(this);

        System.out.println("Person waiting for elevator...");
        }catch(Exception e) {
            System.out.println("Request was interrupted.");
            Thread.currentThread().interrupt();
        }
    }

}