package AnotherClass;
import java.util.Arrays;


//Напишите обобщенный метод compareArrays(),
// который принимает два массива и возвращает true, если они одинаковые, и false
// в противном случае. Массивы могут быть любого типа данных,
// но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.
public class CompareArrays {

    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        return Arrays.equals(arr1, arr2);
    }
}