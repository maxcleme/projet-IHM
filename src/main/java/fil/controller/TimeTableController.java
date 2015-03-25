package fil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fil.data.TimeTable;
import fil.repository.TimeTableRepository;

@RestController
@RequestMapping( "/timetable" )
public class TimeTableController {

    @Autowired
    TimeTableRepository timeTableRepository;

    @RequestMapping( method = RequestMethod.GET )
    public List< TimeTable > list() {
        return this.timeTableRepository.findAll();
    }

    @RequestMapping( value = "/{nom}/{imagePath}" , method = RequestMethod.PUT )
    public TimeTable add( @PathVariable( "nom" ) final String nom , @PathVariable( "imagePath" ) final String imagePath ) {
        final TimeTable timeTable = new TimeTable( nom, imagePath, 0 );
        this.timeTableRepository.save( timeTable );
        return timeTable;
    }

}
