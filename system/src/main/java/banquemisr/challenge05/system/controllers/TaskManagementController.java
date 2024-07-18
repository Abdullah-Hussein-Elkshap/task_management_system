package banquemisr.challenge05.system.controllers;

import banquemisr.challenge05.system.models.requests.PaginationRequestModel;
import banquemisr.challenge05.system.models.requests.TaskRequestModel;
import banquemisr.challenge05.system.models.responses.PaginationResponseModel;
import banquemisr.challenge05.system.services.TaskServiceImpl;
import banquemisr.challenge05.system.entities.Task;
import banquemisr.challenge05.system.models.responses.BasicResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task/management/v1")
public class TaskManagementController {

    @Autowired
    TaskServiceImpl taskService;

    @PostMapping("/create")
    public BasicResponseModel createTask(@RequestBody TaskRequestModel taskModel){
          return taskService.createTask(taskModel);
    }
    @PostMapping("/update")
    public BasicResponseModel updateTask(@RequestBody TaskRequestModel taskModel, @PathVariable Integer taskId){
          return taskService.updateTask(taskModel, taskId);
    }
    @GetMapping("/getAll")
    public PaginationResponseModel getAllTasks(@RequestBody PaginationRequestModel<Task> paginationRequestModel){
          return taskService.getAllTasks(paginationRequestModel);
    }
    @PostMapping("/delete")
    public BasicResponseModel deleteTask(@PathVariable Integer taskId){
           return taskService.deleteTask(taskId);
    }
}
