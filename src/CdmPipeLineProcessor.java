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

    private CdmPipelineBuild cdm;

    CdmPipeLineProcessor() {
        this.cdm = new CdmPipelineBuild();
    }

    public void displayContents() {
        this.cdm.resultStream().forEach(a -> {
            a.display();
        });
    }

    public void displayGreatestTransacDetails() {
        this.cdm
            .resultStream()
            .filter(a -> {
                return a.amt >= 5000.0;
            })
            .forEach(a -> {
                a.display();
            });
    }
}
