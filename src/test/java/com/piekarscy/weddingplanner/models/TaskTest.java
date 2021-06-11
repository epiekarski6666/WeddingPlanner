package com.piekarscy.weddingplanner.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testAllGetters(){
        Task taskGetters = new Task(1, "kupić suknię", "odebrać ze sklepu", "2021-06-09", "Nowy");
        assertAll("Test successful",
                () -> assertEquals(1, taskGetters.getId()),
                () -> assertEquals("kupić suknię", taskGetters.getName()),
                () -> assertEquals("odebrać ze sklepu", taskGetters.getComment()),
                () -> assertEquals("2021-06-09", taskGetters.getUpdatedOn()),
                () -> assertEquals("Nowy", taskGetters.getStatus())
                );
    }

    @Test
    void testAllSetters(){
        Task taskSetters = new Task(1, "kupić suknię", "odebrać ze sklepu", "2021-06-09", "Nowy");
        taskSetters.setId(2);
        taskSetters.setName("limuzyna");
        taskSetters.setComment("czekamy na prezentację");
        taskSetters.setUpdatedOn("2022-12-12");
        taskSetters.setStatus("Zrobione");
        assertAll("Test successful",
                () -> assertEquals(2, taskSetters.getId()),
                () -> assertEquals("limuzyna", taskSetters.getName()),
                () -> assertEquals("czekamy na prezentację", taskSetters.getComment()),
                () -> assertEquals("2022-12-12", taskSetters.getUpdatedOn()),
                () -> assertEquals("Zrobione", taskSetters.getStatus())
        );
    }

    @Test
    void testToString() {
        Task taskToString = new Task(1, "kupić suknię", "odebrać ze sklepu", "2021-06-09", "Nowy");
        String expected = "Task [Id=1, name=kupić suknię, comment=odebrać ze sklepu, updatedOn=2021-06-09, status=Nowy]";
        String taskContains = taskToString.toString();
        assertAll("Test successful",
                () -> assertEquals(expected, taskToString.toString()),
                () -> assertTrue(taskContains.contains("Task [Id=" + 1)),
                () -> assertTrue(taskContains.contains("name=kupić suknię")),
                () -> assertTrue(taskContains.contains("comment=odebrać ze sklepu")),
                () -> assertTrue(taskContains.contains("updatedOn=2021-06-09")),
                () -> assertTrue(taskContains.contains("status=Nowy]"))
        );
    }
    @Test
    void testEnum(){
        String expectedNEW = "Nowy";
        String expectedTODO = "Do zrobienia";
        String expectedINPROGRESS = "W trakcie";
        String expectedDONE = "Zrobione";


        assertAll("Test successful",
                () -> assertEquals(expectedNEW, Task.Status.NEW.status2.toString()),
                () -> assertEquals(expectedTODO, Task.Status.TO_DO.status2.toString()),
                () -> assertEquals(expectedINPROGRESS, Task.Status.IN_PROGRESS.status2.toString()),
                () -> assertEquals(expectedDONE, Task.Status.DONE.status2.toString())
        );
    }

    @Test
    void testEmptyConstructor(){
        new Task();
    }

}