public class BST {
    private Node root;
    public static class Node{
        private Node leftChild;
        private Node rightChild;
        private int data ;

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild){
            this.rightChild=rightChild;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public Node (int value){
            this.data =value;
            this.setLeftChild(null);
            this.setRightChild(null);

        }
    }

    public boolean isEmpty(){
        return this.getRoot() ==null;
    }

    public Node getRoot() {
        return root;
    }

    public void add(int value){
        Node newNode = new Node(value);

        if(this.isEmpty()){
            this.root = newNode;
            return;
        }

        Node currentNode = this.getRoot();

        while (currentNode !=null){

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (currentNode.getData() > value){
                if (leftChild == null){
                    currentNode.setLeftChild(newNode);
                    return;
                }
                currentNode =leftChild;
            }
            else {
                if (rightChild ==null){
                    currentNode.setRightChild(newNode);
                    return;
                }
                currentNode =rightChild;
            }

        }

        return;


    }

    public  void printTree(Node node){
        if (node ==null)
            return;

        System.out.print(String.valueOf(node.getData()) + ",");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }

    public Node insertRecursive(Node currentNode, int value){


        if (currentNode==null){
            return new Node(value);
        }
        Node rightChild = currentNode.getRightChild();
        Node leftChild = currentNode.getLeftChild();

        if (currentNode.getData()>value){
            currentNode.setLeftChild(insertRecursive(leftChild, value));
        }
        else if (currentNode.getData() <value){
            currentNode.setRightChild(insertRecursive(rightChild,value));
        }
        else {
            return currentNode;
        }

        return currentNode;

    }

    public void addR (int value){
        if (this.isEmpty()){
            this.root = insertRecursive(null,value);
            return;
        }

        this.insertRecursive(this.root, value);
    }

    public Node search (int value){
        if(this.isEmpty()){
            return null;
        }
        Node currentNode = this.root;

        while (currentNode != null){
            if(currentNode.getData() > value){
                currentNode = currentNode.getLeftChild();
            }
            else if (currentNode.getData()< value){
                currentNode = currentNode.getRightChild();
            }
            else if (currentNode.getData() == value){
                return currentNode;
            }
        }

        System.out.println("Value not found");

        return null;

    }

    public Node searchRecursive(Node node, int value){
        if (node ==null){
            return null;
        }

        if(node.getData() ==value){
            return node ;
        }

        if (node.getData() > value){
            return searchRecursive(node.getLeftChild(), value);
        }
        else{
            return searchRecursive(node.getRightChild(),value);
        }
    }

    public Node searchR(int value){
        if (this.isEmpty()){
            return null;
        }
        Node root = this.getRoot();
        return searchRecursive(root,value);
    }

    public void preTraverse(Node node){
        if(node ==null){
            return ;
        }
        System.out.print(node.getData());
        preTraverse(node.getLeftChild());
        preTraverse(node.getRightChild());

    }

    public void inOrderTraverse(Node node){
        if(node==null){
            return;
        }
        inOrderTraverse(node.getLeftChild());
        System.out.print(node.getData());
        inOrderTraverse(node.getRightChild());
    }

    public void postOrderTraverse(Node node){
        if(node == null){
            return ;
        }

        postOrderTraverse(node.getLeftChild());
        postOrderTraverse(node.getRightChild());
        System.out.print(node.getData());
    }

    public static boolean validateBST(Node root){
        return validateBSTR(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBSTR(Node node, Integer min, Integer max){
        if(node == null){
            return true;
        }

        if (node.getData()> max || node.getData() <min){
            return false;
        }

        if (!validateBSTR(node.getLeftChild(), Integer.MIN_VALUE,node.getData()))
            return false;
        if(!validateBSTR(node.getRightChild(),node.getData(),Integer.MAX_VALUE))
            return false;

        return true;


    }

    public static void main (String [] args){
        BST bst = new BST();
        bst.add(5);
        bst.add(7);
        bst.add(6);
        bst.add(9);
        bst.add(4);
        bst.add(3);
        bst.add(2);

        bst.printTree(bst.getRoot());

        System.out.println();
        BST bst2 = new BST();
        bst2.addR(6);
        bst2.addR( 8);
        bst2.addR( 7);
        bst2.addR( 10);
        bst2.addR(5);
        bst2.addR( 4);
        bst2.addR( 3);

       // bst2.printTree(bst2.getRoot());

       // System.out.println(String.valueOf(bst.search(9)));
       // System.out.println(String.valueOf(bst.search(10)));

       // System.out.println(String.valueOf(bst2.searchR(3)));
       // System.out.println(String.valueOf(bst2.searchR(15)));

        bst.preTraverse(bst.getRoot());
        System.out.println();
        bst.inOrderTraverse(bst.getRoot());
        System.out.println();
        bst.postOrderTraverse(bst.getRoot());

        System.out.println(validateBST(bst.getRoot()));


    }


}
