package pl.codespring.jtask.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String tasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }
    @ResponseBody
    @RequestMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @ResponseBody
    @RequestMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTask(id);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value ="/tasks/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable int id){
        taskService.updateTask(id, task);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/tasks")
    public void addTask(@RequestBody  Task task){
        taskService.addTask(task);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

}
