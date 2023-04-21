import java.util.ArrayList;
import java.util.Scanner;

class Login {
    public static void Login(ArrayList<UserAccount> Account , Scanner sc){
        //資料庫空的情況下直接返回
        if(Account.size() == 0){
            return;
        }
        System.out.println("輸入卡號");
        int[] cardNumber = new int[8];
        //把輸入的卡號轉成array 去比對資料庫中的是否吻合(未寫)


        //確認帳號OK
        for (int i = 0; i < Account.size(); i++) {
            if(Tools.ArrayCheck2(Account , cardNumber)){
            }else {
                System.out.println("無此帳號");
                return;
            }
        }
        //確認密碼OK
        System.out.println("輸入密碼");
        String passWord = sc.next();
        for (int i = 0; i < Account.size(); i++) {
            if(Account.get(i).getPassword().equals(passWord)){
            }else {
                System.out.println("密碼錯誤");
            }
        }


    }
}
