package agua.agua.co.mz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EnviarMensagem extends AppCompatActivity {


    private EditText ed_mensagem ;
    private ImageButton btn_enviar_mensagem;
    private ImageView img_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensagem);

        ed_mensagem = findViewById(R.id.ed_mensame);
        btn_enviar_mensagem = findViewById(R.id.btn_enviar_mensagem);
        img_close = findViewById(R.id.img_close);



        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_enviar_mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarCampo();
            }

            private void verificarCampo() {
                VerificarCampos verificarCampos  = new VerificarCampos();

                if (verificarCampos.isCampoVazio(ed_mensagem.getText().toString())){
                    ed_mensagem.setHintTextColor(Color.RED);
                    ed_mensagem.requestFocus();
                }else {
                    enviar();
                }
            }
        });
    }

    private void enviar() {
        //todo enviar mensagem //
    }
}
