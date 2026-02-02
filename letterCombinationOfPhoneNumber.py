from typing import List
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        d = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

        ans = [""]

        for i in digits:
            s = d[int(i) - 2]
            ans = [a + b for a in ans for b in s]

        return ans
    
s = Solution()
print(s.letterCombinations("23"))
print(s.letterCombinations("2"))