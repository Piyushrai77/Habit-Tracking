package Xcess.example.Habit_Tracking.services.imp;


import Xcess.example.Habit_Tracking.entity.Habit;
import Xcess.example.Habit_Tracking.repo.HabitRepository;
import Xcess.example.Habit_Tracking.services.HabitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImp implements HabitServices {

    @Autowired
    private HabitRepository habitRepository;

    @Override
    public Habit addHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public List<Habit> getHabitsByUserId(Long userId) {
        return habitRepository.findByUserId(userId);
    }
}
