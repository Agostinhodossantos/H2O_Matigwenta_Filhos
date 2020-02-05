package agua.agua.co.mz;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import agua.agua.co.mz.model.Clientes;

public class Cadastrar_cliente extends AppCompatActivity {

    private EditText ed_nome , ed_apelido , ed_telefone , ed_bairo , ed_zona , ed_numero_da_casa;
    private String str_nome , str_apelido , str_telefone , str_bairo , str_zona , str_numero_da_casa;
    private long posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setTitle("Novo cliente");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = findViewById(R.id.fab);
        ed_nome = findViewById(R.id.tv_nome);
        ed_apelido = findViewById(R.id.tv_apelido);
        ed_telefone = findViewById(R.id.tv_telefone);
        ed_bairo = findViewById(R.id.tv_Bairo);
        ed_zona = findViewById(R.id.tv_zona);
        ed_numero_da_casa = findViewById(R.id.tv_numero_da_casa);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                verificarCampos();

            }
        });
    }

    private void verificarCampos() {


        str_nome = ed_nome.getText().toString().trim();
        str_apelido =  ed_apelido.getText().toString().trim();
        str_telefone =  ed_telefone.getText().toString().trim();
        str_bairo =  ed_bairo.getText().toString().trim();
        str_zona =  ed_zona.getText().toString().trim();
        str_numero_da_casa =  ed_numero_da_casa.getText().toString().trim();

        VerificarCampos verificarCampos = new VerificarCampos();
        if (verificarCampos.isCampoVazio(str_nome)){
            ed_nome.requestFocus();
            ed_nome.setHintTextColor(Color.RED);
        }else if(verificarCampos.isCampoVazio(str_apelido)){
            ed_apelido.requestFocus();
            ed_apelido.setHintTextColor(Color.RED);
        }else if(verificarCampos.isCampoVazio(str_telefone)){
            ed_telefone.requestFocus();
            ed_telefone.setHintTextColor(Color.RED);
        }else if(verificarCampos.isNumeroValido(str_telefone)){
            Toast.makeText(this, "Numero Invalido", Toast.LENGTH_SHORT).show();
            ed_telefone.requestFocus();
        }else if(verificarCampos.isCampoVazio(str_bairo)){
            ed_bairo.requestFocus();
            ed_bairo.setHintTextColor(Color.RED);
        }else if(verificarCampos.isCampoVazio(str_zona)){
            ed_zona.requestFocus();
            ed_zona.setHintTextColor(Color.RED);
        }else if (verificarCampos.isCampoVazio(str_numero_da_casa)){
            ed_numero_da_casa.requestFocus();
            ed_numero_da_casa.setHintTextColor(Color.RED);
        }else {

            Clientes clientes = new Clientes(UUID.randomUUID().toString(), str_bairo ,str_nome , str_apelido ,str_zona , str_numero_da_casa ,str_numero_da_casa, "0" , "0" , data(),posicao , true);

            Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show();
        }
    }


    private String data(){
        Date date = new Date();
        Locale locale = new  Locale("pt");
        Locale.setDefault(locale);
        SimpleDateFormat format  =  new SimpleDateFormat("dd/MM/yyyy");
        String data = format.format(date);
        format  =  new SimpleDateFormat("hh:mm" , Locale.getDefault());
        String time = format.format(date);
        data = data+"/"+time;

        return data;
    }


}
