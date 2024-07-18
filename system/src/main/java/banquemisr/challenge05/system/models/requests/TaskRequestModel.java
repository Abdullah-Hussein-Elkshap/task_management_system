package banquemisr.challenge05.system.models.requests;

import banquemisr.challenge05.system.entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRequestModel {
    private String taskStatus;
    private String taskTitle;
    private String taskDescription;
    private List<User> assignedUserList = new ArrayList<>();
    private Date estimateTime;
    private Date creationDate;

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public List<User> getAssignedUserList() {
        return assignedUserList;
    }

    public void setAssignedUserList(List<User> assiginedUserList) {
        this.assignedUserList = assiginedUserList;
    }

    public Date getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
