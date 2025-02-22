package Xcess.example.Habit_Tracking.repo;

import Xcess.example.Habit_Tracking.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit,Long> {


    List<Habit> findByUserId(Long userId);
}
