package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DepthFirstSearch {

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        dfs(node.left);
        dfs(node.right);
    }
}
