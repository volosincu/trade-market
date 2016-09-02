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
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
     * @param message<BasicDBObject>
     * @return boolean
     */
    @Override
    public void persist(final BasicDBObject message) {
        logger.info("entering persist method");

        MongoCollection<BasicDBObject> collection = persistenceConnection.getDatabase().getCollection("messages", BasicDBObject.class);
        collection.insertOne(message);

        logger.info("leaving persist method");
    }

    /**
     *
     * @param greaterThan<Double>
     * @return iterator <MongoCursor>
     */
    @Override
    public MongoCursor find(final Double greaterThan) {

        logger.info("entering find method");

        FindIterable<BasicDBObject> iterable = persistenceConnection.getDatabase().getCollection("messages", BasicDBObject.class).find(
                new Document()
                .append("timestampPlaced", new Document()
                        .append("$gte", greaterThan)
                )
        );

        MongoCursor iterator = iterable.iterator();
        return iterator;
    }

    /**
     *
     * @param greaterThan<Double>
     * @return iterator <MongoCursor>
     */
    @Override
    public BasicDBObject find(final String id) {

        logger.info("entering find (by id) method");

        BasicDBObject query = new BasicDBObject("userId", id);
        BasicDBObject dbObj = persistenceConnection.getDatabase()
                .getCollection("messages", BasicDBObject.class).find(query).first();
        
        logger.info("QUERY object with userId  : "  + id + dbObj.toString());
        
        return dbObj;

    }

}
