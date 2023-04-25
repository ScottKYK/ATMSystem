import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Tools {

    //生成隨機卡號(8位數)
    public static String RandomCardNum (ArrayList<UserAccount> Account , Scanner sc){
        String cardNumber = "";
        Random r = new Random();
        while (true) {
            //生成卡號
            for (int i = 0 ; i < 8 ; i++) {
                int Num = r.nextInt(10);
                cardNumber += Num ;
            }
            //判斷是否有重複
            UserAccount acc = checkCardNum(Account , cardNumber);
            if(acc == null){
                return cardNumber;
            }
        }
    }
    //確認帳戶是否存在
    public static UserAccount checkCardNum(ArrayList<UserAccount> Account, String cardNumber) {
        for (int i = 0; i < Account.size(); i++) {
            UserAccount acc = Account.get(i);
            if (acc.getCardNumber().equals(cardNumber)) {
                return acc;
            }
        }
        return null;
    }

    //列印Array
    public static void printArray(int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i]);
        }
        System.out.println("");
    }
}
