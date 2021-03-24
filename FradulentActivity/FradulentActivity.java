import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FradulentActivity {

    static double calcularMedia(int[] countingArray, int d) {

        int acumulative = 0;
        boolean par = d % 2 == 0;
        double median = 0;
        double median1 = 0;
        double median2 = 0;

        for (int i = 0; i < countingArray.length; i++) {

            acumulative += countingArray[i];

            if (par) {
                if (acumulative >= d / 2) {
                    median1 = (double) i;
                    if (acumulative >= d / 2 + 1) {
                        median2 = (double) i;
                        median = (median1 + median2) / 2;
                        break;
                    } else {
                        continue;
                    }
                }
            } else if (!par) {
                if (acumulative >= d / 2 + 1) {
                    median = i;
                    break;
                }
            }
        }
        return median;

    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        // inicializar todo
        int resp = 0;
        int[] countingArray = new int[201];
        for (int i = 0; i < d; i++) {
            countingArray[expenditure[i]]++;
        }

        for (int q = d; q < expenditure.length; q++) {

            // calcular la media
            double media = calcularMedia(countingArray, d);
            if (expenditure[q] >= media * 2) {
                resp++;
                System.out.println("new case: ");
                System.out.println("expenditure: " + expenditure[q]);
                System.out.println("media: " + media);
            }
            // recalcular countingArray
            countingArray[expenditure[q - d]]--;
            countingArray[expenditure[q]]++;
            ///

        }

        return resp;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resp.txt"));

        Scanner scanner = new Scanner(new File("input01.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
