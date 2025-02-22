package Xcess.example.Habit_Tracking.controller;


import Xcess.example.Habit_Tracking.entity.Habit;
import Xcess.example.Habit_Tracking.services.HabitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitServices habitServices;

    @PostMapping
    public Habit addHabit(@RequestBody  Habit habit){
        return habitServices.addHabit(habit);
    }

    @GetMapping("/user/{userId}")
    public List<Habit> getHabitByUserId(@PathVariable Long UserId){
        return habitServices.getHabitsByUserId(UserId);
    }

}
