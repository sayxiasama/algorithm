package LRUAlgo;

import linkedListPractice.bean.Node;

import java.util.Scanner;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/9 0:00
 * @description：
 * @modified By：
 * @version: $
 */

//基于单链表简单实现 redis中LRU缓存淘汰算法
//LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据。
public class LruLinkedList<T> {

    //默认容量
    public static final Integer DEFAULT_CAPACITY = 10;

    //头结点
    private Node<T> head; //哨兵结点 不存储数据,只存储指针指向链表第一个结点的内存地址()

    //链表长度
    private Integer length;

    //链表容量
    private Integer capacity;

    //无参构造函数,容量取默认容量
    public LruLinkedList() {
        this.head= new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }
    //带容量参数的构造函数，链表容量为参数指定。
    public LruLinkedList(Integer capacity) {
        this.head = new Node<T>();
        this.capacity = capacity;
        this.length = 0;
    }

    //添加元素
    public void add(T data){
        //遍历链表,查询是否存在一个结点的后继指针指向的结点中存储的数据与data相同(删除结点操作,主要是要获取到需要被删除结点的前一个结点位置)
        Node preNode = getPreNode(data);
        //判断当前数据是否存在与链表中,如果存在则删除该结点,重新将data插入链头
        if(preNode != null ){//存在
            /*删除数据在链表中的结点，*/
            deleteOriginalNode(preNode);
            /*将数据重新添加到链表头部*/
            insertNodeBegin(data);
        }else{//如果不存在则判断链表是否已满,如果链表已满则删除尾结点,将数据添加到链头,如果没满直接插入到链尾
            if(this.length >= this.capacity){
                //删除尾结点
                deleteNodeEnd();
                //插入链头
                insertNodeBegin(data);
            }else{
                //插入链表头部
                insertNodeBegin(data);
            }
        }
    }

    private void deleteNodeEnd() {
        //删除链尾结点,将data插入到链头
        Node tempNode = this.head;
        //空链表直接返回
        if(tempNode.next == null ){
            return;
        }
        //查找尾结点的前一个结点
        while(tempNode.getNext().getNext() != null ){
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(null);//设置倒数第二个结点的后继指针为null
        length --; //删除数据，长度-1
    }

    private void insertNodeBegin(T data) {
        //记录链表原头结点
        Node temp = this.head.getNext();
        //设置新的头结点
//        this.head.setElement(data);
        //新的头结点指向原先的头结点
        this.head.setNext(new Node(data,temp));
        //添加数据，链表长度+1
        length++;
    }

    private void deleteOriginalNode(Node preNode) {
        //记录前驱结点的后继指针指向,
        Node temp = preNode.getNext();
        //将前驱结点的后继指针指向, 指向需要删除结点的后继指针
        preNode.setNext(temp.getNext());
        temp = null;
        length --; //删除数据,所以链表长度减一
    }

    private Node getPreNode(T data) {
        //不能改变链表本身head结点，这里将链表头结点赋值与一个临时结点来遍历链表。
        Node tempNode = this.head;
        //当临时结点的后继指针next不为空时进入循环
        while(tempNode.getNext() != null){
            //如果当前数据存在与链表中
            if(data.equals(tempNode.getNext().element)){
                //返回当前结点
                return tempNode;
            }
            //否则当前结点等于当前结点的下一个结点
            tempNode = tempNode.getNext();
        }
        return null;
    }

    private void printAll(){
        Node temp = this.head.getNext();
        while(temp != null ){
            System.out.print("element-----:"+temp.getElement());
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void print(){
        Node temp = this.head.getNext();
        while(temp != null ){
            System.out.println(temp.getElement());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        LruLinkedList<Object> linkedList = new LruLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            linkedList.add(scanner.nextLine());
            linkedList.printAll();
        }
    }
}
