class Solution:
    def largest_consecutive_sequence(self, nums: list[int]) -> int:
        numSet = set(nums)
        longest = 0

        for num in numSet:
            if (num-1) not in numSet:
                length = 0
                while (num+length) in numSet:
                    length += 1
                longest = max(length, longest)

        return longest
    
s = Solution()
nums = [100, 4, 200, 1, 3, 2]
print(s.largest_consecutive_sequence(nums))  # Output: 4 (The sequence is