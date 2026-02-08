from typing import List
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        time, fresh = 0, 0
        rows, cols = len(grid), len(grid[0])

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append((r, c))
                elif grid[r][c] == 1:
                    fresh += 1


        while q and fresh > 0:
            for i in range(len(q)):
                r, c = q.popleft()
                for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    nr, nc = r + dr, c + dc
                    if (nr < 0 or nc < 0 or nr == rows or nc == cols or grid[nr][nc] != 1):
                        continue
                    grid[nr][nc] = 2
                    fresh -= 1
                    q.append((nr, nc))
            time += 1

        return time if fresh == 0 else -1
    
s = Solution()
grid = [[2,1,1],[1,1,0],[0,1,1]]
print(s.orangesRotting(grid))