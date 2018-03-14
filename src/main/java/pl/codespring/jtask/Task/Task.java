package pl.codespring.jtask.Task;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;

enum TaskPriority {LOW, MEDIUM, HIGH}

class ParseDeserializer extends StdDeserializer<LocalDateTime> {
    public ParseDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return LocalDateTime.parse(p.getValueAsString()); // or overloaded with an appropriate format
    }
}

@Entity
public class Task {

    @Column(name = "status")
    boolean status = false;
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "toDoDate")
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = ParseDeserializer.class)
    private LocalDateTime toDoDate;
    @Column(name = "taskPriority")
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    {
        this.toDoDate = LocalDateTime.now();
        this.status = false;
        this.priority = TaskPriority.MEDIUM;
        this.status = true;

    }

    public Task() {

    }

    public Task(boolean status, String name, String description, LocalDateTime toDoDate, TaskPriority priority) {
        this.status = status;
        this.name = name;
        this.description = description;
        this.toDoDate = toDoDate;
        this.priority = priority;
    }



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getToDoDate() {
        return toDoDate;
    }

    public void setToDoDate(LocalDateTime toDoDate) {
        this.toDoDate = toDoDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
}




