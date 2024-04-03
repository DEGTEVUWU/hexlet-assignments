package exercise.controller;

import org.hibernate.query.results.ResultBuilder;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN
//    @Test
//    public void testShow() throws Exception {
//        var task = newTask();
//        taskRepository.save(task);
//
//        MockHttpServletRequestBuilder request = get("/tasks/{id}" + task.getId());
//
//
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isOk()) // Проверяем, что статус ответа 200 OK
//                .andReturn();
//
//        var body = result.getResponse().getContentAsString();
//        assertThatJson(body).and(
//                v -> v.node("title").isEqualTo(task.getTitle()),
//                v -> v.node("description").isEqualTo(task.getDescription())
//        );
//    }

    @Test
    public  void testCreate() throws Exception {
        var data = newTask();
        data.setTitle("title");
        data.setDescription("des");
        taskRepository.save(data);

        MockHttpServletRequestBuilder request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        Optional<Task> task = taskRepository.findByTitle(data.getTitle());

        assertThat(task).isNotNull();
        assertThat(task.get().getTitle()).isEqualTo(data.getTitle());
        assertThat(task.get().getDescription()).isEqualTo(data.getDescription());

    }
    @Test
    public void testShow() throws Exception {
        var task = newTask();
        taskRepository.save(task);

        MockHttpServletRequestBuilder request = get("/tasks/{id}", task.getId());


        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk()) // Проверяем, что статус ответа 200 OK
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(
                v -> v.node("title").isEqualTo(task.getTitle()),
                v -> v.node("description").isEqualTo(task.getDescription())
        );
    }

    @Test
    public void testUpdate() throws Exception {
        var task = newTask();
        taskRepository.save(task);

        var data = new HashMap<>();
        data.put("title", "newTitle");
//        data.put("des", "newDes");

        var request = put("/tasks/{id}", task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                // ObjectMapper конвертирует Map в JSON
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        task = taskRepository.findById(task.getId()).get();
        assertThat(task.getTitle()).isEqualTo(("newTitle"));
//        assertThat(task.getDescription()).isEqualTo(("newDes"));
    }

    @Test
    public void testDestroy() throws Exception {
        var task = newTask();
        taskRepository.save(task);

        var request = delete("/tasks/{id}", task.getId());

        mockMvc.perform(request)
                .andExpect(status().isOk());

        assertThat(taskRepository.findById(task.getId())).isNotPresent();
    }

    public Task newTask() {
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
        return task;
    }
    // END
}
