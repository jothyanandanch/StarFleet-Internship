import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Start Population");
        int start_population = input.nextInt();
        System.out.println("Enter Target Population");
        int end_population = input.nextInt();
        int i = 0;
        while (start_population < end_population) {
            double new_population = start_population / 4.0; 
            double births = start_population / 3.0;
            start_population = (int) (start_population - new_population + births); 
            i++;
        }
        System.out.println("The Years to reach the Target Population is " + i);
    }
}
