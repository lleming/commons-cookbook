package org.example;

import java.util.List;

public class Country {
    private String name;
    private List regions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getRegions() {
        return regions;
    }

    public void setRegions(List regions) {
        this.regions = regions;
    }

    

    @Override
    public String toString() {
        return "Country [name=" + name + ", regions=" + regions + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
}
