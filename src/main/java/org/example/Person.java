package org.example;

public class Person {
    private String name;
    private String favoriteColour;
    private Integer age;

    public Person() {

    }

    public Person(String name) {
        this(name, null);
    }

    public Person(String name, String favoriteColour) {
        this.name = name;
        this.favoriteColour = favoriteColour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteColour() {
        return favoriteColour;
    }

    public void setFavoriteColour(String favoriteColour) {
        this.favoriteColour = favoriteColour;
    }

    String getNameColourfull() {
        return name + " " + favoriteColour;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
