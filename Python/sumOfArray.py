#Method 1:
def sumOfArray(arr):
    total = 0
    for num in arr:
        total += num
    return total

arr = [1, 2, 3, 4, 5]
print("Sum of array:", sumOfArray(arr))


#Method 2:
def sumOfArray(arr):
    return sum(arr)

arr = [1, 2, 3, 4, 5]
print("Sum of array:", sumOfArray(arr))