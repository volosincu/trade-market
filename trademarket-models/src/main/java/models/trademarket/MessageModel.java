package models.trademarket;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 * {"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}
 * 
 * @author bogdan.volosincu
 */
public class MessageModel  {
    
    
    private BigInteger userId;
    private String currencyFrom;
    private String currencyTo;

    private Double amountSell;
    private Double amountBuy;
    private Double rate;
    private Date timePlaced;
    private String originatingCountry;
    private String timestampPlaced;

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

    public Double getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(Double amountSell) {
        this.amountSell = amountSell;
    }

    public Double getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(Double amountBuy) {
        this.amountBuy = amountBuy;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public String getTimestampPlaced() {
        return timestampPlaced;
    }

    public void setTimestampPlaced(String timestampPlaced) {
        this.timestampPlaced = timestampPlaced;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.userId);
        hash = 59 * hash + Objects.hashCode(this.currencyFrom);
        hash = 59 * hash + Objects.hashCode(this.currencyTo);
        hash = 59 * hash + Objects.hashCode(this.amountSell);
        hash = 59 * hash + Objects.hashCode(this.amountBuy);
        hash = 59 * hash + Objects.hashCode(this.rate);
        hash = 59 * hash + Objects.hashCode(this.timePlaced);
        hash = 59 * hash + Objects.hashCode(this.originatingCountry);
        hash = 59 * hash + Objects.hashCode(this.timestampPlaced);
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
        if (!Objects.equals(this.originatingCountry, other.originatingCountry)) {
            return false;
        }
        if (!Objects.equals(this.timestampPlaced, other.timestampPlaced)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.amountSell, other.amountSell)) {
            return false;
        }
        if (!Objects.equals(this.amountBuy, other.amountBuy)) {
            return false;
        }
        if (!Objects.equals(this.rate, other.rate)) {
            return false;
        }
        if (!Objects.equals(this.timePlaced, other.timePlaced)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MessageModel{" + "userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo + ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate + ", timePlaced=" + timePlaced + ", originatingCountry=" + originatingCountry + ", timestampPlaced=" + timestampPlaced + '}';
    }
    
}
