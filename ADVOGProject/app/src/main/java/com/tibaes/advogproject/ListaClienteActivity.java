package com.tibaes.advogproject;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.tibaes.advogproject.com.tibaes.advog_project.adapter.ClienteAdapter;
import com.tibaes.advogproject.com.tibaes.advog_project.adapter.RecyclerViewOnClickListener;
import com.tibaes.advogproject.com.tibaes.advog_project.model.cliente.ClienteRepresentante;

import java.util.ArrayList;
import java.util.List;


public class ListaClienteActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        // FRAGMENT
        ListaClienteFragment frag = (ListaClienteFragment)
                getSupportFragmentManager().findFragmentByTag("mainFrag");

        if(frag == null) {
            frag = new ListaClienteFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag");
            ft.commit();
        }

    }


}
