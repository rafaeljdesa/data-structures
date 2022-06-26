package br.com.example.data.structures;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList {

    private static final int RESIZING_FACTOR = 2;
    private static final int INITIAL_POSITION = 0;

    private Object[] data;
    private int positionToInsertNextElement;

    public ArrayList() {
        this.data = new Object[RESIZING_FACTOR];
        this.positionToInsertNextElement = INITIAL_POSITION;
    }

    public void add(Object object) {
        this.data[this.positionToInsertNextElement] = object;
        updatePositionToInsertNextElement();
    }

    public void remove(Object object) {
        for (int i = INITIAL_POSITION; i < this.data.length; i++) {
            Object currentObject = this.data[i];
            if (object.equals(currentObject)) {
                this.data[i] = null;
                this.reallocateElements(i);
                break;
            }
        }
    }

    public Object get(Object object) {
        for (int i = INITIAL_POSITION; i < this.data.length; i++) {
            Object currentObject = this.data[i];
            if (object.equals(currentObject)) {
                return currentObject;
            }
        }
        return null;
    }

    public Object[] getAll() {
        return Arrays.stream(this.data)
                .filter(Objects::nonNull)
                .toArray();
    }

    private void resizeArray() {
        Object[] resizedData = new Object[this.data.length * RESIZING_FACTOR];
        for (int i = INITIAL_POSITION; i < this.data.length; i++) {
            resizedData[i] = this.data[i];
        }
        this.data = resizedData;
    }

    private void reallocateElements(int currentPosition) {
        this.moveElementsToLeft(currentPosition);
        this.updatePositionForInsertNextElementAfterRellocation();
    }

    private void moveElementsToLeft(int currentPosition) {
        int nextPosition = currentPosition + 1;
        for (int i = nextPosition; i < this.data.length; i++) {
            int previousPosition = i - 1;
            this.data[previousPosition] = this.data[i];
        }
    }

    private void updatePositionForInsertNextElementAfterRellocation() {
        this.positionToInsertNextElement--;
    }

    private void updatePositionToInsertNextElement() {
        this.positionToInsertNextElement++;
        if (this.positionToInsertNextElement == this.data.length) {
            this.resizeArray();
        }
    }

}
