package fil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import fil.data.TimeTable;
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

        this.timeTableRepository.save( new TimeTable( "TimeTable1", "C:\\Test\\Test\\Test1", 0 ) );
        this.timeTableRepository.save( new TimeTable( "TimeTable2", "C:\\Test\\Test\\Test2", 0 ) );
        this.timeTableRepository.save( new TimeTable( "TimeTable3", "C:\\Test\\Test\\Test3", 0 ) );
        this.timeTableRepository.save( new TimeTable( "TimeTable4", "C:\\Test\\Test\\Test4", 0 ) );
        this.timeTableRepository.save( new TimeTable( "TimeTable5", "C:\\Test\\Test\\Test5", 0 ) );

    }
}
