package fil.data;

import org.springframework.data.annotation.Id;

public class Vote {

    @Id
    private String id;

    private String idUser;

    private String idTimeTable;

    public Vote() {

    }

    public Vote( final String pIdUser , final String pIdTimeTable ) {
        super();
        this.idUser = pIdUser;
        this.idTimeTable = pIdTimeTable;
    }

    @Override
    public String toString() {
        return "Vote [id=" + this.id + ", idUser=" + this.idUser + ", idTimeTable=" + this.idTimeTable + "]";
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

    public String getIdTimeTable() {
        return this.idTimeTable;
    }

    public void setIdTimeTable( final String pIdTimeTable ) {
        this.idTimeTable = pIdTimeTable;
    }

}
