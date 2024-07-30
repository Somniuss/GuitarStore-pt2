package com.somniuss.guitarstore.controller.impl;

import com.somniuss.guitarstore.controller.Command;
import com.somniuss.guitarstore.entity.MusicalInstrument;
import com.somniuss.guitarstore.logic.GuitarstoreLogic;
import com.somniuss.guitarstore.logic.GuitarstoreLogicProvider;

public class FindInstrumentCommand implements Command {
    private final GuitarstoreLogic logic = GuitarstoreLogicProvider.getInstance().getGuitarstoreLogic();

    @Override
    public String execute(String request) {
        String response;
        try {
            int id = Integer.parseInt(request.trim());
            MusicalInstrument instrument = logic.findInstrumentById(id);
            response = instrument != null ? instrument.toString() : "Instrument not found.";
        } catch (NumberFormatException e) {
            response = "Invalid ID format.";
        } catch (Exception e) {
            response = "Error finding instrument: " + e.getMessage();
        }
        return response;
    }
}
