public class LinkedList<I extends Number> {
    static class Node{
        int data;
        Node next;
        public Node(){
            data=0;
            next=null;
        }
        public Node(int data){
            this.data = data;
            this.next =null;
        }


    }

    Node head;

    public static LinkedList<Number> insert (LinkedList<Number> list , int data){
        Node newNode = new Node(data);
        //check if list has got nodes added
        if (list.head == null){
            list.head = newNode;
        }
        else{
            //list has got nodes
            Node last = list.head;
            //traverse nodes to go to last node and add it
            while (last.next !=null){
                last =last.next;

            }
            //insert node at last node
            last.next = newNode;
        }
        return list;
    }

    public static boolean findValueInList(LinkedList<Number> list , int value){
        //list is empty
        if(list.head==null){
            return false;
        }
        Node currentNode = list.head;

        while (currentNode.next != null){
            if (currentNode.data == value){
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;

    }

    public static boolean rFindValueInList(Node currNode, int value){
        if (currNode ==null){
            return false;
        }
        else if (currNode.data == value){
            return true;
        }

        return rFindValueInList(currNode.next,value);

    }

    public static LinkedList<Number> insertAtHead(LinkedList<Number> list , int data){
        Node newNode = new Node(data);

        if (list.head != null) {
            newNode.next = list.head;
        }
        list.head = newNode;

        return list;
    }

    public static void printList(Node node){
        //print from head to last
        System.out.print("{");
        while(node.next != null){
            System.out.print(node.data + " ->") ;
            node = node.next;
        }
        System.out.print(node.data);
        System.out.print("}");
        System.out.println("");

    }

    public static void printList (LinkedList<Number> list){
        Node node = list.head;
        LinkedList.printList(node);
    }

    public static  Node addReverse(Node node, Node node2){

        Node result = addReverse(node, node2,0);

        return result;
    }

    public static Node addReverse(Node first, Node second, int carry){
        if (first==null && second==null && carry==0){
            return null;
        }

        Node nextFirst = null;
        Node nextSecond =null;

        int value =carry;
        int reminder = 0;
        if (first !=null){
            value +=first.data;
            nextFirst= first.next;
        }
        if(second !=null){
            value +=second.data;
            nextSecond = second.next;
        }

        if (value >=10){
            carry =1;
            reminder = value%10;
        }else{
            reminder = value;
            carry =0;
        }




        Node result = new Node(reminder);
        result.next = addReverse(nextFirst, nextSecond, carry);
        return result;

    }

    public static void printReverse(Node node){
        if (node ==null){
            return;
        }
        printReverse(node.next);
        System.out.print(String.valueOf(node.data) + " ");
    }


    public static Node reverse (Node node){
        // use pointer
        Node previous = null;
        Node current = node;
        Node next = null;

        while (current !=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next ;


        }

        node = previous;

        return node;

    }



    public static void main (String [] args){
      /*  LinkedList<Number> list = new LinkedList<Number>();
        LinkedList.insert(list,3);
        LinkedList.insert(list, 5);
        LinkedList.insert(list,7);

        LinkedList.printList(list);

        System.out.println("");

        LinkedList<Number> list1 = new LinkedList<Number>();
        LinkedList.insertAtHead(list1,5);
        LinkedList.insertAtHead(list1,6);
        LinkedList.insertAtHead(list1,8);
        LinkedList.insertAtHead(list1,11);
        LinkedList.insertAtHead(list1,15);
        LinkedList.printList(list1);

        System.out.println("");

        System.out.println("Find 9 in first list");

        String valueExists = LinkedList.findValueInList(list,9)? "True":"False";

        System.out.println(valueExists);
        System.out.println("");

        System.out.println("Find 6 in second list");
        String exists = LinkedList.findValueInList(list1,6)? "Yes":"No";
        System.out.println(exists);

        System.out.println("Find 10 in first list ");
        Node head = list.head;
        exists = LinkedList.rFindValueInList(head,10)? "Yes":"No";
        System.out.println(exists);

        System.out.println("Find 11 in second list");
        Node head1 = list1.head;
        exists = LinkedList.rFindValueInList(head1,11)? "Yes": "No";
        System.out.println(exists);

        LinkedList.printList(list.head);
        Node reverse = LinkedList.reverse(list.head);
        LinkedList.printList(reverse);


        LinkedList.printList(list1.head);

         System.out.println("Print Reverse");
        printReverse(list1.head);

        LinkedList.printList(list1.head);

        Node reverse1 = LinkedList.reverse(list1.head);
        LinkedList.printList(reverse1);

*/
        LinkedList<Number> list = new LinkedList<Number>();
        LinkedList.insert(list,6);
        LinkedList.insert(list, 5);

        LinkedList<Number> list1= new LinkedList<Number>();
        LinkedList.insert(list1,9);
        LinkedList.insert(list1, 8);
        LinkedList.insert(list1,7);

       Node result = addReverse(list.head, list1.head);

       printList(result);



    }
}
