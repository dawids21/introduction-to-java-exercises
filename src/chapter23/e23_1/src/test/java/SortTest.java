import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    private static class ComparableObject implements Comparable<ComparableObject> {

        private int value;

        public ComparableObject(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComparableObject that = (ComparableObject) o;
            return getValue() == that.getValue();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public String toString() {
            return "ComparableObject{" + "value=" + value + '}';
        }

        @Override
        public int compareTo(ComparableObject comparableObject) {
            return Integer.compare(getValue(), comparableObject.getValue());
        }
    }

    private static class NonComparableObject {

        private int value;

        public NonComparableObject(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NonComparableObject that = (NonComparableObject) o;
            return getValue() == that.getValue();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public String toString() {
            return "NonComparableObject{" + "value=" + value + '}';
        }
    }

    private static class ObjectComparator implements Comparator<NonComparableObject> {

        @Override
        public int compare(NonComparableObject o1, NonComparableObject o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }


    private ComparableObject[] list;
    private ComparableObject[] expectedList;
    private NonComparableObject[] listNon;
    private NonComparableObject[] expectedListNon;

    @BeforeEach
    void setUp() {
        list = new ComparableObject[]{new ComparableObject(45), new ComparableObject(11),
                                      new ComparableObject(2), new ComparableObject(50),
                                      new ComparableObject(4), new ComparableObject(59),
                                      new ComparableObject(7), new ComparableObject(60),
                                      new ComparableObject(10),};
        expectedList =
                 new ComparableObject[]{new ComparableObject(2), new ComparableObject(4),
                                        new ComparableObject(7), new ComparableObject(10),
                                        new ComparableObject(11),
                                        new ComparableObject(45),
                                        new ComparableObject(50),
                                        new ComparableObject(59),
                                        new ComparableObject(60),};
        listNon = new NonComparableObject[]{new NonComparableObject(45),
                                            new NonComparableObject(11),
                                            new NonComparableObject(2),
                                            new NonComparableObject(50),
                                            new NonComparableObject(4),
                                            new NonComparableObject(59),
                                            new NonComparableObject(7),
                                            new NonComparableObject(60),
                                            new NonComparableObject(10),};
        expectedListNon = new NonComparableObject[]{new NonComparableObject(2),
                                                    new NonComparableObject(4),
                                                    new NonComparableObject(7),
                                                    new NonComparableObject(10),
                                                    new NonComparableObject(11),
                                                    new NonComparableObject(45),
                                                    new NonComparableObject(50),
                                                    new NonComparableObject(59),
                                                    new NonComparableObject(60),};
    }

    @Nested
    class BubbleSort {

        @Test
        @DisplayName("returns sorted array of comparable objects")
        void returns_sorted_array_of_comparable_objects() {

            Sort.bubbleSort(list);

            assertArrayEquals(expectedList, list);
        }

        @Test
        @DisplayName("returns sorted array using given comparator")
        void returns_sorted_array_using_given_comparator() {
            Sort.bubbleSort(listNon, new ObjectComparator());

            assertArrayEquals(expectedListNon, listNon);
        }
    }

}