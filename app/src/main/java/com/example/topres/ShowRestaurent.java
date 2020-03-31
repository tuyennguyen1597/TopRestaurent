package com.example.topres;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class ShowRestaurent extends AppCompatActivity {
    static Restaurents restaurent = new Restaurents();
    //Initilised the value of the target Restaurent
    String resName, addr1, addr2, addr3;
    String[] addr;
    int top;

    //Initilised the view name
    TextView resNameV, resAddr1V, resAddr2V, resAddr3V, resPriceV, resRateV;
    ImageView resImgV;
    Button call;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_show);

        //get the value from the MainActivity intent into this intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        resName = (String) extras.get("resName");
        restaurent = Restaurents.searchRestaurent(resName);
        top = (int) extras.get("resTop");


        //split the address
        addr = restaurent.getLocation().split(", ");
        addr1 = addr[0];
        addr2 = addr[1];
        addr3 = addr[2];

        //intialise and find the view ID
        resNameV = findViewById(R.id.resName);
        resRateV = findViewById(R.id.resRate);
        resAddr1V = findViewById(R.id.resAddr1);
        resAddr2V = findViewById(R.id.resAddr2);
        resAddr3V = findViewById(R.id.resAddr3);
        resPriceV = findViewById(R.id.resPrice);
        resImgV = findViewById(R.id.resImg);
        call = findViewById(R.id.callBtn);

        //set the suitable text to the TextView
        resNameV.setText(resName);
        resRateV.setText(String.valueOf(restaurent.getRating()));
        NumberFormat price = NumberFormat.getCurrencyInstance();
        String price_value = price.format(restaurent.getPriceAvg());
        resPriceV.setText(price_value + "/person");
        resAddr1V.setText(addr1);
        resAddr2V.setText(addr2);
        resAddr3V.setText(addr3);

        //set image for the ImageVIew
        int img = getResources().getIdentifier("top" + top, "drawable", "com.example.topres");
        resImgV.setImageResource(img);

        //make an intent for CALL_ACTION
        //activate the book table button
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callNum = "tel:" + restaurent.getContactNumber();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(callNum));
                startActivity(intent);
            }
        });
    }
}
