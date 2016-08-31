/**
 * @author bvolosincu
 */
package services.trademarket;

import interfaces.trademarket.IMessageService;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public  class MessageService implements IMessageService  {
    
    private static final Logger logger = Logger.getLogger(MessageService.class);
    
    @Override
    public void processMessage(MessageModel model) {
        logger.info("entering processMessage  ".concat(model.toString()));
    }
       
}
