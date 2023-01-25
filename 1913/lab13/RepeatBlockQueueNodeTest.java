public class RepeatBlockQueueNodeTest {
    public static void main(String[] args) {
        RepeatBlockQueueNode<String> rbqn = new RepeatBlockQueueNode<>("apple", null);
        System.out.println(rbqn.getData());              // apple
        System.out.println(rbqn.getNext() == null);      // true

        RepeatBlockQueueNode<String> nodeTwo = new RepeatBlockQueueNode<>("apple", null);
        rbqn.setData("banana");
        rbqn.setNext(nodeTwo);

        System.out.println(nodeTwo.getData());           // apple
        System.out.println(nodeTwo.getNext() == null);   // true

        System.out.println(rbqn.getData());              // banana
        System.out.println(rbqn.getNext() == null);      // false
        System.out.println(rbqn.getNext() == nodeTwo);   // true

        nodeTwo.setData("nameless");

        System.out.println(rbqn.getNext().getData());    // nameless

        RepeatBlockQueueNode<Integer> i = new RepeatBlockQueueNode<>(1, null);
        System.out.println((13 + i.getData()));          // 14
    }
}
/* Expected output:

apple
true
apple
true
banana
false
true
nameless
14

 */