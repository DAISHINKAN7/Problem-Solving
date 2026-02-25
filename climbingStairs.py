class Solution:
    def climbStairs(self, n: int) -> int:
        one, two = 1, 1
        for i in range(2, n + 1):
            one, two = one + two, one
        return one
s = Solution()
print(s.climbStairs(2))  # Output: 2
print(s.climbStairs(3))  # Output: 3    