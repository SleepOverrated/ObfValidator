package de.safebaum.obfvalidator.checks.basic;

import java.util.Base64;

public class Instance3 {

    public String getString() {
        return "SW5zdGFuY2UgMyBQYXNzZWQh";
    }

    public void print(String... args) {
        Base64.Decoder base64decoder = Base64.getDecoder();
        for (String str : args)
            System.out.println(new String(base64decoder.decode(str)));
    }
}
