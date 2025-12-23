from collections import defaultdict
class Solution:
    def group_anagrams(self, strs: list[str]) -> list[list[str]]:
        # Time complexity: O(m * n)
        res = defaultdict(list) #mapping charcter count to list of anagrams

        for s in strs:
            count= [0] * 26 # there are 26 letters in the english alphabet
            
            for char in s:
                count[ord(char) - ord('a')] += 1

            res[tuple(count)].append(s)

        return res.values()
    
s = Solution()
strs = ["eat","tea","tan","ate","nat","bat"]
print(s.group_anagrams(strs))