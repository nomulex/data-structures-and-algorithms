import java.util.*;
import java.io.*;
import java.util.LinkedList;

public class DFSRecursive {
    public static class Graph{
        public int Vertices;
        public LinkedList<Integer> [] adjacencyList;
        public Graph(int vertices){
            this.Vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for(int i = 0; i < vertices; i++){
                adjacencyList[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int source, int destination ){
            this.adjacencyList[source].addLast(destination);
        }

    }

    public static void printAdjList(Graph g){
        for(int i =0; i <g.Vertices; i++){
            System.out.print(String.valueOf(i)+ "==>");
            LinkedList<Integer> Node = g.adjacencyList[i];
            Iterator it = Node.listIterator();

            if(it.hasNext()){

                while (it.hasNext()){
                    int n  = (int) it.next();
                    System.out.print(String.valueOf(n)+"==>");
                }
                System.out.println("null");
            }
            else{
                System.out.println("null");
            }
        }
    }

    public static void Dfs ( Graph graph ){
         boolean [] visited = new boolean[graph.Vertices];
         for (int i = 0; i < graph.Vertices; i++){
             if (! visited[i]){
                 doDfs(i, visited, graph);
             }
         }

    }

    public static boolean detectCycle(Graph g){
        boolean[] visted = new boolean[g.Vertices];
        boolean[] visitedCurr = new boolean[g.Vertices];

        for (int i =0; i < g.Vertices; i++){
            if (isCyclic(i,g, visted, visitedCurr)){
                return true;
            }
        }
         return false;
    }

    public static boolean isCyclic(int vertex, Graph g , boolean[] visited, boolean[] vistedCurr){
//in visited
        if(vistedCurr[vertex]){
            return true;
        }

        vistedCurr[vertex] = true;
        visited[vertex]=true;
        LinkedList<Integer> node = g.adjacencyList[vertex];
        Iterator<Integer> list = node.listIterator();

        while(list.hasNext()){
            int n = list.next();
            visited[n] = true;
                if (isCyclic(n,g, visited,vistedCurr)){
                    return true;
                }

        }

        vistedCurr [vertex] = false;
        return false;
    }

    public static void doDfs(int vertex, boolean [] visited, Graph g){

        visited[vertex] = true;
        System.out.print(String.valueOf(vertex));
       Iterator <Integer> node = g.adjacencyList[vertex].listIterator();
        while (node.hasNext()){
            int n = node.next();
            if (!visited[n]){
                visited[n] =true;
                doDfs(n, visited,g);
            }
        }

    }

    public static void main (String [] args ){
        Graph g = new Graph(9);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(5,3);
        g.addEdge(5,6);
        g.addEdge(3,6);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(6,4);
        g.addEdge(7,8);
        printAdjList(g);
        Dfs(g);

        System.out.println();
        System.out.println(detectCycle(g)? "Cyclic": "Not Cyclic");

    }

}
