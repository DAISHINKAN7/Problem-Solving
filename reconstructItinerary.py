from typing import List
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = { src : [] for src, dst in tickets }
        for src, dst in tickets:
            adj[src].append(dst)
        for src in adj:
            adj[src].sort()
        res = []
        def dfs(src):
            while adj.get(src,[]):
                dst = adj[src].pop(0)
                dfs(dst)
            res.append(src)
        dfs("JFK")
        return res[::-1]
    
s = Solution()
print(s.findItinerary(tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]))
print(s.findItinerary(tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]))