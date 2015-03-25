package fil.data;

import org.springframework.data.annotation.Id;

public class TimeTable {

    @Id
    private String  id;

    private String  nom;

    private String  imagePath;

    private Integer nbVote;

    public TimeTable() {

    }

    public TimeTable( final String pNom , final String pImagePath , final Integer pNbVote ) {
        super();
        this.nom = pNom;
        this.imagePath = pImagePath;
        this.nbVote = pNbVote;
    }

    @Override
    public String toString() {
        return "TimeTable [id=" + this.id + ", nom=" + this.nom + ", imagePath=" + this.imagePath + ", nbVote=" + this.nbVote + "]";
    }

    public String getId() {
        return this.id;
    }

    public void setId( final String pId ) {
        this.id = pId;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom( final String pNom ) {
        this.nom = pNom;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath( final String pImagePath ) {
        this.imagePath = pImagePath;
    }

    public Integer getNbVote() {
        return this.nbVote;
    }

    public void setNbVote( final Integer pNbVote ) {
        this.nbVote = pNbVote;
    }

}
