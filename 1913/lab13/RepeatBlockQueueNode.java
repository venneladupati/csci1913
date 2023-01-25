//Lab12 1913
// author: vennela dupati

public class RepeatBlockQueueNode<T> {
    
    private T data;
    private int count;
    private RepeatBlockQueueNode<T> next;

    public RepeatBlockQueueNode(T data) {
        this(data,null);
    }

    public RepeatBlockQueueNode(T data, RepeatBlockQueueNode<T> next) {
        this.data = data;
        this.next = next;
        count = 1;

    }

    public T getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public RepeatBlockQueueNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(RepeatBlockQueueNode<T> next) {
        this.next = next;
    }

}