package interfaces.trademarket;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;

/**
 *
 * @author bogdan.volosincu
 */
public interface IRepository {

    /**
     *
     */
    public MongoCursor find(String userId);

    /**
     *
     */
    public MongoCursor find(Double greaterThan);

    /**
     *
     */
    public void persist(BasicDBObject message);

}
