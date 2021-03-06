package 算法题;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class likou141 {
    /**
     * 经典解法就是用两个指针，一个跑得快，一个跑得慢。
     * 如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；
     * 如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环。
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }


    int pos = 0;

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (pos < 0) return false;
        ListNode p = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while (p.next != null) {
            map.put(p, index);
            if (map.containsKey(p)) {
                return true;
            }
            p = p.next;
            index++;
        }
        return false;
    }


    public static void main(String[] args) {
        likou141 likou141 = new likou141();

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
