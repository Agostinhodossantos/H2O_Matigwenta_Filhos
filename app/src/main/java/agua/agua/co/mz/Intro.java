package agua.agua.co.mz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;


public class Intro extends AppCompatActivity {

    private View mView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                verificaConexao();

            }
        },2000);
    }

    @SuppressLint("MissingPermission")
    public boolean verificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null && conectivtyManager.getActiveNetworkInfo().isAvailable() &&
                conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
            entrar();
        } else {
            conectado = false;
            tentarConectar();
        }
        return conectado;
    }

    private void tentarConectar() {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mView = getLayoutInflater().inflate(R.layout.dialognointernet, null);


        mBuilder.setView(mView);
        dialog = mBuilder.create();
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        Button btn_tentar = mView.findViewById(R.id.btn_id_reiniciar);
        ImageView img_cancel = mView.findViewById(R.id.btn_cancelar);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificaConexao()){
                    verificaConexao();
                }else {
                    finish();
                }

            }
        });
        btn_tentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaConexao();
                dialog.dismiss();
            }
        });

    }

    private void entrar() {
        startActivity(new Intent(Intro.this , MainActivity.class));
        finish();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onRestart() {


        super.onRestart();
    }
}
