class Solution:
    def longest_substring_without_repeating(self, s:str) -> int:
        charSet = set()
        left = 0
        res = 0

        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[left])
                left += 1
            charSet.add(s[r])
            res = max(res, r - left + 1)
        return res
    

s = Solution()
print(s.longest_substring_without_repeating("abcabcbb"))
print(s.longest_substring_without_repeating("bbbbb"))
print(s.longest_substring_without_repeating("pwwkew"))