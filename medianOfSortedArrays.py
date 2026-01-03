class Solution:
    def medianOfSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        A, B = nums1, nums2
        total = len(A) + len(B)
        half = total // 2
        
        if len(A) > len(B):
            A, B = B, A
            
        l, r = 0, len(A) - 1
        
        while True:
            i = (l + r) // 2  # A's median index
            j = half - i - 2  # B's median index
            
            Aleft = A[i] if i >= 0 else float("-infinity")
            Aright = A[i + 1] if (i + 1) < len(A) else float("infinity")
            Bleft = B[j] if j >= 0 else float("-infinity")
            Bright = B[j + 1] if (j + 1) < len(B) else float("infinity")
            
            # partition is correct
            if Aleft <= Bright and Bleft <= Aright:
                # odd
                if total % 2:
                    return min(Aright, Bright)
                # even
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1

s = Solution()
print(s.medianOfSortedArrays([1,3], [2]))          # Output: 2.0
print(s.medianOfSortedArrays([1,2], [3,4]))        # Output: 2.5
print(s.medianOfSortedArrays([0,0], [0,0]))        # Output: 0.0
print(s.medianOfSortedArrays([], [1]))               # Output: 1.0
print(s.medianOfSortedArrays([2], []))               # Output: 2.0