package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

	@Autowired
	private DepthFirstSearch depthFirstSearch;

	public static void main(String[] args) {
		SpringApplication.run(ConsoleApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(6);
		root.left.right = new Node(1);
		root.right.left = new Node(0);
		root.right.right = new Node(9);

		System.out.println("Aplikacja konsolowa SpringBoot działa");
		depthFirstSearch.dfs(root);
	}
}
