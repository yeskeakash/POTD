import java.util.HashMap;
import java.util.Scanner;

class sol1010 {
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        int maxDist = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i])) {
                maxDist = Math.max(maxDist, i - mp.get(arr[i])); // Use get() instead of []
            } else {
                mp.put(arr[i], i); // Use put() instead of []
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            sol1010 ob = new sol1010();
            System.out.println(ob.maxDistance(arr));
        }
        
        sc.close();
    }
}
