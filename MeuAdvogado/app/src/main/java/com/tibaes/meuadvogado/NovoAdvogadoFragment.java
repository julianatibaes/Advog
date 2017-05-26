package com.tibaes.meuadvogado;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tibaes.meuadvogado.dao.AdvogadoDAO;
import com.tibaes.meuadvogado.helper.AdvogadoHelper;
import com.tibaes.meuadvogado.model.Advogado;


public class NovoAdvogadoFragment extends Fragment {
    private AdvogadoHelper helper;
    private Advogado advogado;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novo_advogado, container, false);

        helper = new AdvogadoHelper(view);

        if(!getResources().getBoolean(R.bool.modoGrande)) {
            Intent intent = getActivity().getIntent();
            advogado = (Advogado) intent.getSerializableExtra("goAdvogado");
        }else{
            Bundle parametros = getArguments();
            if (parametros != null) {
                advogado  = (Advogado) parametros.getSerializable("goAdvogado");
            }
        }
        if (advogado != null) {
            helper.setAdvogado(advogado);
        }

        Button button = (Button) view.findViewById(R.id.btn_salvar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advogado = helper.getAdvogado();
                AdvogadoDAO dao = new AdvogadoDAO(getContext());
                if (advogado.getId() == null) {
                    dao.inserir(advogado);
                }
                else{
                    dao.alterar(advogado);
                }
                dao.close();

                if(getResources().getBoolean(R.bool.modoGrande)) {
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction tx = manager.beginTransaction();

                    ListFragment listFragment  = new ListFragment();
                    tx.replace(R.id.list_adv, listFragment);
                    tx.commit();
                }
                else{
                    getActivity().finish();
                }


            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
