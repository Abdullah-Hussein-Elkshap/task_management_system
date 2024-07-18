package banquemisr.challenge05.system.services;


import banquemisr.challenge05.system.entities.Task;
import banquemisr.challenge05.system.models.requests.PaginationRequestModel;
import banquemisr.challenge05.system.models.requests.TaskRequestModel;
import banquemisr.challenge05.system.models.responses.BasicResponseModel;
import banquemisr.challenge05.system.models.responses.PaginationResponseModel;

public interface TaskServiceImpl {
     BasicResponseModel createTask(TaskRequestModel taskModel);
     BasicResponseModel updateTask(TaskRequestModel taskModel, Integer taskId);
     PaginationResponseModel getAllTasks(PaginationRequestModel<Task> paginationRequestModel);
     BasicResponseModel deleteTask(Integer taskId);
}
