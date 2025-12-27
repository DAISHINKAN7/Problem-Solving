class Solution:
    def permutation_in_string(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        countS1, countS2 = [0] * 26, [0] * 26
        for i in range(len(s1)):
            countS1[ord(s1[i]) - ord('a')] += 1
            countS2[ord(s2[i]) - ord('a')] += 1

        matches = 0
        for i in range(26):
            matches += (1 if countS1[i] == countS2[i] else 0)

        left = 0
        for right in range(len(s1), len(s2)):
            if matches == 26:
                return True
            
            index = ord(s2[right]) - ord('a')
            countS2[index] += 1
            if countS2[index] == countS1[index]:
                matches += 1
            elif countS2[index] == countS1[index] + 1:
                matches -= 1

            index = ord(s2[left]) - ord('a')
            countS2[index] -= 1
            if countS2[index] == countS1[index]:
                matches += 1
            elif countS2[index] == countS1[index] - 1:
                matches -= 1

            left += 1

        return matches == 26
    
s = Solution()
print(s.permutation_in_string("ab", "eidbaooo"))    
print(s.permutation_in_string("ab", "eidboaoo"))
