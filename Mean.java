import java.util.*;

// 1. Compute Mean x-bar (Add all elements, divide by # of elements)
// 2. Compute Range [MAX - MIN]

public class Mean{
   public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        List<Double> sample = new ArrayList<Double>();
        boolean flag = false;
        
        // grab data for the Sample
        System.out.println("Enter numbers for Sample, input 510 when done");
        while (flag == false)
        {
            double response = reader.nextDouble();
            if (response != 510)
            {
                sample.add(response);
            }
            else
            {
                flag = true;
            }
        }
        System.out.println("Sample: " + sample);
        System.out.println("Mean: " + mean(sample));
        System.out.println("Range: " + range(sample));
        System.out.println("Deviation: " + deviation(sample));
    }
    

    public static double mean(List<Double> numbers)
    {
        double total = numbers.size();
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            sum += numbers.get(i);
        }
        double m = sum / total;
        return m;
    }
    

    public static double range(List<Double> numbers)
    {
        double max = numbers.get(0);
        double min = numbers.get(0);

        for (double i : numbers)
        {
            if (i > max)
            {
                max = i;
            }
            else if (i < min)
            {
                min = i;
            }
        }
        return max - min;
    }

    public static double deviation(List<Double> numbers)
    {
        double counter = 0;
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            sum += numbers.get(i);
        }

        for (int i = 0; i < numbers.size(); i++)
        {
            double temp = numbers.get(i) - sum / (double)numbers.size();
            counter += temp * temp;
        }
        double counterDiv = counter / ((double)numbers.size()-1);
        double s = Math.sqrt(counterDiv);
        return s;
    }
}
// k = samples -> x-bar-bar = Add all means, Divide by # samples
// n = sample size -> r-bar = Add all ranges, Divide by # samples
// made for Operations Management [TOM 3010]