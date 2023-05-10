package es.mdef.traducpolPrueba;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraducpolPruebaApplication {
	public static final Logger log = LoggerFactory.getLogger(TraducpolPruebaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TraducpolPruebaApplication.class, args);
	}

}
