package interfaces.trademarket;

import com.mongodb.BasicDBObject;
import java.util.List;

/**
 * @author bogdan.volosincu
 */
public interface IMessageService {

    /**
     *
     */
    public void processMessage(String json) throws Exception;
    
    public List<BasicDBObject> queryRange(Double greaterThan);
}
