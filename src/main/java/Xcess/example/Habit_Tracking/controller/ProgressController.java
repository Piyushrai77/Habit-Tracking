package Xcess.example.Habit_Tracking.controller;

import Xcess.example.Habit_Tracking.entity.Progress;
import Xcess.example.Habit_Tracking.services.ProgressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressServices progressServices;

    @PostMapping
    public Progress addProgress(@RequestBody Progress progress){
        return progressServices.addProgress(progress);
    }
    @GetMapping("/habit/{habitId}")
    public List<Progress> getProgressByHabitId(@PathVariable Long habitId){
        return progressServices.getProgressByHabitId(habitId);

    }
    @GetMapping("/habit/{habitId}/date/{date}")
    public List<Progress> getProgressByHabitIdAndDate(@PathVariable Long habitId,
                                                      @PathVariable String date){
        return progressServices.getProgressByHabitIdAndDate(habitId, date);
    }
}
