package itschool;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        TwoDimensionalArray_1();
//        TwoDimensionalArray_2();
//        TwoDimensionalArray_3();
//        TwoDimensionalArraysCompare();

//        ThreeDimensionalArray_1();
//        ThreeDimensionalArray_2();

//        FourDimensionalArray_1();
//        FourDimensionalArray_2();

//        JaggedArray_1();
//        JaggedArray_2();

//        ArrayFill();
//        RandomArray();
//        QuickSort();

//        LibraryExample();

//        StringCompare_1();
//        StringCompare_2();
        StringExample();

        // Homework_Example_1();
        // Homework_Example_2();
    }

    private static Scanner scanner = new Scanner(System.in);

    // Двумерные массивы. Пример 1
    private static void TwoDimensionalArray_1() {
        System.out.println("\nДвумерный массив. Пример 1");
        int[][] array = new int[3][3];

        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;

        array[1][0] = 4;
        array[1][1] = 5;
        array[1][2] = 6;

        array[2][0] = 7;
        array[2][1] = 8;
        array[2][2] = 9;

        System.out.println("Двумерный прямоугольный массив : ");

        System.out.print(array[0][0] + " ");
        System.out.print(array[0][1] + " ");
        System.out.print(array[0][2] + " ");
        System.out.print("\n");
        System.out.print(array[1][0] + " ");
        System.out.print(array[1][1] + " ");
        System.out.print(array[1][2] + " ");
        System.out.print("\n");
        System.out.print(array[2][0] + " ");
        System.out.print(array[2][1] + " ");
        System.out.print(array[2][2] + " ");
    }

    // Двумерные массивы. Пример 2
    private static void TwoDimensionalArray_2() {
        System.out.println("\nДвумерный массив. Пример 2");
        int[][] array = new int[3][3];

        // Заполнение массива
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = i * j + 1;
            }
        }

        System.out.println("Двумерный прямоугольный массив : ");

        // Выводим массив на экран
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Двумерные массивы. Пример 3
    private static void TwoDimensionalArray_3() {
        System.out.println("\nДвумерный массив. Пример 3");
        // Компилятор определяет размер массива на основании выражения инициализации.
        int[][] array = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 0, 1}
        };

        System.out.println("Двумерный прямоугольный массив : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Сравнение двумерных массивов
    private static void TwoDimensionalArraysCompare() {
        System.out.println("\nСравнение двумерных массивов");

        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] array2 = new int[3][3];
        // Заполнение массива
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = (new Random()).nextInt(10);
            }
        }

        System.out.println("\nArray1:");
        for (int [] a : array1)
            System.out.println(Arrays.toString(a));

        System.out.println("\nArray2:");
        for (int [] a : array2)
            System.out.println(Arrays.toString(a));

        if (Arrays.equals(array1, array2))
            System.out.println("Массивы равны!");
        else
            System.out.println("Массивы не равны!");


        System.out.println("Клонируем содержимое одного массива:");
        for (int row = 0; row < array1.length; row++)
            for (int column = 0; column < array1[row].length; column++)
                array1[row][column] = array2[row][column];

        System.out.println("\nArray1:");
        for (int [] a : array1)
            System.out.println(Arrays.toString(a));

        System.out.println("\nArray2:");
        for (int [] a : array2)
            System.out.println(Arrays.toString(a));

        System.out.println("\nПри обычном сравнении через equals двумерный массив - это экземпляр Object[], а не int[][]");
        if (Arrays.equals(array1, array2))
            System.out.println("Массивы равны!");
        else
            System.out.println("Массивы не равны!");

        System.out.println("\nПоэтому сравнивать нужно через deepEquals:");
        if (Arrays.deepEquals(array1, array2))
            System.out.println("Массивы равны!");
        else
            System.out.println("Массивы не равны!");
    }

    // Трёхмерные массивы. Пример 1
    private static void ThreeDimensionalArray_1() {
        System.out.println("\nТрехмерный массив. Пример 1");
        int[][][] array = new int[3][3][3];

        array[0][0][0] = 1;
        array[0][0][1] = 2;
        array[0][0][2] = 3;
        array[0][1][0] = 4;
        array[0][1][1] = 5;
        array[0][1][2] = 6;
        array[0][2][0] = 7;
        array[0][2][1] = 8;
        array[0][2][2] = 9;

        array[1][0][0] = 1;
        array[1][0][1] = 2;
        array[1][0][2] = 3;
        array[1][1][0] = 4;
        array[1][1][1] = 5;
        array[1][1][2] = 6;
        array[1][2][0] = 7;
        array[1][2][1] = 8;
        array[1][2][2] = 9;

        array[2][0][0] = 1;
        array[2][0][1] = 2;
        array[2][0][2] = 3;
        array[2][1][0] = 4;
        array[2][1][1] = 5;
        array[2][1][2] = 6;
        array[2][2][0] = 7;
        array[2][2][1] = 8;
        array[2][2][2] = 9;

        System.out.println("Трехмерный прямоугольный массив : ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Трёхмерные массивы. Пример 2
    private static void ThreeDimensionalArray_2() {
        System.out.println("\nТрехмерный массив. Пример 2");

        int[][][] array =
                {
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
                };


        System.out.println("Трехмерный прямоугольный массив : ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Четырёхмерные массивы. Пример 1
    private static void FourDimensionalArray_1() {
        System.out.println("\nЧетырехмерный массив. Пример 1");

        int[][][][] array = new int[2][2][2][2];

        array[0][0][0][0] = 0;
        array[0][0][0][1] = 1;
        array[0][0][1][0] = 2;
        array[0][0][1][1] = 3;

        array[0][1][0][0] = 4;
        array[0][1][0][1] = 5;
        array[0][1][1][0] = 6;
        array[0][1][1][1] = 7;

        array[1][0][0][0] = 8;
        array[1][0][0][1] = 9;
        array[1][0][1][0] = 10;
        array[1][0][1][1] = 11;

        array[1][1][0][0] = 12;
        array[1][1][0][1] = 13;
        array[1][1][1][0] = 14;
        array[1][1][1][1] = 15;

        System.out.println("Четырехмерный прямоугольный массив : ");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        System.out.print(array[i][j][k][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Четырёхмерные массивы. Пример 2
    private static void FourDimensionalArray_2() {
        System.out.println("\nЧетырехмерный массив. Пример 2");
        int[][][][] array =
                {
                        {
                                {{0, 1}, {2, 3}},
                                {{4, 5}, {6, 7}}
                        },
                        {
                                {{8, 9}, {10, 11}},
                                {{12, 13}, {14, 0xF}}
                        }
                };

        System.out.println("Четырехмерный прямоугольный массив : ");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        System.out.print(array[i][j][k][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    // Зубчатые массивы. Пример 1
    private static void JaggedArray_1() {
        System.out.println("\nЗубчатые массивы. Пример 1");

        int[][] jagged = new int[3][];

        jagged[0] = new int[]{1, 2};
        jagged[1] = new int[]{1, 2, 3, 4, 5};
        jagged[2] = new int[]{1, 2, 3};

        System.out.println("Зубчатый двумерный массив : ");

        // Во внешнем цикле выполняется проход по всем вложенным массивам.
        for (int i = 0; i < jagged.length; ++i) {
            // Во внутреннем цикле выполняется обращение к каждому элементу вложенного массива.
            for (int j = 0; j < jagged[i].length; ++j) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Зубчатые массивы. Пример 2
    private static void JaggedArray_2() {
        System.out.println("\nЗубчатые массивы. Пример 2");
        int[][] jagged =
                {
                        {1, 2},
                        {1, 2, 3, 4, 5},
                        {1, 2, 3}
                };

        System.out.println("Зубчатый двумерный массив : ");

        // Во внешнем цикле выполняется проход по всем вложенным массивам.
        for (int i = 0; i < jagged.length; ++i) {
            // Во внутреннем цикле выполняется обращение к каждому элементу вложенного массива.
            for (int j = 0; j < jagged[i].length; ++j) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }

    }

    // Наполнение массива одинаковыми данными
    private static void ArrayFill() {
        System.out.println("\nНаполнение массива одинаковыми данными");

        int[][] array = new int[3][3];

        // Функция fill принимает одномерный массив
        for (int i = 0; i < array.length; i++)
            Arrays.fill(array[i], 20);

        System.out.println("Двумерный квадратный массив : ");
        for (int[] subArray : array) {
            for (int element : subArray) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Сортировка QuickSort
    private static void QuickSort() {
        System.out.println("\nСортировка двухмерного массива методом QuickSort");
        int[][] num = {
                {5, 4, 45, 12},
                {7, 5, 8, 85}
        };

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(num[row][col] + "\t");
            }
            System.out.println();
        }

        int rows = num.length;
        int columns = num[0].length;

        // Сюда запишем наш двухмерный массив
        int[] flat = new int[rows * columns];

        // Переписываем двухмерный массив в одномерный
        int ctr = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                flat[ctr++] = num[row][col];
            }
        }

        // Сортируем одномерный массив
        Arrays.sort(flat);

        // Переписываем одномерный массив в двухмерный
        ctr = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                num[row][col] = flat[ctr++];
            }
        }

        System.out.println("Массив после сортировки : ");

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(num[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // Заполнение массива случайными значениями
    private static void RandomArray() {
        System.out.println("\nЗаполнение массива случайными значениями");

        Random random = new Random();
        int[][] array = new int[10][10];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = random.nextInt(100);

        System.out.println("Двумерный квадратный массив со случайными элементами : ");

        for (int[] subArray : array) {
            for (int element : subArray) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }

    }

    // Пример с книжной библиотекой
    private static void LibraryExample() {
        System.out.println("\nПример с библиотекой");
        String[][][] library = new String[2][2][2];

        int counter = 1;
        for (int i = 0; i < library.length; i++) {
            for (int j = 0; j < library[i].length; j++) {
                for (int k = 0; k < library[i][j].length; k++) {
                    String AutorName = "Автор " + counter;
                    String BookName = "Название " + counter * 2;

                    library[i][j][k] = BookName + " (" + AutorName + ")";
                    ++counter;
                }
            }
        }

        for (int bookCase = 0; bookCase < library.length; bookCase++) {
            for (int shelf = 0; shelf < library[bookCase].length; shelf++) {
                for (int book = 0; book < library[bookCase][shelf].length; book++) {
                    System.out.println("Шкаф " + (bookCase + 1) + "-ый " +
                            " Полка " + (shelf + 1) + "-ая " + "Ячейка " + (book + 1) + "-ая. Книга: " + library[bookCase][shelf][book]);
                }
            }
        }
    }

    // Сравнение строк. Пример 1
    private static void StringCompare_1() {
        System.out.println("\nСравнение строк. Пример 1.");
        String s1 = "str";
        String s2 = "str";

        // Сравниваем ссылки
        System.out.println("Объекты s1 и s2 в памяти одинаковые - " + (s1 == s2)); // true
        // Сравниваем строковое значение
        System.out.println("Символьный массив идентичен - " + s1.equals(s2)); // true
    }

    // Сравнение строк. Пример 2
    private static void StringCompare_2() {
        System.out.println("\nСравнение строк. Пример 2.");
        String s1 = "str";
        // Пользователь вводит str
        String s2 = scanner.next();

        // Сравниваем ссылки
        System.out.println("Объекты s1 и s2 в памяти одинаковые - " + (s1 == s2)); // false
        // Сравниваем строковое значение
        System.out.println("Символьный массив идентичен - " + s1.equals(s2)); // true or false
    }

    private static void StringExample() {
        String login = "user     ";
        String userLogin = " User ";

        if (login.trim().toLowerCase().equals(userLogin.trim().toLowerCase()))
            System.out.println("=");
        else
            System.out.println("!=");

        System.out.printf(String.valueOf(userLogin.lastIndexOf(" ")));

//        String concated = userLogin + login;
        String concated = userLogin.concat(login);
        System.out.println(concated);

        System.out.println((userLogin += login));
        System.out.println(login);
    }

    // Типовая задача из домашнего задания. Пример 1
    private static void Homework_Example_1() {
        //В двухмерном массиве целых чисел заменить все элементы,
        //меньшие среднего арифметического, значением среднего арифметического,
        //округленного до целого. Массив заполняется случайным образом.

        System.out.println("\nТиповая задача из ДЗ. Пример 1");

        int N = 5;
        int[][] array = new int[N][N];

        int average = 0;

        Random random = new Random();

        System.out.println("Исходный массив : ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100);
                // Выводим элемент массива
                System.out.print(array[i][j] + " ");
                // и тут же будем суммировать элементы массива
                average += array[i][j];
            }
            System.out.println();
        }

        // Находим среднее арифметическое
        average /= (N * N);

        System.out.println("\nCреднее арифметическое - " + average + "\n");

        System.out.println("Массив после перестановки : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < average)
                    array[i][j] = average;
                // Выводим элемент массива
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Типовая задача из домашнего задания. Пример 2
    private static void Homework_Example_2() {
        //Найти сумму всех четных элементов Двумерного массива целых чисел A[10, 10].
        System.out.println("\nТиповая задача из ДЗ. Пример 2");

        int N = 10;
        int[][] matrix = new int[N][N];
        int sum = 0;
        Random random = new Random();

        System.out.println("Квадратный двумерный массив : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Присваиваем значение элементу массива
                matrix[i][j] = random.nextInt(100);
                // Выводим элемент массива на экран
                System.out.print(matrix[i][j] + "\t");

                // Сумма четных элементов
                if (matrix[i][j] % 2 == 0)
                    sum += matrix[i][j];
            }
            System.out.println();
        }

        System.out.println("Сумма чётных элементов массива - " + sum);
    }
}
