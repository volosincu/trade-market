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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import models.trademarket.MessageModel;
import services.util.ServiceUtil;

@Component
public class MessageServiceImpl extends AbstractMongoService implements IMessageService {

    private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);

    @Autowired
    IRepository messageRepository;

    /**
     * The param greater than is a timestamp parsed to a Double (number)
     *
     * @param after<Double>
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
            throw new Exception("Invalid input. The input is not a Valid JSON object.");
        }

        MessageModel model = ServiceUtil.validateAndConvertToModel(message);  
        validateExchange(model);

        Date timeplaced = ServiceUtil.parseDate(String.valueOf(message.get("timePlaced")));
        
        message.append("timestampPlaced", timeplaced.getTime());
        message.replace("userId", (String) message.get("userId")); // save id as a String 

        messageRepository.persist(message);
    }

    /**
     * @desc the function will throw an Exception with message in case it fails
     * 
     * @param model<MessageModel>
     * @see ServiceUtil.validateAndConvertToModel
     * @return void 
     * @throws Exception
     */
    public void validateExchange(final MessageModel m) throws Exception {

        String errMessage = null;
        final Double rate = m.getRate();
        final Double amountSell = m.getAmountSell();
        final Double amountBuy = m.getAmountBuy();

        final Double calc = amountSell * rate;
        final Double exchanged = new BigDecimal(calc.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        final Double amountBuyRoundUp = new BigDecimal(amountBuy.toString()).setScale(2, RoundingMode.HALF_UP).doubleValue();

        if (amountSell <= 0 || amountBuy <= 0 || rate <= 0) {
            errMessage = "Invalid conversion :  negative values not allowed : " + rate + ", " + amountSell + ", " + amountBuy;
            logger.error(errMessage);
            throw new Exception(errMessage);
        }

        if (exchanged.doubleValue() != amountBuy.doubleValue()) {
            errMessage = "Invalid conversion :  amountSell: " + amountSell + " * rate: " + rate + " doesn't equal  amountBuy:" + amountBuyRoundUp;
            logger.error(errMessage);
            throw new Exception(errMessage);
        }

    }

}
