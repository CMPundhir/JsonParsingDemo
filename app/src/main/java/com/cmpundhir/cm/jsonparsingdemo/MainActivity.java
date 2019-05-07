package com.cmpundhir.cm.jsonparsingdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cmpundhir.cm.jsonparsingdemo.model.GithubUserPojo;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ImageView img1,img2;
    private String TAG = "JSON_PARSING";
    String imgUrl = "https://avatars2.githubusercontent.com/u/1825798?v=4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        firstTarika();
        secondTarika();
        Glide.with(this).load(imgUrl).into(img1);
        Picasso.get().load(imgUrl).into(img2);
    }

    public void firstTarika(){
        String json1 = getResources().getString(R.string.json1);
        try {
            JSONObject jsonObject = new JSONObject(json1);
            String login,avatar_url;
            login = jsonObject.getString("login");
            avatar_url = jsonObject.getString("avatar_url");
            JSONObject addrObject = jsonObject.getJSONObject("address");
            String house_no,gali_no,city,country;
            house_no = addrObject.getString("house_no");
            gali_no = addrObject.getString("gali_no");
            city = addrObject.getString("city");
            country = addrObject.getString("country");
            Log.d(TAG,avatar_url);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void secondTarika(){
        String json1 = getResources().getString(R.string.json1);
        Gson gson = new Gson();
        GithubUserPojo pojo = gson.fromJson(json1,GithubUserPojo.class);
        Toast.makeText(this, pojo.toString(), Toast.LENGTH_SHORT).show();
        Log.d(TAG,pojo.toString());
    }
}
