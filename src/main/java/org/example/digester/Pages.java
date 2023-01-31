package org.example.digester;

import java.util.ArrayList;
import java.util.List;

public class Pages {

    private List pages = new ArrayList();

    public List getPages() {
        return pages;
    }

    public void addPage(Object page) {
        this.pages.add(page);
    }

    
}
