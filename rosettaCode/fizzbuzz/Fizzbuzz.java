package rosettaCode.fizzbuzz;

public class Fizzbuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String output = "";
            if (i % 3 == 0) output += "Fizz";
            if (i % 5 == 0) output += "Buzz";
            System.out.println(output.isEmpty() ? i : output); // print i if output is empty
        }
    }

}
