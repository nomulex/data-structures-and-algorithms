public class DoublyLinkedList <T> {
    public class Node{
        public T data;
        public Node nextNode;
        public Node prevNode;
        public Node (T data){
            this.data = data;
            this.nextNode = null;
            this.prevNode =null;
        }

    }
    private Node headNode;
    private Node tailNode;
    public int size ;

    public DoublyLinkedList(){
        this.headNode =null;
        this.tailNode = null;
    }

    public boolean isEmpty(){
        return this.headNode==null && this.tailNode ==null;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(T data){
        Node newNode = new Node(data);
        if (this.isEmpty()){
            this.headNode =newNode;
            this.tailNode =newNode;
        }
        else{
            Node headNode = this.getHeadNode();
            newNode.nextNode = headNode;
            headNode.prevNode = newNode;
            this.headNode = newNode;
        }
        this.size++;
    }

    public void insertAtEnd(T data){
        if (this.isEmpty()){
            this.insertAtHead(data);
        }
        else{
            Node newNode = new Node(data);
            Node tailNode = this.getTailNode();
            tailNode.nextNode = newNode;
            newNode.prevNode = tailNode;
            this.tailNode = newNode;
        }
    }

    public void printList(){
        if(this.isEmpty()){
            System.out.println("list is empty");
        }

        Node temp = getHeadNode();

        System.out.print("null==>");

        while (temp.nextNode !=null){
            System.out.print(String.valueOf(temp.data)+ "<==>");
            temp = temp.nextNode;
        }

        System.out.println(String.valueOf(temp.data) + "==>null");


    }

    public void printListReverse(){
        if(this.isEmpty()){
            System.out.println("List is empty");
        }
        Node temp = this.getTailNode();
        System.out.print("null==>");

        while (temp.prevNode !=null){
            System.out.print(String.valueOf(temp.data) + "<==>");
            temp = temp.prevNode;
        }
         System.out.println(String.valueOf(temp.data) +  "==> null");

    }

    public void deleteAtHead(){
        if (this.isEmpty()) return;

        Node nextNode = getHeadNode().nextNode;
        if (nextNode ==null){
            this.tailNode = null;
        }
        else{
            nextNode.prevNode = null;
        }
        this.headNode = nextNode;
        size--;
    }

    public void deleteAtTail(){
        if (isEmpty()) return;
        Node penultimateNode = this.getTailNode().prevNode;
        if(penultimateNode ==null){
            this.headNode =null;
        }
        else{
            penultimateNode.nextNode = null;
        }
        this.tailNode = penultimateNode;
        this.size--;
    }

    public static void main (String [] args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.printList();
        list.printListReverse();
        list.insertAtHead(6);
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.printList();
        list.printListReverse();
        list.deleteAtHead();
        list.deleteAtTail();
        list.printList();
        list.printListReverse();

    }


}
