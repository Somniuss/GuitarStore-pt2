package com.somniuss.guitarstore.controller.impl;

import com.somniuss.guitarstore.controller.Command;
import com.somniuss.guitarstore.logic.GuitarstoreLogic;
import com.somniuss.guitarstore.logic.GuitarstoreLogicProvider;

public class DeleteInstrumentCommand implements Command {
    private final GuitarstoreLogic logic = GuitarstoreLogicProvider.getInstance().getGuitarstoreLogic();

    @Override
    public String execute(String request) {
        String response;
        String[] params = request.split("\n");

        try {
            int id = Integer.parseInt(params[1].split("=")[1]);
            boolean result = logic.deleteInstrumentById(id);
            response = result ? "Instrument deleted successfully." : "Instrument not found.";
        } catch (Exception e) {
            response = "Error deleting instrument.";
        }

        return response;
    }
}
