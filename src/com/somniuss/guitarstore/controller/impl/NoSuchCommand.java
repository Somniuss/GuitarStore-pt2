package com.somniuss.guitarstore.controller.impl;

import com.somniuss.guitarstore.controller.Command;

public class NoSuchCommand implements Command {
    @Override
    public String execute(String request) {
        return "Invalid command.";
    }
}