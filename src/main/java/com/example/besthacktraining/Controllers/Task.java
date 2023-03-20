package com.example.besthacktraining.Controllers;

import com.example.besthacktraining.Models.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class Task {

    @GetMapping ("/1")
    private Task1Model task1(){
        return new Task1Model(1, "Обычный Get запрос");
    }

    @PostMapping("/2")
    private Task2Model task2(@RequestParam int number){
        Task2Model task = new Task2Model();
        task.setNumber(number);
        task.setTask("Обычный Post запрос");
        return task;
    }

    @PostMapping("/3/{string}")
    private Task3Model task3(@PathVariable String string){
        Task3Model task = new Task3Model();
        task.setString(string);
        task.setTask("Post запрос с передачей переменной по ссылке");
        return task;
    }

    @PostMapping("/4/{string}")
    private Task4Model task4(@PathVariable String string, @RequestParam int number){
        Task4Model task = new Task4Model();
        task.setString(string);
        task.setTask("Post запрос с передачей переменной по ссылке и скрыто");
        task.setNumber(number);
        return task;
    }

    @GetMapping("/5/list")
    private Task5Model task5_1(){
        Task5Model task = new Task5Model();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Я");
        map.put(2, "Люблю");
        map.put(3, "Когда");
        map.put(4, "Голые");
        map.put(5, "Волосатые");
        map.put(6, "Мужики");
        map.put(7, "Обмазываются");
        map.put(8, "Маслом");
        task.setList(map);
        task.setTask("Распарсить лист");
        return task;
    }

    @GetMapping("/5")
    private Task5Model task5_2(@RequestParam int id){
        Task5Model task = new Task5Model();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Я");
        map.put(2, "Люблю");
        map.put(3, "Когда");
        map.put(4, "Голые");
        map.put(5, "Волосатые");
        map.put(6, "Мужики");
        map.put(7, "Обмазываются");
        map.put(8, "Маслом");
        task.setList(new HashMap<>(){{
            put(id,map.get(id));
        }});
        task.setTask("Распарсить лист");
        return task;
    }

    @GetMapping("/6")
    private Task6Model task6(){
        Task6Model task = new Task6Model();
        ArrayList<String> list = new ArrayList<>();
        list.add("hi");
        list.add("i");
        list.add("am");
        list.add("dolboeb");
        task.setList(list);
        task.setTask("Лень придумывать");
        return task;
    }

    @GetMapping("/7")
    private Task7Model task7(){
        Task7Model task = new Task7Model();
        String[] list = new String[4];
        list[0] = "0 элемент";
        list[1] = "1 элемент";
        list[2] = "2 элемент";
        list[3] = "3 элемент";
        task.setList(list);
        task.setTask("Лень придумывать");
        return task;
    }

}
