import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("Enter your сity of residence: ");
        String city = in.nextLine();

        System.out.print("Enter your age: ");
        String age = in.nextLine();

        System.out.print("Enter your hobby: ");
        String hobby = in.nextLine();

        System.out.println("-------------------------");
        System.out.println("Name:\t" + name);
        System.out.println("City:\t" + city);
        System.out.println("Age:\t" + age);
        System.out.println("Hobby:\t" + hobby);

        System.out.println("-------------------------");
        System.out.println("Human named " + name + " lives in " + city + ".");
        System.out.println("He's " + age + " years old and loves " + hobby);

        System.out.println("-------------------------");
        System.out.println(name + "\t - Name");
        System.out.println(city + "\t - City");
        System.out.println(age + "\t\t - Age");
        System.out.println(hobby + "\t - Hobby");

        System.out.println("-------------------------");

    }
}
