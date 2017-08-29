import java.util.Stack;

/**
 * Created by blunt on 2017/8/23.
 */
public class LinkList {
    public Node head;
    public Node current;

    public void add(int data){
        if ( head ==null){
            head = new Node(data);
            current = head;
        }else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    public void add(Node node){
        if (node == null) return;
        if ( head == null){
            head = node;
            current = head;
        }else {
            current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
            current = current.next;
        }
    }

    /**
     * Add from middle
     */
    public void addFromNode(int data,Node node){
        if (this.Find(node.data) == null) {
            return;
        }
        current = node;
        Node tmp = new Node(data);
        tmp.next = current.next;
        current.next = tmp;

    }

    /**
     * Find data from list
     */
    public Node Find(int data){
       if ( head == null) {
           return null;
       }else{
           current = head;
           while (current != null){
               if (current.data == data) return current;
               current = current.next;
           }
           return null;
       }

    }

    /**
     *Reverse LinkList
     */

    public Node reverse(Node Head){
        if ( head ==null || head.next == null){
            return head;
        }
        Node current = head;
        Node next = null ;
        Node pre = null ;
        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current ;
            current = next ;
        }
        return pre;
    }

    /**
     * ReversePrint
     * @param head
     */
    public void reversePrint(Node head){
        if (head == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        current = head;

        while (current != null){
            stack.push( current);
            current = current.next;
        }

        while( stack.size()>0 ){
            System.out.println(stack.pop().data);

        }
    }

    public void print(Node node) {
        if (node == null) return;
        current = node;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    public Boolean hasCycle(Node head){
        if ( head == null) return false;

        Node first = head;
        Node second = head;

        while ( second.next!= null && second.next.next!= null){
            first = first.next;
            second = second.next.next;

            if (first == second) return true;
        }

        return false;


    }

    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data =  data;
        }
    }

}

