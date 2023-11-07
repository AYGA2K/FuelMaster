package ma.fstt.fuelMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.fstt.entity")
@EnableJpaRepositories(basePackages = "ma.fstt.repository")
@ComponentScan(basePackages = "ma.fstt.controller")
@ComponentScan(basePackages = "ma.fstt.config")
public class FuelMasterApplication {

  public static void main(String[] args) {
    SpringApplication.run(FuelMasterApplication.class, args);
  }

}
