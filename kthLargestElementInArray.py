from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #Method 1: Normal Sort
        # nums.sort()
        # return nums[len(nums) - k]

        #Method 2: Quick Select
        k = len(nums) - k

        def quickSelect(left, right):
            pivot, p = nums[right], left
            for i in range(left, right):
                if nums[i] <= pivot:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1
            
            nums[p], nums[right] = nums[right], nums[p]

            if p > k:
                return quickSelect(left, p - 1)
            elif k > p:
                return quickSelect(p + 1, right)
            else:
                return nums[p]
        
        return quickSelect(0, len(nums) - 1)
    
s = Solution()
print(s.findKthLargest([3,2,1,5,6,4], k = 2))
print(s.findKthLargest([3,2,3,1,2,4,5,5,6], k = 4))