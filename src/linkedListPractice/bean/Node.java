package linkedListPractice.bean;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/9 21:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Node<T>{
    public T element;
    public Node next;

    public Node() {
    }

    public Node(T data) {
        this.element = data;
    }

    public Node(T data, Node next) {
        this.element = data;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
