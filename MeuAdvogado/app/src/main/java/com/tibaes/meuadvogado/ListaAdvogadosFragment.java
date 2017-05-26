package com.tibaes.meuadvogado;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tibaes.meuadvogado.adapter.AdvogadosAdapter;
import com.tibaes.meuadvogado.adapter.RecyclerViewOnClickListener;
import com.tibaes.meuadvogado.dao.AdvogadoDAO;
import com.tibaes.meuadvogado.model.Advogado;

import java.util.ArrayList;
import java.util.List;


public class ListaAdvogadosFragment extends Fragment implements RecyclerViewOnClickListener {

    private RecyclerView recyclerView;
    private List<Advogado> advogadoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_advogados, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        carregar();

        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.float_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getResources().getBoolean(R.bool.modoGrande)) {
                    Intent intent = new Intent(getContext(), NovoAdvogadoActivity.class);
                    startActivity(intent);
                }
                else{
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction tx = manager.beginTransaction();

                    NovoAdvogadoFragment novoAdvogadoFragment = new NovoAdvogadoFragment();
                    tx.replace(R.id.new_adv, novoAdvogadoFragment);
                    tx.commit();
                }
            }
        });
        return view;
    }

    private void carregar() {
        AdvogadoDAO dao = new AdvogadoDAO(getContext());
        advogadoList = dao.pesquisar();
        dao.close();

        AdvogadosAdapter adapter = new AdvogadosAdapter(getActivity(), advogadoList);
        adapter.setRecyclerViewOnClickListener(this);
        recyclerView.setAdapter( adapter );
    }

    @Override
    public void onClickListener(View view, int position) {
        AdvogadosAdapter adapter = (AdvogadosAdapter) recyclerView.getAdapter();
        Advogado advogado = adapter.getAdvogado(position);
        if(getResources().getBoolean(R.bool.modoGrande)) {
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction tx = manager.beginTransaction();

            NovoAdvogadoFragment novaReceitaFragment = new NovoAdvogadoFragment();

            Bundle parametros = new Bundle();
            parametros.putSerializable("goAdvogado", advogado);
            novaReceitaFragment.setArguments(parametros);
            tx.replace(R.id.new_adv, novaReceitaFragment);
            tx.commit();

        }
        else{
            Intent intent = new Intent(getActivity(), NovoAdvogadoActivity.class);
            intent.putExtra("goAdvogado", advogado);
            startActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        carregar();
    }
}
