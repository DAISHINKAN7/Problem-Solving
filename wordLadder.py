from typing import List
import collections
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        neighbours = collections.defaultdict(list)
        wordList.append(beginWord)

        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j+1:]
                neighbours[pattern].append(word)

        visit = set([beginWord])
        queue = deque([beginWord])
        res = 1

        while queue:
            for i in range(len(queue)):
                word = queue.popleft()
                if word == endWord:
                    return res
                
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j+1:]
                    for neighWord in neighbours[pattern]:
                        if neighWord not in visit:
                            visit.add(neighWord)
                            queue.append(neighWord)

            res += 1
        return 0 
    
s = Solution()

print(s.ladderLength(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]))
print(s.ladderLength(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]))