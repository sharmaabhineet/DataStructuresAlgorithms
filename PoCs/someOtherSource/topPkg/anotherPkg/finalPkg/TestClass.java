package topPkg.anotherPkg.finalPkg;

public class TestClass {
    public static void staticMethod1() {
        System.out.println("Hello World!!!!");
    }

    public static void staticMethWithArgs(String arg1, int arg2) {
        System.out.println("I am a static method with arguments");
        System.out.println("\t Arg1 is String : " +arg1);
        System.out.println("\t Arg2 is int : " +arg2);
    }

    public TestClass() {
        System.out.println("No arg constructor invoked");
    }

    public TestClass(String arg) {
        System.out.println("Arg constructor invoked: " +arg);
    }

    public void method1(){
        System.out.println("Method 1 invoked");
    }

    public void method2(String arg1, int arg2) {
        System.out.println("Method 2 invoked");
        System.out.println("\t Arg1 : " +arg1);
        System.out.println("\t Arg2 : " +arg2);
    }

    public static void main(String[] args) {
        ABC.method(args);
    }

    private static class ABC {
        static void method(String[] args) {
            System.out.println("Invoked inner class method....");
            for (String arg : args) {
                System.out.println("==> " + arg);

         DEF.method(args);   }
        }

        static class DEF {
            static void method(String[] args) {
                System.out.println("GOT INTO DEF...");
            }
        }
    }
}