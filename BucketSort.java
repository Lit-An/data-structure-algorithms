package sort;

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = {1,4,5,8,3,6,2,7,10,13,9};
        int bucketSize = 4;
        bucketSort(nums,bucketSize);
        for(int num: nums){
            System.out.println(num);
        }
    }
    public static void bucketSort(int[] nums, int bucketSize){
        if (nums.length < 2){
            return;
        }
        // find min & max to calculate the bucketCount
        int min = nums[0];
        int max = nums[1];
        for (int i = 0 ; i < nums.length; i++){
            if (min > nums[i]){
                min = nums[i];
            }else if (max < nums[i]){
                max = nums[i];
            }
        }
        // calculate the bucket count
        int bucketCount = (max - min)/2 + 1;
        int[][] bucket = new int[bucketCount][bucketSize];
        int[] indexArray = new int[bucketCount]; // to record the sum of number in every bucket
        //put numbers into bucket
        for (int i = 0; i < nums.length; i++){
            //calculate the number of the bucket
            // into which the number should be deposited
            int bucketIndex = (nums[i] - min) / bucketSize;
            //expansion the bucket[bucketIndex]
            if (indexArray[bucketIndex] == bucket[bucketIndex].length){
                increaseCapacity(bucket,bucketIndex);
            }
            bucket[bucketIndex][indexArray[bucketIndex]++] = nums[i];
        }
        //sort the number in the buckets using by quick_sort
        int k = 0;
        for (int i = 0; i < bucket.length; i++){
            if (indexArray[i] == 0){
                continue;
            }
            quickSort(bucket[i],indexArray[i]);
            for(int j = 0; j < indexArray[i]; j++){
                nums[k++] = bucket[i][j];
            }
        }

    }
    public static void increaseCapacity(int[][] buckets,int bucketIndex){
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = buckets[tempArr.length*2];
        for (int i = 0; i < tempArr.length; i++){
            newArr[i] = tempArr[i];
        }
        buckets[bucketIndex] = newArr;
    }

    public static void quickSort(int[] nums,int n){
        quickSortFinally(nums,0,n-1);
    }
    public static void quickSortFinally(int[] nums, int q, int r){
        if (q >= r) return;
        int p = partition(nums,q,r);
        quickSortFinally(nums,q,p-1);
        quickSortFinally(nums,p+1,r);
    }
    public static int partition(int[] nums, int q, int r){
        int pivot = nums[r];
        int i = q;
        for (int j = q; j < r; j++){
            if(nums[j] < pivot){
                if (i == j){
                    i++;
                }else{
                    swap(nums,i,j);
                }
            }
        }
        swap(nums,i,r);
        return i;
    }
    public static void swap(int[] nums, int a, int b){
        if (nums[a] == nums[b]) return;
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
