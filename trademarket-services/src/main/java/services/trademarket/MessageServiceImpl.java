/**
 * @author bvolosincu
 */
package services.trademarket;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;
import interfaces.trademarket.IMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import interfaces.trademarket.IRepository;
import java.util.Date;
import java.util.List;
import services.util.ServiceUtil;

@Component
public class MessageServiceImpl extends AbstractMongoService implements IMessageService {

    private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);

    @Autowired
    IRepository messageRepository;

    /**
     * The param greater than is a timestamp parsed to a Double (number)
     *
     * @param greaterThan<Double>
     * @return List<BasicDBObject>
     */
    @Override
    public List<BasicDBObject> queryMessageAfterDate(final Double after) {
        MongoCursor cursor = messageRepository.find(after);

        return this.iterteCursor(cursor);
    }

    /**
     *
     * @param userId<String>
     * @return List<BasicDBObject>
     */
    @Override
    public List<BasicDBObject> queryByUserId(final String userId) {
        MongoCursor cursor = messageRepository.find(userId);

        return this.iterteCursor(cursor);
    }

    /**
     *
     * @param json<String>
     */
    @Override
    public void processMessage(String json) throws Exception {
        logger.info("entering processMessage  JSON ".concat(json));

        BasicDBObject message;
        try {
            message = (BasicDBObject) JSON.parse(json);
        } catch (JSONParseException e) {
            logger.error(e.getMessage());
            throw new Exception("Invalid JSON.");
        }

        Boolean valid = ServiceUtil.validateRequiredFields(message);
        if (!valid) {
            logger.error("Required Fields missing.");
            throw new Exception("Not a valid input. Required Fields missing.");
        }

        Date timeplaced = ServiceUtil.parseDate(String.valueOf(message.get("timePlaced")));
        if(timeplaced == null) {
            throw new Exception("Invalid timePlaced format date. Valid format : dd-MMM-yy HH:mm:ss");
        }
        message.append("timestampPlaced", timeplaced.getTime());
        message.replace("userId", (String) message.get("userId")); // save id as a String 

        messageRepository.persist(message);
    }

}
