package banquemisr.challenge05.system.repositories;

import banquemisr.challenge05.system.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "select * from task t where (t.id =: filterDataModel.id)\n" +
            "and (t.title =: filterDataModel.title) \n" +
            "and (t.status =: filterDataModel.status)\n" +
            "and (t.description =: filterDataModel.description) order by t.status filterDataModel.sortBY limit filterDataModel.size ", nativeQuery = true)
    public List<Task> getAllTasksByFilterData(Task filterDataModel, String sortBy, String orderBy);
}
