package LeetCode.Daily_Challenge.Medium.Design_a_Food_Rating_System;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {

        class FoodRatings {
            private Map<String, String> foodToCuisine;
            private Map<String, Integer> foodToRating;
            private Map<String, TreeSet<String>> cuisineToFoods;

            public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
                foodToCuisine = new HashMap<>();
                foodToRating = new HashMap<>();
                cuisineToFoods = new HashMap<>();

                for (int i = 0; i < foods.length; i++) {
                    String food = foods[i];
                    String cuisine = cuisines[i];
                    int rating = ratings[i];

                    foodToCuisine.put(food, cuisine);
                    foodToRating.put(food, rating);

                    cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                        (a, b) -> {
                            int cmp = Integer.compare(foodToRating.get(b), foodToRating.get(a));
                            if (cmp == 0) return a.compareTo(b);
                            return cmp;
                        }
                    ));
                    cuisineToFoods.get(cuisine).add(food);
                }
            }

            public void changeRating(String food, int newRating) {
                String cuisine = foodToCuisine.get(food);
                TreeSet<String> set = cuisineToFoods.get(cuisine);

                set.remove(food);
                foodToRating.put(food, newRating);
                set.add(food);
            }

            public String highestRated(String cuisine) {
                return cuisineToFoods.get(cuisine).first();
            }
    }
}
