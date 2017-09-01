package Sort;

/**
 * Created by blunt on 2017/8/31.
 */
public class Sort {
    public static void swapInt(int a, int b,int[] arr){
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }


    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean swapflag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapInt(j, j + 1, arr);
                    swapflag = true;
                }
            }
            if (!swapflag) break;
        }
    }

    public static int[] quickSort(int[] arr,int low,int high){
        if ( low < high){
            //返回的middle 既等于low也等于high，
            int middle = partition(arr,low,high);
            quickSort(arr,low,middle-1);
            quickSort(arr,middle+1,high);
        }
        return arr;
    }

    public static int[] quickSort2(int[] arr,int low,int high){
        if ( low < high){
            //返回的middle 既等于low也等于high，
            int middle = partition2(arr,low,high);
            quickSort2(arr,low,middle-1);
            quickSort2(arr,middle+1,high);
        }
        return arr;
    }

    public static int partition2(int[] arr, int low, int high){
        int pivot = arr[low];

        while (high > low){
            //从high开始遍历，如果high大于pivot则high--往前推移，知道某一个数小于等于pivot，则交换
            while ( high>low && arr[high] >= pivot) {
                high--;
            }
                swapInt(high, low, arr);
            //此时交换后，low元素肯定小于pivot，则low++，继续寻找至一个大于pivot的元素，交换。
            while ( high>low && arr[low] <= pivot){
                low++;
            }
                swapInt(high, low, arr);
        }
        return low;

    }

    private static int partition(int[] arr, int low, int high) {
        // 分解
        int pivot = arr[high];
        int i = low - 1;
        int temp;

        //i初始为-1，每发现一个比pivot小的元素，则将它与i的位置互换，并将i++，
        // 则最终比pivot小的元素则依次排列，最终把pivot和中间位置互换
        for (int j=low; j < high; j++){
            if (arr[j] <= pivot ){
                i++;
                swapInt(i,j,arr);
            }
        }

        swapInt(i+1,high,arr);
        return  i+1;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        sort(arr,0,arr.length-1,tmp);
    }

    private static void sort(int[] arr, int left,int right,int[] tmp){
        if (left >= right){
            return;
        }

        if (left < right){
            int middle = (left+right)/2;
            sort(arr,left,middle,tmp);  //递归分解至单个元素
            sort(arr,middle+1,right,tmp);
            merge(arr,left,middle,right,tmp);
        }


    }

    private static void merge(int[] arr, int left,int middle, int right, int[] tmp) {
        int i = left;
        int j = middle+1; //right 序列指针
        int k = 0; //tmp指针
        while ( i<=middle && j<=right){
            if ( arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }

        while (i<=middle){
            tmp[k++] = arr[i++];
        }

        while (j<=right){
            tmp[k++] = arr[j++];
        }

        k = 0;
        while(left<=right){
            arr[left++] = tmp[k++];
        }

    }

    /**
     * 选择排序
     *
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1;j < arr.length;j++){
                if ( arr[i] > arr[j] ) {
                    swapInt(i,j,arr);
                }
            }

        }
    }

    public static void selectSort2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int lowIndex = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[lowIndex] > arr[j]){
                    lowIndex = j;
                }
            }
            swapInt(i,lowIndex,arr);
        }
    }

}
