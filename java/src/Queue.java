public class Queue <T> {
    private int front ;
    private int back ;
    private int maxSize;
    private T[] arr;
    private int currentSize;

    public Queue(int max_size){
        this.maxSize = max_size;
        this.front = 0;
        this.back = -1;
        this.currentSize=0;
        this.arr = (T[]) new Object [max_size];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty(){
        return this.currentSize ==0;
    }

    public boolean isFull(){
        return this.currentSize == this.maxSize;
    }
    public T Top(){
        if (this.isEmpty()){
             System.err.println("Queue is empty");
             return null;
        }
        return this.arr[front];
    }

    public void Enqueue (T value){
        if (this.isFull()){
            System.err.println("Queue is full");
            return;
        }
        back = (back + 1) % maxSize; //keep index in range
        currentSize++;
        this.arr[back] = value;

    }

    public T Dequeue (){
        if (this.isEmpty()){
            System.err.println("Queue is empty");
            return null;
        }
        T temp = this.arr[front];
        currentSize--;
        front = (front+1) % maxSize;
        return temp;
    }

    public static void main (String[] args){
        Queue<Integer> q = new Queue<Integer>(4);
        System.out.println(1);
        q.Enqueue(1);
        System.out.println(2);
        q.Enqueue(2);
        System.out.println(3);
        q.Enqueue(3);
        System.out.println(4);
        q.Enqueue(4);

        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());

        System.out.println(5);
        q.Enqueue(5);
        System.out.println(6);
        q.Enqueue(6);
        System.out.println(7);
        q.Enqueue(7);
        System.out.println(8);
        q.Enqueue(8);

        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());


    }
}
