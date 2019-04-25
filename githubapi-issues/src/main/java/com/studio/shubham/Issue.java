package com.studio.shubham;

import java.util.Date;

public class Issue implements Comparable<Object> {
  private long id;
  private String state;
  private String title;
  private String body;
  private String number;
  private Date createdAt;
  private Date closedAt;
  private User user; 
  private User assignee;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
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
      Issue other = (Issue) obj;
    if (id != other.id) 
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "Issue [id=" + id + ", state=" + state + ", title=" + title
      + ", body=" + body + ", number=" + number + ", createAt="
      + createdAt + ", closedAt=" + closedAt + ", user=" + user
      + ", assignee=" + assignee + "]";
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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


  public int compareTo(Object obj) {
    if (getClass() != obj.getClass()) {
      return -1;
    }
    Issue other = (Issue) obj;
    long locVal = id;
    long objVal = other.id;
    {
      if (locVal == objVal) {
        return 0;
      } else if (locVal > objVal) {
        return 1;
      } else {
        return -1;
      }
    }
  }
  
}

