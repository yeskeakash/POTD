import java.io.IOException;
import java.util.*;

class solution {
    public String roundToNearest(String str) {
        int n = str.length();
        int lastDigit = str.charAt(n - 1) - '0'; // Convert char to int
        
        if (lastDigit < 5) {
            // Set last digit to '0'
            str = str.substring(0, n - 1) + '0';
        } else {
            // Set last digit to '0'
            str = str.substring(0, n - 1) + '0';
            
            // Round up the second last digit
            StringBuilder newStr = new StringBuilder(str);
            for (int i = n - 2; i >= 0; i--) {
                if (newStr.charAt(i) < '9') {
                    newStr.setCharAt(i, (char)(newStr.charAt(i) + 1));
                    break;
                } else {
                    newStr.setCharAt(i, '0');
                }
            }
            
            // If all the numbers in str are 9, insert a '1' at the beginning
            if (newStr.charAt(0) == '0') {
                newStr.insert(0, '1');
            }
            str = newStr.toString();
        }
        
        return str;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t>0){
            String str = sc.next();
            solution obj = new solution();
            System.out.println(obj.roundToNearest(str));
            t--;
        }

        sc.close();
    }
}