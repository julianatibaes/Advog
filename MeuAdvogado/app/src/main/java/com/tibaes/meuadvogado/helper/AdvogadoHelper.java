package com.tibaes.meuadvogado.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.tibaes.meuadvogado.R;

import com.tibaes.meuadvogado.model.Advogado;

/**
 * Created by Juliana Tibães on 22/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.helper
 */

public class AdvogadoHelper {
    private final EditText etNome, etNomeSocial, etTelefone, etEmail;
    private final RatingBar rbClassificacao;
    private Advogado advogado;

    public AdvogadoHelper(View view) {
        etNome = (EditText) view.findViewById(R.id.ed_nome);
        etNomeSocial = (EditText) view.findViewById(R.id.ed_nome_social);
        etTelefone = (EditText) view.findViewById(R.id.et_telefone);
        etEmail= (EditText) view.findViewById(R.id.et_email);
        rbClassificacao = (RatingBar) view.findViewById(R.id.rb_classificacao);
        advogado = new Advogado();
    }
    public Advogado getAdvogado(){
        advogado.setNomeCompleto(etNome.getText().toString());
        advogado.setNomeSocial(etNomeSocial.getText().toString());
        advogado.setTelefone(etTelefone.getText().toString());
        advogado.setEmail(etEmail.getText().toString());
        advogado.setClassificacao(rbClassificacao.getRating());
        return advogado;
    }

    public void setAdvogado(Advogado advogado){
        etNome.setText(advogado.getNomeCompleto());
        etNomeSocial.setText(advogado.getNomeSocial());
        etTelefone.setText(advogado.getTelefone());
        etEmail.setText(advogado.getEmail());
        rbClassificacao.setRating(advogado.getClassificacao());
        this.advogado = advogado;
    }
}
