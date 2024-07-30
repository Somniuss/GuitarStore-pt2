package com.somniuss.guitarstore.dao;

import java.util.List;
import com.somniuss.guitarstore.entity.MusicalInstrument;

public interface GuitarStoreDao {

    void addInstrument(MusicalInstrument instrument);

    MusicalInstrument findInstrumentById(int id);

    List<MusicalInstrument> findInstrumentsByType(String type);

    List<MusicalInstrument> findInstrumentsByBrand(String brand);

    List<MusicalInstrument> sortInstrumentsByPrice(boolean ascending);

    List<MusicalInstrument> filterInstrumentsByPrice(double maxPrice);

    void updateInstrument(MusicalInstrument instrument);

    boolean deleteInstrumentById(int id);
	

}
