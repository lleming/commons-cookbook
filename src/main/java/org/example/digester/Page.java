package org.example.digester;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private List persons = new ArrayList();

    public void addPerson(Object person) {
        persons.add(person);
    }

    public List getPersons() {
        return this.persons;
    }
}
