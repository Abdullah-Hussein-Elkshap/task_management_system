package banquemisr.challenge05.system.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer taskId;
    @Column(name = "TITLE")
    @Size(min = 16, max = 256)
    private String taskTitle;
    @Column(name = "DESCRIPTION")
    private String taskDescription;

    @ManyToMany
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<User> assignedUserList = new ArrayList<>();
    @Column(name = "STATUS")
    private String taskStatus;
    @Column(name = "ESTIMATE_TIME")
    private Date estimateTime;
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public void setAssignedUserList(List<User> assignedUserList) {
        this.assignedUserList = assignedUserList;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
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
