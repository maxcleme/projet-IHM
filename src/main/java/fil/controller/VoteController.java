package fil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.data.TimeTable;
import fil.data.Vote;
import fil.repository.TimeTableRepository;
import fil.repository.VoteRepository;

@RestController
@RequestMapping( "/vote" )
public class VoteController {

    private static final int MAX_VOTE_PER_USER = 3;

    @Autowired
    TimeTableRepository      timeTableRepository;

    @Autowired
    VoteRepository           voteRepository;

    @RequestMapping( value = "/{idUser}/{idTimeTable}" , method = RequestMethod.PUT )
    public String addVote( @PathVariable( "idUser" ) final String idUser , @PathVariable( "idTimeTable" ) final String idTimeTable ) {
        final TimeTable timeTable = this.timeTableRepository.findById( idTimeTable );
        if ( timeTable == null ) {
            return "L'emploi du temps n'existe pas.";
        }

        final Vote vote = this.voteRepository.findByIdUserAndIdTimeTable( idUser, idTimeTable );
        final List< Vote > votes = this.voteRepository.findByIdUser( idUser );

        if ( votes.size() < VoteController.MAX_VOTE_PER_USER ) {
            return "Vous avez déjà voté " + VoteController.MAX_VOTE_PER_USER + " fois. Cependant vous pouvez toujours modifier un de vos votes.";
        }

        if ( ( vote != null ) ) {
            return "Déjà voté pour cet emplois du temps.";
        }

        this.voteRepository.save( new Vote( idUser, idTimeTable ) );
        timeTable.setNbVote( timeTable.getNbVote() + 1 );
        this.timeTableRepository.save( timeTable );
        return "A voté.";

    }

    @RequestMapping( value = "/{idUser}/{idTimeTable}" , method = RequestMethod.DELETE )
    public String deleteVote( @PathVariable( "idUser" ) final String idUser , @PathVariable( "idTimeTable" ) final String idTimeTable ) {
        final TimeTable timeTable = this.timeTableRepository.findById( idTimeTable );
        if ( timeTable == null ) {
            return "L'emploi du temps n'existe pas.";
        }

        final Vote vote = this.voteRepository.findByIdUserAndIdTimeTable( idUser, idTimeTable );

        if ( ( vote == null ) ) {
            return "Vous n'avez jamais voté cet emplois du temps.";
        }

        this.voteRepository.delete( vote );
        timeTable.setNbVote( timeTable.getNbVote() - 1 );
        this.timeTableRepository.save( timeTable );
        return "Vote supprimé.";

    }

}
