import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.stream.Stream;

public class CDMPipelineStart {

    private Stream<String> csvRawContents;

    CDMPipelineStart() {}

    CDMPipelineStart(Stream<String> contents) {
        this.csvRawContents = contents;
    }

    public Stream<String> inputStream() throws IOException {
        CDMPipelineStart obj = new CDMPipelineStart(
            Files.lines(Path.of("transactions_dataset.csv"))
        );
        return obj.csvRawContents;
    }
}
