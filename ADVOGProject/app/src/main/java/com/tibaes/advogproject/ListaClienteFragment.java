package com.tibaes.advogproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tibaes.advogproject.com.tibaes.advog_project.adapter.ClienteAdapter;
import com.tibaes.advogproject.com.tibaes.advog_project.adapter.RecyclerViewOnClickListener;
import com.tibaes.advogproject.com.tibaes.advog_project.model.cliente.ClienteRepresentante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListaClienteFragment extends Fragment implements RecyclerViewOnClickListener{

    private RecyclerView recyclerView;
    private List<ClienteRepresentante> clientes;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_cliente, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_listas_cliente);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        carregar();

        return view;
    }

    private void carregar() {

        clientes = new ArrayList<>();
        clientes.add(new ClienteRepresentante("Ana"));
        clientes.add(new ClienteRepresentante("José"));
        clientes.add(new ClienteRepresentante("João"));

        //ArrayAdapter<ClienteRepresentante> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clientes);

        ClienteAdapter adapter = new ClienteAdapter(getActivity(), clientes);
        adapter.setRecyclerViewOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        carregar();
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "Position: "+position, Toast.LENGTH_SHORT).show();

        ClienteAdapter adapter = (ClienteAdapter) recyclerView.getAdapter();

        ClienteRepresentante contact = adapter.getClient(position);
        Intent intent = new Intent(getContext(),
                NovoClienteActivity.class);

        // pega os dados do objeto shirt e utiliza o marcador
        // "goClient" para a intent carregar essa informação na hora de 'startar' outra
        intent.putExtra("goClient", contact);
        startActivity(intent);
    }


}
