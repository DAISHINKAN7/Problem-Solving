import heapq
class MedianFinder:

    def __init__(self):
        self.small, self.large = [], []


    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -1 * num)

        #Make sure every num small is <= every num in large
        if(self.small and self.large and (-1 * self.small[0]) > self.large[0]):
            val = -1 * heapq.heappop(self.small)
            heapq.heappush(self.large, val)

        #uneven size
        if len(self.small) > len(self.large) + 1:
            val = -1 * heapq.heappop(self.small)
            heapq.heappush(self.large, val)
        elif len(self.large) > len(self.small) + 1:
            val = heapq.heappop(self.large)
            heapq.heappush(self.small, -1 * val)

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return -self.small[0]
        if len(self.large) > len(self.small):
            return self.large[0]
        
        return (-self.small[0] + self.large[0]) / 2
    
m = MedianFinder()
m.addNum(1)
m.addNum(2)
print(m.findMedian())
m.addNum(3)
print(m.findMedian())
        