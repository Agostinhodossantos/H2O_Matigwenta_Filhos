package agua.agua.co.mz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import agua.agua.co.mz.model.Clientes;
import agua.agua.co.mz.rv.Rv_bloqueados;
import agua.agua.co.mz.rv.Rv_clientes;
import agua.agua.co.mz.rv.Rv_faturas;
import agua.agua.co.mz.utils.Dados;

public class Bloqueados extends AppCompatActivity {


    List<Clientes>  clientesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloqueados);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Clientes bloquados");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        buscarClientesBloqueados();

    }

    private void buscarClientesBloqueados() {


        clientesList = new Dados().getClientesList();

        for (int i = 0 ; i < clientesList.size() ; i++){
            if (clientesList.get(i).getActivo()){
                clientesList.remove(i);
            }
        }

        show();
       }



    private void show() {

        RecyclerView myrecyclerView = findViewById(R.id.rv_clientes_bloqueados);
        Rv_bloqueados adapter = new Rv_bloqueados(this ,clientesList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1 , LinearLayoutManager.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);
        myrecyclerView.setAdapter(adapter);

    }


}
