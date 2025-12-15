# PATRICIA Tree Implementation (Compressed Trie) \ ***5th Term - Search and Sorting***

This project presents an implementation of a PATRICIA Tree (Practical Algorithm To Retrieve Information Coded In Alphanumeric), an optimized variation of Trie Trees (prefix trees), developed in Java without the use of the language's native data structures (Trees, Queues, etc.).

## Overview

The PATRICIA Tree is a compressed prefix data structure, highly efficient for string storage and retrieval. It optimizes memory usage and search time by grouping nodes into unary paths, where a single node can represent a sequence of characters instead of just one character per node.

This implementation demonstrates a deep understanding of data structures, requiring the manual creation of fundamental tree components and traversal tools, such as the custom queue.

## Fundamental Implementation Concepts

*   **Compression:** The tree compresses paths where nodes have only one child, making the structure leaner for sets of strings with common prefixes.
*   **Tree Nodes (`NoPatricia`):** Each node in the tree is defined by:
    *   `vLetras`: A `char[26]` array (for letters 'a' to 'z') storing the branching characters originating from this node.
    *   `vLig`: A `NoPatricia[26]` array acting as a vector of pointers, where `vLig[i]` points to the next node corresponding to character `'a' + i`.
    *   `Palavra`: A `String` storing the complete word if this is a terminal node (i.e., represents the end of a word). If the node is just a branching intermediate, this field will be `null`.
    *   `Numero`: A crucial `int` serving as the **skip index**. It indicates the position of the character in the string to be compared to decide which path to follow from this node. If `Numero` is `0`, the node is considered a leaf or a terminal node storing the `Palavra`.

## Custom Auxiliary Data Structures

In full compliance with restrictions, the following data structures were manually implemented:

*   **`Fila` (Queue):** A custom implementation of a queue structure (FIFO - First-In, First-Out) built as a simple linked list.
    *   `inicio`: Pointer to the first element of the queue.
    *   `fim`: Pointer to the last element of the queue.
    *   `enqueue(NoPatricia no, int nivel)`: Adds a `No` (encapsulating a `NoPatricia` and its `level`) to the end of the queue.
    *   `dequeue()`: Removes and returns the first `No` from the queue.
    *   `IsEmpty()`: Checks if the queue is empty.
    
*   **`No` (Queue Node):** An auxiliary node used to build the internal linked list of the `Fila`.
    *   `nivel`: Stores the corresponding level of the `NoPatricia` in the tree.
    *   `No`: Stores a reference to the actual `NoPatricia` of the tree.
    *   `prox`: Pointer to the next `No` in the queue sequence.

## Implemented Features

The project offers the following operations on the PATRICIA Tree:

1.  **Word Insertion (`Insere(String palavra)`):**
    *   Normalizes the word to lowercase before insertion.
    *   Manages the first word insertion, initializing the tree `Raiz` (Root).
    *   For subsequent words, the method traverses the tree, comparing characters based on the skip index (`Numero`) of each node.
    *   It is capable of:
        *   Creating new terminal nodes when a word is fully inserted.
        *   "Splitting" existing paths, creating intermediate nodes when new common prefixes or divergence points are found (e.g., inserting "gelo" after "galo", a new intermediate node is created for `g` and `e`).
        *   Handling scenarios where an inserted word is a prefix of an existing one or vice-versa, adjusting the `Numero` (skip indices) and `Palavra` of nodes according to PATRICIA compression.

2.  **Display All Words (`ExibeTodasAsPalavras()`):**
    *   Performs a tree traversal using the **Breadth-First Search (BFS)** algorithm, implemented with the custom `Fila`.
    *   Prints to the console all words stored in the tree, along with the level of the node where the word was found.

3.  **Display Level-by-Level Information (`ExibeTodasAsInformacoesNivelANivel()`):**
    *   Also uses a **Breadth-First Search (BFS)** with the custom `Fila` to traverse the tree.
    *   Prints a header indicating each level of the tree.
    *   For each node, it displays:
        *   The branching characters it possesses.
        *   The word it stores (if it is a terminal node), or indicates it "Does Not Have" a word.
        *   Its skip index (`INDICE = %d`).

4.  **Word Search (`Busca(String palavra)`):**
    *   Traverses the tree following the character flow of the search word and the skip indices (`Numero`) of the nodes.
    *   Returns `true` if the word is found in the tree and `false` otherwise.
