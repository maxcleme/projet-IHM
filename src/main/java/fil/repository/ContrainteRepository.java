package fil.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fil.data.Contrainte;

public interface ContrainteRepository extends MongoRepository< Contrainte , String > {

    public Contrainte findById( final String id );

    public List< Contrainte > findByIdUser( final String idUser );

}
