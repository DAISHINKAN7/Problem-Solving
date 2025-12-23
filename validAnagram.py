from collections import Counter
class Solution:
    def valid_anagram(self, s: str, t: str) -> bool:
        # Method 1 (Time complexity: O(s+t), space complexity: O(s+t))
        if len(s) != len(t):
            return False
        countS, countT = {}, {}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)

        for c in countS:
            if countS[c] != countT.get(c, 0):
                return False
            
        return True
    
        #Method 2: Cheat method usinf Counter
        # return Counter(s) == Counter(t)

        #Method 3:Sorting
        return sorted(s) == sorted(t)


s = Solution()
print(s.valid_anagram("anagram", "nagaram"))
print(s.valid_anagram("rat", "car"))