package java;
import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  
        System.out.println("Hello, " + name + "!");

      
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); 
        System.out.println("You are " + age + " years old.");

      
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
        System.out.println("Your height is " + height + " meters.");


        System.out.print("Do you like Java? (true/false): ");
        boolean likesJava = scanner.nextBoolean();
        System.out.println("Likes Java: " + likesJava);

        
        scanner.close();
    }
}