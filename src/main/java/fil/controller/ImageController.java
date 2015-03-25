package fil.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping( "/image" )
public class ImageController {

    @RequestMapping( method = RequestMethod.PUT )
    public String addImage( @RequestBody final MultipartFile multiPartFile ) {

        /*
         * TODO: CF FTP REST
         */

    }

}
