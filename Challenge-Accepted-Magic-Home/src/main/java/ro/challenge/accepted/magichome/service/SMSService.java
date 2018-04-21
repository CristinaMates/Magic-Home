package ro.challenge.accepted.magichome.service;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.challenge.accepted.magichome.controller.ReservationController;

/**
 * Created by sebi on 4/21/18.
 */
@Service
public class SMSService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSService.class);

    public void sendSms(String nr, String text)throws Exception {


        AuthMethod auth = new TokenAuthMethod("2b424393", "tIDI4WlgTJJuPHw4");
        NexmoClient client = new NexmoClient(auth);

        SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
                "40371700048",
                nr,
                text
        ));
        for (SmsSubmissionResult response : responses) {
           LOGGER.info("SMS response {}",response);
        }
    }
}
