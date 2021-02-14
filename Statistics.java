import java.util.*;
public class Statistics{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        List<Double> a = new ArrayList<Double>();
        List<Double> b = new ArrayList<Double>();
        boolean flag = false;
        boolean flag2 = false;
        
        // grab data for List A
        System.out.println("Enter numbers for List A, input 510 when done");
        while (flag == false)
        {
            double response = reader.nextDouble();
            if (response != 510)
            {
                a.add(response);
            }
            else
            {
                flag = true;
            }
        }
        System.out.println("List A: " + a);

        // grab data for List B
        System.out.println("\nEnter numbers for List B, input 510 when done");
        while (flag2 == false)
        {
            double response = reader.nextDouble();
            if (response != 510)
            {
                b.add(response);
            }
            else
            {
                flag2 = true;
            }
        }
        System.out.println("List B: " + b);

        // print results
        System.out.println("Mean X " + mean(a));
        System.out.println("Mean Y " + mean(b));
        System.out.println("Deviation SX " + deviation(a));
        System.out.println("Deviation SY " + deviation(b));
        System.out.println("Correlation Coefficient r " + corr(a, b));
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

    
    public static double corr(List<Double> numbersA, List<Double> numbersB)
    {
        // r = (1/n-1)𝚺((x-x`)/sx)*((y-y`)/sy)
        double meanA = mean(numbersA);
        double meanB = mean(numbersB);
        double devA = deviation(numbersA);
        double devB = deviation(numbersB);
        double r = 0;

        for (int i = 0; i < numbersA.size(); i++)
        {
            double tempA = 0;
            double tempB = 0;
            tempA = (numbersA.get(i)-meanA)/devA;
            tempB = (numbersB.get(i)-meanB)/devB;
            r += tempA * tempB;
        }
        r = r/(numbersA.size()-1);
        return r;
    }

}



