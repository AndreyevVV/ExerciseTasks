package LeetCode.Daily_Challenge.Hard.Delete_Duplicate_Folders_in_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {

    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String name = "";
        boolean isDeleted = false;
    }

    Map<String, Integer> serialCount = new HashMap<>();
    Map<String, List<TrieNode>> serialToNodes = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String dir : path) {
                curr.children.putIfAbsent(dir, new TrieNode());
                curr = curr.children.get(dir);
                curr.name = dir;
            }
        }

        serialize(root);

        for (Map.Entry<String, Integer> entry : serialCount.entrySet())
            if (entry.getValue() > 1)
                for (TrieNode node : serialToNodes.get(entry.getKey()))
                    markDeleted(node);

        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> parts = new ArrayList<>();
        for (String key : new TreeSet<>(node.children.keySet())) {
            String childSerial = serialize(node.children.get(key));
            parts.add("(" + key + childSerial + ")");
        }

        String serial = String.join("", parts);
        serialCount.put(serial, serialCount.getOrDefault(serial, 0) + 1);
        serialToNodes.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }

    private void markDeleted(TrieNode node) {
        node.isDeleted = true;
        for (TrieNode child : node.children.values())
            markDeleted(child);
    }

    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (child.isDeleted) continue;
            path.add(entry.getKey());
            result.add(new ArrayList<>(path));
            collectPaths(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
