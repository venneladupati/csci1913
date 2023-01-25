//lab 12 1913
//vennela dupati

public class RepeatBlockQueue<T> {

    private RepeatBlockQueueNode<T> front;
    private RepeatBlockQueueNode<T> rear;
    private int size;

    
    public RepeatBlockQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * adds a element to the rear of the queue
     * @param takes an element
     *
     */
    public void enqueue(T data) {
        RepeatBlockQueueNode<T> node = new RepeatBlockQueueNode<T>(data);

        if (isEmpty()){
            front = node;
        }
        else {
            rear.setNext(node);
        }

        rear = node;
        size++;
            
    }

    /**
     * 
     * @return the first element in the queue without removing it
     */
    public T front() {
       if (isEmpty()){
        return null;
       }
       else {
        return front.getData();
       }
    }

    /**
     * 
     * @return the first element in the queue and removes it
     */
    public T dequeue() {
        T answer;
        if (isEmpty()) {
            return null;
        }
        else {
            answer = front.getData();
            front = front.getNext();
            size--;
        }

        return answer;
    }

    /**
     * 
     * @return returns how many times the first block repeats
     */
    public int frontOfLineRepeatCount (){
            RepeatBlockQueueNode<T> node = front;

            int count = 0;
            if(isEmpty()) {
                return 0;
            }
            
            else{
                while( node != null && node.getData() == front.getData()) {
                    count += 1;
                    node = front.getNext();
                
            }
        }
            return count;
            }

        


    /**
     * 
     * @return size of of queue
     */
    public int getSize() {
         
        return size;
    }

    /**
     * 
     * @return whether or not queue is empty
     */
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }
    
    /**
     * returns the string represenation of the queue
     */
    public String toString() {

        String answer = "";
        RepeatBlockQueueNode<T> node = front;

        while (node != null) {
            
            answer = answer + (node.getData()).toString() + ":" + node.getCount();
            answer += ", ";

            while (node.getNext() != null && node.getData() == node.getNext().getData()) {
                node = node.getNext();
            }

            node = node.getNext();
        }
        
       
    return answer;
    }

    
} 