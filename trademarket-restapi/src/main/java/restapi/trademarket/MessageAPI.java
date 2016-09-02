package restapi.trademarket;

import com.mongodb.BasicDBObject;
import interfaces.trademarket.IMessageService;
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
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<BasicDBObject> getAMessage(@PathVariable(value = "id") final String id) {

        logger.info("entering get message ---------------- " + id );

        BasicDBObject message = messageService.queryById(id);
        
        logger.info("sending response : ".concat( message.toString()));

        return new ResponseEntity<BasicDBObject>(message, HttpStatus.OK);
    }
    
    
     /**
     *
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> findMessagesAfterDate(@RequestParam("gte") final Double gte) {

        logger.info("entering find message after date  ");

        List<BasicDBObject> messageList = messageService.queryMessageAfterDate(gte);
        
        logger.info("sending response : ".concat( messageList.toString()));

        return new ResponseEntity<String>(messageList.toString() ,HttpStatus.OK);

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

}
