package threads;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int size = 10000000;
        float[] first = new float[size];
        float[] second = new float[size];
        Arrays.fill(first, 0);
        Arrays.fill(second, 0);

        long start = System.currentTimeMillis();
        calculateOneThread(first);
        System.out.printf("First method is finished for %d milliseconds %n", (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        calculateTwoThread(first);
        System.out.printf("Second method is finished for %d milliseconds %n", (System.currentTimeMillis() - start));


    }

    private static void calculate(float[] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + i + offset / 5) *
                    Math.cos(0.2f + i + offset / 5) *
                    Math.cos(0.4f + i + offset / 2));
        }
    }

    public static void calculateOneThread(float[] arr) {
        calculate(arr, 0);
    }

    public static void calculateTwoThread(float[] arr) {
        int half = arr.length / 2; //создание переменной, равной половине длинны массива
        float[] array1Part = new float[half]; //создание новых массивов равных половине изначального
        float[] array2Part = new float[half];

        Thread first = new Thread(() -> calculate(array1Part, 0));//задать вычисления первой части массива с 0 до середины
        Thread second = new Thread(() -> calculate(array2Part, half));//задать вычисления первой части массива с середины до конца
       //копирование массивов(источник, позиция начала нового массива, масиив-назначения, начальное положение, количество копируемых элементов)
        System.arraycopy(arr, 0, array1Part, 0, half);
        System.arraycopy(arr, half, array2Part, 0, half);

        //запуск потоков
        first.start();
        second.start();

        //склейка потоков + возможная ошибка
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //обратное копирование получившихся результатов в изначальный массив
        System.arraycopy(array1Part, 0, arr, 0, half);
        System.arraycopy(array2Part, 0, arr, half, half);
    }
}
