while True:
    string = input()
    stack = []
    if string == '.':
        break

    for i in string:
        if i == '(':
            stack.append(i)
        elif i == '[':
            stack.append(i)
        elif i == ')':
            if not stack:
                print('no')
                break
            elif stack[-1] == '(':
                stack.pop()
            else:
                print('no')
                break
        elif i == ']':
            if not stack:
                print('no')
                break
            elif stack[-1] == '[':
                stack.pop()
            else:
                print('no')
                break
    else:
        if stack:
            print('no')
        else:
            print('yes')