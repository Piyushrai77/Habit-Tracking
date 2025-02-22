package Xcess.example.Habit_Tracking.services.imp;

import Xcess.example.Habit_Tracking.entity.Progress;
import Xcess.example.Habit_Tracking.repo.ProgressRepository;
import Xcess.example.Habit_Tracking.services.ProgressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServicesImp implements ProgressServices {

    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public Progress addProgress(Progress progress) {
        return progressRepository.save(progress);

    }

    @Override
    public List<Progress> getProgressByHabitId(Long habitId) {
        return progressRepository.findByHabitHabitId(habitId);
    }

    @Override
    public List<Progress> getProgressByHabitIdAndDate(Long habitId, String date) {
        return progressRepository.findByHabitHabitIdAndDate(habitId, date);
    }
}
