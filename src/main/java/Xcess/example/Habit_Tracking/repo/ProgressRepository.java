package Xcess.example.Habit_Tracking.repo;

import Xcess.example.Habit_Tracking.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress,Long> {

    List<Progress> findByHabitHabitId(Long habitId);

    // Custom query to find progress by date
    List<Progress> findByHabitHabitIdAndDate(Long habitId, String date);
}
