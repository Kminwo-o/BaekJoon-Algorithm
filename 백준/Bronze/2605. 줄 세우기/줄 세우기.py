N = int(input())

stu_lst = list(map(int,input().split()))
lst = []
for i in range(1,N+1):
    if i == 1:
        lst.append(i)
    
    else:
        lst.insert(len(lst) - stu_lst[i-1], i)

print(*lst)