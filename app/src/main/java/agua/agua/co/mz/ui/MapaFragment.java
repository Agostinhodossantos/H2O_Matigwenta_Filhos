package agua.agua.co.mz.ui;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import agua.agua.co.mz.R;
import agua.agua.co.mz.rv.Rv_clientes;
import agua.agua.co.mz.rv.Rv_clientes_select;
import agua.agua.co.mz.utils.Dados;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment {

    View view;
    private View mView;
    private AlertDialog dialog;
    private TextView tv_nome , tv_localizacao;

    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
       view  = inflater.inflate(R.layout.fragment_mapa, container, false);
        tv_localizacao = view.findViewById(R.id.tv_localizacao);
        tv_nome = view.findViewById(R.id.tv_nome);
       return view;
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.mapa, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.pesquisar:
                pesquisar();
                break;

        }

        return true;
    }

    private void pesquisar() {

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mView = getLayoutInflater().inflate(R.layout.dialog_pesquisar, null);
        mBuilder.setView(mView);
        dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        initRv(mView);

        ImageView btn_back = mView.findViewById(R.id.btn_voltar);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        TextView pesquisar = mView.findViewById(R.id.tv_pesquisa);
        pesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    private void initRv(View mView) {

        Dados dados = new Dados();

        RecyclerView myrecyclerView = mView.findViewById(R.id.rv_clientes);
        Rv_clientes_select adapter = new Rv_clientes_select(getActivity() ,dados.getClientesList());
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1 , LinearLayoutManager.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);
        myrecyclerView.setAdapter(adapter);
    }



}
