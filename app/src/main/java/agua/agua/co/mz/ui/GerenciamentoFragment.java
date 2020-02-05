package agua.agua.co.mz.ui;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import agua.agua.co.mz.Definicoes;
import agua.agua.co.mz.EnviarMensagem;
import agua.agua.co.mz.R;
import agua.agua.co.mz.model.Clientes;
import agua.agua.co.mz.utils.Dados;


/**
 * A simple {@link Fragment} subclass.
 */
public class GerenciamentoFragment extends Fragment {

    private View view;
    private ImageView img_enviar_mensagem;
    private ImageView img_enviar_faturas;
    private ImageView img_enviar_aviso;
    private View mView;
    private AlertDialog dialog;

    public GerenciamentoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

       view  = inflater.inflate(R.layout.fragment_gerenciamento, container, false);

       initUi();

       img_enviar_mensagem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getActivity() , EnviarMensagem.class);
               startActivity(intent);
           }
       });
       
       img_enviar_aviso.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               enviarAviso();
           }
       });

       img_enviar_faturas.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               enviarFaturas();
           }
       });
       return view;
    }

    private void enviarFaturas() {
        // TODO: 2/3/2020 enviar faturas // 
    }

    private void enviarAviso() {
        // TODO: 2/3/2020 enviar Aviso //
    }

    private void initUi() {

        img_enviar_faturas = view.findViewById(R.id.img_enviar_faturas);
        img_enviar_aviso = view.findViewById(R.id.img_enviar_aviso);
       img_enviar_mensagem = view.findViewById(R.id.img_enviar_mensagem);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.gerenciamento , menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_data){
            showData();
        }else if(item.getItemId() == R.id.item_definicoes){
            showDefinicoes();
        }

        return true;
    }

    private void showDefinicoes() {

        Intent intent = new Intent(getActivity() , Definicoes.class);
        startActivity(intent);
    }

    private void showData() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mView = getLayoutInflater().inflate(R.layout.dialog_data, null);

        mBuilder.setView(mView);
        dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();



        ListView listView_categorias  = mView.findViewById(R.id.list_item_mes);

        String meses[] = new  String[10];
        for (int i = 0 ; i < meses.length ; i++){
            meses[i] = "Janeiro "+2020;
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity() , android.R.layout.simple_list_item_1 , meses);
        listView_categorias.setAdapter(adapter);

        listView_categorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(getActivity(), ""+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
    }
}
