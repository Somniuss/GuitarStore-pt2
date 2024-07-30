package com.somniuss.guitarstore.controller.impl;

import com.somniuss.guitarstore.controller.Command;
import com.somniuss.guitarstore.entity.MusicalInstrument;
import com.somniuss.guitarstore.logic.GuitarstoreLogic;
import com.somniuss.guitarstore.logic.GuitarstoreLogicProvider;

public class AddInstrumentCommand implements Command {
    private final GuitarstoreLogic logic = GuitarstoreLogicProvider.getInstance().getGuitarstoreLogic();

    @Override
    public String execute(String request) {
        String response;
        String[] params = request.split("\n");

        if (params.length < 4) {
            return "Error: Insufficient data provided.";
        }

        try {
  
            String type = params[0].trim();
            String brand = params[1].trim();
            String model = params[2].trim();
            double price = Double.parseDouble(params[3].trim());

            MusicalInstrument instrument = new MusicalInstrument(type, brand, model, price);
            logic.addInstrument(instrument);

            response = "Instrument added successfully.";
        } catch (Exception e) {
            response = "Error adding instrument: " + e.getMessage();
        }

        return response;
    }
}
