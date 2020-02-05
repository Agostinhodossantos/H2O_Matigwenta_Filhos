package agua.agua.co.mz.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import agua.agua.co.mz.Bloqueados;
import agua.agua.co.mz.Cadastrar_cliente;
import agua.agua.co.mz.R;
import agua.agua.co.mz.rv.Rv_clientes;
import agua.agua.co.mz.utils.Dados;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaClientesFragment extends Fragment {

    private View view;
    public ListaClientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        view =  inflater.inflate(R.layout.fragment_clientes, container, false);
        buscarClientes();
        return view;
    }

    private void buscarClientes() {

        Dados dados = new Dados();

        RecyclerView myrecyclerView = view.findViewById(R.id.rv_clientes);
        Rv_clientes adapter = new Rv_clientes(getActivity() ,dados.getClientesList());
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1 , LinearLayoutManager.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);
        myrecyclerView.setAdapter(adapter);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
       inflater.inflate(R.menu.main , menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.item_1:
                    cadastrarNovocl();
                    break;
                case R.id.item_2:
                    clientesBloqueados();
                    break;
                case R.id.pesquisar:
                    pesquisar(item);
                    break;
            }

        return true;
    }

    private void clientesBloqueados() {
        Intent intent = new Intent(getActivity() , Bloqueados.class);
        startActivity(intent);
    }

    private void cadastrarNovocl() {

        Intent intent = new Intent(getActivity() , Cadastrar_cliente.class);
        startActivity(intent);
    }

    private void pesquisar(MenuItem item) {


        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return true;
            }

            @Override

            public boolean onQueryTextChange(String s) {

                return true;
            }
        });

    }
}
