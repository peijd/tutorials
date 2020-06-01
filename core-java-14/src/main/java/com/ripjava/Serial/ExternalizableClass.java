package com.ripjava.Serial;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serial;

public class ExternalizableClass implements Externalizable {
    @Serial
    private void writeObject(ObjectOutputStream stream) throws IOException {} // Compilation error

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}