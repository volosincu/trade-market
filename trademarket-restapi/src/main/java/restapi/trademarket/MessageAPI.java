package restapi.trademarket;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import interfaces.trademarket.IMessageService;
import java.math.BigInteger;
import java.util.logging.Level;
import models.trademarket.MessageModel;
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
    @RequestMapping(value = "/message/{lt}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> getAMessage(@PathVariable(value = "lt") final Double lessThan) {

        logger.info("entering post message ");

        messageService.queryRange(lessThan);

        return new ResponseEntity<String>("a response after message was proccessed", HttpStatus.OK);

    }

    /**
     *
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> postAMessage(final HttpEntity<String> httpEntity) {

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
