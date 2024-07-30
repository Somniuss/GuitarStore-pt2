package com.somniuss.guitarstore.controller;

import java.util.HashMap;
import java.util.Map;

import com.somniuss.guitarstore.controller.impl.AddInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.UpdateInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.FindInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.DeleteInstrumentCommand;
import com.somniuss.guitarstore.controller.impl.NoSuchCommand;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD, new AddInstrumentCommand());
        repository.put(CommandName.UPDATE, new UpdateInstrumentCommand());
        repository.put(CommandName.FIND, new FindInstrumentCommand());
        repository.put(CommandName.DELETE, new DeleteInstrumentCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}