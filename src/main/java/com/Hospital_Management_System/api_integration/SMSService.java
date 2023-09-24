package com.Hospital_Management_System.api_integration;

import com.Hospital_Management_System.configuration.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    private final TwilioConfig twilioConfig;

    @Autowired
    public SMSService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public void sendSMS(String to, String body) {
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        Message.creator(new PhoneNumber(to), new PhoneNumber(twilioConfig.getPhoneNumber()), body).create();
    }
}
