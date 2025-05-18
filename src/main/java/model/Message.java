package model;

import java.sql.Timestamp;

public class Message {
    private int id;
    private String message;
    private Timestamp date;

    public Message(int id, String message, Timestamp date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Message(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
