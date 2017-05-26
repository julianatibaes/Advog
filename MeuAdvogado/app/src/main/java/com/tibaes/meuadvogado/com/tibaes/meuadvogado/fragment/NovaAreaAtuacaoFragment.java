package com.tibaes.meuadvogado.com.tibaes.meuadvogado.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tibaes.meuadvogado.R;
import com.tibaes.meuadvogado.dao.AreaAtuacaoDAO;
import com.tibaes.meuadvogado.model.AreaAtuacao;


public class NovaAreaAtuacaoFragment extends Fragment {

    private EditText editAtuacao;
    public NovaAreaAtuacaoFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_nova_area_atuacao, container, false);

        editAtuacao = (EditText) view.findViewById(R.id.edit_atuacao);
        Button btnSalvar = (Button) view.findViewById(R.id.btn_atuacao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AreaAtuacaoDAO dao = new AreaAtuacaoDAO(getContext());
                dao.inserir(new AreaAtuacao(editAtuacao.getText().toString()));
                editAtuacao.setText("");
                getActivity().finish();
            }
        });

        return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
