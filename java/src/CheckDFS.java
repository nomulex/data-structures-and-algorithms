public class CheckDFS {

    public static String dfs(Graph g) {
        String result = "";
        if (g.getVertices() <1){
            return "";
        }

        boolean[] visited = new boolean[g.getVertices()];

        for(int i= 0; i < g.getVertices(); i++){
            if(!visited[i]){
                result += dfsVisit(g,i,visited);
            }
        }

        // Write - Your - Code
        return result;
    }

    public static String dfsVisit(Graph g , int source, boolean[] visited){
        String result = "";
        Stack<Integer> stack = new Stack(g.getVertices());
        stack.push(source);

        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            result += String.valueOf(currentNode);
            DoublyLinkedList<Integer>.Node temp = g.getAdjacencyList()[currentNode].getHeadNode();

            while(temp !=null){
                if(!visited[temp.data]){
                    visited[temp.data] = true;
                    stack.push(temp.data);
                }

                temp = temp.nextNode;
            }
        }

        return result;



    }
}

