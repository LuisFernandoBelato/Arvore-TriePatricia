## 🌐 Language | Idioma

[🇺🇸 English (Default)](#en) | [🇧🇷 Português](#pt)

<div id="en"></div>

---

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

<div id="pt"></div>

---

# Implementação de Árvore PATRICIA (Trie Compactada) \ ***5º Termo - Pesquisa e Ordenação***

Este projeto apresenta uma implementação de uma Árvore PATRICIA (Pratical Algorithm To Retrieve Information Coded In Alphanumeric), uma variação otimizada das Árvores Trie (prefix trees), desenvolvida em Java, sem o uso de estruturas de dados nativas da linguagem (Árvores, Filas, etc).

## Visão Geral

A Árvore PATRICIA é uma estrutura de dados de prefixo compactada, altamente eficiente para o armazenamento e busca de strings. Ela otimiza o uso de memória e o tempo de pesquisa ao agrupar nós em caminhos unários, onde um único nó pode representar uma sequência de caracteres, em vez de apenas um caractere por nó.

Esta implementação demonstra a compreensão aprofundada de estruturas de dados, exigindo a criação manual dos componentes fundamentais da árvore e das ferramentas de travessia, como a fila customizada.

## Conceitos Fundamentais da Implementação

*   **Compactação:** A árvore comprime caminhos onde os nós têm apenas um filho, tornando a estrutura mais enxuta para conjuntos de strings com prefixos comuns.
*   **Nós da Árvore (`NoPatricia`):** Cada nó da árvore é definido por:
    *   `vLetras`: Um array `char[26]` (para as letras 'a' a 'z') que armazena os caracteres de ramificação que partem deste nó.
    *   `vLig`: Um array `NoPatricia[26]` que atua como um vetor de ponteiros, onde `vLig[i]` aponta para o próximo nó correspondente ao caractere `'a' + i`.
    *   `Palavra`: Uma `String` que armazena a palavra completa se este nó é um nó terminal (ou seja, representa o fim de uma palavra). Se o nó é apenas um intermediário de ramificação, este campo será `null`.
    *   `Numero`: Um `int` crucial que serve como o **índice de salto (skip index)**. Ele indica a posição do caractere na string que deve ser comparado para decidir qual caminho seguir a partir deste nó. Se `Numero` for `0`, o nó é considerado uma folha ou um nó terminal que armazena a `Palavra`.

## Estruturas de Dados Auxiliares Customizadas

Em total conformidade com as restrições, as seguintes estruturas de dados foram implementadas manualmente:

*   **`Fila`:** Uma implementação customizada de uma estrutura de fila (FIFO - First-In, First-Out) construída como uma lista encadeada simples.
    *   `inicio`: Ponteiro para o primeiro elemento da fila.
    *   `fim`: Ponteiro para o último elemento da fila.
    *   `enqueue(NoPatricia no, int nivel)`: Adiciona um `No` (que encapsula um `NoPatricia` e seu `nivel`) ao final da fila.
    *   `dequeue()`: Remove e retorna o primeiro `No` da fila.
    *   `IsEmpty()`: Verifica se a fila está vazia.

*   **`No` (da `Fila`):** Um nó auxiliar usado para construir a lista encadeada interna da `Fila`.
    *   `nivel`: Armazena o nível correspondente do `NoPatricia` na árvore.
    *   `No`: Armazena uma referência para o `NoPatricia` real da árvore.
    *   `prox`: Ponteiro para o próximo `No` na sequência da fila.

## Funcionalidades Implementadas

O projeto oferece as seguintes operações sobre a Árvore PATRICIA:

1.  **Inserção de Palavras (`Insere(String palavra)`):**
    *   Normaliza a palavra para minúsculas antes da inserção.
    *   Gerencia a inserção da primeira palavra, inicializando a `Raiz` da árvore.
    *   Para palavras subsequentes, o método percorre a árvore, comparando caracteres baseados no índice de salto (`Numero`) de cada nó.
    *   É capaz de:
        *   Criar novos nós terminais quando uma palavra é totalmente inserida.
        *   "Dividir" caminhos existentes, criando nós intermediários quando novos prefixos comuns ou pontos de divergência são encontrados (ex: ao inserir "gelo" após "galo", um novo nó intermediário é criado para `g` e `e`).
        *   Lidar com cenários onde uma palavra inserida é prefixo de uma já existente ou vice-versa, ajustando os `Numero` (índices de salto) e `Palavra` dos nós conforme a compactação da PATRICIA.

2.  **Exibição de Todas as Palavras (`ExibeTodasAsPalavras()`):**
    *   Realiza uma travessia na árvore utilizando o algoritmo de **Busca em Largura (BFS)**, implementado com a `Fila` customizada.
    *   Imprime no console todas as palavras armazenadas na árvore, juntamente com o nível do nó onde a palavra foi encontrada.

3.  **Exibição de Informações Nível a Nível (`ExibeTodasAsInformacoesNivelANivel()`):**
    *   Também utiliza uma **Busca em Largura (BFS)** com a `Fila` customizada para percorrer a árvore.
    *   Imprime um cabeçalho indicando cada nível da árvore.
    *   Para cada nó, exibe:
        *   Os caracteres de ramificação que ele possui.
        *   A palavra que ele armazena (se for um nó terminal), ou indica que "Não Possui" palavra.
        *   Seu índice de salto (`INDICE = %d`).

4.  **Busca de Palavras (`Busca(String palavra)`):**
    *   Percorre a árvore seguindo o fluxo de caracteres da palavra de busca e os índices de salto (`Numero`) dos nós.
    *   Retorna `true` se a palavra é encontrada na árvore e `false` caso contrário.
