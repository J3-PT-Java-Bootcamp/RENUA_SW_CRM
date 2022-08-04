package com.ironhack.commander;

import java.util.Map;

public class CommandResult<T> {
    private Map<String, String> parameters;
    private Command<T> command;

    public CommandResult(Map<String, String> parameters, Command command) {
        this.parameters = parameters;
        this.command = command;
    }

    public T getResult() {
        return command.getValue();
    }


    public Map<String, String> getParameters() {
        return parameters;
    }

    public void run() {
        this.command.run(this);
    }

    private void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
    public String getParameter(String key) {
        return getParameters().get(key);
    }

    public int getIntegerParameter(String key) {
        return Integer.parseInt((getParameters().get(key)));
    }
}