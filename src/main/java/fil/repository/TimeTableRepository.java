package fil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fil.data.TimeTable;

public interface TimeTableRepository extends MongoRepository< TimeTable , String > {

    public TimeTable findById( final String id );

    public TimeTable findByNom( final String nom );

}
