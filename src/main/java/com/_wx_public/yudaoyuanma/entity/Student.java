package com._wx_public.yudaoyuanma.entity;

public class Student {
    private String name;
    private int age;

    /**
     * Setter 和 Getter可以用lombok重构
     * @return
     */
    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
            this.age = age;
    }

    /**
     * lombok 有 提供 Builder 实现，一个注解就完事
     * @return
     */
    public static Builder builder(){
            return new Builder();
    }
    public static class Builder{
            private String name;
            private int age;
            public Builder name(String name){
                    this.name = name;
                    return this;
            }

            public Builder age(int age){
                    this.age = age;
                    return this;
            }

            public Student build(){
                    Student student = new Student();
                    student.setAge(age);
                    student.setName(name);
                    return student;
            }
    }

    public static void main(String[] args) {
        new Student.Builder().age(1).name("lombok有Accessor");
    }
}