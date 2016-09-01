package interfaces.trademarket;

import java.math.BigInteger;
import models.trademarket.MessageModel;

/**
 * @author bogdan.volosincu
 */
public interface IMessageService {

    /**
     *
     */
    public void processMessage(String json) throws Exception;
    
    public void queryRange(Double lessThan);
}
