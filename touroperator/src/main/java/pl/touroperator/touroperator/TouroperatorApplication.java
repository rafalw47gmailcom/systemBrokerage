package pl.touroperator.touroperator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class TouroperatorApplication {

    protected static final java.util.logging.Logger log = Logger.getLogger(String.valueOf(TouroperatorApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(TouroperatorApplication.class, args);

        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("Application run: ");
        log.info("http://localhost:8080/user" + "  - strona dla użytkowników");
        log.info(" ");
        log.info("http://localhost:8080/admin" + "  - strona dla admina");
        log.info(" ");
        log.info("http://localhost:8080/api/tours/all" + "  - endpointy dla systemu pośrednictwa");
        log.info(" ");
        log.info("http://localhost:8080/console" + "  - konsola bazy dancyh");
        log.info(" ");
        log.info("Dodatkowe");
        log.info("http://localhost:8080/api/numbers");
        log.info("------------------------------------------------------------------------------------------------------------------------------");
    }

}
