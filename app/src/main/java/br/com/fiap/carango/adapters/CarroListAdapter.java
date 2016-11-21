package br.com.fiap.carango.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.fiap.carango.R;
import br.com.fiap.carango.listeners.OnClickListener;
import br.com.fiap.carango.models.Carro;

/**
 * Created by guilherme on 19/11/16.
 */

public class CarroListAdapter extends RecyclerView.Adapter<CarroListAdapter.CarrosViewHolder> {

    private Context context;
    private List<Carro> carros;
    private OnClickListener clickListener;

    public CarroListAdapter(Context context, List<Carro> carros, OnClickListener clickListener){
        this.context = context;
        this.carros = carros;
        this.clickListener = clickListener;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.carro_row, parent, false);
        return new CarrosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CarrosViewHolder holder, final int position) {
        holder.tvCarroRowTitle.setText(carros.get(position).getNome());
        holder.tvCarroRowDesc.setText(carros.get(position).getDescricao());
        Picasso.with(context)
                .load(carros.get(position).getFoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivCarroRow);
        if(clickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    clickListener.onClick(holder.itemView, position);
                }
            });
        }
    }

    public Carro getItem(int position){
        return carros.get(position);
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{

        TextView tvCarroRowTitle;
        TextView tvCarroRowDesc;
        ImageView ivCarroRow;

        public CarrosViewHolder(View itemView) {
            super(itemView);
            tvCarroRowTitle = (TextView)itemView.findViewById(R.id.tvCarroRowTitle);
            tvCarroRowDesc = (TextView)itemView.findViewById(R.id.tvCarroRowDesc);
            ivCarroRow = (ImageView)itemView.findViewById(R.id.ivCarroRow);
        }
    }

}
