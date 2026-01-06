from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def linkedListCycle(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast:
                return True
        
        return False
    
def print_list(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None") 

# Example usage:
head = ListNode(3)
head.next = ListNode(2)
head.next.next = ListNode(0)
head.next.next.next = ListNode(-4)
head.next.next.next.next = head.next  # Create a cycle for testing  
s = Solution()
has_cycle = s.linkedListCycle(head)
print("Cycle detected!" if has_cycle else "No cycle detected.")  # Output should be