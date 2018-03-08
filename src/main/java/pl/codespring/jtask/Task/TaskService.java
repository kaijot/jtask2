package pl.codespring.jtask.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll()
                .forEach(tasks::add);
        return tasks;
    }

    public Task getTask(int id) {
        return taskRepository.findOne(id);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(int id, Task task) {
        taskRepository.save(task);

    }

    public void deleteTask(int id) {
        taskRepository.delete(id);

    }
}
