class Solution:
    def contains_duplicate(self, nums: list[int]) -> bool:
        hash_set = set()

        for num in nums:
            if num in hash_set:
                return True
            hash_set.add(num)

        return False
    
s = Solution()
num = [1, 2, 3, 1]
print(s.contains_duplicate(num))

#Time complexity: O(n)
#Space complexity: O(n)