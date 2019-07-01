package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
}

    public void call(View view){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


        Call<List<Obj>> call = retrofit.create(Api.class).call();

            call.enqueue(new Callback<List<Obj>>() {
                @Override
                public void onResponse(Call<List<Obj>> call, Response<List<Obj>> response) {
                    List<Obj> list = response.body();
                    List<Obj2> sublist=new ArrayList<Obj2>();
                    for (int i = 0; i < list.size(); i++) {
                        sublist.add(list.get(i).getUrl());
                    }

                    for (int i = 0; i < list.size(); i++) {
                        txt.append("\n" + list.get(i).getName() + "\n" + list.get(i).getTimestamp() + "\n"+sublist.get(i).getSmall()+"\n"+sublist.get(i).getMedium()+"\n"+sublist.get(i).getLarge()+"\n");
                        txt.append("---------------------------------------------");
                    }
                }

                @Override
                public void onFailure(Call<List<Obj>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });



    }

}
