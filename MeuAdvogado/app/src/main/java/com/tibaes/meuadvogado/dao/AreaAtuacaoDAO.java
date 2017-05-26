package com.tibaes.meuadvogado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tibaes.meuadvogado.model.AreaAtuacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juliana Tibães on 19/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.dao
 */

public class AreaAtuacaoDAO extends DatabaseFactory implements DAO<AreaAtuacao> {

    public AreaAtuacaoDAO(Context context) {
        super(context);
    }


    @NonNull
    private ContentValues getContentValues(AreaAtuacao areaAtuacao) {
        ContentValues dados = new ContentValues();
        dados.put(ID, areaAtuacao.getId());
        dados.put(DESCRICAO, areaAtuacao.getDescricao());
        return dados;
    }

    @Override
    public void inserir(AreaAtuacao areaAtuacao) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(areaAtuacao);
        db.insert(AREA_ATUACAO_TABLE, null, dados);
    }

    @Override
    public void alterar(AreaAtuacao areaAtuacao) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(areaAtuacao);

        String[] params ={areaAtuacao.getId().toString()};
        db.update(AREA_ATUACAO_TABLE, dados, ID + " = ?", params);
    }

    @Override
    public void excluir(AreaAtuacao areaAtuacao) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {areaAtuacao.getId().toString()};
        db.delete(AREA_ATUACAO_TABLE, ID +" = ?", params);
    }

    @Override
    public List<AreaAtuacao> pesquisar() {
        String sql = "SELECT * FROM "+AREA_ATUACAO_TABLE+";";
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery(sql, null);
            Log.d("DEBUG: ", c.toString());
            List<AreaAtuacao> list = new ArrayList<AreaAtuacao>();
            while (c.moveToNext()) {
                AreaAtuacao atuacao = new AreaAtuacao();
                atuacao.setId(c.getLong(c.getColumnIndex(ID)));
                atuacao.setDescricao(c.getString(c.getColumnIndex(DESCRICAO)));
                list.add(atuacao);
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
