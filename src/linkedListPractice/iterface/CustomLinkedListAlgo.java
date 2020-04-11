package linkedListPractice.iterface;

import linkedListPractice.bean.Node;

public interface CustomLinkedListAlgo {
    //查找值为value的结点
    Node findByValue(Object value);
    //根据下标index查询结点
    Node findByIndex(int index);
    //链头插入
    void insertToHead(Object value);
    //链尾插入
    void insertToTail(Object value);
    //在指定结点P后面插入value
    void insertAfterNode(Node p,Object value);
    //在指定结点P前插入value
    void insertBeforeNode(Node p , Object value);
    //删除指定结点
    void deleteByNode(Node p);
    //根绝value删除第一个value结点(扩展,删除全部值为value的结点)
    void deleteByValue(Object Value);
    //获取链表长度
    int size();
    //打印
    void printAll();
    //根据指定结点打印
    void printAll(Node node);
}
