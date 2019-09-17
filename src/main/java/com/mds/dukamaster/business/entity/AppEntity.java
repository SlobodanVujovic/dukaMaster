package com.mds.dukamaster.business.entity;

/**
 *
 * @author Dell
 */
//Nisam je nazvao "Application" jer JAXRSConfiguration vec extenduje klasu koja se zove Application.
public class AppEntity {

    private long id = 1;
    private String name = "'De si Duka, 100 godina!";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AppEntity other = (AppEntity) obj;
        return this.id == other.id;
    }
}
