from typing import Optional

class Node:
    def __init__(self, val: int, next: 'Optional[Node]' = None, random: 'Optional[Node]' = None):
        self.val = val
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldToCopy = {None : None}

        curr = head
        while curr:
            copy = Node(curr.val)
            oldToCopy[curr] = copy
            curr = curr.next

        curr = head
        while curr:
            copy = oldToCopy[curr]
            copy.next = oldToCopy[curr.next]
            copy.random = oldToCopy[curr.random]
            curr = curr.next

        return oldToCopy[head]
    
def print_list(head):
    while head:
        random_val = head.random.val if head.random else None
        print(f"Node val: {head.val}, Random points to: {random_val}")
        head = head.next
    print("None")

# Example usage:
node1 = Node(7)
node2 = Node(13)
node3 = Node(11)
node4 = Node(10)
node5 = Node(1)
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node2.random = node1
node3.random = node5
node4.random = node3
node5.random = node1
s = Solution()
copied_head = s.copyRandomList(node1)
print_list(copied_head)  # Output should show the copied list with correct random pointers