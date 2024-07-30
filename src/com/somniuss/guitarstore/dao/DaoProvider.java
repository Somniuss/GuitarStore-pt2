package com.somniuss.guitarstore.dao;

import com.somniuss.guitarstore.dao.impl.FileGuitarStoreDao;

public final class DaoProvider {
    private static final DaoProvider INSTANCE = new DaoProvider();

    private DaoProvider() {}

    private GuitarStoreDao guitarStoreDao = new FileGuitarStoreDao();

    public GuitarStoreDao getGuitarStoreDao() {
        return guitarStoreDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }
}