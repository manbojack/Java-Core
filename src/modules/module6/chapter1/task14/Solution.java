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

        for (int i = 0; i < testString.length; i++) {
            System.out.println(test.get(i));
        }

    }

    public static class DynamicArray<T> {

        private T[] array;

        public DynamicArray() {
        }

        public void add(T el) {
            if (array == null) {
                this.array = (T[]) new Object[]{el};
            } else {
                T[] added = (T[]) new Object[array.length + 1];
                System.arraycopy(array, 0, added, 0, array.length);
                added[array.length] = el;
                this.array = added;
            }
        }

        public void remove(int index) {
            try {
                if (array != null) {
                    T[] deleted = (T[]) new Object[array.length - 1];
                    System.arraycopy(array, 0, deleted, 0, index);
                    System.arraycopy(array, index + 1, deleted, index, deleted.length - index);
                    this.array = deleted;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }
        }

        public T get(int index) {
            try {
                return array[index];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

    }

}
