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
    public void persist(BasicDBObject message);

    /**
     *
     */
    public MongoCursor find(Double greaterThan);

}
