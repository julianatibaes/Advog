package com.tibaes.meuadvogado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tibaes.meuadvogado.model.Advogado;
import com.tibaes.meuadvogado.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juliana Tibães on 19/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.dao
 */

public class AdvogadoDAO extends DatabaseFactory implements DAO<Advogado> {

    public AdvogadoDAO(Context context) {
        super(context);
    }


    @NonNull
    private ContentValues getContentValues(Advogado advogado) {
        ContentValues dados = new ContentValues();
        dados.put(ID, advogado.getId());
        dados.put(NOME_COMPLETO, advogado.getNomeCompleto());
        dados.put(NOME_SOCIAL, advogado.getNomeSocial());
        dados.put(EMAIL, advogado.getEmail());
        //dados.put(OAB, advogado.getOab());
        //dados.put(INICIO_ATUACAO, advogado.getInicioAtuacao().toString());
        dados.put(CLASSIFICACAO, advogado.getClassificacao().toString());
        dados.put(AREA_ATUACAO, "1");
        return dados;
    }

    @Override
    public void inserir(Advogado advogado) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(advogado);
        db.insert(ADVOGADO_TABLE, null, dados);
    }

    @Override
    public void alterar(Advogado advogado) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(advogado);

        String[] params ={advogado.getId().toString()};
        db.update(ADVOGADO_TABLE, dados, ID + " = ?", params);
    }

    @Override
    public void excluir(Advogado advogado) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {advogado.getId().toString()};
        db.delete(ADVOGADO_TABLE, ID +" = ?", params);
    }

    @Override
    public List<Advogado> pesquisar() {
        String sql = "SELECT * FROM "+ADVOGADO_TABLE+";";
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery(sql, null);
            Log.d("DEBUG: ", c.toString());
            List<Advogado> list = new ArrayList<Advogado>();
            while (c.moveToNext()) {
                Advogado advogado = new Advogado();
                advogado.setId(c.getLong(c.getColumnIndex(ID)));
                advogado.setNomeCompleto(c.getString(c.getColumnIndex(NOME_COMPLETO)));
                advogado.setNomeSocial(c.getString(c.getColumnIndex(NOME_SOCIAL)));
                advogado.setEmail(c.getString(c.getColumnIndex(EMAIL)));
                //advogado.setOab(c.getString(c.getColumnIndex(OAB)));
                advogado.setClassificacao(c.getFloat(c.getColumnIndex(CLASSIFICACAO)));
                //advogado.setAreaAtuacoes();
                //advogado.setInicioAtuacao();
                list.add(advogado);
            }
            c.close();
            return list;
        }
        catch (Exception e){
            Log.e("ERROR: ", e.getMessage());
            return null;
        }
    }
}
