import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class signup {
    public static void Signup (ArrayList<UserAccount> Account , Scanner sc){
        UserAccount userAccount = new UserAccount();
        //帳號
        System.out.println("輸入帳號");
        String Username = sc.next();
        userAccount.setUsername(Username);
        //密碼
        while (true) {
            System.out.println("輸入密碼");
            String Password = sc.next();
            userAccount.setPassword(Password);
            System.out.println("請再次輸入密碼,確認兩次數入相同");
            String PasswordCheck = sc.next();
            if(Password.equals(PasswordCheck)) {
                userAccount.setPassword(Password);
                break;
            }
            System.out.println("輸入密碼錯誤 , 請重新輸入");
        }

        //生成隨機卡號(12位數)
        Random r = new Random();
        int [] CardNumber = new int[8];
        while (true) {
            //生成卡號
            for (int i = 0 ; i < CardNumber.length ; i++) {
                int Num = r.nextInt(10);
                CardNumber[i] = Num;
            }
            //判斷是否有重複
            if(Tools.ArrayCheck((Account) , CardNumber)){
                userAccount.setCardNumber(CardNumber);
                break;
            }
        }
        Account.add(userAccount);
        System.out.println("帳號註冊完成 , 卡號為" );
        Tools.printArray(CardNumber);

    }
}
