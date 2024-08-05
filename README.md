# Trabalho de Faculdade - Ordenações e Buscas

Este repositório contém um trabalho desenvolvido durante a faculdade, focado em diversas técnicas de ordenação e busca utilizando listas encadeadas e arquivos texto. O objetivo principal é calcular o tempo de execução de cada técnica de ordenação para diferentes tipos de arquivos: ordenado, aleatório e invertido.

## Conteúdo

O trabalho consiste nos seguintes componentes principais:

- **Ordenações**: Implementação de vários algoritmos de ordenação.
- **Buscas**: Métodos de busca em listas encadeadas.
- **Medição de Tempo**: Cálculo do tempo de execução de cada técnica de ordenação em diferentes tipos de arquivos.

## Estrutura do Projeto

Abaixo está a estrutura do projeto e uma breve descrição de cada arquivo:

- `src/`
  - `Arquivo_Java.java`: Implementação das operações relacionadas ao arquivo.
  - `Entrada.java`: Classe para manipulação das entradas de dados.
  - `Lista.java`: Implementação de uma lista encadeada.
  - `Main.java`: Classe principal que executa o programa.
  - `No.java`: Implementação do nó da lista encadeada.
  - `Pilha.java`: Implementação de uma pilha.
  - `Registro.java`: Classe que define o registro a ser armazenado na lista.
  - `TabelaTxt.java`: Classe para manipulação de tabelas em arquivos texto.

- Arquivos de Dados
  - `arq.dat`, `arq1.dat`, `arq2.dat`: Arquivos de dados para testes.
  - `arqDecre.dat`: Arquivo de dados ordenado de forma decrescente.
  - `ArqOrd.dat`: Arquivo de dados ordenado.
  - `ArqRand.dat`: Arquivo de dados com ordem aleatória.
  - `ArqRev.dat`: Arquivo de dados em ordem inversa.
  - `Tab.txt`: Arquivo de texto contendo a tabela de dados.
  - `teste.dat`: Arquivo de dados de teste.

## Como Executar

Para executar o projeto, siga as etapas abaixo:

1. Certifique-se de ter o JDK instalado em sua máquina.
2. Compile as classes Java usando o seguinte comando:
   ```bash
   javac -d out/production/trab-1 src/*.java


## Funcionalidades
`Leitura e Escrita em Arquivos:` Manipulação de arquivos de dados para leitura e escrita de registros.
`Ordenação:` Implementação de vários algoritmos de ordenação e cálculo do tempo de execução para diferentes tipos de arquivos e listas encadeadas.
`Busca:` Métodos de busca eficientes em listas encadeadas e arquivos.

## Observações
O tempo de execução dos algoritmos de ordenação é medido em segundos.
Os arquivos de dados são processados para simular diferentes condições de ordenação: ordenado, aleatório e invertido.

