package com.somniuss.guitarstore.logic;

import com.somniuss.guitarstore.entity.MusicalInstrument;
import java.util.List;

public interface GuitarstoreLogic {

	void addInstrument(MusicalInstrument instrument);

	MusicalInstrument findInstrumentById(int id);

	List<MusicalInstrument> findInstrumentsByType(String type);

	List<MusicalInstrument> findInstrumentsByBrand(String brand);

	List<MusicalInstrument> sortInstrumentsByPrice(boolean ascending);

	List<MusicalInstrument> filterInstrumentsByPrice(double maxPrice);

	void updateInstrument(MusicalInstrument instrument);

	boolean deleteInstrumentById(int id);

}
