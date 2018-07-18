/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.s2it;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author mateusgobo
 */
public class MapBinaryTree {

    private LinkedHashMap<Integer, Object> tree;
    private LinkedHashMap<Integer, Object> left;
    private LinkedHashMap<Integer, Object> right;

    public static void main(String[] args) {
        MapBinaryTree map = new MapBinaryTree();
        map.addNode(5, "ROOT");
        map.addNode(3, "ESQUERDA");
        map.addNode(6, "DIREITA");
        map.addNode(4, "ESQUERDA");
        map.addNode(7, "DIREITA");
        map.showValues();
    }

    public void showValues() {
        this.tree.put(0, this.left);
        this.tree.put(1, this.right);
        for (Map.Entry<Integer, Object> arvore : this.tree.entrySet()) {
            if (arvore.getValue() instanceof String) {
                System.out.println(arvore.getKey() + "(" + arvore.getValue() + ")");
            } else if (arvore.getValue() instanceof LinkedHashMap) {
                LinkedHashMap<Integer, Object> node = (LinkedHashMap<Integer, Object>) arvore.getValue();
                for (Map.Entry<Integer, Object> n : node.entrySet()) {
                    System.out.println("\t" + n.getKey() + "(" + n.getValue() + ")");
                }
            }
        }
    }

    public void addNode(Integer key, Object value, LinkedHashMap<Integer, Object>... myTree) {
        LinkedHashMap<Integer, Object> t = myTree != null && myTree.length > 0 ? myTree[0] : this.tree;
        if (tree == null) {
            this.tree = new LinkedHashMap<>();
            this.tree.put(key, value);
        } else {
            for (Map.Entry<Integer, Object> tr : t.entrySet()) {
                if (tr.getKey() > key) {//Esquerda
                    this.addNodeLeft(t, key, value);
                } else if (tr.getKey() < key) {//Direita
                    this.addNodeRight(t, key, value);
                }
            };
        }
    }

    public void addNodeLeft(LinkedHashMap<Integer, Object> nodeLeft, Integer key, Object value) {
        if (this.left == null) {
            this.left = new LinkedHashMap<>();
            this.left.put(key, value);
        } else {
            for (Map.Entry<Integer, Object> n : nodeLeft.entrySet()) {
                if (n.getKey() > key) {//Esquerda
                    this.left.put(key, "ESQUERDA");
                } else if (n.getKey() < key) {//Direita
                    this.addNode(key, "DIREITA", nodeLeft);
                }
            }
        }
    }

    public void addNodeRight(LinkedHashMap<Integer, Object> nodeRight, Integer key, Object value) {
        if (this.right == null) {
            this.right = new LinkedHashMap<>();
            this.right.put(key, value);
        } else {
            for (Map.Entry<Integer, Object> n : nodeRight.entrySet()) {
                if (n.getKey() > key) {//Esquerda
                    this.addNode(key, "ESQUERDA", nodeRight);
                } else if (n.getKey() < key) {//Direita
                    this.right.put(key, "DIREITA");
                }
            }
        }
    }
}
