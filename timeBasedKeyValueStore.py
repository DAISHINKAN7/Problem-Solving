class TimeMap:
    def __init__(self):
        self.store = {}

    def set(self, key:str, value: str, timestamp:int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append([value,timestamp])

    def get(self, key:str, timestamp:int) -> str:
        res = ""
        values = self.store.get(key,[])

        #binary search
        left, right = 0, len(values) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if values[mid][1] <= timestamp:
                res = values[mid][0]
                left = mid + 1
            else:
                right = mid - 1

        return res

t = TimeMap()
t.set("foo","bar",1)
print(t.get("foo",1))  # return "bar"
print(t.get("foo",3))  # return "bar", since there is no value  corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar"
t.set("foo","bar2   ",4)
print(t.get("foo",4))  # return "bar2"
print(t.get("foo",5))  # return "bar2"       