package LeetCode;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {4,2,5,12,3};
        int n = nums.length;
        System.out.println(find(nums,n,2));
        for (int num: nums){
            System.out.println(num);
        }
    }
    public static int find(int[] nums,int n,int k){
        findReally(nums,0,n-1,k);
        return nums[k-1];
    }
    public static void  findReally(int[] nums, int q , int r,int k){
        int p = partition(nums,q,r);
        if (p+1 > k){
            findReally(nums,q,p-1,k);
        }else if (p+1 < k){
            findReally(nums,p+1,r,k);
        }else{
            return;
        }
    }
    public static int  partition(int[] nums, int q, int r){
        int i = q;
        int pivot = nums[r];
        for (int j = q; j < r; j++){
            if(nums[j] < pivot){
                if(i==j){
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
