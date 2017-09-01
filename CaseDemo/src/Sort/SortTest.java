package Sort;

/**
 * Created by blunt on 2017/8/31.
 */
public class SortTest {
    public static void main(String[] args) {
        final int arrNum = 100000;


        int[] arr =new int[arrNum] ;
        for (int i = 0; i < arrNum; i++) {
            arr[i] = (int) (Math.random()*1000);
        }
        int[] arr2 = arr.clone();

        int[] arr3 = {2,2,4,1,2,7,0,3,9};

        long startTime = System.currentTimeMillis();
//        Sort.bubbleSort(arr);
        Sort.selectSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        long startTime2 = System.currentTimeMillis();
        Sort.selectSort2(arr2);
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2-startTime2);



    }

}
