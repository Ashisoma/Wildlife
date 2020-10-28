package models;

import DB.DB;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class Rangers {
    private String rangerName;
    private int contact;
    private int badge;
    private int rangersId;

    public Rangers(String rangerName, int contact, int badge) {
        this.rangerName = rangerName;
        this.contact = contact;
        this.badge = badge;
    }

    public int getRangersId() {
        return rangersId;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public void setRangersId(int rangersId) {
        this.rangersId = rangersId;
    }

    public Rangers() {
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getContact() {
        return contact;
    }

    public int getBadge() {
        return badge;
    }


}
