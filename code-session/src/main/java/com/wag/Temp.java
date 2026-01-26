package com.wag;

public class Temp {

    public static void main(String[] args) {
//        List<Integer> xs = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        xs.removeIf(p -> p % 2 == 0);
//        System.out.println(xs);
//
//        Iterator<Integer> it = xs.iterator();
//        while(it.hasNext()) {
//            Integer next = it.next();
//            System.out.println("next: " + next);
//            it.remove();
//        }
//        System.out.println(xs);

        P p = new C();
        p.f("x");
    }

    static class P {
        void f(Object o) {
            System.out.print("PO");
        }
    }

    static class C extends P {
        void f(String s) {
            System.out.print("CS");
        }
    }
}
