package ru.job4j.generics;

public class FindFixation {
    private final static int SIZE = 4;
    private Node[] arrayMustBe = new Node[SIZE];
    private Node[] arrayTesting = new Node[SIZE];

    public void setArrayTesting(Node[] insert) {
        this.arrayTesting = insert;
    }

    public void insertdates() {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        // расположение связей в базовом связанном списке
        arrayMustBe[0] = second;
        arrayMustBe[1] = third;
        arrayMustBe[2] = fourth;
        arrayMustBe[3] = null;


        // расположение связей в тестируемом связанном списке
        arrayTesting[0] = second;
        arrayTesting[1] = third;
        arrayTesting[2] = fourth;
        arrayTesting[3] = first;

    }

    public boolean hasCycle(Node first) {

        boolean res = false;

        for (int i = 0; i <= SIZE - 1; i++) {
            if (i < SIZE - 1) {
                if (!(arrayTesting[i].equals(arrayMustBe[i]))) {
                    res = true;
                    break;
                }
            } else {
                if (!(arrayTesting[SIZE - 1].equals(arrayMustBe[SIZE - 1]))) {
                    res = true;
                    break;
                }
            }
        }

        return res;
    }

    public Node[] getArrayMustBe() {
        return arrayMustBe;
    }

    public Node[] getArrayTesting() {
        return arrayTesting;
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }


}
