import java.util.*;

class progrm1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt(); // threshold limit
        int Y = sc.nextInt(); // current speed

        if (Y > X) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}