def compareTriplets(a, b):
    result = []
    alice_score = 0
    bob_score = 0

    for i in range(len(a)):
        if a[i] > b[i]:
            alice_score += 1
        elif a[i] < b[i]:
            bob_score += 1

    result.append(alice_score)
    result.append(bob_score)

    return result

a = [int(input()) for i in range(3)]
b = [int(input()) for i in range(3)]
result = compareTriplets(a, b)
print(result)