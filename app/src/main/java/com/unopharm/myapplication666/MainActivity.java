package com.unopharm.myapplication666;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.paymob.paymob_sdk.PaymobSdk;
import com.paymob.paymob_sdk.domain.model.CreditCard;
import com.paymob.paymob_sdk.domain.model.SavedCard;
import com.paymob.paymob_sdk.ui.PaymobSdkListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements PaymobSdkListener {

    static String PaymobUnopharmSecretKey="egy_sk_test_43424fc69f3c6affa5607cf5b7237e6b3a2863a9c4";
    String public_key="egy_pk_test_QgdH3rKyfsYeUpkg";
    Context mcontext;
static Integer integrationID = 3400472;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


     //---


        mcontext = this;



        Toast.makeText(this, "......xxxxxxxxxx...", Toast.LENGTH_SHORT).show();




    }
    public  void gogo(View view){
        //-------GET Client Secret-----------------------------------------------------
        int amountToPay = 100; // Example amount
        paymobGetClientSecret(amountToPay, new PaymobClientSecretCallback() {

            @Override
            public void onFailure(String error) {
                System.err.println("Error: " + error);
            }

            @Override
            public void onSuccess(String clientSecret) {
                // Create a SavedCard object
                List<CreditCard> creditCards = Arrays.asList(
                        CreditCard.VISA,    CreditCard.MASTERCARD,  CreditCard.AMERICAN_EXPRESS,
                        CreditCard.MEEZA,  CreditCard.JCB,  CreditCard.MAESTRO,  CreditCard.OMAN_NET
                );

                SavedCard savedCard = new SavedCard(
                        "**** **** **** 1234", // maskedPan
                        "****************************", // savedCardToken
                        CreditCard.VISA // Pass the list of credit cards
                );
                String CLIENT_SECRET = "xxx";

                // Build the PaymobSdk instance
                PaymobSdk paymobSdk = new PaymobSdk.Builder(
                        MainActivity.this, // context
                        clientSecret, //
                        public_key, // Place Public Key here
                       MainActivity.this,// paymobSdkListener
                        null// Optional Field if you have a saved card
                ).build();

            String  nn=  paymobSdk.getClientSecret();


                paymobSdk.start();




              /*  PaymobSdk paymobsdk = new PaymobSdk.Builder()
                        .context(this)
                        .clientSecret(clientSecret)
                        .publicKey(publicKey)
                        .paymobSdkListener(this)
                        .savedCard(savedCard) // Optional Field if you have a saved card
                        .setButtonBackgroundColor(buttonBackgroundColor != null ? buttonBackgroundColor : Color.BLACK)
                        .setButtonTextColor(buttonTextColor != null ? buttonTextColor : Color.WHITE)
                        .setAppName(appName)
                        .isAbleToSaveCard(showSaveCard != null ? showSaveCard : true)
                        .isSavedCardCheckBoxCheckedByDefault(saveCardDefault != null ? saveCardDefault : false)
                        .build();
                paymobsdk.start();
                */





            }

        });

    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "......onFailure...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccess(@NonNull HashMap<String, String> hashMap) {
        Toast.makeText(this, "......onSuccess...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPending() {
        Toast.makeText(this, "......onPending...", Toast.LENGTH_SHORT).show();

    }





    public interface PaymobClientSecretCallback {
        void onSuccess(String clientSecret);
        void onFailure(String error);
    }


    public static void paymobGetClientSecret(int valueToPay, PaymobClientSecretCallback callback) {
        //llString clientSecret = "";
        OkHttpClient client = new OkHttpClient();
        // Define the URL for the POST request
        String url = "https://accept.paymob.com/v1/intention/";
        // Create the JSON body
        JSONObject json = new JSONObject();
        try {
            json.put("amount", valueToPay);
            json.put("currency", "EGP");
            json.put("payment_methods", new JSONArray().put(integrationID));
            JSONArray itemsArray = new JSONArray();
            JSONObject item = new JSONObject();
            item.put("name", "Item name 1");
            item.put("amount", valueToPay);
            item.put("description", "Item description 1");
            item.put("quantity", 1);
            itemsArray.put(item);
            json.put("items", itemsArray);
            JSONObject billingData = new JSONObject();
            billingData.put("apartment", "sympl");
            billingData.put("first_name", "dumy");
            billingData.put("last_name", "dumy");
            billingData.put("street", "dumy");
            billingData.put("building", "dumy");
            billingData.put("phone_number", "+201125773493");
            billingData.put("city", "dumy");
            billingData.put("country", "EG");
            billingData.put("email", "dumy@dumy.com");
            billingData.put("floor", "dumy");
            billingData.put("state", "dumy");
            json.put("billing_data", billingData);
            JSONObject customer = new JSONObject();
            customer.put("first_name", "dumy");
            customer.put("last_name", "dumy");
            customer.put("email", "dumy@dsumy.com");
            JSONObject extras = new JSONObject();
            extras.put("re", "22");
            customer.put("extras", extras);
            json.put("customer", customer);
            JSONObject extrasMain = new JSONObject();
            extrasMain.put("ee", 22);
            json.put("extras", extrasMain);
            // Create the request body
            RequestBody body = RequestBody.create(
                    json.toString(),
                    MediaType.parse("application/json; charset=utf-8") // Specify the content type
            );
            // Build the request
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Token " + PaymobUnopharmSecretKey)
                    .post(body)
                    .build();
            // Execute the request asynchronously
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                    callback.onFailure("Error: " + e.getMessage());
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String responseData = response.body().string();
                        JSONObject jsonResponse = null;
                        try {
                            jsonResponse = new JSONObject(responseData);
                        } catch (JSONException e) {
                            callback.onFailure("Client secret not found");
                        }
                        if (jsonResponse.has("client_secret")) {
                            try {
                                final String  clientSecret  = jsonResponse.getString("client_secret");
                                callback.onSuccess(clientSecret); // Call the callback with the client secret
                            } catch (JSONException e) {
                                callback.onFailure("Client secret not found");
                            }
                        } else {
                            callback.onFailure("Client secret not found");
                        }
                    } else {
                        callback.onFailure("Server error: " + response.code());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            callback.onFailure("Error: " + e.getMessage());
        }
    }

}