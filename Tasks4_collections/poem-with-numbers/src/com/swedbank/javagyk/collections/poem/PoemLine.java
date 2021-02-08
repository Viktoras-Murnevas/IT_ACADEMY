package com.swedbank.javagyk.collections.poem;

public class PoemLine implements Comparable<PoemLine> {

    private int number;
    private String text;

    public PoemLine(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    @Override
    public int compareTo(PoemLine o1) {
        if (o1.getNumber() > this.number) {
            return 1;
        } else if (o1.getNumber() < number) {
            return -1;
        }
        return 0;
    }
}
