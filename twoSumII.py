class Solution:
    def two_sum_II(self, numbers:list[int], target:int) -> list[int]:
        left, right = 0, len(numbers) - 1

        while left < right:
            currSum = numbers[left] + numbers[right]
            if currSum > target:
                right -= 1
            elif currSum < target:
                left += 1
            else:
                return [left + 1, right + 1]
            
        return []
    
s = Solution()
print(s.two_sum_II([2,7,11,15], 9)) 