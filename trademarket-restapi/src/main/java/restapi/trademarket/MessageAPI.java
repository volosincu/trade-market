package restapi.trademarket;


import interfaces.trademarket.IMessageService;
import java.math.BigInteger;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** *
 * @author bogdan.volosincu
 */

@Controller
public class MessageAPI  {
    
       private static final Logger logger = Logger.getLogger(MessageAPI.class);
       
       @Autowired
       private IMessageService messageService;
    
    /**
     * 
     */
    @RequestMapping(value = "/message/{name}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> postAMessage(@PathVariable(value = "name")  final String name) {
        
        logger.info("entering post message ".concat(name));
        
            MessageModel model = new MessageModel();
            model.setUserId(new BigInteger("42122352252"));
            model.setCurrencyFrom("RO");
            model.setCurrencyTo("JP");
            
            messageService.processMessage(model);
            
        
        return new ResponseEntity<String>("a response after message was proccessed", HttpStatus.OK); 
        
    }
    
}
