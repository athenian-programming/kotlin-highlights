package org.athenian;

public class Examples {

    public static void main(String[] args) {

        Person p = new Person();
        p.setFirst("Jill");
        p.setLast("Quigley");
        p.setAge(25);
        System.out.println(p);

        FluentPerson fp =
                new FluentPerson()
                        .setFirst("Bill")
                        .setLast("Mason")
                        .setAge(35);
        System.out.println(fp);

    }
}