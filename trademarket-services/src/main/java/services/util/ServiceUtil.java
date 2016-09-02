/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.util;

import com.mongodb.BasicDBObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import models.trademarket.MessageModel;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import services.trademarket.MessageServiceImpl;

/**
 *
 * @author bogdan.volosincu
 */
public final class ServiceUtil {
    
    private ServiceUtil() {}
    
    private static final Logger logger = Logger.getLogger(ServiceUtil.class);
    
    
      /**
     * Checks if the required flelds of a message are not blank or null
     *
     * @param input<BasicDBObject>
     * @return boolean
     */
    public final static boolean validateRequiredFields(final BasicDBObject input) {
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
     * @param date<String>
     */
    public final static Date parseDate(String date) {
    Date timeplaced = null;
    
    try{
         String d = String.valueOf(date);
         timeplaced = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.UK).parse(d);
    }catch(ParseException e){
        logger.error(e.getMessage());
    } catch (Exception e) {
        logger.error(e.getMessage());    
    }
        return timeplaced;
    }
    

    /**
     *
     * @param BasicDBObject
     */
    public final static MessageModel convertToMessageModel(BasicDBObject message) throws ParseException {

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
