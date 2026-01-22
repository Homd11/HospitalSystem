public class QueueBst {
    NodeBst front , rear ;

    public QueueBst() {
        front = rear = null ;
    }
    public void enQueue(NodeBst node) {
        if (front == null) {
            front=rear=node;
        }else {
            rear.next=node;
            rear=node;
        }


    }
    public NodeBst deQueue() {
        if (isEmpty()){
            return null;
        }
        NodeBst dequeuedNode = front ;
        front = front.next ;
        if (front == null){
            rear=null;
        }
        return dequeuedNode;
    }

    public boolean isEmpty() {
        return front == null && rear == null ;
    }
}
