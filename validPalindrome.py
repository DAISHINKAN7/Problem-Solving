class Solution:
    def valid_palindrome(self, s:str) -> bool:
        #Method 1: Functional appraoch
        # newStr = ""

        # for c in s:
        #     if c.isalnum():
        #         newStr += c.lower()
        # return newStr == newStr[::-1]
    

        #Method 2: Two pointer approach
        left, right = 0, len(s) - 1

        while left < right:
            while not self.alphaNum(s[left]):
                left += 1
            while not self.alphaNum(s[right]):
                right -= 1
                
            if s[left].lower() != s[right].lower():
                return False
            
            left, right = left + 1, right - 1
        
        return True
    
    def alphaNum(self, c):
        return (ord('A') <= ord(c) <= ord('Z')) or (ord('a') <= ord(c) <= ord('z')) or (ord('0') <= ord(c) <= ord('9'))

    

s = Solution()
print(s.valid_palindrome("A man, a plan, a canal: Panama")) 