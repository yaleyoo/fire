package com.fes.common.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qigege on 2017/10/14.
 */
public class PaypalService {

    private static final String PAYMENT_METHOD = "paypal";

    private static final String CANCEL_URL = "http://localhost:8080/jsp/pay-error.html";

    private static final String RETURN_URL = "http://localhost:8080/order/payment-process";

    private static Payer payer;

    private static RedirectUrls redirectUrls;

    @Resource
    private APIContext apiContext;

    static {
        payer = new Payer();
        redirectUrls = new RedirectUrls();
        payer.setPaymentMethod(PAYMENT_METHOD);
        redirectUrls.setCancelUrl(CANCEL_URL);
        redirectUrls.setReturnUrl(RETURN_URL);
    }

    public String getPayUrl (int price, String orderNum) throws PayPalRESTException {
        // Set payment details
        Details details = new Details();
        details.setShipping("0");
        details.setSubtotal(String.valueOf(price));
        details.setTax("0");

// Payment amount
        Amount amount = new Amount();
        amount.setCurrency("USD");
// Total must be equal to sum of shipping, tax and subtotal.
        amount.setTotal(String.valueOf(price));
        amount.setDetails(details);

// Transaction information
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setInvoiceNumber(orderNum);
        transaction
                .setDescription("FES Course Transaction");

// Add transaction to a list
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

// Add payment details
        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);

        // Create payment
        Payment createdPayment = payment.create(apiContext);
        List<Links> links = createdPayment.getLinks();
        for(Links link : links){
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                return link.getHref();
            }
        }
        return "";
    }


}
