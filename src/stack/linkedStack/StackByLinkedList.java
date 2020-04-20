package stack.linkedStack;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/20 21:33
 * @description：
 * @modified By：
 * @version: $
 */
public class StackByLinkedList {

    private Node head;

    private int length = 0;

    //入栈操作.
    public boolean push(int data) {
        //链表为空直接插入头结点
        Node newNode = new Node(data, null);
        if(head == null ){
            head = newNode;
            length ++;
            return false;
        }
        Node tempNode = head;
        newNode.setNext(head);
        head = newNode;
        length++;
        return true;
    }

    //出栈操作(先进的后出,取链头数据)
    public Node pop(){
        //链表为空,返回null
        if(head == null ){
            return null;
        }

        Node tempNode = head;//记录原先头结点
        Node tempNextNode = head.next;
        head = tempNextNode;
        length--;
        return tempNode;
    }

    public void printAll(){
        Node tempNode = head;
        if(tempNode == null ){
            return;
        }

        while(tempNode != null ){
            System.out.println(tempNode.getElement());
            tempNode = tempNode.getNext();
        }
    }


    public class Node {
        private int element;

        private Node next;

        public Node() {
        }

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        StackByLinkedList stackByLinkedList = new StackByLinkedList();
        stackByLinkedList.push(1);
        stackByLinkedList.push(3);
        stackByLinkedList.push(5);
        stackByLinkedList.printAll();
        System.out.println("------------------------");
        stackByLinkedList.pop();
        stackByLinkedList.pop();
        stackByLinkedList.printAll();
    }
}
