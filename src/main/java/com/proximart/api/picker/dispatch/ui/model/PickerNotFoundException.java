package com.proximart.api.picker.dispatch.ui.model;

public class PickerNotFoundException extends RuntimeException {
    private final String pickerId;

    public PickerNotFoundException(String pickerId) {
        this.pickerId = pickerId;
    }

    @Override
    public String getMessage() {
        return "Picker not found, id = " + this.pickerId;
    }
}
