package pl.brokeridge.system_supporting_brokeridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Aggregation;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;
import pl.brokeridge.system_supporting_brokeridge.search.Searcher;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootApplication
public class SystemSupportingBrokeridgeApplication {

    protected static final java.util.logging.Logger log = Logger.getLogger(String.valueOf(SystemSupportingBrokeridgeApplication.class));

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SystemSupportingBrokeridgeApplication.class, args);



        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("System supporting brokeridge run on: ");
        log.info(" ");
        log.info("http://localhost:8082/brokerapi/tours/all");
        log.info(" ");
        log.info("http://localhost:8082/brokerapi/tours/searchByParams?country=Polska&destinationCity=Honollu&dateFrom=2020-02-12&dateTo=2020-02-17");
        log.info("------------------------------------------------------------------------------------------------------------------------------");



    }


}
