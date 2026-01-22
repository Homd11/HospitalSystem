public class WaitingList {
    private Heap waitingList;
    private Patient patient;

    public WaitingList() {
    waitingList =new Heap(100000);
    }

    public void addToWaitList(Patient patient ) {
     waitingList.insert(patient);
    }
    public void removeFromWaitList() {
        waitingList.delete();
    }
    public void PrintWaitingList(){
        waitingList.print();
    }
}
