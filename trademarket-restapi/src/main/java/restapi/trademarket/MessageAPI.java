package restapi.trademarket;

import com.mongodb.BasicDBObject;
import interfaces.trademarket.IMessageService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * *
 * @author bogdan.volosincu
 */
@Controller
public class MessageAPI {

    private static final Logger logger = Logger.getLogger(MessageAPI.class);

    @Autowired
    private IMessageService messageService;

    /**
     *
     */
    @RequestMapping(value = "message/user/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<BasicDBObject>> getAMessage(@PathVariable(value = "userId") final String userId) {

        logger.info("entering get message  " + userId);

        List<BasicDBObject> messages = messageService.queryByUserId(userId);
        logger.info("sending response : ".concat(messages.toString()));

        return new ResponseEntity<List<BasicDBObject>>(messages, HttpStatus.OK);
    }


     /**
     *
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> findMessagesAfterDate(@RequestParam("gte") final Double gte) {

        logger.info("entering find message after date  " + gte);

        if (gte == null) {
            return new ResponseEntity<String>(this.checkIfNull(gte).toString(), HttpStatus.OK);
        }

        List<BasicDBObject> messages = messageService.queryMessageAfterDate(gte);
        logger.info("sending response : ".concat(messages.toString()));

        return new ResponseEntity<String>(messages.toString(), HttpStatus.OK);

    }

    /**
     *
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> postAMessage(final HttpEntity<String> httpEntity) {

        logger.info("entering post message ");

        final String json = httpEntity.getBody();

        try {
            messageService.processMessage(json);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MessageAPI.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);

    }
    
    /**
     * Make sure url is correct. Ex:  /message/user/{userId}  |  /message?gte={timestamp}
     * 
     * @param value
     * @return List<BasicDBObject> 
     */
    private List<BasicDBObject> checkIfNull(Object value) {
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
