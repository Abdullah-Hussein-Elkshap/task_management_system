package banquemisr.challenge05.system.services;


import banquemisr.challenge05.system.entities.Task;
import banquemisr.challenge05.system.models.requests.PaginationRequestModel;
import banquemisr.challenge05.system.models.requests.TaskRequestModel;
import banquemisr.challenge05.system.models.responses.BasicResponseModel;
import banquemisr.challenge05.system.models.responses.PaginationResponseModel;

public interface TaskServiceImpl {
    public BasicResponseModel createTask(TaskRequestModel taskModel);
    public BasicResponseModel updateTask(TaskRequestModel taskModel, Integer taskId);
    public PaginationResponseModel getAllTasks(PaginationRequestModel<Task> paginationRequestModel);
    public BasicResponseModel deleteTask(Integer taskId);
}
