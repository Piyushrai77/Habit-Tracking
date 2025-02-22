package Xcess.example.Habit_Tracking.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long progressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="habit_id", nullable = false)
    private Habit habit;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Boolean status;



    public long getProgressId() {
        return progressId;
    }

    public void setProgressId(long progressId) {
        this.progressId = progressId;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
