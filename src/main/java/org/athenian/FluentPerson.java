package org.athenian;

public class FluentPerson {

    private String first;
    private String last;
    private int age;

    public FluentPerson() {
    }

    public String getFirst() {
        return first;
    }

    public FluentPerson setFirst(String first) {
        this.first = first;
        return this;
    }

    public String getLast() {
        return last;
    }

    public FluentPerson setLast(String last) {
        this.last = last;
        return this;
    }

    public int getAge() {
        return age;
    }

    public FluentPerson setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FluentPerson{");
        sb.append("first='").append(first).append('\'');
        sb.append(", last='").append(last).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

}
