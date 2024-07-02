package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepthFirstSearchTests {

	@Autowired
	private DepthFirstSearch depthFirstSearch;

	@Test
	public void testDFS() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(6);
		root.left.right = new Node(1);
		root.right.left = new Node(0);
		root.right.right = new Node(9);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		depthFirstSearch.dfs(root);
		String expectedOutput = "1\r\n2\r\n6\r\n1\r\n3\r\n0\r\n9\r\n";
		assertEquals(expectedOutput, outContent.toString());
	}
}
