package model;

import java.sql.Timestamp;

public class Message {
    private int id;
    private String message;
    private int senderId;
    private int receiverId;
    private Timestamp date;

    public Message(String message, Timestamp date, int senderId, int receiverId) {
        this.message = message;
        this.date = date;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Message(){}

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

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
