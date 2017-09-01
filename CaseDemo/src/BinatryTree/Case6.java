package BinatryTree;

import java.util.Arrays;

/**
 * Created by blunt on 2017/8/30.
 */


public class Case6 {
    public static void main(String[] args) throws Exception {
        int[] preSort = {1,2,4,7,3,5,6,8};
        int[] inSort = {4,7,2,1,5,3,8,6};
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node root = ReConstruct(preSort,inSort);
    }

    private static BinaryTree.Node ReConstruct(int[] preSort, int[] inSort) throws Exception {
        if ( preSort == null || inSort == null) return null;
        if ( preSort.length != inSort.length )  throw new Exception("不合法的输入");

        BinaryTree.Node root = new BinaryTree.Node();

        for (int i = 0; i < inSort.length; i++) {
            if ( inSort[i] == preSort[0]){
            root.key = inSort[i];
            root.data = ":"+inSort[i];
            root.leftChild = ReConstruct(Arrays.copyOfRange(preSort,1,i+1),Arrays.copyOfRange(inSort,0,i));

            root.rightChild = ReConstruct(Arrays.copyOfRange(preSort,i+1,preSort.length),Arrays.copyOfRange(inSort,i+1,inSort.length));
            }

        }
        root.display();
        return root;



    }
}
