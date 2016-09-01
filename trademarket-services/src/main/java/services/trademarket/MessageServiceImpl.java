/**
 * @author bvolosincu
 */
package services.trademarket;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import interfaces.trademarket.IMessageService;
import models.trademarket.MessageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import interfaces.trademarket.IRepository;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

@Component
public class MessageServiceImpl implements IMessageService {

    private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);

    @Autowired
    IRepository messageRepository;

    /**
     *
     * @param lessThan
     */
    @Override
    public void queryRange(final Double lessThan) {
        messageRepository.find(lessThan);
    }

    /**
     *
     * @param json
     */
    @Override
    public void processMessage(String json) throws Exception {
        logger.info("entering processMessage  JSON ".concat(json));

        final BasicDBObject message = (BasicDBObject) JSON.parse(json);

        Boolean valid = validateRequiredFields(message);
        if (!valid) {
            throw new Exception("Not a valid input.");
        }

        final MessageModel model = fromBasicDBObject(message);
        message.append("timestampPlaced", model.getTimestampPlaced());

        logger.info("MODEL toString ..... ".concat(model.toString()));

        messageRepository.persist(message);
    }

    /**
     *
     * @param  BasicDBObject
     * @return isValid
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
    private MessageModel fromBasicDBObject (BasicDBObject message) throws ParseException {
        
        BigInteger userid = new BigInteger((String) message.get("userId"));
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
