N = int(input())
budget_lst = list(map(int, input().split()))
M = int(input())

low = 0
high = max(budget_lst)
result = 0
temp_budget = 0

while low <= high:
    mid = (low+high) // 2

    for i in budget_lst:
        if i > mid:
            temp_budget += mid
        else:
            temp_budget += i
    
    if temp_budget <= M:
        result = mid
        low = mid + 1
        temp_budget = 0
    
    else:
        high = mid - 1
        temp_budget = 0

print(result)