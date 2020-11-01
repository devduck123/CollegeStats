import java.util.*;
public class Mean // this program takes a list of numbers and calculates the mean and standard deviation
{
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        boolean check = false;
        List<Double> numbers = new ArrayList<Double>();

        // prompt for list of numbers
        System.out.println("Enter the list of numbers and enter 510 when finished");
        while (check == false)
        {
            double response = reader.nextDouble();
            if (response != 510)
            {
                numbers.add(response);
            }
            else
            {
                check = true;
            }
        }
        System.out.println(numbers);




        // add up numbers in the list
        double total = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            total += numbers.get(i);
        }
        // print addition total, and amount of numbers
        System.out.println("total: " + total);
        System.out.println("amount of numbers: " + numbers.size());

        // divide the total by amount of numbers to obtain median
        System.out.println("that makes the median x: " + total / (double)numbers.size());

        // find (sample) standard deviation 's' --> size-1
        // 1. subtract mean from original value
        // 2. square that value
        // 3. add all of these values up w/ a counter
        // 4. divide by the size again
        // 5. square root of it
        double counter = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            // assign temp variable to value of original value - mean
            double temp = numbers.get(i) - total / (double)numbers.size();
            // add to variable counter that value, but squared
            counter += temp * temp;
        }
        double counterDiv = counter / ((double)numbers.size()-1);
        double s = Math.sqrt(counterDiv);
        System.out.println("that makes the SAMPLE standard deviation s: " + s);
    }
}
