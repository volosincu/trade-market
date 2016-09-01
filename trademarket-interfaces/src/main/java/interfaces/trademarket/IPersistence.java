package interfaces.trademarket;

import java.math.BigInteger;
import models.trademarket.MessageModel;

/**
 * @author bvolosincu
 *
 */
public interface IPersistence {
    /**
     *
     */
    public Boolean save(MessageModel model);
    /**
     *
     */
    public String get(BigInteger id);

}
