package edu.studio.issue;

import java.util.Date;

public class Issue {
    
    private int number;
    
    private long id;
    
    private String state;
    
    private String title;
    
    private String body;
    
    private Date createdAt;
    
    private Date closedAt;
    
    private User user; //creator
    
    private User assignee;
    
    public Issue() {}
    
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
      
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
   
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getClosedAt() {
        return closedAt;
    }
    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getAssignee() {
        return assignee;
    }
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    
    @Override
    public String toString() {
        return "Issue [number=" + number + ", id=" + id + ", state=" + state + ", title=" + title + ", body=" + body
                + ", createdAt=" + createdAt + ", closedAt=" + closedAt + ", user=" + user.getLogin() + ", assignee=" + assignee.getLogin()
                + "]";
    }
    
    
}
