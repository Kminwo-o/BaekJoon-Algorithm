import sys
input = sys.stdin.readline

# 트리에 들어갈 노드 생산
class Node:
    def __init__(self,data,left_data,right_data):
        self.data = data
        self.left = left_data
        self.right = right_data

# 전위 순회
def pre_traversal(Node):
    print(Node.data, end='')
    if Node.left != None:
        pre_traversal(tree[Node.left])
    if Node.right != None:
        pre_traversal(tree[Node.right])

# 중위 순회
def in_traversal(Node):
    if Node.left != None:
        in_traversal(tree[Node.left])
    print(Node.data,end='')
    if Node.right != None:
        in_traversal(tree[Node.right])

# 후위 순회
def post_traversal(Node):
    if Node.left != None:
        post_traversal(tree[Node.left])
    if Node.right != None:
        post_traversal(tree[Node.right])
    print(Node.data,end='')

N = int(input())
tree = {}

for _ in range(N):
    data, left, right = input().split()
    if left == '.':
        left = None
    if right == '.':
        right = None
    tree[data] = Node(data, left, right)

pre_traversal(tree['A'])
print()
in_traversal(tree['A'])
print()
post_traversal(tree['A'])