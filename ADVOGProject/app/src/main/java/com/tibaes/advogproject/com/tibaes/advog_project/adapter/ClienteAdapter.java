package com.tibaes.advogproject.com.tibaes.advog_project.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tibaes.advogproject.R;
import com.tibaes.advogproject.com.tibaes.advog_project.model.cliente.ClienteRepresentante;
import com.tibaes.advogproject.com.tibaes.advog_project.util.CircleImageView;

import java.util.List;

/**
 * Created by juliana tibães on 08/05/2017.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.MyViewHolder> {

    private List<ClienteRepresentante> clientList;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public ClienteAdapter(Context context, List<ClienteRepresentante> clientList) {
        this.clientList = clientList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG", "onCreateViewHolder()");
        View view = layoutInflater.inflate(R.layout.list_item_person, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("LOG", "onBindViewHolder()");

        /*
        String pathPhoto = clientList.get(position).getLogin().getCaminhoFoto();
        if (pathPhoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(pathPhoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            holder.ivClient.setImageBitmap(bitmapReduzido);
            holder.ivClient.setTag(pathPhoto);
        }
        else{

        }
        */
        holder.ivClient.setImageResource(R.drawable.people_edited);
        holder.tvClienName.setText(clientList.get(position).getNomeSocial());
        //holder.tvClientPhone.setText(clientList.get(position).getTelefones().get(0).getNumTelefone());
        holder.tvClientPhone.setText("9999-9999");
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    public ClienteRepresentante getClient(int position){
        return clientList.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CircleImageView ivClient;
        public TextView tvClienName;
        public TextView tvClientPhone;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivClient = (CircleImageView) itemView.findViewById(R.id.item_list_photo);
            tvClienName = (TextView) itemView.findViewById(R.id.item_list_name);
            tvClientPhone = (TextView) itemView.findViewById(R.id.item_list_phone);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(recyclerViewOnClickListener != null){
                recyclerViewOnClickListener.onClickListener(view, getPosition());
            }
        }
    }
}
