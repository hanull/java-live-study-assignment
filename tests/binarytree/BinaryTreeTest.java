package binarytree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Nested
    @DisplayName("addNode 메소드는")
    class AddMethod {

        @Nested
        @DisplayName("트리가 비어있을 때,")
        class EmptyTree {

            @Test
            @DisplayName("새로운 노드가 루트 노드가 된다.")
            void getRootNode() {
                BinaryTree binaryTree = new BinaryTree();

                assertNull(binaryTree.root);

                binaryTree.addNode(1);
                assertEquals(1, binaryTree.getRootNode().getValue());
            }
        }

        @Nested
        @DisplayName("트기에 하나 이상의 노드가 존재 할 때,")
        class HasNode {

        }
    }

    @Nested
    @DisplayName("DFS 메소드는")
    class DFS {

        @Test
        @DisplayName("리프 노드를 만날 때까지 재귀호출을 하고 inOrder 방법으로 값을 출력한다.")
        void dfs() {
            BinaryTree binaryTree = new BinaryTree();

            binaryTree.addNode(3);
            binaryTree.addNode(6);
            binaryTree.addNode(9);
            binaryTree.addNode(12);

            binaryTree.dfs(binaryTree.getRootNode());
        }
    }

    @Nested
    @DisplayName("BFS 메소드는")
    class BFS {

        @Test
        @DisplayName("위부터 차례로 값을 호출한다.")
        void bfs() {
            BinaryTree binaryTree = new BinaryTree();

            binaryTree.addNode(9);
            binaryTree.addNode(3);
            binaryTree.addNode(6);
            binaryTree.addNode(12);

            binaryTree.bfs();
        }
    }
}