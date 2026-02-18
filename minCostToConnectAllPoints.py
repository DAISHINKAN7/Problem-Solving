from typing import List

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        minDist = [float("inf")] * n
        minDist[0] = 0
        visited = set()
        
        res = 0
        
        for _ in range(n):
            u = -1
            for i in range(n):
                if i not in visited and (u == -1 or minDist[i] < minDist[u]):
                    u = i
            
            visited.add(u)
            res += minDist[u]
        
            for v in range(n):
                if v not in visited:
                    dist = abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
                    minDist[v] = min(minDist[v], dist)
        
        return res

    
s = Solution()
print(s.minCostConnectPoints(points = [[0,0],[2,2],[3,10],[5,2],[7,0]]))
print(s.minCostConnectPoints(points = [[3,12],[-2,5],[-4,1]]))