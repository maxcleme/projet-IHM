package fil.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fil.data.Vote;

public interface VoteRepository extends MongoRepository< Vote , String > {

    public Vote findByIdUserAndIdTimeTable( final String idUser , final String idTimeTable );

    public List< Vote > findByIdUser( final String idUser );

}
