package interfaces.trademarket;

import com.mongodb.client.MongoDatabase;

/**
 * @author bogdan.volosincu
 *
 */

public interface IPersistenceConnection {
    
    public MongoDatabase getDatabase();

}
