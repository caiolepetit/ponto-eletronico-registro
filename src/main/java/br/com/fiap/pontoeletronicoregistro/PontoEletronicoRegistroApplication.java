package br.com.fiap.pontoeletronicoregistro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PontoEletronicoRegistroApplication {

    public static void main(String[] args) {
        SpringApplication.run(PontoEletronicoRegistroApplication.class, args);
    }

}
