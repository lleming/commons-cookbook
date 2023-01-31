package org.example;

public class Character {
    private String name;
    private String descr;
    private Boolean protagonist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(Boolean protagonist) {
        this.protagonist = protagonist;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((descr == null) ? 0 : descr.hashCode());
        result = prime * result + ((protagonist == null) ? 0 : protagonist.hashCode());
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
        Character other = (Character) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (descr == null) {
            if (other.descr != null)
                return false;
        } else if (!descr.equals(other.descr))
            return false;
        if (protagonist == null) {
            if (other.protagonist != null)
                return false;
        } else if (!protagonist.equals(other.protagonist))
            return false;
        return true;
    }

    
}
