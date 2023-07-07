package com.example.prm_assignment_foodanddrink;

import android.os.AsyncTask;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.EphemeralKey;
import com.stripe.net.RequestOptions;

import java.util.HashMap;
import java.util.Map;

public class GetEphemeralKeyTask extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... strings) {
        Stripe.apiKey = "sk_test_51NPq0PHofgTLkPmA1z2GrzKoRzmNJTd0tipFIZWrpdUv3AJqOVsi26MH0VzwTNgVCaBaq1AXc059EDHX8Hzcx0Y400i3rMf1vV";
        RequestOptions requestOptions = (new RequestOptions.RequestOptionsBuilder())
                .setStripeVersionOverride("2022-11-15")
                .build();
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("customer", strings[0]);
        EphemeralKey key = null;
        try {
            key = EphemeralKey.create(options, requestOptions);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
        return key.getSecret();

    }

}
