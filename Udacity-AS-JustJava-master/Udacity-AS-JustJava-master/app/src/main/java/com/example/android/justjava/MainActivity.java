package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity <= 99){
            quantity = quantity + 1;
        }
        displayQuantity(quantity);
        if (quantity == 100){
            //Show a message as a toast
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.toast_100_cups);
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, text, duration).show();
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity >= 2){
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
        if (quantity == 1){
            //Show a message as a toast
            Toast.makeText(this, getString(R.string.toast_1_cups), Toast.LENGTH_SHORT ).show();
        }
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {

        //Allows the user to enter is name
        EditText textNameV2 = (EditText) findViewById(R.id.edit_text_name_v2);
        String hasEnteredNameV2 = textNameV2.getText().toString();
        //Log.v("MainActivity" , "given nameV2: " + hasEnteredNameV2);

        //Figure out if the user wants whipped cream topping
        CheckBox topping01CheckBox = (CheckBox) findViewById(R.id.topping01_text_view);
        boolean hasWhippedCream = topping01CheckBox.isChecked();
        //Log.v("MainActivity" , "Has whipped cream: " + hasWhippedCream);

        //Figure out if the user wants chocolate topping
        CheckBox topping02CheckBox = (CheckBox) findViewById(R.id.topping02_text_view);
        boolean hasChocolate = topping02CheckBox.isChecked();
        //Log.v("MainActivity" , "Has chocolate: " + hasChocolate);

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, hasEnteredNameV2);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.extra_subject) +  hasEnteredNameV2);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream
     * @param addChocolate  is whether or not the user wants chocolate
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
       //Price of 1 cup of coffee
        int basePrice = 5;

        //Add 1$ if the user wants whipped cream
        if (addWhippedCream){
            basePrice = basePrice + 1;
        }

        //Add 2$ if the user wants chocolate
        if (addChocolate){
            basePrice = basePrice + 2;
        }

        //calculate the total price
        return quantity * basePrice;

    }

    /**
     * This method create an order summary text.
     *
     * @param price of the order
     * @param toppingWhippedCream  whether or not the user adds whipped cream
     * @param toppingChocolate  whether or not the user adds chocolate
     * @param editTextNameV2  whether or not the user enters is name (using String)
     * @return text summary
     */
    private String createOrderSummary(int price, boolean toppingWhippedCream, boolean toppingChocolate, String editTextNameV2 ) {
        String priceMessage =  getString(R.string.order_summary).toUpperCase();
        priceMessage += "\n" + getString(R.string.order_summary_name, editTextNameV2);
        priceMessage += "\n" + getString(R.string.order_summary_whipped_cream, toppingWhippedCream);
        priceMessage += "\n" + getString(R.string.order_summary_chocolate, toppingChocolate);
        priceMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        priceMessage += "\n" + getString(R.string.order_summary_price, price);
        priceMessage += "\n" + getString(R.string.order_summary_thank_you);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCups) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCups);
    }

}
