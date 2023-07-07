package com.example.prm_assignment_foodanddrink;

import android.os.AsyncTask;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import java.util.HashMap;
import java.util.Map;

public class GetPaymentIntentTask extends AsyncTask<PaymentIntentInput, Integer, String> {
    @Override
    protected String doInBackground(PaymentIntentInput... paymentIntentInputs) {
        Stripe.apiKey = "sk_test_51NPq0PHofgTLkPmA1z2GrzKoRzmNJTd0tipFIZWrpdUv3AJqOVsi26MH0VzwTNgVCaBaq1AXc059EDHX8Hzcx0Y400i3rMf1vV";
        PaymentIntentInput paymentIntentInput = paymentIntentInputs[0];
        Map<String, Object> automaticPaymentMethods =
                new HashMap<>();
        automaticPaymentMethods.put("enabled", true);
        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentIntentInput.getAmount());
        params.put("currency", "usd");
        params.put(
                "automatic_payment_methods",
                automaticPaymentMethods
        );

        try {
            PaymentIntent paymentIntent =
                    PaymentIntent.create(params);
            return paymentIntent.getClientSecret();
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
