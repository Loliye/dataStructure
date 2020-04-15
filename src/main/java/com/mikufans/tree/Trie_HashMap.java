package com.mikufans.tree;

import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trie_HashMap
{

    private final static String[] LOVE_CHINA = {"富强", "民主", "文明", "和谐", "自由", "平等", "公正", "法治", "爱国",
            "敬业", "诚信", "友善"};


    private Set<String> keyWords;

    private Node rootNode;

    private static String invalidClear(String str)
    {
        String regEx = "[`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…（）—【】｛｝｜／《》‘；：＋——＊&……％$＃@！～”“’。，、？·\\s\t\r\n]";
        Matcher m = Pattern.compile(regEx).matcher(str);
        return m.replaceAll("").trim();
    }


    public static void main(String[] args)
    {
        Trie_HashMap trie = new Trie_HashMap();
        trie.init();
        trie.find("abc");
        trie.find("nihaoya");
        trie.find("1nihao");
        trie.find("jlkjlh");
    }

    private void readSensitiveWords()
    {
        keyWords = new HashSet<>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(Trie_HashMap.class.getClassLoader().
                    getResourceAsStream("keywords.txt"), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
                keyWords.add(line.trim());
            }
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("-------------");
    }

    private void insertKeywords(String keyword)
    {
        Node tmp = rootNode;
        for (Character c : keyword.toCharArray())
        {
            Node next = tmp.getNextNode(c);
            if (next == null)
            {
                next = new Node(c);
                tmp.putNextNode(next);
            }
            tmp = next;
        }
        tmp.isEnding = true;
    }

    public void init()
    {
        if (keyWords == null)
            readSensitiveWords();

        rootNode = new Node(' ');
        for (String keyword : keyWords)
            insertKeywords(keyword);
    }

    public boolean find(String txt)
    {
        txt = invalidClear(txt);
        StringBuffer sb = new StringBuffer();
        Node tmp = rootNode;
        for (int i = 0; i < txt.length(); i++)
        {
            tmp = tmp.getNextNode(txt.charAt(i));
            if (tmp == null)
            {
                sb.setLength(0);
                tmp = rootNode;
                continue;
            }
            sb.append(txt.charAt(i));
            if (tmp.isEnding)
            {
                System.out.println(txt + " 存在敏感词：" + sb.toString());
                return true;
            }
        }
        return false;
    }

    private String loveChina(String txt)
    {
        if (find(txt))
            return LOVE_CHINA[(int) (Math.random() * LOVE_CHINA.length)];
        return txt;
    }

    public class Node
    {
        public char key;
        public Map<Character, Node> nextNodes;
        public boolean isEnding;

        public Node(char key)
        {
            this.key = key;
            this.nextNodes = new HashMap<>();
            this.isEnding = false;
        }

        public Node getNextNode(char key)
        {
            return nextNodes.get(key);
        }

        public void putNextNode(Node node)
        {
            nextNodes.put(node.key, node);
        }
    }
}
