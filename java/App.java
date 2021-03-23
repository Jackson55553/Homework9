import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            String[][] array = {{"1", "2", "3", "4"}, {"2", "3", "6", "6"}, {"5", "4", "9", "1"}, {"6","3","1","8"}};
            String[][] array1 = new String[3][3];
            String[][] array2 = {{"1", "2", "3", "4"}, {"2", "3", "b", "6"}, {"5", "4", "9", "1"}, {"6","3","1","8"}};
            mtd(array);
            //Методы для проверки.
            //mtd(array1); // MyArraySizeException
            //mtd(array2);  //MyArrayDataException
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива ");
        } catch (MyArrayDataException e) {
            System.out.println("Неверное число");
        }
    }

    public static boolean isNumber(String a){
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void mtd(String[][] s) throws MyArraySizeException, MyArrayDataException {
        int i = s.length;
        if (i != 4){
            throw new MyArraySizeException();
        }
        int summ = 0;
        for (int j = 0; j < s.length; j++) {
            for (int k = 0; k < s[0].length; k++) {
                isNumber(s[j][k]);
                if (isNumber(s[j][k]) == true){
                    summ = summ + Integer.parseInt(s[j][k]);
                }
                else{
                    System.out.println("НА месте: " + "["+ j + "]"+ "[" + k + "]" + " находится символ: " + s[j][k]);
                    throw new MyArrayDataException();
                }
            }
        }
        System.out.println("Сумма = " + summ);
    }
}
