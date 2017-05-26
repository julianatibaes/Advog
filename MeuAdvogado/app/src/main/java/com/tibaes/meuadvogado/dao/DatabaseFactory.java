package com.tibaes.meuadvogado.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Juliana Tibães on 19/05/2017.
 * MeuAdvogado
 * com.tibaes.meuadvogado.model
 */

public class DatabaseFactory extends SQLiteOpenHelper {

    private static final String DATABASE = "meu_adv";

    public static final String CLIENTE_TABLE = "cliente_table";
    public static final String ADVOGADO_TABLE = "advogado_table";
    public static final String AREA_ATUACAO_TABLE = "atuacao_table";

    // tabela cliente e advogado
    public static final String ID = "id";
    public static final String NOME_COMPLETO = "nome_completo";
    public static final String NOME_SOCIAL = "nome_social";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";

    // tabela area atuacao
    public static final String DESCRICAO = "descricao";

    // tabela advogado
    public static final String OAB = "oab";
    public static final String INICIO_ATUACAO = "inicio_atuacao";
    public static final String AREA_ATUACAO = "id_atuacao";
    public static final String CLASSIFICACAO = "classificacao";

    public DatabaseFactory(Context context) {
        super(context, "meu_adv", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCliente = "CREATE TABLE IF NOT EXISTS "+CLIENTE_TABLE+"( " +
                ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                NOME_COMPLETO+" TEXT NOT NULL, " +
                NOME_SOCIAL+" TEXT, " +
                TELEFONE+" TEXT, " +
                EMAIL+" TEXT "+
                ");";

        String sqlAtuacao = "CREATE TABLE IF NOT EXISTS "+AREA_ATUACAO_TABLE+"( " +
                ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                DESCRICAO+" TEXT NOT NULL " +
                ");";

        String sqlAdvogado = "CREATE TABLE IF NOT EXISTS "+ADVOGADO_TABLE+"( " +
                ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                NOME_COMPLETO+" TEXT NOT NULL, " +
                NOME_SOCIAL+" TEXT, " +
                EMAIL+" TEXT, "+
                OAB+" TEXT, "+
                INICIO_ATUACAO+" TEXT, "+
                AREA_ATUACAO+" INTEGER, "+
                TELEFONE+" TEXT, " +
                CLASSIFICACAO+" REAL, "+
                " FOREIGN KEY("+AREA_ATUACAO+") REFERENCES "+AREA_ATUACAO_TABLE+ "("+ID+") "+
                ");";
        db.execSQL(sqlCliente);
        db.execSQL(sqlAtuacao);
        db.execSQL(sqlAdvogado);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlCliente = "DROP TABLE IF EXISTS "+CLIENTE_TABLE+";";
        String sqlAtuacao = "DROP TABLE IF EXISTS "+AREA_ATUACAO_TABLE+";";
        String sqlAdvogado = "DROP TABLE IF EXISTS "+ADVOGADO_TABLE+";";

        db.execSQL(sqlCliente);
        db.execSQL(sqlAtuacao);
        db.execSQL(sqlAdvogado);
    }
}
