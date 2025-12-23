class Solution:
    def two_sum(self, nums: list[int], target: int) -> list[int]:
        # Time complexity: O(n), Space complexity: O(n)
        num_map = {}

        for i, num in enumerate(nums):
            difference = target - num
            if difference in num_map:
                return [num_map[difference], i]
            
            num_map[num] = i
        return
    
s = Solution()
nums = [2,7,11,15]
target = 17
print(s.two_sum(nums, target))  # Output: [0, 1]