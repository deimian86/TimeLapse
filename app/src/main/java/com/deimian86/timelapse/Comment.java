package com.deimian86.timelapse;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Example model
 * Created by deimian86 on 24/07/2017.
 */
public class Comment {

    private String authorName;
    private String commentString;
    private Date commentDate;
    private Drawable authorAvatar;

    public Comment(){ }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Drawable getAuthorAvatar() { return authorAvatar; }

    public void setAuthorAvatar(Drawable authorAvatar) { this.authorAvatar = authorAvatar; }
}
