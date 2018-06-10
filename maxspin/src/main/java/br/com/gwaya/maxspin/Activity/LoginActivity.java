package br.com.gwaya.maxspin.Activity;

/**
 * Created by Diego on 10/06/2018.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import br.com.gwaya.maxspin.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAuth autenticacao;
    private EditText login;
    private EditText senha;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.LoginText);
        senha = (EditText) findViewById(R.id.PasswordText);




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

    @Override
    public void onClick(View view) {

        hideKeyboard();

        EditText fieldEmail = findViewById(R.id.LoginText);
        String email = fieldEmail.getText().toString();

        EditText fieldPassword = findViewById(R.id.PasswordText);
        String password = fieldPassword.getText().toString();

        /*
        if(isFieldsValidated(email,password)){
            showDialog();

            WebTaskLogin taskLogin = new WebTaskLogin(this, email,password);
            taskLogin.execute();

        }
        */
    }

}
