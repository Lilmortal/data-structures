package com.interview.questions.queue;

public class QueueMain {
    public static void main(String[] args) {
        System.out.println("queue");
//        testQueue();

        System.out.println("linked list queue");
        testLinkedListQueue();
    }

    private static void testQueue() {
        Queue<Integer> queue = new QueueImpl<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.peek(1));
        System.out.println(queue.remove());

        queue.add(5);
        queue.add(6);

        System.out.println(queue.remove());

        queue.add(7);
    }

    private static void testLinkedListQueue() {
        Queue<Integer> queue = new LinkedListQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.peek(1));
        System.out.println(queue.remove());

        queue.add(5);
        queue.add(6);

        System.out.println(queue.remove());

        queue.add(7);
    }
}
