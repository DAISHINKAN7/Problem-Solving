import java.util.PriorityQueue;

public class mergeKSortedLists {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val).append("->");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
    public static void main(String[] args) {
    mergeKSortedLists solution = new mergeKSortedLists();

    mergeKSortedLists.ListNode[] input1 = new mergeKSortedLists.ListNode[]{};
    mergeKSortedLists.ListNode[] input2 = new mergeKSortedLists.ListNode[]{
        solution.new ListNode(1),
        solution.new ListNode(0)
    };
    mergeKSortedLists.ListNode[] input3 = new mergeKSortedLists.ListNode[]{
        solution.new ListNode(1, solution.new ListNode(4, solution.new ListNode(5))),
        solution.new ListNode(1, solution.new ListNode(3, solution.new ListNode(4))),
        solution.new ListNode(2, solution.new ListNode(6))
    };

    solution.mergeKLists(input1);
    solution.mergeKLists(input2);
    solution.mergeKLists(input3);   

    System.out.println("Merged List 1: " + listToString(solution.mergeKLists(input1))); // Expected: null
    System.out.println("Merged List 2: " + listToString(solution.mergeKLists(input2))); // Expected: 0->1->null
    System.out.println("Merged List 3: " + listToString(solution.mergeKLists(input3))); // Expected: 1
    }
}
