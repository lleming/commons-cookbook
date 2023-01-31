package org.example;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private String genre;
    private String year;
    private String language;
    private String name;
    private String author;
    private String summary;
    private List characters = new ArrayList();

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List getCharacters() {
        return characters;
    }

    public void setCharacters(List characters) {
        this.characters = characters;
    }
    
}
