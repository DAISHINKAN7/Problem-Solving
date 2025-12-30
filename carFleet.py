class Solution:
    def carFleet(self, target: int, position: list[int], speed: list[int]) -> int:
        pair = [[p, s] for p, s in zip(position, speed)]

        stack = []
        for p, s in sorted(pair, reverse=True):
            stack.append((target - p) / s)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
            
        return len(stack)
    

s = Solution()
print(s.carFleet(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]))
print(s.carFleet(10, [3], [3]))  
print(s.carFleet(100, [0, 2, 4], [4, 2, 1]))  