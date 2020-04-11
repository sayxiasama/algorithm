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
    public static Node inversionList(Node node){
        Node cur = node ;// 记录当前结点
        Node pre = null; // 记录上一个结点
        while(cur != null ){
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
    // TODO
    /*
    两个有序的链表合并
    删除链表倒数第 n 个结点
    求链表的中间结点
     */

    public static void main(String[] args) {
        CustomLinkedListAlgo custom = new CustomLinkedList();
        custom.insertToTail(1);
        custom.insertToTail(3);
        custom.insertToTail(5);
        Node node = custom.findByIndex(0);
        Node inversionNode = inversionList(node);
        custom.printAll(inversionNode);
    }
}
