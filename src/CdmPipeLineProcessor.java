
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;



public class CdmPipeLineProcessor {
    private Predicate<CdmPipelineBuild.Data> filter;


     CdmPipelineBuild cdm;
     int count;
    CdmPipeLineProcessor() {
        this.cdm = new CdmPipelineBuild();
    }
     private void defineFilter(String t, String type){
        if(type.equals("status")){ this.filter=(a)->{
            return a.status.equals(t);
        };
        }
        else if(type.equals("amount")){
            this.filter = (a)->{
                return a.amt==Double.parseDouble(t);
            };
        }
        else if(type.equals("amount_>=")){
            this.filter=(a)->{
                return a.amt>=Double.parseDouble(t);
            };
        }
        else if(type.equals("amount_<=")){
            this.filter=(a)->{
                return a.amt<=Double.parseDouble(t);
            };
        }
        else if(type.equals("city")){
            this.filter=(a)->{
                return a.city.equals(t);
            };
        }
        else if(type.equals("payment_method")){
            this.filter=(a)->{
                return a.paymentMeth.equals(t);
            };
        }
        else if(type.equals("category")){
            this.filter=(a)->{
                return a.cat.equals(t);
            };
        }
        else if(type.equals("customer_id")){
            this.filter=(a)->{
                return a.custID.equals(t);
            };
        }
        else if(type.equals("transaction_id")){
            this.filter=(a)->{
                return a.transacId.equals(t);
            };
        }

        }
        double averageAmount(String t, String type){
        this.defineFilter(t, type);
         this.count = (int) this.cdm.resultStream().filter(this.filter).count();
         return this.cdm.resultStream().filter((this.filter)).map((a)->{
             return a.amt;
         }).reduce(0.0, (a, b)->a+b);
        }

     Stream<CdmPipelineBuild.Data> filteredStream(String t, String type){
        this.defineFilter(t, type);
        return this.cdm.resultStream().filter(this.filter);
    }

    }
