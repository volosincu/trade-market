
package services.trademarket;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author bogdan.volosincu
 */
public abstract class AbstractMongoService {

    private static final Logger logger = Logger.getLogger(AbstractMongoService.class);

    List<BasicDBObject> iterteCursor(Iterator cursor) {

        List<BasicDBObject> messages = new ArrayList<>();

        while (cursor.hasNext()) {
            BasicDBObject dbmessage = (BasicDBObject) cursor.next();
            messages.add(dbmessage);
        }

        return messages;
    }

}
