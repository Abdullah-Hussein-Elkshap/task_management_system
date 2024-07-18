package banquemisr.challenge05.system.services;

import banquemisr.challenge05.system.models.requests.TaskRequestModel;
import banquemisr.challenge05.system.models.responses.PaginationResponseModel;
import banquemisr.challenge05.system.repositories.UserRepository;
import banquemisr.challenge05.system.entities.Task;
import banquemisr.challenge05.system.entities.User;
import banquemisr.challenge05.system.models.requests.PaginationRequestModel;
import banquemisr.challenge05.system.models.responses.BasicResponseModel;
import banquemisr.challenge05.system.models.responses.TaskResponseModel;
import banquemisr.challenge05.system.repositories.TaskRepository;
import banquemisr.challenge05.system.utils.Defines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceImpl {

    Logger logger = LoggerFactory.getLogger(TaskService.class);
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public BasicResponseModel createTask(TaskRequestModel taskModel) {
        Task task = new Task();
        try{
            task.setTaskDescription(taskModel.getTaskDescription());
            task.setTaskTitle(taskModel.getTaskTitle());

            List<User> users = userRepository.findAll();
            task.setAssignedUserList(users);

            task.setTaskStatus(taskModel.getTaskStatus());
            task.setCreationDate(taskModel.getCreationDate());
            task.setEstimateTime(taskModel.getEstimateTime());
            taskRepository.save(task);
        }catch (Exception e){
          logger.error(Defines.DATABASE_ERROR_REPLY_MSG+":{}",e);
          return new BasicResponseModel.BasicResponseBuilderModel()
                  .setReplyCode(Defines.GENERAL_ERROR_REPLY_CODE)
                  .setReplyMsg(Defines.GENERAL_ERROR_REPLY_MSG)
                  .build();
        }
       return new BasicResponseModel
               .BasicResponseBuilderModel()
               .setReplyCode(Defines.REPLY_CODE)
               .setReplyMsg(Defines.REPLY_MSG)
               .build();
    }

    @Override
    public BasicResponseModel updateTask(TaskRequestModel taskModel, Integer taskId) {
        try {
            Optional<Task> task = taskRepository.findById(taskId);

            if(task.isPresent()){
                task.map(t -> {
                    t.setEstimateTime(taskModel.getEstimateTime());
                    t.setTaskDescription(taskModel.getTaskDescription());
                    t.setTaskTitle(taskModel.getTaskTitle());
                    t.setTaskStatus(taskModel.getTaskStatus());
                    taskRepository.save(t);
                    return t;
                });
            }
            else {
                throw new RuntimeException("Task is not exist");
            }
        }catch (Exception e){
            logger.error(Defines.DATABASE_ERROR_REPLY_MSG+":{}",e);
            return new BasicResponseModel.BasicResponseBuilderModel()
                    .setReplyCode(Defines.GENERAL_ERROR_REPLY_CODE)
                    .setReplyMsg(Defines.GENERAL_ERROR_REPLY_MSG)
                    .build();
        }
        return new BasicResponseModel
                .BasicResponseBuilderModel()
                .setReplyCode(Defines.REPLY_CODE)
                .setReplyMsg(Defines.REPLY_MSG)
                .build();
        }

    @Override
    public PaginationResponseModel getAllTasks(PaginationRequestModel<Task> paginationRequestModel) {
        List<TaskResponseModel> taskResponseModelList = new ArrayList<>();
        TaskResponseModel taskResponseModel = new TaskResponseModel();
        PaginationResponseModel paginationResponseModel = new PaginationResponseModel();
        List<Task> tasks ;

               if(paginationRequestModel.getFilterData() != null){
                    tasks =
                            taskRepository.getAllTasksByFilterData(paginationRequestModel.getFilterData(), paginationRequestModel.getSortBy(), paginationResponseModel.getOrderBy());
               }
               else {
                    tasks = taskRepository.findAll();
               }

               for(Task task : tasks){
                   taskResponseModel.setTaskId(task.getTaskId());
                   taskResponseModel.setTaskDescription(task.getTaskDescription());
                   taskResponseModel.setTaskStatus(task.getTaskStatus());
                   taskResponseModel.setTaskTitle(task.getTaskTitle());
                   taskResponseModel.setAssignedTo(taskResponseModel.getAssignedTo());
                   taskResponseModelList.add(taskResponseModel);
               }
               paginationResponseModel.setPageId(paginationRequestModel.getPageId());
               paginationResponseModel.setPageSize(paginationRequestModel.getPageSize());
               paginationResponseModel.setOrderBy(paginationResponseModel.getOrderBy());
               paginationResponseModel.setFilterDataResponse(paginationRequestModel.getFilterData());
               paginationResponseModel.setResultList(taskResponseModelList);

           return paginationResponseModel;
    }

    @Override
    public BasicResponseModel deleteTask(Integer taskId) {
        try{
            Optional<Task> task = taskRepository.findById(taskId);
            if(task.isPresent()){
                taskRepository.delete(task.get());
            }
            else {
                throw new RuntimeException();
            }
        }catch (Exception e){
            logger.error(Defines.DATABASE_ERROR_REPLY_MSG+":{}",e);
            return new BasicResponseModel.BasicResponseBuilderModel()
                    .setReplyCode(Defines.GENERAL_ERROR_REPLY_CODE)
                    .setReplyMsg(Defines.GENERAL_ERROR_REPLY_MSG)
                    .build();
        }
        return new BasicResponseModel
                .BasicResponseBuilderModel()
                .setReplyCode(Defines.REPLY_CODE)
                .setReplyMsg(Defines.REPLY_MSG)
                .build();
    }
}
