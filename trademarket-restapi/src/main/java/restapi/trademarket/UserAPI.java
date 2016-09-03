package restapi.trademarket;

import com.mongodb.BasicDBObject;
import interfaces.trademarket.IMessageService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * *
 * @author bogdan.volosincu
 */
@CrossOrigin(origins = "https://volosincu.github.io")
@Controller
public class UserAPI {

    private static final Logger logger = Logger.getLogger(MessageAPI.class);

    @Autowired
    private IMessageService messageService;

       /**
      * @desc find all messages of an user based on userId
      * 
      * @param gte<String>
      * @return <List<BasicDBObject>>
     */
    @RequestMapping(value = "users/{userId}/messages", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<BasicDBObject>> getAMessage(@PathVariable(value = "userId") final String userId) {

        logger.info("entering get message  " + userId);

        List<BasicDBObject> messages = messageService.queryByUserId(userId);
        logger.info("sending response : ".concat(messages.toString()));

        return new ResponseEntity<List<BasicDBObject>>(messages, HttpStatus.OK);
    }
    
}


