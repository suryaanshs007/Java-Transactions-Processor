import java.io.File;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CdmPipeLineProcessor {
    public Predicate<CdmPipelineBuild.Data> filter;

    private CdmPipelineBuild cdm;
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
        else if(type.equals("amount >=")){
            this.filter=(a)->{
                return a.amt>=Double.parseDouble(t);
            };
        }
        else if(type.equals("amount <=")){
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
    public void displayFilteredResults(String t, String type){
        this.defineFilter(t, type);
        this.cdm.resultStream().filter(this.filter).forEach((a)->{
            a.display();
        });
    }



    }
