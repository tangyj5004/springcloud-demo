package com.xuliugen.springcloud.bean;

/**
 * Created by xuliugen on 2017/7/26.
 */
public class User {

    private String id;
    private String name;
    private String password;
    private String sex;
    private int age;

    public User() {
    }

    public User(String id, String name, String password, String sex, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
