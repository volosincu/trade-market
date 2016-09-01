package interfaces.trademarket;

import com.mongodb.BasicDBObject;
import java.math.BigInteger;
import models.trademarket.MessageModel;

/**
 *
 * @author bogdan.volosincu
 */
public interface IRepository {
    
        /**
     *
     */
    public Boolean persist(BasicDBObject message);
    /**
     *
     */
    public String find(Double id);

    
}
