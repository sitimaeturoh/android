package com.sitimaeturoh.kuis2222.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sitimaeturoh.kuis2222.MainActivity;
import com.sitimaeturoh.kuis2222.R;
import com.sitimaeturoh.kuis2222.model.DataModel;

import java.util.List;
/**
 * Created by Server on 13/09/2017.
 */
public class RecylerAdapter extends
        RecyclerView.Adapter<RecylerAdapter.MyHolder> {
    List<DataModel> mList ;
    Context ctx;
    public RecylerAdapter(Context ctx, List<DataModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }
    @Override
    public RecylerAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_layoutlist, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecylerAdapter.MyHolder holder,
                                 final int position) {
        holder.kodeminimarket.setText(mList.get(position).getkodeminimarket());
        holder.namaminimarket.setText(mList.get(position).getnamaminimarket());
        holder.kategori.setText(mList.get(position).getkategori());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent goInput = new Intent(ctx, MainActivity.class);
                try {
                    goInput.putExtra("id",
                            mList.get(position).getId());
                    goInput.putExtra("kodeminimarket",
                            mList.get(position).getkodeminimarket());
                    goInput.putExtra("namaminimarket",
                            mList.get(position).getnamaminimarket());
                    goInput.putExtra("kategori",
                            mList.get(position).getkategori());
                    ctx.startActivity(goInput);
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ctx, "Error data " +e,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return mList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView kodeminimarket, kategori, namaminimarket;
        DataModel dataModel;
        public MyHolder(View v)
        {
            super(v);
            kodeminimarket = (TextView) v.findViewById(R.id.tvkodeminimarket);
            namaminimarket = (TextView) v.findViewById(R.id.tvnamaminimarket);
            kategori = (TextView) v.findViewById(R.id.tvkategori);
        }
    }
}
