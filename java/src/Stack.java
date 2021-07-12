public class Stack <T> {
    private int maxSize ;
    private int top;
    private T [] arr;

    public  Stack(int max_Size){
        this.maxSize =max_Size;
        this.top = -1;
        arr = (T[]) new Object[max_Size];
    }

    public int  getCapacity(){
        return this.maxSize;
    }

    public boolean isEmpty (){
        return this.top == -1;
    }

    public boolean isFull(){
        return  this.top == this.maxSize -1;
    }

    public T Top(){
        if (this.isEmpty()) return null;
        return this.arr[this.top];
    }

    public void push (T value){
        if(this.isFull()){
            System.err.println("Stack is full");
            return;
        }
        this.arr[++top] = value;
    }
    public T pop(){
        if(this.isEmpty()){
            System.err.println("Stack is empty");
            return null;
        }
        return this.arr[top--];


    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int resultIndex = 0;
        Stack<Integer> stack = new Stack<>(arr.length);
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.Top() <= arr[i]) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else
                result[i]  = stack.Top();
            stack.push(arr[i]);
        }
        return result;
    }


    public static void main (String[] args){
        Stack<Integer> stack = new Stack<Integer>(4);
        System.out.println(stack.isEmpty()? "Stack is Empty": "Stack is not Empty");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isFull()? "Stack is full": "Stack is not full");
        System.out.println(stack.Top());
        stack.pop();
        System.out.println(stack.Top());
        stack.pop();
        System.out.println(stack.Top());
        stack.pop();
        System.out.println(stack.Top());
        stack.pop();
        System.out.println(stack.isEmpty()? "Stack is Empty": "Stack is not Empty");

        int arr[] = {4,6,3,2,8,1,11};
        System.out.print("[");

        for (int i:arr){
            System.out.print( i);
            System.out.print( " ");
        }

        System.out.print("]");

        int result[] = nextGreaterElement(arr);
        System.out.print("[");

        for (int i:result){
            System.out.print( i);
            System.out.print( " ");
        }

        System.out.print("]");


    }
}
