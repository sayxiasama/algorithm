package queue.arrqueue;

/**
 * @author ：Ago
 * @date ：Created in 2020/4/20 22:44
 * @description：
 * @modified By：
 * @version: $
 */
public class QueueByArr {

    private static final Integer DEFAULT_CAPACITY = 5;

    private int[] element;

    private int capacity = 0;

    private int head = 0; //记录头部下标

    private int tail = 0; //记录尾部下表

    public QueueByArr() {
        element = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public QueueByArr(int capacity) {
        element = new int[capacity];
        this.capacity = capacity;
    }

    //入队操作： 先进后出, 插入队列尾部,从队头中取数据.
    public boolean enqueue(int data){
        //如果head = 0,并且队尾没有空间(tail = capacity)存储数据说明队列已满返回false
        //如果head !=0, 并且tail = capacity 说明队列没有满但是队尾没有空间存储新数据,则进行数据搬移,并重新更新head下标与tail下标
        if(tail == capacity ){//队尾没有多余位置
            //判断head下标是否为0
            if(head == 0 ){//说明队列已满
                return false;
            }
            //进行数据搬移
            for(int i = head; i <tail; i++){
                element[i-head]  =  element[i];
            }
            //更新head && tail
            tail = tail - head;
            head = 0;
        }

        element[tail] = data;
        tail ++;
        return true;
    }

    //出队操作：从头部取出一个数据
    public int dequeue(){
        //如果尾部下标 = 头部下标 说明为空
        if(head == tail ){
            return -1;
        }

        //取出头部数据
        int res = element[head];
        head++;
        return res;
    }

    public void printAll(){
        if(head == tail ){
            System.out.println("-----队列为空");
            return;
        }
        System.out.println("当前头下标为:"+head);
        System.out.println("当前尾下标为:"+tail);
        for (int i : element) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        QueueByArr queueByArr = new QueueByArr();
        queueByArr.enqueue(1);
        queueByArr.enqueue(3);
        queueByArr.enqueue(5);
        queueByArr.enqueue(7);
        queueByArr.dequeue();
        queueByArr.enqueue(9);
        queueByArr.enqueue(11);
        queueByArr.printAll();
        System.out.println("-------------");
//        queueByArr.dequeue();
//        queueByArr.dequeue();
//        queueByArr.printAll();
    }
}
