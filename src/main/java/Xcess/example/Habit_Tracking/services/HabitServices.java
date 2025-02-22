package Xcess.example.Habit_Tracking.services;

import Xcess.example.Habit_Tracking.entity.Habit;

import java.util.List;

public interface HabitServices {

    Habit addHabit(Habit habit);
    List<Habit> getHabitsByUserId(Long userId);
}
