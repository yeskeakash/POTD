import java.util.*;

class Node {
    int data;
    Node next;
    Node down;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.down = null;
    }
}

public class solution {
    static Node construct(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }

        Node head = construct(matrix, 0, 0);
        return head;
    }

    private static Node construct(int[][] matrix, int row, int col) {
        if (row >= matrix.length || col>=matrix[row].length) {
            return null;
        }

        Node node = new Node(matrix[row][col]); //creating new node
        node.down = construct(matrix, row + 1, col); //pointing to down of newly created node and creating new node using recursion

        if (col < matrix[row].length - 1) {
            node.next = construct(matrix, row, col + 1); //pointing to right right of newly created node
        }

        return node;
    }

    public static void printMatrix(Node head) {
        Node current = head;
        while (current != null) {
            Node row = current;
            while (row != null) {
                System.out.print(row.data + " ");
                row = row.next;
            }
            System.out.println();
            current = current.down;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Node head = construct(matrix);
        printMatrix(head);
        scanner.close();
    }
}