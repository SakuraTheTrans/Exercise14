import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper map = new ObjectMapper();

        // Deserialize into a Map to access the "todos" key
        Map<String, List<Task>> data = map.readValue(
                new File("data.json"),
                new TypeReference<Map<String, List<Task>>>() {}
        );

        // Get the list from the map
        List<Task> myList = data.get("todos");

        // Print all tasks
        for (Task task : myList) {
            System.out.println(task);
        }
        
        data.put("todos", myList); 
        map.writeValue(new File("data.json"), data);
    }
}


class Task {
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public Task() {}

    public Task(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}