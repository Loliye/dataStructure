package com.mikufans.tree;

public class Trie
{
    private Node root = new Node('/');

    public static void main(String[] args)
    {
        Trie trie = new Trie();
        trie.insert("nm");
        System.out.println(trie.find("wcnm"));
        System.out.println(trie.find("nihaoya"));
    }

    public void insert(String txt)
    {
        Node node = root;
        for (int i = 0; i < txt.length(); i++)
        {
            int index = txt.charAt(i) - 'a';
            if (node.children[index] == null)
            {
                Node tmp = new Node(txt.charAt(i));
                node.children[index] = tmp;
            }
            node = node.children[index];
        }
        node.isEnding = true;
    }

    public boolean find(String pattern)
    {
        Node p = root;
        for (int i = 0; i < pattern.length(); i++)
        {
            int index = pattern.charAt(i) - 'a';
            if (p.children[index] == null)
            {
                p = root;
                continue;
            }
            p = p.children[index];
            if (p.isEnding)
                return true;
        }

        return false;
    }

    public class Node
    {
        public char data;
        public Node[] children = new Node[30];
        public boolean isEnding = false;

        public Node(char data)
        {
            this.data = data;
        }
    }
}
