import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

public class CsvDataManagerMain {

    public static void main(String[] args) {
        CdmPipeLineProcessor cdmp = new CdmPipeLineProcessor();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter filtering category and it's corresponding filter value: ");
        String cat = sc.next();
        String val = sc.next();
        try {cdmp.displayFilteredResults(val, cat);}
        catch(NullPointerException e){
            System.out.println("No results found. Also, check your input category syntax.");
        }
    }
}
