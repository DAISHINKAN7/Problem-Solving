class Solution:
    def minimum_window_substring(self, s: str, t: str) -> str:
        if t == "":
            return "" 
        
        Tcount, window = {}, {}

        for c in t:
            Tcount[c] = 1 + Tcount.get(c, 0)
        
        have, need = 0, len(Tcount)

        res, resLen = [-1, -1], float("infinity")
        left = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)
            
            if c in Tcount and window[c] == Tcount[c]:
                have += 1
            
            while have == need:
                #update result
                if (r - left + 1) < resLen:
                    res = [left, r]
                    resLen = (r - left + 1)
                
                #Pop from left
                window[s[left]] -= 1
                if s[left] in Tcount and window[s[left]] < Tcount[s[left]]:
                    have -= 1

                left += 1

        left, r = res
        return s[left:r+1] if resLen != float("infinity") else ""
    
s = Solution()
print(s.minimum_window_substring("ADOBECODEBANC", "ABC"))
print(s.minimum_window_substring("a", "a"))
print(s.minimum_window_substring("a", "aa"))

