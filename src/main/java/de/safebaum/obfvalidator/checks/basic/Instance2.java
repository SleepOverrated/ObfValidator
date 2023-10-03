package de.safebaum.obfvalidator.checks.basic;

import de.safebaum.obfvalidator.Main;

public class Instance2 {

    public String passed;
    public String instance;
    public int num;

    public Instance2(String instance, String s) {
        this.instance = instance;
        this.passed = s;
    }
    public void print() {
        System.out.println(this.instance + this.num + this.passed);
        Main.checkPassed();
    }
}
