import java.util.LinkedList;

public class Graph {
    private int vertices;
    private DoublyLinkedList<Integer> adjacencyList [];

    public Graph (int vertices){
        this.vertices = vertices;
        this.adjacencyList = new DoublyLinkedList[vertices];
        for(int i=0; i<vertices; i++){
            this.adjacencyList[i] = new DoublyLinkedList<>();
        }

    }

    public int getVertices() {
        return vertices;
    }

    public DoublyLinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void addEdge(int source, int destination){
        if (source< vertices && destination < vertices){
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }


    public void printGraph(){

        System.out.println("Adjacency List Print for graph");

        for(int i =0 ; i <vertices; i++){
            System.out.print("|" + i+"| =>");
            DoublyLinkedList<Integer>.Node temp = this.adjacencyList[i].getHeadNode();
            if (temp !=null){

                while(temp.nextNode !=null){
                    System.out.print("[" + String.valueOf(temp.data) + "] =>");
                    temp = temp.nextNode;
                }

                System.out.println(String.valueOf(temp.data) + "=> null");
            }
            else{
                System.out.println("null");
            }
        }

    }

    public static void main (String [] args){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);

        graph.printGraph();
    }


}
