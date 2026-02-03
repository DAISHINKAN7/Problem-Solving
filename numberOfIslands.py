from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        visited = [[False for _ in range(cols)] for _ in range(rows)]
        
        def dfs(r: int, c: int):
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return
            if grid[r][c] == '0' or visited[r][c]:
                return
            
            visited[r][c] = True
            
            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            for dr, dc in directions:
                dfs(r + dr, c + dc)
        
        island_count = 0
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1' and not visited[r][c]:
                    dfs(r, c)
                    island_count += 1
        
        return island_count
    
s = Solution()
print(s.numIslands([
    ["1","1","0","0","0"],
    ["1","1","0","0","0"], 
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]))  # Output: 3
print(s.numIslands([
    ["1","1","1"],
    ["0","1","0"],
    ["1","1","1"]
]))  # Output: 1