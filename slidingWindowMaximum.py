import collections
class Solution:
    def sliding_window_maximum(self, nums:list[int], k:int) -> list[int]:
        output = []
        q = collections.deque()
        left = right = 0

        while right < len(nums):
            while q and nums[q[-1]] < nums[right]:
                q.pop()
            q.append(right)

            # remove left element if its out of the window
            if left > q[0]:
                q.popleft()

            if (right + 1) >= k:
                output.append(nums[q[0]])
                left += 1
            right +=1

        return output

s = Solution()
print(s.sliding_window_maximum([1,3,-1,-3,5,3,6,7], 3))
print(s.sliding_window_maximum([1], 1))