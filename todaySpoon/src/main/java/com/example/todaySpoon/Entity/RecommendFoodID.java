package com.example.todaySpoon.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

    @Getter
    @Setter
    public class RecommendFoodID implements Serializable {

        private String userID;
        private Long foodId;

        public RecommendFoodID() {
        }

        public RecommendFoodID(String userID, Long foodId) {
            this.userID = userID;
            this.foodId = foodId;
        }


    }
