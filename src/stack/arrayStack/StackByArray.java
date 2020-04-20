package stack.arrayStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/16 21:11
 * @description：
 * @modified By：
 * @version: $
 */

//使用数组实现 栈. 仅仅提供入栈和出栈操作.
public class StackByArray {
    private static final Integer DEFAULT_CAPACITY = 10;
    private int [] array;
    private Integer count; //元素数量
    private Integer capacity; //数组容量

    public StackByArray() {
        this.array = new int[10];
        this.capacity = DEFAULT_CAPACITY;
        count = 0;
    }

    public StackByArray(Integer capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /*
        入栈操作：向数组尾部添加一个元素,如果链表容量已满,则自动扩容为原先的1倍.
     */
    public boolean push(int element){
        if(count == capacity){
            //扩容.
            resize(2*this.capacity);

        }
        this.array[count] = element;
        count++;
        return true;
    }

    /*
        出栈操作：返回数组末尾的元素
     */
    public int pop(){
        if(count == 0){
            return -1;
        }
        int temp = this.array[count - 1];
        this.array[count - 1] = -1;
        count --;
        return temp;
    }

    private void resize(int capacity){
        int[] newArray = new int[capacity];
        for (int i = 0 ; i<this.capacity ; i ++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public void print(){
        for (int i : array) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        StackByArray array = new StackByArray(5);
        array.push(1);
        array.push(3);
        array.push(5);
        array.push(7);
        array.push(9);
        array.push(11);
        array.push(13);
        array.print();

        System.out.println("-----------");
//        array.pop();
//        array.pop();
//        array.pop();
        array.print();
    }

}
