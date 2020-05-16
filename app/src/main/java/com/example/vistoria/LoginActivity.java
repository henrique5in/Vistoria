package com.example.vistoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        try{
            EditText email = (EditText) findViewById(R.id.edtUsuario);
            String login = email.getText().toString();

            EditText password = (EditText) findViewById(R.id.edtSenha);

            if(login.contains("@fatec")){
                System.out.println("Sucesso");
            }else{
                Toast.makeText(this,"Digite um email válido",Toast.LENGTH_SHORT).show();

            }

        }catch (Exception e){
            Toast.makeText(this,"Erro: " +e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        SharedPreferences.Editor dados = getSharedPreferences("uehara", MODE_PRIVATE).edit();
        dados.putInt("acesso", 1);
        dados.apply();

        setResult(RESULT_OK);


        finish();
    }

}
