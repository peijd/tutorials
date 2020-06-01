package com.ripjava.Serial;

import java.io.ObjectStreamException;
import java.io.Serial;

public enum SerialEnum {
    TEST;

    @Serial
    private void readObjectNoData() throws ObjectStreamException {} // Compilation error
}