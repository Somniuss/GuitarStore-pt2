package com.somniuss.guitarstore.logic.impl;

import com.somniuss.guitarstore.dao.DaoProvider;
import com.somniuss.guitarstore.dao.GuitarStoreDao;
import com.somniuss.guitarstore.entity.MusicalInstrument;
import com.somniuss.guitarstore.logic.GuitarstoreLogic;

import java.util.List;

public class GuitarstoreLogicImpl implements GuitarstoreLogic {

    private final GuitarStoreDao guitarStoreDao = DaoProvider.getInstance().getGuitarStoreDao();

    @Override
    public void addInstrument(MusicalInstrument instrument) {
        guitarStoreDao.addInstrument(instrument);
    }

    @Override
    public MusicalInstrument findInstrumentById(int id) {
        return guitarStoreDao.findInstrumentById(id);
    }

    @Override
    public List<MusicalInstrument> findInstrumentsByType(String type) {
        return guitarStoreDao.findInstrumentsByType(type);
    }

    @Override
    public List<MusicalInstrument> findInstrumentsByBrand(String brand) {
        return guitarStoreDao.findInstrumentsByBrand(brand);
    }

    @Override
    public List<MusicalInstrument> sortInstrumentsByPrice(boolean ascending) {
        return guitarStoreDao.sortInstrumentsByPrice(ascending);
    }

    @Override
    public List<MusicalInstrument> filterInstrumentsByPrice(double maxPrice) {
        return guitarStoreDao.filterInstrumentsByPrice(maxPrice);
    }

    @Override
    public void updateInstrument(MusicalInstrument instrument) {
        guitarStoreDao.updateInstrument(instrument);
    }

    @Override
    public boolean deleteInstrumentById(int id) {
        return guitarStoreDao.deleteInstrumentById(id);
    }
}