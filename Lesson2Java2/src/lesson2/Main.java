package lesson2;

import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String first = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String second = "10 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String third = "10 3 1 F\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            double result = amAndDiv(toMatrix(first));
            System.out.println("Результат 1" + result);

            result = amAndDiv(toMatrix(second));
            System.out.println("Результат 2" + result);

            result = amAndDiv(toMatrix(third));
            System.out.println("Результат 3" + result);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace(); //указывает, где произошла ошибка в исходном коде посредством печати строки
            System.out.println(e.getLocalizedMessage()); //getLocalizedMessage - возвращает сообщение для локального описания объекта класса Throwable
        }

    }

    public static String[][] toMatrix(String str) {
        String[] mat1 = str.split("\n"); //str.split - разбивает строку по определенным параметрам
        if (mat1.length != 4) {
            throw new IndexOutOfBoundsException(
                    String.format("Количество элементов не соответствуют: строка '%s', разделитель \\n", str));
        }
        String[][] array = new String[4][];
        for (int i = 0; i < 4; i++) {
            array[i] = mat1[i].split(" ");
            if (array[i].length != 4) {
                throw new IndexOutOfBoundsException(
                        String.format("Количество элементов не соответствуют: строка '%s' разделитель \" \"", mat1[i]));
                //string.format - форматирование строки, %s - строковое значение
            }
        }
        System.out.println(Arrays.deepToString(array));
        return array;
    }

    public static double amAndDiv(String[][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array[i].length; k++) {
                try {
                    result += Integer.parseInt(array[i][k]); //Integer.parseInt - возвращает целое число, т.е. преобразует элементы массива в int
                } catch (NumberFormatException e) {
                    System.out.println("amAndDiv :" + e.getMessage()); //get.Message - возвращает сообщение этого экземпляра класса Throwable
                    throw e;
                }
            }
        }
        return result / 2d;
    }
}
