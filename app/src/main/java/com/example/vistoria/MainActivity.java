package com.example.vistoria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Integer acesso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences dados = getSharedPreferences("uehara", MODE_PRIVATE);

        acesso = dados.getInt("acesso", 0);

        if(acesso == 0){
            Intent login = new Intent(this, LoginActivity.class);
            startActivityForResult(login, '1');
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                acesso = 1;
            }else{
                acesso = 0;
            }
            recreate();
        }
    }
    public void sair(View v){
        SharedPreferences.Editor dados = getSharedPreferences("uehara", MODE_PRIVATE).edit();
        dados.putInt("acesso", 0);
        dados.apply();

        recreate();
    }
}
