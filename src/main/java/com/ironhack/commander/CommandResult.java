package com.ironhack.commander;

import java.util.Map;

public class CommandResult<T> {
    private Map<String, String> parameters;
    private T result;

    public CommandResult(Map<String, String> parameters, T result) {
        this.parameters = parameters;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    private void setResult(T result) {
        this.result = result;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    private void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}