package fil.data;

import org.springframework.data.annotation.Id;

public class Contrainte {

    @Id
    private String  id;

    private String  idUser;

    private String  motif;

    private Integer importance;

    public Contrainte() {

    }

    public Contrainte( final String pId , final String pIdUser , final String pMotif , final int pImportance ) {
        this( pIdUser, pMotif, pImportance );
        this.id = pId;
    }

    public Contrainte( final String pIdUser , final String pMotif , final int pImportance ) {
        this.idUser = pIdUser;
        this.motif = pMotif;
        this.importance = pImportance;
    }

    public Contrainte( final String pId , final String pIdUser ) {
        this.id = pId;
        this.idUser = pIdUser;
    }

    public int getImportance() {
        return this.importance;
    }

    public void setImportance( final int pImportance ) {
        this.importance = pImportance;
    }

    public String getId() {
        return this.id;
    }

    public void setId( final String pId ) {
        this.id = pId;
    }

    public String getIdUser() {
        return this.idUser;
    }

    public void setIdUser( final String pIdUser ) {
        this.idUser = pIdUser;
    }

    public String getMotif() {
        return this.motif;
    }

    public void setMotif( final String pMotif ) {
        this.motif = pMotif;
    }

}
