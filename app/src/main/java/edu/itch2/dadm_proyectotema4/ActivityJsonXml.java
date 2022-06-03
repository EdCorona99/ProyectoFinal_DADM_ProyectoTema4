package edu.itch2.dadm_proyectotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.itch2.dadm_proyectotema4.model.ApiCall;
import edu.itch2.dadm_proyectotema4.model.Model;
import edu.itch2.dadm_proyectotema4.model.MyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ActivityJsonXml extends AppCompatActivity {

    private ArrayList<Model> modelArrayList;
    private ApiCall myApi;
    private ListView lv;
    private String BaseUrl="https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_xml);

        lv=findViewById ( R.id.lv );
        modelArrayList=new ArrayList<> ();

        displayRetrofitData();

    }

    private void displayRetrofitData() {
        Retrofit retrofit=new Retrofit.Builder ()
                .baseUrl ( BaseUrl )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        myApi=retrofit.create ( ApiCall.class );
        Call<ArrayList<Model>> arrayListCall=myApi.callModel ();
        arrayListCall.enqueue ( new Callback<ArrayList<Model>>() {
            @Override
            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                modelArrayList=response.body ();
                // A for loop that iterates through the modelArrayList and sets the adapter to the
                // listview.
                for (int i=0;i<modelArrayList.size ();i++);
                MyAdapter custom = new MyAdapter(modelArrayList, ActivityJsonXml.this, R.layout.singleview);
                lv.setAdapter ( custom );
            }

            /**
             * A function that is called when the request fails.
             * 
             * @param call This is the call you just made.
             * @param t The type of the response.
             */
            @Override
            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                Toast.makeText ( ActivityJsonXml.this, "Error al cargar la informacion", Toast.LENGTH_SHORT ).show ();
            }
        });
    }

}