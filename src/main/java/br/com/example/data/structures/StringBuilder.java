package br.com.example.data.structures;

import java.util.Arrays;

public class StringBuilder {

    private final ArrayList arrayList;

    public StringBuilder() {
        this.arrayList = new ArrayList();
    }

    public StringBuilder append(String string) {
        this.arrayList.add(string);
        return this;
    }

    public String toString() {
        return Arrays.stream(this.arrayList.getAll())
                .map(Object::toString)
                .reduce((str1, str2) -> str1 + str2)
                .orElse(null);
    }
}
