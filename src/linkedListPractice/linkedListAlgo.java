package linkedListPractice;

import linkedListPractice.bean.Node;
import linkedListPractice.iterface.CustomLinkedListAlgo;
import linkedListPractice.listImple.CustomLinkedList;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/10 22:39
 * @description：
 * @modified By：
 * @version: $
 */
/*
单链表反转
链表中环的检测
两个有序的链表合并
删除链表倒数第 n 个结点
求链表的中间结点
 */
public class linkedListAlgo {

    //单链表反转
    public static Node inversionList(Node node) {
        Node cur = node;// 记录当前结点
        Node pre = null; // 记录上一个结点
        while (cur != null) {
            //记录当前结点的next指针
            Node temp = cur.getNext();
            //设置当前结点反转后的next结点
            cur.setNext(pre);
            //设置当前cru结点为下一个结点的pre结点
            pre = cur;
            //移动cur结点为之前记录的反转前cur的next结点,为下一轮循环赋值
            cur = temp;
        }
        return pre;
    }
    //  两个有序的链表合并

    public static Node margeLinkedList(Node l1, Node l2) {
        Node node = new Node(0);
        Node p = node;
        while(l1 !=null && l2 != null ){
            if((int)l1.getElement() < (int)l2.getElement()){
                p.setNext(l1);
                l1 = l1.getNext();
            }else{
                p.setNext(l2);
                l2 = l2.getNext();
            }
            p = p.getNext();
        }
        if(l1 != null ){p.setNext(l1);}
        if(l2 != null ){p.setNext(l2);}
        return node.getNext();
    }

    //删除链表倒数第 n 个结点
    public static void delNodeByDescIndex(Node l1 , int index){
        Node fast = l1;
        int i = 1;
        while(fast!=null && i < index ){
            fast = fast.getNext();
            i++;
        }
        if(fast == null ){return; }

        Node slow = l1;
        Node pre = null;
        while(fast.getNext()!=null){
            fast = fast.getNext();
            pre = slow;
            slow = slow.getNext();
        }
        if(pre == null ){
            l1 = l1.getNext();
        }else{
            pre.setNext(pre.getNext().getNext());
        }

    }

    /*
    求链表的中间结点
     */
    public static Node searchMidNode(Node l1){
        Node fast = l1;
        Node slow = l1;
        while(fast != null && fast.getNext() != null ){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
            return slow;
    }

    public static void main(String[] args) {
        CustomLinkedListAlgo custom = new CustomLinkedList();
        custom.insertToTail(1);
        custom.insertToTail(3);
        custom.insertToTail(5);
        custom.insertToTail(7);
        custom.insertToTail(9);
        custom.insertToTail(11);
        custom.insertToTail(13);
        custom.insertToTail(15);
//        Node node = custom.findByIndex(0);
//        Node inversionNode = inversionList(node);
//        custom.printAll(inversionNode);
//        CustomLinkedListAlgo custom2 = new CustomLinkedList();
//        custom2.insertToTail(2);
//        custom2.insertToTail(4);
//        custom2.insertToTail(6);

//        Node node = margeLinkedList(custom.findByIndex(0), custom2.findByIndex(0));
//        custom.printAll(node);

        //此处数位链表长度为7是因为该方法没有写在自定义链表类中,无法修改length长度导致.此处仅作为测试方法
//        delNodeByDescIndex(custom.findByIndex(0),2);
//        custom.printAll();

        Node node = searchMidNode(custom.findByIndex(0));
        System.out.println(node.getElement());
    }
}
