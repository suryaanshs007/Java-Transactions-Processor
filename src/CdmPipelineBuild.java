import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class CdmPipelineBuild {

    private List<Data> dat;

    CdmPipelineBuild() {
        this.dat = new ArrayList<>();
        try {
            this.streamBuild();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public class Data {

        String transacId;
        String date;
        String custID;
        String cat;
        String paymentMeth;
        double amt;
        String status, city;
        double sum;

        Data(ArrayList<String> fields) {
            this.transacId = fields.get(0);
            this.date = fields.get(1);
            this.custID = fields.get(2);
            this.cat = fields.get(3);
            this.paymentMeth = fields.get(4);
            this.amt = Double.parseDouble(fields.get(5));
            this.status = fields.get(6);
            this.city = fields.get(7);
        }
        Data(double sum){
            this.sum=sum;
        }

        void display() {
            System.out.print(" | ");
            System.out.print(this.transacId);
            System.out.print(" | ");
            System.out.print(this.date);
            System.out.print(" | ");
            System.out.print(this.custID);
            System.out.print(" | ");
            System.out.print(this.cat);
            System.out.print(" | ");
            System.out.print(this.paymentMeth);
            System.out.print(" | ");
            if (this.amt == 0.0) System.out.print("amount");
            else System.out.print(this.amt);
            System.out.print(" | ");
            System.out.print(this.status);
            System.out.print(" | ");
            System.out.print(this.city);
            System.out.print(" | ");
            System.out.println();
        }
    }

    private void streamBuild() throws IOException {
        CDMPipelineStart input = new CDMPipelineStart();
        input
            .inputStream()
            .map(a -> a.split(","))
            .forEach(a -> {
                ArrayList<String> fields = new ArrayList<>();
                for (String s : a) {
                    if (s.equals("amount")) fields.add("0.0");
                    else fields.addLast(s);
                }
                this.dat.add(new Data(fields));
            });
    }

    public Stream<Data> resultStream() {
        return this.dat.stream();
    }
}
