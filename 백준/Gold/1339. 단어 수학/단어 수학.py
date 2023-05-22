N = int(input())
alpha_dict = {}
alpha_lst = []
dict_value = []

num = 9
sum = 0

for i in range(N):
    alpha_lst.append(input().strip())

for i in range(N):
    for j in range(len(alpha_lst[i])):
        if alpha_lst[i][j] in alpha_dict:
            alpha_dict[alpha_lst[i][j]] += 10 ** (len(alpha_lst[i])-j-1)
        else:
            alpha_dict[alpha_lst[i][j]] = 10 ** (len(alpha_lst[i])-j-1)

for i in alpha_dict.values():
    dict_value.append(i)

dict_value.sort(reverse=True)

for i in dict_value:
    sum += num * i
    num -= 1

print(sum)