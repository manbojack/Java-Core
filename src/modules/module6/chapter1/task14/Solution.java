package modules.module6.chapter1.task14;

public class Solution {
    public static void main(String[] args) {

        String[] testString = new String[]{
                "one", "two", "three", "four", "five", "six", "seven"
        };
        DynamicArray<String> test = new DynamicArray<>();

        for (String s : testString) {
            test.add(s);
        }

        test.remove(3);

        for (int i = 0; i < 100; i++) {
            System.out.println(test.get(i));
        }

    }

    public static class DynamicArray<T> {
        private T[] array;
        private int size;

        public DynamicArray() {
            this.array = (T[]) new Object[10];
        }

        private int getIndex(int index) {
            if (index >= size || index < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return index;
        }

        public T get(int index) {
            return array[getIndex(index)];
        }

        public void remove(int index) {
            getIndex(index);
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            size--;
        }

        public void add(T el) {
            if (size == array.length)  {
                T[] newArray = (T[]) new Object[(2 * array.length)];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[size] = el;
            size++;
        }
    }

}
