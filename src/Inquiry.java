import java.util.ArrayList;
import java.util.Scanner;

class Inquiry {
    //查詢餘額
    public void InquiryBalance(ArrayList<UserAccount> Account, Scanner sc, int Num) {
        System.out.println("您的餘額為" + Account.get(Num).getBalance());
    }

    //存款
    public void InputMoney(UserAccount acc, Scanner sc, int Num) {
        int inputMoney = 0;
        boolean judge = true;

        while (judge) {// 判斷超過上限進入循環
            System.out.println("輸入存款金額 (單次交易上限為" + acc.getMoneyLimit() + ")");
            inputMoney = sc.nextInt();
            if (inputMoney > acc.getMoneyLimit()) {
                System.out.println("存款金額超過上限,請重新輸入");
            } else {
                judge = false;
            }
        }
        int Balance = acc.getBalance();
        acc.setBalance((Balance + inputMoney));
        System.out.println("存款成功 , 您的餘額為" + acc.getBalance());
    }

    //取款
    public void OutputMoney(UserAccount acc, Scanner sc, int Num) {
        int outputMoney;
        int judge = 0;
        int Balance = acc.getBalance();
        while (true) {// 判斷超過上限 , 進入循環
            System.out.println("輸入取出金額 (單次交易上限為" + acc.getMoneyLimit() + ")");
            outputMoney = sc.nextInt();
            if(acc.getBalance() == 0){
                System.out.println("餘額為0");
            } else if (outputMoney > acc.getMoneyLimit()) {
                System.out.println("交易金額超過上限 , 請重新輸入");
            } else if (Balance < outputMoney) {
                System.out.println("餘額不足 , 請重新輸入");
            }else {
                break;
            }

        }
            acc.setBalance((Balance - outputMoney));
            System.out.println("交易完成 , 您的餘額為" + acc.getBalance());
    }

    //修改交易上限
    public void ModifyLimit(UserAccount acc, Scanner sc, int Num){
        System.out.println("請問希望修改上限為?");
        acc.setMoneyLimit(sc.nextInt());
        System.out.println("修改成功 , 目前交易上限為" + acc.getMoneyLimit());
    }

    public void ModifyPassword(UserAccount acc, Scanner sc, int Num) {
        System.out.println("請輸入原本密碼");
        boolean judge = sc.next().equals(acc.getPassword());
        System.out.println("密碼錯誤");
            if(judge){
                while (true) {
                    System.out.println("請輸入新的密碼");
                    String newPd = sc.next();
                    System.out.println("請再次輸入新的密碼");
                    String newPdCk = sc.next();
                    if(newPd.equals(newPdCk)){
                        System.out.println("密碼修改成功");
                        acc.setPassword(newPd);
                        break;
                    }
                    System.out.println("密碼錯誤 ,請重新輸入");
                }

            }



    }

    public void info(UserAccount acc, Scanner sc, int Num) {
        System.out.println("==============您的信息如下================");
        System.out.println("帳戶名稱 :" + acc.getUsername());
        System.out.println("卡號 :" + acc.getCardNumber());
        System.out.println("餘額 :" + acc.getBalance());
        System.out.println("交易限制金額 :" + acc.getMoneyLimit());
    }
}
