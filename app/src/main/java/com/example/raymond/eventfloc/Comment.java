package com.example.raymond.eventfloc;

import java.util.Date;

/**
 * Created by hollytatan on 21/04/15.
 */
public class Comment {

    private int comment_id;
    private int user_id;
    private Date comment_date;
    private String comment_text;


    public Comment(int comment_id, int user_id, Date comment_date, String comment_text) {
        this.user_id = user_id;
        this.comment_id = comment_id;
        this.comment_date = comment_date;
        this.comment_text = comment_text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }


}
