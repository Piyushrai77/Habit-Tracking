package Xcess.example.Habit_Tracking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long habitId;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String frequency;



    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progress> progressList;
    //Getter and setter

    public long getHabitId() {
        return habitId;
    }

    public void setHabitId(long habitId) {
        this.habitId = habitId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public List<Progress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<Progress> progressList) {
        this.progressList = progressList;
    }

}

