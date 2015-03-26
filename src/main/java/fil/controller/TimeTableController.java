package fil.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fil.data.TimeTable;
import fil.repository.TimeTableRepository;

@RestController
@RequestMapping( "/timetable" )
public class TimeTableController {

    @Autowired
    TimeTableRepository timeTableRepository;

    @RequestMapping( method = RequestMethod.GET )
    public List< TimeTable > createTimeTable( @RequestParam( value = "order" , required = false ) final String order ) {
        if ( order != null ) {
            if ( "ASC".equals( order.toUpperCase().trim() ) ) {
                return this.timeTableRepository.findAll( new Sort( Sort.Direction.ASC, "nom" ) );
            } else if ( "DESC".equals( order.toUpperCase().trim() ) ) {
                return this.timeTableRepository.findAll( new Sort( Sort.Direction.DESC, "nom" ) );
            }
        }
        return this.timeTableRepository.findAll();
    }

    @RequestMapping( method = RequestMethod.POST )
    public TimeTable add( @RequestParam( "nom" ) final String nom , @RequestParam( "file" ) final MultipartFile file ) throws IOException {

        final File tmp = File.createTempFile( file.getOriginalFilename(), "" );
        final FileOutputStream fos = new FileOutputStream( tmp );
        fos.write( file.getBytes() );
        fos.close();

        final TimeTable timeTable = new TimeTable( nom, tmp.getAbsolutePath(), 0 );
        this.timeTableRepository.save( timeTable );
        return timeTable;
    }

}
