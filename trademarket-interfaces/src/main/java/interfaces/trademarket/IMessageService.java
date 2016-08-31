package interfaces.trademarket;

import models.trademarket.MessageModel;

/**
 * @author bogdan.volosincu
 */
public interface IMessageService  {
    
     public void processMessage(MessageModel model);
}
