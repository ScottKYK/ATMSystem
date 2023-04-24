import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<UserAccount> Account = new ArrayList<>();
        System.out.println("=====歡迎使用網路ATM=====");
        while (true) {
            System.out.println("請選擇以下功能");
            System.out.println("1. 登入帳戶");
            System.out.println("2. 註冊帳戶");
            System.out.println("3. 註冊帳戶");
            int function = sc.nextInt();
            switch (function){
                case 1:
                    //登入
                    Login.Login(Account , sc);
                    break;
                case 2:
                    //註冊
                    signup.Signup(Account , sc);
                    break;
                case 3 :
                    //退出
                    return;
                default:
                    System.out.println("輸入錯誤");
            }
        }
    }
}