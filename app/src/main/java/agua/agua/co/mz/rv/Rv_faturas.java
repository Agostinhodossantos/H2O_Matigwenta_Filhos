package agua.agua.co.mz.rv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import agua.agua.co.mz.Home_cliente;
import agua.agua.co.mz.R;
import agua.agua.co.mz.model.Clientes;
import agua.agua.co.mz.model.Faturas;


public class Rv_faturas extends RecyclerView.Adapter<Rv_faturas.MyViewHoder> {

        Context mContext;
        List<Faturas> mData;

    public Rv_faturas(Context mContext, List<Faturas> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @Override
    public MyViewHoder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_fatura, viewGroup,false);

        MyViewHoder viewHoder = new MyViewHoder(v);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHoder holder, final int position) {


        if (mData.get(position).isEstado()){
            holder.tv_estado.setText("Pago");
        }else {
            holder.tv_estado.setText("Em divida");
            holder.tv_estado.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }

        holder.tv_mes.setText(mData.get(position).getMes());
        holder.tv_letra.setText(mData.get(position).getMes().toUpperCase().charAt(0)+"");
        holder.tv_valor.setText(mData.get(position).getValor()+" MT");
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHoder extends RecyclerView.ViewHolder{


        private TextView tv_mes , tv_valor , tv_letra , tv_estado;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);

            tv_estado = itemView.findViewById(R.id.tv_estado);
            tv_letra = itemView.findViewById(R.id.tv_letra);
            tv_mes = itemView.findViewById(R.id.tv_mes);
            tv_valor = itemView.findViewById(R.id.preco);
            tv_estado = itemView.findViewById(R.id.tv_estado);


        }
    }



}
