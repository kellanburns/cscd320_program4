public class TopoSort {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class LinkedList {
        public Node head;

        public void add(int value) {
            Node newNode = new Node(value);

            if (head == null)
                head = newNode;
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = newNode;
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1){
            throw new IllegalArgumentException("Not enough args");
        }


    }
}