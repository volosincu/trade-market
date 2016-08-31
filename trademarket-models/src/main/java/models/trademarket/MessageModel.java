package models.trademarket;

import java.math.BigInteger;
import java.util.Objects;

/**
 *
 * @author bogdan.volosincu
 */
public class MessageModel  {
    
    
    private BigInteger userId;
    private String currencyFrom;
    private String currencyTo;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }
    
    @Override
    public String toString() {
        return "MessageModel{" + "userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.userId);
        hash = 19 * hash + Objects.hashCode(this.currencyFrom);
        hash = 19 * hash + Objects.hashCode(this.currencyTo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessageModel other = (MessageModel) obj;
        if (!Objects.equals(this.currencyFrom, other.currencyFrom)) {
            return false;
        }
        if (!Objects.equals(this.currencyTo, other.currencyTo)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

//amountSell
//amountBuy
//rate
//timePlaced
//originatingCountry
    
    //{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}
    
}
