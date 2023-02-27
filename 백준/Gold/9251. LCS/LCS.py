import sys
input = sys.stdin.readline

str1 = input().strip()
str2 = input().strip()

str1_len = len(str1)+1
str2_len = len(str2)+1

Lcs_lst = [[0] * str2_len for _ in range(str1_len)]

for i in range(1,str1_len):
    for j in range(1,str2_len):
        if str1[i-1] == str2[j-1]:
            Lcs_lst[i][j] = Lcs_lst[i-1][j-1] + 1
        
        else:
            Lcs_lst[i][j] = max(Lcs_lst[i][j-1], Lcs_lst[i-1][j])

print(Lcs_lst[str1_len-1][str2_len-1])