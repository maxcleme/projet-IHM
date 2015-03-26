package fil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import fil.repository.TimeTableRepository;

@SpringBootApplication
@EnableMongoRepositories
@EnableAutoConfiguration
public class FilendarApplication implements CommandLineRunner {

    @Autowired
    TimeTableRepository timeTableRepository;

    public static void main( final String[] args ) {
        SpringApplication.run( FilendarApplication.class, args );
    }

    @Override
    public void run( final String... pArg0 ) throws Exception {
        this.timeTableRepository.deleteAll();
    }
}
