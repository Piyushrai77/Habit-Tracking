package Xcess.example.Habit_Tracking.services;

import Xcess.example.Habit_Tracking.entity.Progress;

import java.util.List;

public interface ProgressServices {

    Progress addProgress(Progress progress);
    List<Progress> getProgressByHabitId(Long habitId);
    List<Progress> getProgressByHabitIdAndDate(Long habitId, String date);
}
