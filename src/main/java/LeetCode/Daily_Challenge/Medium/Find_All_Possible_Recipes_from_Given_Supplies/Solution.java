package LeetCode.Daily_Challenge.Medium.Find_All_Possible_Recipes_from_Given_Supplies;

import java.util.*;

public class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i))
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
        }

        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies)
            queue.offer(supply);

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String ingredient = queue.poll();
            if (indegree.containsKey(ingredient)) {
                result.add(ingredient);
            }
            if (!graph.containsKey(ingredient)) continue;

            for (String recipe : graph.get(ingredient)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    queue.offer(recipe);
                }
            }
        }

        return result;
    }
}
