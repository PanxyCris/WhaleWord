package com.silence.enums;

public enum Label {
    Handled("已掌握"),
    Unfamiliar("生词"),
    Studied("已学词");

    public String value;

    Label(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
