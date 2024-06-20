package Adv.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan("Adv.controller")
@ComponentScan("Adv.services")
@EntityScan("Adv")
@EnableJpaRepositories("Adv.daoRepository")

@ComponentScan("Adv")
public class ProjectAdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAdvApplication.class, args);
	}

}
