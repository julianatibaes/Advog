package com.tibaes.meuadvogado;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tibaes.meuadvogado.com.tibaes.meuadvogado.fragment.NovaAreaAtuacaoFragment;
import com.tibaes.meuadvogado.dao.AreaAtuacaoDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FRAGMENT
         if (getResources().getBoolean(R.bool.modoGrande)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction tx = fragmentManager.beginTransaction();
            tx.replace(R.id.list_adv, new ListaAdvogadosFragment());
            tx.replace(R.id.new_adv, new NovoAdvogadoFragment());
            tx.commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_atuacao:
                Intent intent = new Intent(MainActivity.this, NovaAtuacaoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
