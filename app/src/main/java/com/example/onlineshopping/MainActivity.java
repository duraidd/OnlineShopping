package com.example.onlineshopping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> itemcontent;


    String json = "[{ \"Mobile\": [{ \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Images\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Images\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" }, { \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Images\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Images\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" }, { \"Name\": \"Galaxy M31\", \"Price\": \"20000\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/D00HRVQm/galaxym31.jpg\" }, { \"Name\": \"Redmi Note 9\", \"Price\": \"13000\", \"Quantity\": \"30\", \"Images\": \"https://i.postimg.cc/W3cTg4vj/Redmi.jpg\" }, { \"Name\": \"Poco X2\", \"Price\": \"14000\", \"Quantity\": \"10\", \"Images\": \"https://i.postimg.cc/YqR07QwF/poco.jpg\" }], \"MensCloths\": [{ \"Name\": \"Designer Printed casual Shirts\", \"Price\": \"549\", \"Quantity\": \"5\", \"Images\": \"https://i.postimg.cc/15gH80yk/casula.jpg\" }, { \"Name\": \"Brocade Nehru Jacket in Light Beige\", \"Price\": \"3485\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/qq63vL2Q/nehru-jacket-in-light-beige.jpg\" }, { \"Name\": \"Black and Grey color Rayon fabric Jodhpuri Suit \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/9fxb4Lqj/jacket.jpg\" }], \"Computer\": [{ \"Name\": \"2021 Apple iMac\", \"Price\": \"139,900\", \"Quantity\": \"10\", \"Images\": \"https://i.postimg.cc/rFRMpH35/apple.jpg\" }, { \"Name\": \"Dell Inspiron 7790\", \"Price\": \"50000\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/VvpwR9rS/Dell.jpg\" }, { \"Name\": \"Hp \", \"Price\": \"9845\", \"Quantity\": \"20\", \"Images\": \"https://i.postimg.cc/MTG8J31M/hp.jpg\" }], \"WomensCloths\": [{ \"Name\": \"Chudi\", \"Price\": \"2500\", \"Quantity\": \"50\", \"Images\": \"https://i.postimg.cc/nrmxgMQS/chudi.jpg\" }, { \"Name\": \"Jump Suit\", \"Price\": \"3000\", \"Quantity\": \"40\", \"Images\": \"https://i.postimg.cc/qMXV3PcK/jumpsuit.jpg\" }, { \"Name\": \"Girls Skater\", \"Price\": \"5000\", \"Quantity\": \"10\", \"Images\": \"https://i.postimg.cc/3RpbHGnG/skater.jpg\" }] }]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbarcolor1));
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemcontent = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            JSONObject obj = array.getJSONObject(0);
            JSONArray scdarray = obj.getJSONArray("Mobile");
            for (int i = 0; i < scdarray.length(); i++) {
                JSONObject obj1 = scdarray.getJSONObject(i);
                model obj2 = new model(obj1.getString("Name"), obj1.getString("Price"), obj1.getString("Images"));
                itemcontent.add(obj2);
            }

            recyclerView.setAdapter(new adapter(MainActivity.this,itemcontent));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}