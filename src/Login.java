import java.util.ArrayList;
import java.util.Scanner;

class Login {
    public static void Login(ArrayList<UserAccount> Account, Scanner sc) {
        //資料庫空的情況下直接返回
        if (Account.size() == 0) {
            System.out.println("請先進行註冊");
            return;
        }

        System.out.println("輸入卡號");
        String CardNumber_in = sc.next();
        int temp = 0;
        //確認有此帳號
        UserAccount acc = Tools.checkCardNum(Account , CardNumber_in);
            if (acc == null) {
                System.out.println("無此帳號");
                return; //跳出登入介面
            }

        //確認密碼正確
        System.out.println("輸入密碼");
        while (true) {
            String passWord = sc.next();
            if (acc.getPassword().equals(passWord)) {
                System.out.println(Account.get(temp).getUsername() + "您好 , 歡迎進入ATM系統");
                break;
            } else {
                System.out.println("密碼錯誤 , 請重新輸入");
            }
        }


        //登入完之後,進入查詢頁面
        Inquiry inquiry = new Inquiry();
        while (true) {
            System.out.println("請選擇以下功能");
            System.out.println("1. 顯示您的信息");
            System.out.println("2. 查詢餘額");
            System.out.println("3. 存款");
            System.out.println("4. 取款");
            System.out.println("5. 修改交易上限");
            System.out.println("6. 修改密碼");
            System.out.println("7. 退出");
            int function = sc.nextInt();
            switch (function) {
                case 1:
                    //顯示信息
                    inquiry.info(Account, sc, temp);
                    break;
                case 2:
                    //查詢餘額
                    inquiry.InquiryBalance(Account, sc, temp);
                    break;
                case 3:
                    //存款
                    inquiry.InputMoney(acc, sc, temp);
                    break;
                case 4:
                    //取款
                    inquiry.OutputMoney(acc, sc, temp);
                    break;
                case 5:
                    //修改交易上限
                    inquiry.ModifyLimit(Account, sc, temp);
                    break;
                case 6:
                    //修改密碼
                    inquiry.ModifyPassword(Account, sc, temp);
                    break;
                case 7:
                    //退出
                    System.out.println("退出ATM");
                    return;
                default:
                    System.out.println("輸入錯誤");
            }
        }
    }
}
