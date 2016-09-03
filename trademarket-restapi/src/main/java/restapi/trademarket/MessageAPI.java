package restapi.trademarket;

import com.mongodb.BasicDBObject;
import interfaces.trademarket.IMessageService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * *
 * @author bogdan.volosincu
 */
@CrossOrigin(origins = {"http://localhost:8000", "https://volosincu.github.io"})
@Controller
public class MessageAPI {

    private static final Logger logger = Logger.getLogger(MessageAPI.class);

    @Autowired
    private IMessageService messageService;

     /**
      * @desc find all messages with timePlaced after @param gte
      * 
      * @param gte<Double>
      * @return <List<BasicDBObject>>
     */
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<BasicDBObject>> findMessagesAfterDate(@RequestParam("gte") final Double gte) {

        logger.info("entering find message after date  " + gte);

        List<BasicDBObject> response = this.nullCheckRequestParam(gte);
        
        if (response == null) {
            response = messageService.queryMessageAfterDate(gte);
            logger.info("sending response : ".concat(response.toString()));
        }
        return new ResponseEntity<List<BasicDBObject>>(response, HttpStatus.OK);

    }

    /**
     * @param httpEntity <HttpEntity<String>>
     * @desc create a anew message; 
     *  
     * @return <String>
     */
    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> postAMessage(final HttpEntity<String> httpEntity) {

        logger.info("entering post message ");

        final String json = httpEntity.getBody();

        try {
            messageService.processMessage(json);
            
        } catch (Exception ex) {
           logger.error(ex.getMessage(), ex);
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);

    }
    
    /**
     * Make sure url is correct. Ex:  /message/user/{userId}  |  /message?gte={timestamp}
     * 
     * @param value<Object>
     * @return List<BasicDBObject> 
     */
    private List<BasicDBObject> nullCheckRequestParam(Object value) {
        List<BasicDBObject> messages = null;
        
        if(value == null){
            messages = new ArrayList<>();
            BasicDBObject errormsg = new BasicDBObject(
                    "error message", "Make sure resource path is correct. /message?gte={timestamp}");
            messages.add(errormsg);
        }
        
        return messages;
    }

}
