package itschool;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
        /*
        TwoDimensionalArray_1();
        TwoDimensionalArray_2();
        TwoDimensionalArray_3();
        TwoDimensionalArraysCompare();

        ThreeDimensionalArray_1();
        ThreeDimensionalArray_2();

        FourDimensionalArray_1();
        FourDimensionalArray_2();

        JaggedArray_1();
        JaggedArray_2();
         */
//        ArrayFill();
//        RandomArray();
//        QuickSort();
//          ArrayClone();
//        LibraryExample();

//        StringCompare_1();
//        StringCompare_2();
		//StringExample();
		// LessonWork1();
//		LessonWork2();
//		LessonWork4();
//		LessonWork5();
//		LessonWork6();
		LessonWork7();
		// Homework_Example_1();
		// Homework_Example_2();
	}

	private static void LessonWork7()
	{
		final int ROWS = 6, COLUMNS = 5;
		int[][] array = new int[ROWS][COLUMNS];
		int sumEven = 0, counterPositive = 0, a = 2, b = 3, counterAB = 0;
		Random r = new Random();

		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				array[row][cols] = r.nextInt(10);
			}
		}

		printArray(array);

		int temp;
		for (int row = 0; row < ROWS; row += 2) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				temp = array[row][cols];
				array[row][cols] = array[row + 1][cols];
				array[row + 1][cols] = temp;
			}
		}
		printArray(array);

	}

	private static void printArray(int[][] array)
	{
		System.out.println();
		for (int[] row : array) {
			for (int value : row) {
				System.out.print(String.format("%5d", value));
			}
			System.out.println();
		}
	}

	private static void LessonWork6()
	{
		final int ROWS = 5, COLUMNS = 5;
		int[][] array = new int[ROWS][COLUMNS];
		int sumEven = 0, counterPositive = 0, a = 2, b = 3, counterAB = 0;
		Random r = new Random();

		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				array[row][cols] = r.nextInt(10);
				if (array[row][cols] % 2 == 0) {
					sumEven += array[row][cols];
				}

				if (array[row][cols] > 0) {
					counterPositive++;
				}
				if (array[row][cols] % a == 0 || array[row][cols] % b == 0) {
					counterAB++;
				}
				System.out.print(array[row][cols] + "  ");
			}
			System.out.println();
		}

		System.out.println("суммa нечетных элементов: " + sumEven);
		System.out.println("количество положительных элементов: " + counterPositive);
		System.out.println("количество элементов, кратных а или b: " + counterAB);
	}

	private static void LessonWork4()
	{
        /*Задан Двумерный массив вещественных чисел. Найти:
        а) максимальную сумму абсолютных значений
        элементов по строкам и номер строки с такой суммой;
        б) максимальную сумму абсолютных значений
        элементов по столбцам и номер столбца с такой суммой.*/
		final int ROWS = 4, COLUMNS = 5;
		double[][] array = new double[ROWS][COLUMNS];

		Random r = new Random();
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) { array[row][cols] = 50 - r.nextDouble() * 100; }
		}

		for (double[] a : array) { System.out.println(Arrays.toString(a)); }

		double[] sumsRows = new double[ROWS];

		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				sumsRows[row] += Math.abs(array[row][cols]);
			}
		}

		System.out.println(Arrays.toString(sumsRows));

		int indMax = 0;
		for (int i = 1; i < sumsRows.length; i++) {
			if (sumsRows[i] > sumsRows[indMax]) { indMax = i; }
		}
		System.out.println("Max in Rows= " + sumsRows[indMax] + ", at: " + indMax);


		System.out.println();
		double[] sumsCols = new double[COLUMNS];

		for (int cols = 0; cols < COLUMNS; cols++) {
			for (int row = 0; row < ROWS; row++) { sumsCols[cols] += Math.abs(array[row][cols]); }
		}


		System.out.println(Arrays.toString(sumsCols));

		int indMaxcols = 0;
		for (int i = 1; i < sumsCols.length; i++) {
			if (sumsCols[i] > sumsCols[indMaxcols]) { indMaxcols = i; }
		}
		System.out.println("Max in Cols= " + sumsCols[indMaxcols] + ", at: " + indMaxcols);
	}

	private static void LessonWork5()
	{
		final int ROWS = 5, COLUMNS = 5;
		int[][] array = new int[ROWS][COLUMNS];

		Random r = new Random();
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				array[row][cols] = r.nextInt(10);
				System.out.print(array[row][cols] + "  ");
			}
			System.out.println();
		}

		int rowMax = 0, rowMin = 0, colMax = 0, colMin = 0;
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				if (array[row][cols] > array[rowMax][colMax]) {
					rowMax = row;
					colMax = cols;
				}

				if (array[row][cols] < array[rowMin][colMin]) {
					rowMin = row;
					colMin = cols;
				}
			}
		}
		int maxCounter = 0, minCounter = 0;
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				if (array[row][cols] == array[rowMax][colMax]) { maxCounter++; }
				if (array[row][cols] == array[rowMin][colMin]) { minCounter++; }
			}
		}

		System.out.println("Max is " + array[rowMax][colMax] + " found " + maxCounter + " times");
		System.out.println("Min is " + array[rowMin][colMin] + " found " + minCounter + " times");

	}

	private static void LessonWork2()
	{
		final int ROWS = 5, COLUMNS = 5;
		double[][] array = new double[ROWS][COLUMNS];

		Random r = new Random();
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) { array[row][cols] = 50 - r.nextDouble() * 100; }
		}

		printArray(array);

		double sum = 0;
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) {
				if (row == cols) {
					sum += array[row][cols];
				}
			}
		}
		System.out.println(sum);

		sum = 0;
		for (int cols = 0; cols < COLUMNS; cols++) {
			sum += array[cols][cols];
		}
		System.out.println(sum);


	}

	private static void printArray(double[][] array)
	{
		System.out.println();
		for (double[] row : array) {
			for (double value : row) {
				System.out.print(String.format("%6.1f", value));
			}
			System.out.println('\n');
		}
	}

	private static void LessonWork1()
	{
		final int ROWS = 5, COLUMNS = 5;
		double[][] array = new double[ROWS][COLUMNS];

		Random r = new Random();
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) { array[row][cols] = 50 - r.nextDouble() * 100; }
		}

		printArray(array);

		int indMaxRow = 0;
		int indMaxCol = 0;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (array[row][col] > array[indMaxRow][indMaxCol]) {
					indMaxRow = row;
					indMaxCol = col;
				}
			}
		}

		System.out.println("[" + indMaxRow + "][" + indMaxCol + "] = " + array[indMaxRow][indMaxCol]);

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (col < row) {
					array[row][col] = 0;
				}
			}
		}
		printArray(array);

		for (int row = 0; row < array.length; row++) {
			for (int col = row + 1; col < array[row].length; col++) {
				double temp = array[row][col];
				array[row][col] = array[col][row];
				array[col][row] = temp;
			}
		}
		printArray(array);

	}

	private static void ArrayClone()
	{
		final int ROWS = 5, COLUMNS = 5;
		double[][] array = new double[ROWS][COLUMNS];

		Random r = new Random();
		for (int row = 0; row < ROWS; row++) {
			for (int cols = 0; cols < COLUMNS; cols++) { array[row][cols] = 50 - r.nextDouble() * 100; }
		}

		printArray(array);
		double[][] clone = array.clone();
		printArray(clone);

	}

	// Двумерные массивы. Пример 1
	private static void TwoDimensionalArray_1()
	{
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
	private static void TwoDimensionalArray_2()
	{
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
	private static void TwoDimensionalArray_3()
	{
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
	private static void TwoDimensionalArraysCompare()
	{
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
		for (int[] a : array1) { System.out.println(Arrays.toString(a)); }

		System.out.println("\nArray2:");
		for (int[] a : array2) { System.out.println(Arrays.toString(a)); }

		if (Arrays.equals(array1, array2)) { System.out.println("Массивы равны!"); }
		else { System.out.println("Массивы не равны!"); }


		System.out.println("Клонируем содержимое одного массива:");
		for (int row = 0; row < array1.length; row++) {
			for (int column = 0; column < array1[row].length; column++) { array1[row][column] = array2[row][column]; }
		}

		System.out.println("\nArray1:");
		for (int[] a : array1) { System.out.println(Arrays.toString(a)); }

		System.out.println("\nArray2:");
		for (int[] a : array2) { System.out.println(Arrays.toString(a)); }

		System.out.println("\nПри обычном сравнении через equals двумерный массив - это экземпляр Object[], а не int[][]");
		if (Arrays.equals(array1, array2)) { System.out.println("Массивы равны!"); }
		else { System.out.println("Массивы не равны!"); }

		System.out.println("\nПоэтому сравнивать нужно через deepEquals:");
		if (Arrays.deepEquals(array1, array2)) { System.out.println("Массивы равны!"); }
		else { System.out.println("Массивы не равны!"); }
	}

	// Трёхмерные массивы. Пример 1
	private static void ThreeDimensionalArray_1()
	{
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
	private static void ThreeDimensionalArray_2()
	{
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
	private static void FourDimensionalArray_1()
	{
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
	private static void FourDimensionalArray_2()
	{
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

		for (int cube = 0; cube < 2; cube++) {
			for (int layer = 0; layer < 2; layer++) {
				for (int row = 0; row < 2; row++) {
					for (int element = 0; element < 2; element++) {
						System.out.print(array[cube][layer][row][element] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}

	}

	// Зубчатые массивы. Пример 1
	private static void JaggedArray_1()
	{
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
	private static void JaggedArray_2()
	{
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
	private static void ArrayFill()
	{
		System.out.println("\nНаполнение массива одинаковыми данными");

		int[][] array = new int[4][3];

		// Функция fill принимает одномерный массив
		for (int i = 0; i < array.length; i++) { Arrays.fill(array[i], i + 1); }

		System.out.println("Двумерный квадратный массив : ");
		for (int[] subArray : array) {
			for (int element : subArray) {
				System.out.print(element + " ");
			}
			System.out.println();
		}

		int[] ar1 = {1, 2, 3};
		int[] ar2 = ar1.clone();
		ar1[0] = 333;
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));
		System.out.println(ar1);
		System.out.println(ar2);

		int[][] array2 = new int[array.length][];
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i].clone();
		}

		// array[0][0] = 555;
		System.out.println(array);
		System.out.println(array2);

		for (int[] subarray : array) {
			System.out.println(Arrays.toString(subarray));
		}
		System.out.println();
		for (int[] subarray2 : array2) {

			System.out.println(Arrays.toString(subarray2));
		}
//array2 = array;
		System.out.println(array.equals(array2));
		boolean isEqual = isEqual(array, array2);
		System.out.println(isEqual);
	}

	private static boolean isEqual(int[][] array, int[][] array2)
	{
		if (array.length == array2.length) {
			for (int i = 0; i < array.length; i++) {
				if (!Arrays.equals(array[i], array2[i])) {
					return false;
				}
			}
		}
		return true;
	}

	// Сортировка QuickSort
	private static void QuickSort()
	{
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
	private static void RandomArray()
	{
		System.out.println("\nЗаполнение массива случайными значениями");

		Random random = new Random();
		int[][] array = new int[10][10];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) { array[i][j] = random.nextInt(100); }
		}

		System.out.println("Двумерный квадратный массив со случайными элементами : ");

		for (int[] subArray : array) {
			for (int element : subArray) {
				System.out.print(element + "\t");
			}
			System.out.println();
		}

	}

	// Пример с книжной библиотекой
	private static void LibraryExample()
	{
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
	private static void StringCompare_1()
	{
		System.out.println("\nСравнение строк. Пример 1.");
		String s1 = "str";
		String s2 = "str";

		// Сравниваем ссылки
		System.out.println("Объекты s1 и s2 в памяти одинаковые - " + (s1 == s2)); // true
		// Сравниваем строковое значение
		System.out.println("Символьный массив идентичен - " + s1.equals(s2)); // true
	}

	// Сравнение строк. Пример 2
	private static void StringCompare_2()
	{
		System.out.println("\nСравнение строк. Пример 2.");
		String s1 = "str";
		// Пользователь вводит str
		String s2 = scanner.next();

		// Сравниваем ссылки
		System.out.println("Объекты s1 и s2 в памяти одинаковые - " + (s1 == s2)); // false
		// Сравниваем строковое значение
		System.out.println("Символьный массив идентичен - " + s1.equals(s2)); // true or false
	}

	private static void StringExample()
	{
		String login = "user ";
		String userLogin = " User "; // email@gmail.com  e.mail@gmail.com  EMA.IL @gmail.com

		if (login.trim().toLowerCase().equals(userLogin.trim().toLowerCase())) { System.out.println("="); }
		else { System.out.println("!="); }

		System.out.printf(String.valueOf(userLogin.lastIndexOf(" ")));

//        String concated = userLogin + login;
		String concated = userLogin.concat(login);
		System.out.println(concated);

		System.out.println((userLogin += login));
		System.out.println(login);

		String email = "it-school@gmail.com";
		System.out.println(isCorrectEmail(email));
		String fakeEmail = "it-school@gmail.co.uk";
		System.out.println(isCorrectEmail(fakeEmail));

		String text = "Егор Алла Александр";
		Pattern pattern = Pattern.compile("А.+а");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(text.substring(matcher.start(), matcher.end()));
		}

	}

	/**
	 * Проверяем корректность адреса электронной почты
	 *
	 * @param email - адрес, который проверяем
	 *
	 * @return true - если корректный, false - если некорректный
	 */
	public static boolean isCorrectEmail(String email)
	{
		if (!email.isEmpty()) {
			int posAt = email.indexOf("@");
			if (posAt > 0 && posAt < email.length() - 4) {
				if (email.lastIndexOf("@") == posAt) {
					System.out.println(email);
					System.out.println(email.lastIndexOf("."));
					System.out.println(email.length());
					return email.lastIndexOf(".") <= email.length() - 3;
				}
			}
		}
		return false;
	}

	// Типовая задача из домашнего задания. Пример 1
	private static void Homework_Example_1()
	{
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
				if (array[i][j] < average) { array[i][j] = average; }
				// Выводим элемент массива
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Типовая задача из домашнего задания. Пример 2
	private static void Homework_Example_2()
	{
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
				if (matrix[i][j] % 2 == 0) { sum += matrix[i][j]; }
			}
			System.out.println();
		}

		System.out.println("Сумма чётных элементов массива - " + sum);
	}
}
