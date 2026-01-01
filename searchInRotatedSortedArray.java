public class searchInRotatedSortedArray {
    public int search(int nums[], int target){
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //Left case
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            //Right case
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        searchInRotatedSortedArray srs = new searchInRotatedSortedArray();
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int[] nums3 = {1};
        int target3 = 0;

        System.out.println(srs.search(nums1, target1)); // Output: 4
        System.out.println(srs.search(nums2, target2)); // Output: -1
        System.out.println(srs.search(nums3, target3)); // Output: -1
    }
}
