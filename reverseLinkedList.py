from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        if not head.next:
            return head
        
        newHead = self.reverseList(head.next)
        head.next.next = head
        head.next = None

        return newHead

def print_list(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)

print("Original list:")
print_list(head)

s = Solution()
reversed_head = s.reverseList(head)

print("Reversed list:")
print_list(reversed_head)
