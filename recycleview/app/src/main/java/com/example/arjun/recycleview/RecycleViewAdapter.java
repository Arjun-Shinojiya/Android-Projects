package com.example.arjun.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Arjun on 14-05-2018.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mimagenames = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapter(Context context, ArrayList<String> imagename) {
        mimagenames = imagename;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.imagename.setText(mimagenames.get(position));
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on "+ mimagenames.get(position));

                Toast.makeText(mcontext ,mimagenames.get(position),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mimagenames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView imagename;
        RelativeLayout parentlayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imagename = itemView.findViewById(R.id.image_name);
            parentlayout = itemView.findViewById(R.id.parent_layout);


        }
    }


}
