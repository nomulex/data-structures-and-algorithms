public class CheckBFS {

    public  static String bfs (Graph g){
        String result = "";
        boolean[] visited = new boolean[g.getVertices()];
        for (int i=0; i< g.getVertices(); i++){
            if (!visited[i]){
                result +=bfsVisit(g,i,visited);
            }
        }
        return result;
    }

    public static String bfsVisit (Graph g, int source, boolean[] visited){
        String result = "";
        Queue<Integer> queue = new Queue<>(g.getVertices());
        visited[source] = true;
        queue.Enqueue(source);

        while(!queue.isEmpty()){
            int currentNode = queue.Dequeue();
            result +=String.valueOf(currentNode);
            DoublyLinkedList<Integer>.Node temp = g.getAdjacencyList()[currentNode].getHeadNode();
            while (temp != null){
                if (!visited[temp.data]){
                    visited[temp.data] = true;
                    queue.Enqueue(temp.data);
                }
                temp = temp.nextNode;
            }
        }

        return  result;
    }
}
