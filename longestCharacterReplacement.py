class Solution:
    def longest_character_replacement(self, s:str, k:int) -> int:
        count = {}
        res = 0
        left  = 0

        for right in range(len(s)):
            count[s[right]] = 1 + count.get(s[right], 0)
            while(right-left+1) - max(count.values()) >= k:
                count[s[left]] -= 1
                left += 1

            res = max(res, right-left+1)
        
        return res
    
s = Solution()
print(s.longest_character_replacement("ABAB", 2))
print(s.longest_character_replacement("AABABBA", 1))