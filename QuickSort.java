package LeetCode;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums ={1,5,6,4,2,3};
        QuickSort.quickSort(nums,6);
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void quickSort(int[] nums,int n){//n = nums.length
        quickSortFinally(nums,0,n-1);
    }
    public static void quickSortFinally(int[] nums, int p, int r){
        if (p >= r){
            return;
        }
        //分区
        int q = partition(nums,p,r);
        quickSortFinally(nums, p , q-1);
        quickSortFinally(nums,q+1,r);
    }
    public static int partition(int[] nums, int p ,int r){
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r ;j++){
            if (nums[j] < pivot){
                if (i == j){
                    i++;
                }else{
                    int temp = nums[i];
                    nums[i++] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        return i;
    }
}
