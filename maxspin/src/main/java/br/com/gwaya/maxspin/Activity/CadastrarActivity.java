package br.com.gwaya.maxspin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.gwaya.maxspin.R;

/**
 * Created by Diego on 10/06/2018.
 */

public class CadastrarActivity extends AppCompatActivity {

    private EditText nome;
    private EditText login;
    private EditText senha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.Nome);
        login = (EditText) findViewById(R.id.NovoLoginText);
        senha = (EditText) findViewById(R.id.PasswordTextConfirma);
        btnCadastrar = (Button) findViewById(R.id.buttonCadastrar);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Testar envio na porta USB



            }
        });


    }
}
