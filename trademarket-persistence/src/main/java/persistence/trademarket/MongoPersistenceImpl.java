package persistence.trademarket;

import persistence.properties.MongoPropertiesBean;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Component;

import java.util.Arrays; 
import interfaces.trademarket.IPersistence;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;

/**
 * @author bvolosincu
 *
 */
@Component
public class MongoPersistenceImpl implements IPersistence {
    
     private static final Logger logger = Logger.getLogger(MongoPersistenceImpl.class);

    private DB db = null;
    private MongoClient mongoClient;
   
    /**
     *
     */
    public MongoPersistenceImpl(MongoPropertiesBean config) {

        logger.info("Initialization  (mongo connection) ");

        StringBuilder url = new StringBuilder("mongodb://");
        url.append(config.getUsername()).append(":");
        url.append(config.getPassword()).append("@");
        url.append(config.getHost()).append(":");
        url.append(config.getPort()).append("/");
        url.append(config.getDatabase());

        logger.info("mongo connection  URI address is : " + url.toString());

        mongoClient = new MongoClient(
                new MongoClientURI(url.toString())
        );

    }

    

    /**
     *
     */
    @Override
    public Boolean save(final MessageModel model) {
        logger.info("entering save method   ".concat(model.toString()));
        
          mongoClient = new MongoClient("localhost");

        mongoClient.getDatabase("icurencyfair");
        MongoDatabase ic = mongoClient.getDatabase("icurencyfair");
        
        logger.info(ic.getCollection("messages").toString() );
        return false;
    }

    /**
     *
     */
    @Override
    public String get(final BigInteger id) {
        return "";
    }

}
