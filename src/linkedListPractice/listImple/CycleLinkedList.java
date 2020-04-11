package linkedListPractice.listImple;

import linkedListPractice.bean.Node;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/10 22:34
 * @description：
 * @modified By：
 * @version: $
 */
//环链表 主要用于测试检 测环的操作方法方法
public class CycleLinkedList {
    private static final Integer DEFAULT_CAPACITY = 10;//默认容量

    private Node head;//哨兵结点

    private Integer capacity = 0;

    private Integer length = 0;

    public CycleLinkedList() {
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public CycleLinkedList(Integer capacity) {
        this.length = 0;
        this.capacity = capacity;
    }

    public Node getFirstNode(){
        return head;
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data,null);
            head.setNext(head);
            this.length++;
            return;
        }
        Node temp = head;
        while (temp.getNext() != head) {
            temp = temp.getNext();
        }
        if (this.length >= capacity) {
            System.out.println("链表容量已满,请处理");
            return;
        }
        Node new_node = new Node(data,head);//环链表最后一个结点指向头结点
        temp.setNext(new_node);
        this.length++;


    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println("linkedListInversions Element ======>" + temp.element);
            temp = temp.getNext();
        }
    }

    public void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println("linkedListInversions Element ======>" + temp.element);
            temp = temp.getNext();
        }
    }
    //环检测
    public static boolean checkRing(Node node){
        if(node.getNext() == null ){
            return false; //环形链表中一般不会存在next指针为null
        }
        Node slow = node;//定义慢指针
        Node fast = node;//定义快指针
        while(fast != null && fast.getNext() != null ){
            slow = slow.getNext();//slow指针一次走一个结点
            fast = fast.getNext().getNext();//fast指针一次
            //判断如果有一个时刻slow与fast相等,则正面有环返回true 否则返回false
            if(slow == fast ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
