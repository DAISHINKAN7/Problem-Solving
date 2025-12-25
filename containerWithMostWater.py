class Solution:
    def container_with_most_water(self, height:list[int]) -> int:
        #BRUTE Force
        # res = 0
        
        # for l in range(len(height)):
        #     for r in range(l+1, len(height)):
        #         area = (r - l) * min(height[l], height[r])
        #         res = max(res, area)
        # return res
    
        #Method 2: Two Pointer Approach
        left, right = 0, len(height) - 1
        res = 0

        while left < right:
            area = (right - left) * min(height[left], height[right])
            res = max(res, area)

            if height[left] < height[right]:
                left += 1
            else: 
                right -= 1

        return res
    
s = Solution()
print(s.container_with_most_water([1,8,6,2,5,4,8,3,7]))