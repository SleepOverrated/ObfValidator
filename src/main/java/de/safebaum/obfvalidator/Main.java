package de.safebaum.obfvalidator;

import de.safebaum.obfvalidator.checks.basic.Access;
import de.safebaum.obfvalidator.checks.basic.Instance1;
import de.safebaum.obfvalidator.checks.basic.Instance2;
import de.safebaum.obfvalidator.checks.basic.Instance3;

public class Main {
    public static String field1 = "abcdef_test_test";
    public static String field2 = "Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{";

    private static Integer successfulChecks = 0;
    public static void main(String[] args) {
        checkInstances();
    }

    private static void checkInstances() {
        System.out.println("Creating instances");
        new Instance1();
        Instance2 instance2 = new Instance2("Instance ", " Passed!");
        instance2.num = 2;
        instance2.print();
        Instance3 instance3 = new Instance3();
        instance3.print(new String[] { instance3.getString() });
        System.out.println("Done!\n");
    }
    private static void checkAccess() {
        System.out.println("Testing Field access");

        String string1 = field1.equals("abcdef_test_test") ? "passed" : "not passed";
        System.out.println("String1: " + string1);
        String string2 = field2.equals("Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{") ? "passed" : "not passed";
        System.out.println("String2: " + string2);
        String string3 = Access.field1.equals("abcdef_test_test") ? "passed" : "not passed";
        System.out.println("String3: " + string3);
        String string4 = Access.field2.equals("Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{") ? "passed" : "not passed";
        System.out.println("String4: " + string4);

        Access accessCheck = new Access();
        String string5 = accessCheck.field3.equals("abcdef_test_test") ? "passed" : "not passed";
        System.out.println("String5: " + string5);
        String string6 = accessCheck.field4.equals("Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{") ? "passed" : "not passed";
        System.out.println("String6: " + string6);

        if (field1.equals("abcdef_test_test") && field2.equals("Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{") && Access.field1.equals("abcdef_test_test") &&
                Access.field2.equals("Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{") && accessCheck.field3.equals("abcdef_test_test") && accessCheck.field4.equals("Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{")) {
            checkPassed();
        }
        System.out.println("Done!\n");
    }


    public static void checkPassed() {
        successfulChecks ++;
    }
}