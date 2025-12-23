class Solution:
    def top_k_frequent(self, nums: list[int], k: int) -> list[int]:
        counts = {}
        freq = [[] for i in range(len(nums) + 1)]

        for n in nums:
            counts[n] = 1 + counts.get(n, 0)
        for n, c in counts.items():
            freq[c].append(n)

        res = []
        for i in range(len(freq) - 1, 0, -1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res
        
s = Solution()
nums = [1,1,1,2,2,3]
k = 2
print(s.top_k_frequent(nums, k))  # Output: [1, 2