package de.safebaum.obfvalidator.checks.manager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TestManger {

    private ArrayList<Human> humans;

    public TestManger(Human[] humans) {
        this.humans = new ArrayList<>();
        this.humans.addAll(Arrays.asList(humans));
    }

    public boolean check() {
        int successfulChecks = 0;
        for (Human human : humans) {
            successfulChecks += human.talk();
        }
        return successfulChecks == humans.size();
    }

}
