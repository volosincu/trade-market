/**
 * @author bvolosincu
 */
package services.trademarket;

import interfaces.trademarket.IMessageService;
import interfaces.trademarket.IPersistence;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class MessageServiceImpl implements IMessageService  {
    
    private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);
    
    @Autowired
    IPersistence mongoPersistence;
    
    @Override
    public void processMessage(MessageModel model) {
        logger.info("entering processMessage  ".concat(model.toString()));
        
        mongoPersistence.save(model);
    }
       
}
