package Api;

import Entities.Produit;
import Entities.Promo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class sendSMS {
    public static final String ACCOUNT_SID = "AC3521802cee03ed4c823f1c0d947cb226";
    public static final String AUTH_TOKEN = "6ecc197b230da508cfbcae4ae06d2379";

    public static void sendSMS(Promo a) {
        Twilio.init("AC3521802cee03ed4c823f1c0d947cb226", "6ecc197b230da508cfbcae4ae06d2379");

        String messageBody = "TitrePromo: " + a.getTitre()+ ", has a discount of "+ a.getPourcentage()+"% so the price after the discount is " + a.getPromoPrix();
        Message message = Message.creator(
                new PhoneNumber("+21623213381"),
                new PhoneNumber("+12763859149"),
                messageBody
        ).create();

        System.out.println(message.getSid());
    }
}
