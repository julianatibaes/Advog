package com.tibaes.meuadvogado.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tibaes.meuadvogado.model.Advogado;

import java.util.List;
import com.tibaes.meuadvogado.R;

/**
 * Created by Juliana Tibães on 22/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.adapter
 */

public class AdvogadosAdapter extends RecyclerView.Adapter<AdvogadosAdapter.MyViewHolder> {

    private List<Advogado> advogadoList;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public AdvogadosAdapter(Context context, List<Advogado> advogadoList) {
        this.advogadoList = advogadoList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvNome.setText(advogadoList.get(position).getNomeSocial());
        holder.tvNota.setRating(advogadoList.get(position).getClassificacao());

    }

    @Override
    public int getItemCount() {
        return advogadoList.size();
    }

    public Advogado getAdvogado(int position){
        return advogadoList.get(position);
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNome;
        public RatingBar tvNota;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.item_list_title);
            tvNota = (RatingBar) itemView.findViewById(R.id.item_list_nota);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (recyclerViewOnClickListener != null) {
                recyclerViewOnClickListener.onClickListener(view, getPosition());
            }
        }
    }
}
