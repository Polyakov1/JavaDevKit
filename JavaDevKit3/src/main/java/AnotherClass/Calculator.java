package AnotherClass;



// Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
// sum(), multiply(), divide(), subtract().
// Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
// Методы должны возвращать результат своей работы.
public class Calculator {


        public static <T extends Number, U extends Number> double sum(T a, U b) {
            return a.doubleValue() + b.doubleValue();
        }

        public static <T extends Number, U extends Number> double multiply(T a, U b) {
            return a.doubleValue() * b.doubleValue();
        }

        public static <T extends Number, U extends Number> double divide(T a, U b) {
            if (b.doubleValue() == 0) {
                throw new ArithmeticException("Деление на ноль");
            }
            return a.doubleValue() / b.doubleValue();
        }

        public static <T extends Number, U extends Number> double subtract(T a, U b) {
            return a.doubleValue() - b.doubleValue();
        }
    }

