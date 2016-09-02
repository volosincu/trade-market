/**
 * @author bvolosincu
 */
package services.trademarket;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;
import interfaces.trademarket.IMessageService;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import interfaces.trademarket.IRepository;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

@Component
public class MessageServiceImpl implements IMessageService {

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
        List<BasicDBObject> messageList = new ArrayList<>();

        //TODO to not affect performance send dirrectly BasicDBObject
        //final MessageModel model = this.convertToMessageModel(message);
        MongoCursor cursor = messageRepository.find(after);
        while (cursor.hasNext()) {
            BasicDBObject dbmessage = (BasicDBObject) cursor.next();
            messageList.add(dbmessage);
            logger.info(dbmessage.get("originatingCountry") + "  " + dbmessage.get("timestampPlaced") + "  " + dbmessage.getString("timePlaced"));
        }

        return messageList;
    }

    /**
     *
     * @param id<String>
     */
    @Override
    public BasicDBObject queryById(final String id) {
        BasicDBObject obj = messageRepository.find(id);
        return obj;
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
        Boolean valid = validateRequiredFields(message);
        if (!valid) {
            logger.error("Required Fields missing.");
            throw new Exception("Not a valid input. Required Fields missing.");
        }

        String date = String.valueOf(message.get("timePlaced"));
        Date timeplaced = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.UK).parse(date);
        message.append("timestampPlaced", timeplaced.getTime());
        message.replace("userId", (String) message.get("userId")); // save id as a String 

        messageRepository.persist(message);
    }

    /**
     * Checks if the required flelds of a message are not blank or null
     *
     * @param input<BasicDBObject>
     * @return boolean
     */
    public boolean validateRequiredFields(final BasicDBObject input) {
        String[] required_keys = {"userId", "currencyFrom", "currencyTo", "amountSell", "amountBuy", "rate", "timePlaced", "originatingCountry"};

        if (input == null) {
            return false;
        }
        for (int i = 0; i < required_keys.length; i++) {
            String key = required_keys[i];
            if (input.get(key) == null) {
                return false;
            } else if (StringUtils.isBlank(String.valueOf(input.get(key)))) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param BasicDBObject
     */
    private MessageModel convertToMessageModel(BasicDBObject message) throws ParseException {

        String userid = (String) message.get("userId");
        String currencyfrom = String.valueOf(message.get("currencyFrom"));
        String currencyto = String.valueOf(message.get("currencyTo"));
        Double amountbuy = Double.parseDouble(String.valueOf(message.get("amountBuy")));
        Double amountsell = Double.parseDouble(String.valueOf(message.get("amountSell")));
        Double rate = Double.parseDouble(String.valueOf(message.get("rate")));
        String date = String.valueOf(message.get("timePlaced"));

        Date timeplaced = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.UK).parse(date);
        String originatingcountry = String.valueOf(message.get("originatingCountry"));

//       String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(date);
        final MessageModel model = new MessageModel();
        model.setUserId(userid);
        model.setCurrencyFrom(currencyfrom);
        model.setCurrencyTo(currencyto);
        model.setAmountBuy(amountbuy);
        model.setAmountSell(amountsell);
        model.setRate(rate);
        model.setTimePlaced(timeplaced);
        model.setOriginatingCountry(originatingcountry);

        return model;
    }

}
