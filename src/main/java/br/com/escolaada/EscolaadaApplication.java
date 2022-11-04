package br.com.escolaada;

import br.com.escolaada.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class EscolaadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaadaApplication.class, args);
	}

}
