package com.myapplicationdev.android.carparkavailabilityp13ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCarpark;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.lvCarpark);
        client = new AsyncHttpClient();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //This line simply creates a new empty Array List of Weather objects with the variable name alWeather
        ArrayList<Carpark> alCarpark = new ArrayList<Carpark>();

        //Remember the AsyncHttpClient object that we created in Section D?
        //The line above will connect it to the URL where the weather data is located.
        //In other words, you will have to change this URL string accordingly depending on what the address is for your data.
        //It will then wait for a response from the URL.
        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String carparkNo;
            String lotType;
            String lotAvailable;
            String updateDateTime;
            String totalLots;



            //This is the onSuccess() listener.
            //Once a response is successfully received by the app from the site, all the code within here with trigger.
            //Notice this listener has a variable named response.
            //This represents the entire JSON Object data that is being received (as shown above)

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrcarparkData = firstObj.getJSONArray("carpark_data");
                    for(int i = 0; i < jsonArrcarparkData.length();i++){
                        JSONObject  currentItem = jsonArrcarparkData.getJSONObject(i);
                        JSONArray jsoncarparkinfo = currentItem.getJSONArray("carpark_info");
                        JSONObject jsonfinalcarparkinfo = jsoncarparkinfo.getJSONObject(0);

                        lotType =jsonfinalcarparkinfo.getString("lot_type");
                        lotAvailable =jsonfinalcarparkinfo.getString("lots_available");
                        totalLots =jsonfinalcarparkinfo.getString("total_lots");

                        carparkNo = currentItem.getString("carpark_number");
                        updateDateTime = currentItem.getString("update_datetime");

                        Carpark carpark = new Carpark(carparkNo, updateDateTime, totalLots, lotType, lotAvailable);
                        alCarpark.add(carpark);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                ArrayAdapter<Carpark> aaCarpark = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alCarpark);
                lvCarpark.setAdapter(aaCarpark);

            }//end onSuccess

        });
    }//end onResume

}