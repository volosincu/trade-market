package persistence.trademarket;

import persistence.trademarket.properties.MongoPropertiesBean;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import org.apache.log4j.Logger;
import interfaces.trademarket.IPersistenceConnection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author bvolosincu
 *
 */
@Component
public class MongoPersistenceConnectionImpl implements IPersistenceConnection {
    
     private static final Logger logger = Logger.getLogger(MongoPersistenceConnectionImpl.class);

    private MongoClient mongoClient = null;
    private MongoPropertiesBean config;
    private MongoDatabase db = null;
   
    /**
     *
     */
    public MongoPersistenceConnectionImpl(MongoPropertiesBean config) {

        this.config = config;
    }

    @Override
    public MongoDatabase getDatabase() {

        if (mongoClient == null) {
            mongoClient = new MongoClient("localhost");
            db = mongoClient.getDatabase(this.config.getDatabase());
            //mongoClient = new MongoClient(this.buildURI(config));
        }
        
        return db;
    }
    
    
    private String buildURI (final MongoPropertiesBean config) {
    
        StringBuilder url = new StringBuilder("mongodb://");
        url.append(config.getUsername()).append(":");
        url.append(config.getPassword()).append("@");
        url.append(config.getHost()).append(":");
        url.append(config.getPort()).append("/");
        url.append(config.getDatabase());
        
        return url.toString();
    }

}
