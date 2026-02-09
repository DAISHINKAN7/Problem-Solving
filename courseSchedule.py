from typing import List
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        prerequisitesMap = {i: [] for i in range(numCourses)}

        for course, prereq in prerequisites:
            prerequisitesMap[course].append(prereq)

        visited = set()

        def dfs(course):
            if course in visited:
                return False
            if not prerequisitesMap[course]:
                return True
            
            visited.add(course)
            for prereq in prerequisitesMap[course]:
                if not dfs(prereq):
                    return False
            visited.remove(course)
            prerequisitesMap[course] = []
            return True
        
        for course in range(numCourses):
            if not dfs(course):
                return False
        return True
    
s = Solution()
numCourses = 2
prerequisites1 = [[1,0]]
print(s.canFinish(numCourses, prerequisites1))
numCourses = 2
prerequisites = [[1,0],[0,1]]
print(s.canFinish(numCourses, prerequisites))
