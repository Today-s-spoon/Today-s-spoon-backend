package com.example.todaySpoon.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@IdClass(RecommendFoodID.class)
@Getter
@Setter
public class RecommendFood implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userID;

    @Id
    @Column(name = "food_id")
    private Long foodId;

    float recommendAmount;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;
}
