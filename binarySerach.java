public class binarySerach {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;

            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        binarySerach bs = new binarySerach();
        int[] nums1 = {-1,0,3,5,9,12};
        int target1 = 9;
        int[] nums2 = {-1,0,3,5,9,12};
        int target2 = 2;
        int[] nums3 = {5};
        int target3 = 5;

        System.out.println(bs.search(nums1, target1)); // Output: 4
        System.out.println(bs.search(nums2, target2)); // Output: -1
        System.out.println(bs.search(nums3, target3)); // Output: 0
    }
}
