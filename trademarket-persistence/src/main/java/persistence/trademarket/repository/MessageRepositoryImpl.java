/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.trademarket.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import interfaces.trademarket.IPersistenceConnection;
import interfaces.trademarket.IRepository;
import java.math.BigInteger;
import java.util.HashMap;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistence.trademarket.MongoPersistenceConnectionImpl;

/**
 *
 * @author bogdan.volosincu
 */
@Repository
public class MessageRepositoryImpl implements IRepository {

    private static final Logger logger = Logger.getLogger(MessageRepositoryImpl.class);

    @Autowired
    private IPersistenceConnection persistenceConnection;

    /**
     *
     */
    @Override
    public Boolean persist(final BasicDBObject message) {
        logger.info("entering persist method");

        MongoCollection<BasicDBObject> collection = persistenceConnection.getDatabase().getCollection("messages", BasicDBObject.class);
        collection.insertOne(message);
        
        logger.info("leaving persist method");
        return false;
    }

    /**
     *
     */
    @Override
    public String find(final Double lessThan) {
        
          logger.info("entering find method");
        
              FindIterable<BasicDBObject> iterable = persistenceConnection.getDatabase().getCollection("messages", BasicDBObject.class).find(
                new Document()
                .append("timestampPlaced", new Document()
                        .append("$lte", lessThan)
                )
        );
              MongoCursor cursor = iterable.iterator();
              while (cursor.hasNext()) {
	BasicDBObject o = (BasicDBObject) cursor.next();
                     System.out.println(o.get("originatingCountry"));
              }
        
        return "";
    }

}
