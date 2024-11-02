package com.sricode;

import java.util.Date;

public class Task {
    String id;
    String description;
    Status status;
    Date createdDate;
    Date updatedDate;

    public Task(String id, String description, Status status, Date createdDate, Date updatedDate) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String toString() {
        return "Task{id=" + id + ", description=" + description + ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "}";
    }
}
