package com.sitimaeturoh.kuis2222;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import com.sitimaeturoh.kuis2222.adapter.RecylerAdapter;
import com.sitimaeturoh.kuis2222.api.RestApi;
import com.sitimaeturoh.kuis2222.api.RetroServer;
import com.sitimaeturoh.kuis2222.model.DataModel;
import com.sitimaeturoh.kuis2222.model.ResponseModel;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class TampilData extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataModel> mItems = new ArrayList<>();
    ProgressBar pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        pd = (ProgressBar) findViewById(R.id.pd);
        pd.setIndeterminate(true);
        pd.setVisibility(View.VISIBLE);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mManager);
        // pd.setVisibility(View.VISIBLE);
        RestApi api = RetroServer.getClient().create(RestApi.class);
        Call<ResponseModel> getdata = api.getBiodata();
        getdata.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call,
                                   Response<ResponseModel> response) {
                pd.setVisibility(View.GONE);
                Log.d("RETRO", "RESPONSE : " +
                        response.body().getKode());
                mItems = response.body().getResult();
// String iTems []= new String[mItems.size()];
// for (int i=0; i<mItems.size();i++ ){
// iTems[i]= mItems.get(i).getNama();
//
// }
                mAdapter = new
                        RecylerAdapter(TampilData.this,mItems);
                mRecycler.setAdapter(mAdapter);
                //mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<ResponseModel> call, Throwable
                    t) {
                pd.setVisibility(View.GONE);
                //pd.setVisibility(View.GONE);
                Log.d("RETRO", "FAILED : respon gagal");
            }
        });
    }
}
