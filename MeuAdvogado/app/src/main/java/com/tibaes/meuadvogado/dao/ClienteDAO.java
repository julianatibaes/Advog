package com.tibaes.meuadvogado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tibaes.meuadvogado.model.AreaAtuacao;
import com.tibaes.meuadvogado.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juliana Tibães on 19/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.dao
 */

public class ClienteDAO extends DatabaseFactory implements DAO<Cliente> {

    public ClienteDAO(Context context) {
        super(context);
    }


    @NonNull
    private ContentValues getContentValues(Cliente cliente) {
        ContentValues dados = new ContentValues();
        dados.put(ID, cliente.getId());
        dados.put(NOME_COMPLETO, cliente.getNomeCompleto());
        dados.put(NOME_SOCIAL, cliente.getNomeSocial());
        dados.put(EMAIL, cliente.getEmail());
        return dados;
    }

    @Override
    public void inserir(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(cliente);
        db.insert(CLIENTE_TABLE, null, dados);
    }

    @Override
    public void alterar(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(cliente);

        String[] params ={cliente.getId().toString()};
        db.update(CLIENTE_TABLE, dados, ID + " = ?", params);
    }

    @Override
    public void excluir(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {cliente.getId().toString()};
        db.delete(CLIENTE_TABLE, ID +" = ?", params);
    }

    @Override
    public List<Cliente> pesquisar() {
        String sql = "SELECT * FROM "+AREA_ATUACAO_TABLE+";";
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery(sql, null);
            Log.d("DEBUG: ", c.toString());
            List<Cliente> list = new ArrayList<Cliente>();
            while (c.moveToNext()) {
                Cliente cliente = new Cliente();
                cliente.setId(c.getLong(c.getColumnIndex(ID)));
                cliente.setNomeCompleto(c.getString(c.getColumnIndex(NOME_COMPLETO)));
                cliente.setNomeSocial(c.getString(c.getColumnIndex(NOME_SOCIAL)));
                cliente.setEmail(c.getString(c.getColumnIndex(EMAIL)));
                list.add(cliente);
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
