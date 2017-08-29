import java.util.Stack;

/**
 * Created by blunt on 2017/8/25.
 */
public class BinaryTree {
    private Node root;


    public BinaryTree(int key,String data){
        root = new Node(key,data);
    }


    private static class Node {
        Node leftChild = null;
        Node rightChild = null;
        boolean isVisited = false;
        int key = 0;
        String data = null;


        public Node(int newKey, String newData){
            leftChild = null;
            rightChild = null;
            key = newKey;
            data = newData;
        }

        public void display(){
            System.out.println("Node:"+key+"-"+data);
        }

    }

    /**
     * Create a BinTree
     */
    public void createTree(){
        Node newNodeB = new Node(2,"B");
        Node newNodeC = new Node(3,"C");
        Node newNodeD = new Node(4,"D");
        Node newNodeE = new Node(5,"E");
        Node newNodeF = new Node(6,"F");
        root.leftChild=newNodeB;
        root.rightChild=newNodeC;
        root.leftChild.leftChild=newNodeD;
        root.leftChild.rightChild=newNodeE;
        root.rightChild.rightChild=newNodeF;
    }

    public boolean isEmpty(){
        return root == null;
    }

    /**
     * size
     *
     */
    public int size(){
        return size(root);
    }

    /**
     * height
     * @return
     */
    public int height(){
        return height(root);
    }

    private int size(Node subTree) {
        if (subTree == null)
            return 0;
        else {
            return 1+size(subTree.leftChild)
                    +size(subTree.rightChild);
        }
    }


    public int height(Node subTree){
        if ( subTree == null) return 0;
        else {
            int i = height(subTree.leftChild);
            int j = height(subTree.rightChild);
            return (i>j)?(i+1):(j+1);
        }
    }

    public Node parent(Node element){
        return (element == null || element==root)? null :parent(root,element);
    }

    private Node parent(Node subTree, Node element) {
        if (subTree == null) return null;
        if ( subTree.leftChild == element ||subTree.rightChild == element) return subTree;
        Node p;
        if ( (p = parent(subTree.leftChild,element)) != null ){
            return  p;
        }else {
            return parent(subTree.rightChild,element);
        }
    }

    public Node getRoot(){
        return root;
    }

    public Node getLeftChildNode(Node element){
        return (element!=null)?element.leftChild:null;
    }

    public Node getRightChildNode(Node element){
        return (element!=null)?element.rightChild:null;
    }

    public void destory(Node subTree){
        if (subTree != null) {
            destory(subTree.leftChild);
            destory(subTree.rightChild);
            subTree = null;
        }
    }


    /**
     * 递归中序遍历
     *
     */
    public void inOrderTraverseRecurse(){
        System.out.println("inOrderTraverseRecurse");
        inOrderTraverseRecurse(root);
    }

    private void inOrderTraverseRecurse(Node subTree) {
        if ( subTree == null) return;
        inOrderTraverseRecurse(subTree.leftChild);
        subTree.display();
        inOrderTraverseRecurse(subTree.rightChild);
    }

    /**
     * 非递归中序遍历
     */
    public void midTraverse(Node current){
        if ( current== null) return;
        System.out.println("Non Recursive MidTraverse!");
        Stack<Node> stack = new Stack<>();

        while ( !stack.isEmpty()){
            if (current != null ){
                stack.push(current);
                current = current.leftChild;
            }else {
                Node  tmp = stack.pop();
                tmp.display();
                current = tmp.rightChild;
            }
        }
    }

    public void preOrderTraverseRecursive(){
        System.out.println("preOrder Recursive!");
        preOrderTraverseRecursive(root);
    }

    private void preOrderTraverseRecursive(Node subTree) {
        if (subTree == null) return;
        subTree.display();
        preOrderTraverseRecursive(subTree.leftChild);
        preOrderTraverseRecursive(subTree.rightChild);
    }

    /**
     * 非递归前序遍历
     */
    public void preTraverse(Node current){
        if ( current == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()){
            Node tmp = stack.pop();
            tmp.display();
            if (tmp.rightChild != null){
                stack.push(tmp.rightChild);
            }
            if (tmp.leftChild != null){
                stack.push(tmp.leftChild);
            }
        }

    }

    /**
     * 非递归后序遍历
     */
    public void afterTraverse(Node current){
        Node printNode = null;
        if (current == null ) return;
        Stack<Node> stack = new Stack<>();
        stack.push(current);

        while(!stack.isEmpty()){
            current = stack.peek();
            // 如果当前栈顶元素的左节点不为空，左右节点均未被打印过，说明该节点是全新的，所以压入栈中
            if(current.leftChild!=null && printNode !=current.rightChild &&printNode!=current.leftChild){
                stack.push(current.leftChild);
                // 第一层不满足，则说明该节点的左子树已经被打印过了。如果栈顶元素的右节点未被打印过，则将右节点压入栈中
            } else if (current.rightChild != null && printNode != current.rightChild){
                stack.push(current.rightChild);
            } else{
                // 上面两种情况均不满足的时候则说明左右子树均被打印过，此时只需要弹出栈顶元素，打印该值即可
                printNode = stack.pop();
                printNode.display();
            }

        }
    }

    /**
     * 后序遍历非递归2
     */
    public void afterTraverse2(Node current){
        if (current == null ) return;
        Stack<Node> stack = new Stack<>();
        while(current != null) {
            stack.push(current);
            current = current.leftChild;
        }

        while (!stack.isEmpty()){
            Node tmp = stack.peek();
            if (tmp.isVisited == true || tmp.rightChild == null) {
                Node printNode = stack.pop();
                printNode.display();
            } else {
                tmp.isVisited = true;
                current = tmp.rightChild;
                while (current!=null){
                    stack.push(current);
                    current = current.leftChild;
                }
            }
        }
    }

    /**
     * 后序遍历递归
     */
    public void afterTraverseRecursive(){
        System.out.println("后序遍历递归");
        afterTraverseRecursive(root);
    }

    private void afterTraverseRecursive(Node subTree) {
        if (subTree == null) return;
        afterTraverseRecursive(subTree.leftChild);
        afterTraverseRecursive(subTree.rightChild);
        subTree.display();
    }

    /**
     * 后序遍历双栈
     */
    public void afterTraverseWith2Stacks(Node current){
        if ( current == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(current);

        while (!stack1.isEmpty()){
            Node tmp = stack1.pop();
            stack2.push(tmp);
            //第一个栈入栈顺序为根-》左-》右；第二个栈顺序为根-》右-》左，输出为：左-》右-》根
            if (tmp.leftChild !=null)
                stack1.push(tmp.leftChild);

            if (tmp.rightChild != null){
                stack1.push(tmp.rightChild);
            }
        }

        while (!stack2.isEmpty()){
            stack2.pop().display();
        }

    }


}
