from typing import List

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        visit = set()

        minHeap = [[grid[0][0], 0, 0]]
        visit.add((0, 0))

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while minHeap:
            t, r, c = minHeap.pop(0)
            if r == n - 1 and c == n - 1:
                return t
            for dr, dc in directions:
                newR, newC = r + dr, c + dc
                if (newR < 0 or newC < 0 or newR >= n or newC >= n or (newR, newC) in visit):
                    continue
                visit.add((newR, newC))
                minHeap.append([max(t, grid[newR][newC]), newR, newC])
            minHeap.sort()  
        return -1   
    
s = Solution()
print(s.swimInWater([[0,2],[1,3]]))
print(s.swimInWater([[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]))