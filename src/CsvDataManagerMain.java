
import java.util.*;

public class CsvDataManagerMain {

    public static void main(String[] args) {
        CdmPipeLineExecutor cdmp = new CdmPipeLineExecutor();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter filtering category and it's corresponding filter value: ");
        String cat = sc.next();
        String val = sc.next();
        try {cdmp.displayFilteredResults(val, cat);}
        catch(NullPointerException e){
            System.out.println("No results found. Also, check your input category syntax. It has to align with the column name of the CSV.");
        }
        System.out.println("Enter filter category and it's corresponding filter value to find the average transacted amount in that category");
        String cat2=sc.next();
        String val2=sc.next();
        cdmp.displayReducedResult(val2, cat2);
    }
}
