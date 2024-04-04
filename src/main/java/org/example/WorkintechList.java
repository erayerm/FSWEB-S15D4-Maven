package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList extends ArrayList {
    @Override
    public boolean add(Object o) {
        if (!this.contains(o)) super.add(o);
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean returningBool = super.remove(o);
        sort();
        return returningBool;
    }

    public void sort() {
        Collections.sort(this);
    }
}
