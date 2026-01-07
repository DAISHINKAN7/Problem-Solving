public class duplicateNumber {
    public int findDuplicate(int nums[]){
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {2,2,2,2,2};

        duplicateNumber dn = new duplicateNumber();
        System.out.println(dn.findDuplicate(nums1)); // Output: 2
        System.out.println(dn.findDuplicate(nums2)); // Output: 3
        System.out.println(dn.findDuplicate(nums3)); // Output: 2
    }
}
