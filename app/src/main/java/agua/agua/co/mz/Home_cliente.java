package agua.agua.co.mz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import agua.agua.co.mz.model.Faturas;
import agua.agua.co.mz.rv.Rv_clientes;
import agua.agua.co.mz.rv.Rv_faturas;

public class Home_cliente extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btn_adicionar_faturas;
    private TextView tv_dividas , tv_valor_total , tv_estado;
    private String nome , apelido ,uid ,bairo ,zona , telefone ,latitude ,logitude ,numero_da_casa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home_cliente);


        getIntentValue();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(nome);
        toolbar.setSubtitle(apelido);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_dividas = findViewById(R.id.tv_numero_de_dividas);
        tv_estado = findViewById(R.id.tv_estado);
        tv_valor_total = findViewById(R.id.tv_valor_total);
        btn_adicionar_faturas = findViewById(R.id.btn_leitura_do_mes);

        btn_adicionar_faturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               adicionarFaturas();
            }
        });


        buscarFaturas();



    }

    private void adicionarFaturas() {
        Toast.makeText(this, "Adicionar Faturas", Toast.LENGTH_SHORT).show();
    }

    private void buscarFaturas() {

        List<Faturas> faturasList = new ArrayList<>();
        faturasList.add( new Faturas("s","Fevereiro","2020", "20", "300",true, 1));
        faturasList.add( new Faturas("s","Fevereiro","2020", "20", "300",false, 1));
        faturasList.add( new Faturas("s","Fevereiro","2020", "20", "300",false, 1));
        faturasList.add( new Faturas("s","Fevereiro","2020", "20", "300",true, 1));

        RecyclerView myrecyclerView = findViewById(R.id.rv_faturas);

        Rv_faturas adapter = new Rv_faturas(Home_cliente.this, faturasList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1 , LinearLayoutManager.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);
        myrecyclerView.setAdapter(adapter);
    }

    private void getIntentValue() {

        Intent intent = getIntent();
        if (intent != null){
            nome      = intent.getStringExtra("nome");
            apelido   = intent.getStringExtra("apelido");
            uid       = intent.getStringExtra("uid");
            bairo     = intent.getStringExtra("bairo");
            zona      = intent.getStringExtra("zona");
            telefone  = intent.getStringExtra("telefone");
            latitude  = intent.getStringExtra("latitude");
            logitude  = intent.getStringExtra("logitude");
            numero_da_casa = intent.getStringExtra("numero_da_casa");
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_cliente, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.actualizar_localizacao:
                actualizarLocalizacao();
                break;
            case R.id.bloqueiar:
                bloquearUser();
                break;
        }

        return true;
    }

    private void bloquearUser() {
        Toast.makeText(this, "Bloquear", Toast.LENGTH_SHORT).show();
    }

    private void actualizarLocalizacao() {
        Toast.makeText(this, "Actualizar Localizacao", Toast.LENGTH_SHORT).show();
    }



}
