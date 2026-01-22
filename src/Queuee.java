public class Queuee {
     Node rear,front;


    public Queuee() {
        rear = null;
        front = null;
    }

    public boolean isEmpty(){
     if(front == null&&rear == null){return true;}
     else return false;

    }



    public void enqueue(Object data) {
        Node newNode =new Node(data);

        if(isEmpty()){
         front=rear=newNode;
        }else
        {
         rear.next=newNode;
         rear=newNode;
        }

    }




    public void display(){
        Node temp=front;
     while(temp!=null){
         System.out.println(temp.data);
         temp=temp.next;
     }
        System.out.println("null");

    }




    public Object dequeue(){
        Node temp=front;

        if (isEmpty()){
        System.out.println("null");
    }   else
    {
      front = front.next;
    }
        if (front == null){
            rear=null;
        }
        return temp.data;



    }





}
