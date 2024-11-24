import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopoSort {
    private static int reverseCounter; // only for graph_DFS to use
    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private static class LinkedList {
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

    public static void main(String[] args) throws IOException {
        if (args.length != 1){
            throw new IllegalArgumentException("Not enough args");
        }

        String inputFileName = args[0];
        LinkedList[] G = fileReader(inputFileName);

        int[] topologicalOrder = DFS(G);

        for (int j = 0; j < G.length; j++) {
            System.out.print(topologicalOrder[j]);
            if (j < (G.length - 1))
                System.out.print(", ");
        }
    }

    private static LinkedList[] fileReader(String inputFileName) throws IOException {
        LinkedList[] G = new LinkedList[lineCounter(inputFileName)];
        String line;

        try(BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName))) {
            while ((line = inputFile.readLine()) != null) {
                String[] parts = line.split(":");
                int vertex = Integer.parseInt(parts[0].trim());
                G[vertex] = new LinkedList();
                if (parts.length > 1) {
                    String[] neighbors = parts[1].split(",");
                    for (String n: neighbors)
                        G[vertex].add(Integer.parseInt(n.trim()));
                }
            }
        }

        return G;
    }

    private static int lineCounter(String inputFileName) throws IOException {
        int counter = 0;

        try(BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName))) {
            while (inputFile.readLine() != null) {
                counter++;
            }
        }

        return counter;
    }

    private static int[] DFS(LinkedList[] G) {
        boolean[] visited = new boolean[G.length];
        int[] topologicalOrder = new int[G.length];
        reverseCounter = G.length - 1;

        for (int index = 0; index < G.length; index++) {
            if (!(visited[index]))
                graph_DFS(G, index, visited, topologicalOrder);
        }

        return topologicalOrder;
    }

    private static void graph_DFS(LinkedList[] G, int s, boolean[] visited, int[] topologicalOrder) {
        visited[s] = true;
        Node cur = G[s].head;

        while (cur != null) {
            if (!(visited[cur.value]))
                graph_DFS(G, cur.value, visited, topologicalOrder);
            cur = cur.next;
        }

        topologicalOrder[reverseCounter] = s;
        reverseCounter--;
    }
}