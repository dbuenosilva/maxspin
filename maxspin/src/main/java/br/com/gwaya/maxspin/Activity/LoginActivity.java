package br.com.gwaya.maxspin.Activity;

/**
 * Created by Diego on 10/06/2018.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.gwaya.maxspin.Model.Usuario;
import br.com.gwaya.maxspin.R;
import br.com.gwaya.maxspin.DAO.ConfiguracaoFirebase;

public class LoginActivity extends AppCompatActivity {


    private FirebaseAuth autenticacao;
    private EditText login;
    private EditText senha;
    private Button btnLogin;
    private Button btnReset;
    private Button btnRegistrar;
    private Usuario usuario;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.LoginText);
        senha = (EditText) findViewById(R.id.PasswordText);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnReset = (Button) findViewById(R.id.buttonResetSenha);
        btnRegistrar = (Button) findViewById(R.id.buttonRegistrar);


        if ( usuarioLogado() ) {
            abrirTelaMonitor();
        }
        else {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (login.getText().toString().equals("")) {
                        Toast.makeText(LoginActivity.this, "Informe seu login!", Toast.LENGTH_SHORT).show();
                    } else if (senha.getText().toString().equals("")) {
                        Toast.makeText(LoginActivity.this, "Informe sua senha!", Toast.LENGTH_SHORT).show();
                    } else { // campos preenchidos!

                        usuario = new Usuario();
                        usuario.setEmail(login.getText().toString());
                        usuario.setSenha(senha.getText().toString());

                        hideKeyboard();
                        RealizaLogin();


                    }

                }
            });
        }

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirTelaCadastro();
            }
        });

        Log.d("LIFECYCLE","CRIOU");
    }

    @Override
    protected void onStart() {
        super.onStart();
        hideDialog();
        Log.d("LIFECYCLE","INICIOU");
       // EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE","TUDO CERTO. RODANDO");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE","PAUSOU");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE","PAROU");
      //  EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECYCLE","REINICIOU");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE","MORREU");
    }


    public void showDialog(){
        pd = new ProgressDialog(this);
        pd.setMessage("Carregando");
        pd.show();
    }

    public void hideDialog(){
        if(pd != null && pd.isShowing()){
            pd.dismiss();
        }
    }

    public void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (
                    InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    private void RealizaLogin() {

        autenticacao = ConfiguracaoFirebase.getFirebaseAuth();
        autenticacao.signInWithEmailAndPassword( usuario.getEmail().toString(),
                usuario.getSenha().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if ( task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login OK!", Toast.LENGTH_LONG).show();

                    abrirTelaMonitor();

                }
                else {
                    Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private boolean usuarioLogado() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            return(true);
        }
        else{
            return(false);
        }
    }


    private void abrirTelaMonitor() {

        Intent intent = new Intent(LoginActivity.this, MonitorActivity.class);
        startActivity(intent);

    }

    private void abrirTelaCadastro() {

        Intent intent = new Intent(LoginActivity.this, CadastrarActivity.class);
        startActivity(intent);

    }

}
