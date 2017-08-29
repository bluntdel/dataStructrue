/**
 * Created by blunt on 2017/8/28.
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1,"A");
        binaryTree.createTree();
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.height());
        binaryTree.afterTraverseWith2Stacks(binaryTree.getRoot());
        binaryTree.afterTraverseRecursive();
    }


}
