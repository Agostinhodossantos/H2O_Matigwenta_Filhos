package agua.agua.co.mz.rv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import agua.agua.co.mz.Home_cliente;
import agua.agua.co.mz.R;
import agua.agua.co.mz.model.Clientes;


public class Rv_clientes extends RecyclerView.Adapter<Rv_clientes.MyViewHoder> {

        Context mContext;
        List<Clientes> mData;

    public Rv_clientes(Context mContext, List<Clientes> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @Override
    public MyViewHoder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_clientes, viewGroup,false);

        MyViewHoder viewHoder = new MyViewHoder(v);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHoder holder, final int position) {
        if (mData.get(position).getNome().trim().length() > 2){
           String strNome =  mData.get(position).getNome().substring(0 , 1).toUpperCase()+mData.get(position).getNome().substring(1).toLowerCase();
            holder.mTv_nome.setText(strNome);
            holder.mTv_letra.setText(strNome.charAt(0)+"");
        }
        holder.mTv_localizacao.setText(mData.get(position).getBairo() +", "+mData.get(position).getZona());

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext , Home_cliente.class);
                intent.putExtra("nome" , mData.get(position).getNome());
                intent.putExtra("apelido" , mData.get(position).getApelido());
                intent.putExtra("uid" , mData.get(position).getUid());
                intent.putExtra("bairo" , mData.get(position).getBairo());
                intent.putExtra("zona" , mData.get(position).getZona());
                intent.putExtra("telefone" , mData.get(position).getTelefone());
                intent.putExtra("latitude" , mData.get(position).getLatitude());
                intent.putExtra("logitude" , mData.get(position).getLogitude());
                intent.putExtra("numero_da_casa" , mData.get(position).getNr_da_casa());
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHoder extends RecyclerView.ViewHolder{

        private TextView mTv_nome , mTv_localizacao , mTv_letra;
        private LinearLayout mLinearLayout;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);

           mTv_letra = itemView.findViewById(R.id.tv_letra);
           mTv_localizacao = itemView.findViewById(R.id.tv_localizacao);
           mTv_nome = itemView.findViewById(R.id.tv_nome);
           mLinearLayout = itemView.findViewById(R.id.ll);

        }
    }



}
