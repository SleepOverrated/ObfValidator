package de.safebaum.obfvalidator;

import de.safebaum.obfvalidator.checks.basic.Access;
import de.safebaum.obfvalidator.checks.basic.Instance1;
import de.safebaum.obfvalidator.checks.basic.Instance2;
import de.safebaum.obfvalidator.checks.basic.Instance3;
import de.safebaum.obfvalidator.checks.libs.LombokCheck;
import de.safebaum.obfvalidator.checks.manager.Human;
import de.safebaum.obfvalidator.checks.manager.TestManger;

public class Main {
    public static String field1 = "abcdef_test_test";
    public static String field2 = "Unicode_ÜÄÖ!\"§$%&/()=?_:;,.-\\*'+#~}][{";

    private static Integer successfulChecks = 0;
    public static void main(String[] args) {
        checkInstances();
        checkAccess();
        checkManager();
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

    private static void checkManager() {
        TestManger testManger = new TestManger(new Human[]
                {new Human("Joseph", 69, 1.87), new Human("Sophie", 16, 1.70), new Human("Adi", 43, 1.86),
                new Human("Tim", 14, 1.78), new Human("Jan", 75, 2.12)});
        if (testManger.check()) {
            checkPassed();
        }else {
            System.err.println("Check Failed!");
        }
    }

    private static void checkLibs() {
        LombokCheck lombokCheck = new LombokCheck("Hhehehha", 1);

        String newTestSring = "Hello i am a new Test String!";
        lombokCheck.setTestString(newTestSring);

        if (lombokCheck.getTestString().equals(newTestSring)) {
            checkPassed();
        }else {
            System.err.println("Check Failed!");
        }
    }


    public static void checkPassed() {
        System.out.println("Successfully passed a check!");
        successfulChecks ++;
    }
}