package agua.agua.co.mz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Definicoes extends AppCompatActivity {


    private View mView;
    private AlertDialog dialog;
    private LinearLayout ll_tempo , ll_aviso , ll_assinatura;
    private String assinatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definicoes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Definicoes");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ll_aviso = findViewById(R.id.ll_aviso);
        ll_tempo = findViewById(R.id.ll_tempo);
        ll_assinatura = findViewById(R.id.ll_assinatura);


        ll_assinatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAssinatura();
            }
        });

        ll_aviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAviso();
            }
        });
        ll_tempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });


    }

    private void showAssinatura() {



        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mView = getLayoutInflater().inflate(R.layout.dialog_mensagem, null);

        mBuilder.setView(mView);
        dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        TextView tv_cancelar , tv_ok;
        EditText ed_assinatura;

        ed_assinatura = mView.findViewById(R.id.ed_assinatura);
        tv_cancelar = mView.findViewById(R.id.tv_cancelar);
        tv_ok = mView.findViewById(R.id.tv_ok);


        tv_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.dismiss();

            }
        });



    }

    private void showAviso() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mView = getLayoutInflater().inflate(R.layout.dialog_dia, null);

        mBuilder.setView(mView);
        dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        TextView tv_cancelar , tv_ok;
        tv_cancelar = mView.findViewById(R.id.tv_cancelar);
        tv_ok = mView.findViewById(R.id.tv_ok);


        tv_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });

    }

    private void show() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mView = getLayoutInflater().inflate(R.layout.dialog_mensage, null);

        mBuilder.setView(mView);
        dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        TextView tv_cancelar , tv_ok;
        tv_cancelar = mView.findViewById(R.id.tv_cancelar);
        tv_ok = mView.findViewById(R.id.tv_ok);


        tv_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

                setNewTime();
            }
        });

    }

    private void setNewTime() {
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
    }
}
