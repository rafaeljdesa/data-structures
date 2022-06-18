package br.com.example.data.structures;

import java.util.Arrays;
import java.util.Objects;

public class HashTable {

    private static final int DEFAULT_SIZE = 3;

    private String[] items;

    public HashTable() {
        this.items = new String[DEFAULT_SIZE];
    }

    public String getItem(String item) {
        int position = this.getPosition(item);
        String findedItem = this.items[position];
        if (item.equals(findedItem)) {
            return findedItem;
        }
        position = this.findNextPossibleItemPosition(position, item);
        if (position > -1) {
            return this.items[position];
        }
        return null;
    }

    public String[] getItems() {
        return Arrays.stream(this.items)
                .filter(Objects::nonNull)
                .toArray(String[]::new);
    }

    public void insertItem(String item) {
        int position = getPosition(item);
        if (this.items[position] == null || item.equals(this.items[position])) {
            this.items[position] = item;
            return;
        }
        int nextAvailablePosition = this.findNextAvailablePosition(position, item);
        if (nextAvailablePosition > -1) {
            this.items[nextAvailablePosition] = item;
            return;
        }
        this.resizeArray();
        this.insertItem(item);
    }

    public void removeItem(String item) {
        int position = this.getPosition(item);
        String findedItem = this.items[position];
        if (item.equals(findedItem)) {
            this.items[position] = null;
            return;
        }
        position = this.findNextPossibleItemPosition(position, item);
        if (position > -1) {
            this.items[position] = null;
        }
    }

    private int getPosition(String item) {
        int hashCode = this.getHashCode(item);
        return this.getPositionByHashCode(hashCode);
    }

    private void resizeArray() {
        String[] clonedItems = this.items.clone();
        this.items = new String[this.items.length + DEFAULT_SIZE];
        for (String item : clonedItems) {
            this.insertItem(item);
        }
    }

    private int getHashCode(String item) {
        return item.hashCode();
    }

    private int getPositionByHashCode(int hashCode) {
        int position = hashCode % this.items.length;
        if (position < 0) {
            return position * -1;
        }
        return position;
    }

    private int findNextAvailablePosition(int actualPosition, String item) {
        for (int i = actualPosition; i < this.items.length; i++) {
            String currentItem = this.items[i];
            if (currentItem == null || item.equals(currentItem)) {
                return i;
            }
        }
        return -1;
    }

    private int findNextPossibleItemPosition(int actualPosition, String item) {
        for (int i = actualPosition; i < this.items.length; i++) {
            if (item.equals(this.items[i])) {
                return i;
            }
        }
        return -1;
    }

}
