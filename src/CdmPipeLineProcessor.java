import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class CdmPipeLineProcessor {
    private Predicate<CdmPipelineBuild.Data> filter;
    private HashMap<String, Predicate<CdmPipelineBuild.Data>> hmFilter;


     CdmPipelineBuild cdm;
     int count;
    CdmPipeLineProcessor() {
        this.cdm = new CdmPipelineBuild();
        this.hmFilter=new HashMap<>();
    }
   private void initialiseMap(String t){
        this.hmFilter.put("status", a->a.status.contains(t));
        this.hmFilter.put("amount", (a)->a.amt==Double.parseDouble(t));
        this.hmFilter.put("amount_>=", a->a.amt>=Double.parseDouble(t));
        this.hmFilter.put("amount_<=", a->a.amt<=Double.parseDouble(t));
        this.hmFilter.put("city", a->a.city.contains(t));
        this.hmFilter.put("payment_method", a->a.paymentMeth.contains(t));
        this.hmFilter.put("category", a->a.cat.contains(t));
        this.hmFilter.put("customer_id", a->a.custID.contains(t));
        this.hmFilter.put("transaction_id", a->a.transacId.contains(t));
    }

     private void defineFilter(String t, String type){
        this.initialiseMap(t);
        this.hmFilter.keySet()
                .stream()
                .filter(a->a.contains(type))
                .forEach(a->this.filter=this.hmFilter.get(a));
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
