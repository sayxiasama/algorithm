package linkedListPractice.listImple;

import linkedListPractice.bean.Node;
import linkedListPractice.iterface.CustomLinkedListAlgo;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/10 22:34
 * @description：  维护了一个常见的单链表.
 * @modified By：
 * @version: $
 */
//维护一个常见的无哨兵头结点的单链表.实现自定义list接口 实现了一些简单的查询，增加，删除操作
public class CustomLinkedList implements CustomLinkedListAlgo {
    private static final Integer DEFAULT_CAPACITY = 10;//默认容量

    private Node head;

    private Integer capacity = 0;

    private Integer length = 0;

    public CustomLinkedList() {
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public CustomLinkedList(Integer capacity) {
        this.length = 0;
        this.capacity = capacity;
    }

    @Override
    public Node findByValue(Object value) {
        Node p = head;
        while(p != null && p.getElement() != value){
            p = p.getNext();
        }
        return p;
    }
    @Override
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0; //记录元素下标
        while(p!=null && pos != index){
            p = p.getNext();
            ++pos;
        }
        return p;
    }

    @Override
    public void insertToHead(Object value) {
        Node newNode = new Node(value,null);
        insertToHead(newNode);

    }

    private void insertToHead(Node newNode) {
        if(head == null ){//如果头结点为null,则新节点为头结点
            head = newNode;
            length++;
            return;
        }
        newNode.setNext(head);//先设置新结点的next指针为原先的head结点
        head = newNode;//再将新节点设置为新的头结点       否则就会出现自己指向自己导致链表断裂,导致指针丢失
        length++;
    }

    @Override
    public void insertToTail(Object value) {
        Node newNode = new Node(value);
        if(head == null ){
            head = newNode;
            length++;
            return;
        }
        insertToTail(newNode);
    }

    private void insertToTail(Node newNode) {
        Node p = head;
        while(p.getNext()!= null ){
            p = p.getNext();
        }
        newNode.setNext(p.getNext());//先将新结点的next指针设置为P结点原先的next结点
        p.setNext(newNode);//再将p结点的next结点设置为新结点
        length++;
    }

    @Override
    public void insertAfterNode(Node node, Object value) {
        if(node == null ) {return;}
        Node newNode = new Node(value);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        length++;
    }

    @Override
    public void insertBeforeNode(Node node, Object value) {
        if(node == null ) {return;}
        if(head == null ){insertToHead(new Node(value));}
        Node p = head;
        while(p!=null && p.getNext() != node){
            p = p.getNext();
        }
        if(p == null ){return;} //说明遍历到了链表尾部也没有一个结点的next指针 = node 所以直接return
        Node newNode = new Node(value);
        newNode.setNext(p.getNext());
        p.setNext(newNode);
        length++;
    }

    @Override
    public void deleteByNode(Node node) {
        if(node == null ) {return;}
        if(head == null ){return;}
        Node p = head;
        while(p!=null && p.getNext() != node ){
            p = p.getNext();
        }
        if(p==null){return;}
        p.setNext(p.getNext().getNext()); //设置p结点的next指针为下一个结点的下一个结点(跳过原本下一个结点，就等于删除了原本的next结点)
        length--;
    }

    @Override
    public void deleteByValue(Object value) {
        if(value == null ){return;}
        Node p = head;
        while(p!=null && p.getNext().getElement() != value){
            p = p.getNext();
        }
        if(p==null){return;}
        p.setNext(p.getNext().getNext());
        length--;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void printAll() {
        Node p = head;
        int pos = 0;
        while(p != null ){
            System.out.println("当前链表长度为"+length+"第"+pos+"个元素为-----"+p.getElement());
            p = p.getNext();
            pos++;
        }
    }

    @Override
    public void printAll(Node node) {
        Node p = node;
        int pos = 0;
        while(p != null ){
            System.out.println("第"+pos+"个元素为-----"+p.getElement());
            p = p.getNext();
            pos++;
        }
    }

    public static void main(String[] args) {
        CustomLinkedListAlgo  custom = new CustomLinkedList();
        custom.insertToTail(1);
        custom.insertToTail(3);
        custom.insertToTail(5);
        Node node = custom.findByValue(3);
        custom.insertBeforeNode(node,2);
        custom.insertAfterNode(node,4);
        custom.printAll();
        System.out.println("--------------------");
        custom.deleteByNode(node);
        custom.printAll();
        System.out.println("--------------------");
        custom.deleteByValue(5);
        custom.printAll();
    }
}
