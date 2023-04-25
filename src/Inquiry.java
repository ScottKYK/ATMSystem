import java.util.ArrayList;
import java.util.Scanner;

class Inquiry {
    //查詢餘額
    public void InquiryBalance(UserAccount acc) {
        System.out.println("您的餘額為" + acc.getBalance());
    }

    //存款
    public void InputMoney(UserAccount acc, Scanner sc) {
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
    public void OutputMoney(UserAccount acc, Scanner sc) {
        int outputMoney;
        int Balance = acc.getBalance();
        while (true) {// 判斷超過上限 , 進入循環
            System.out.println("輸入取出金額 (單次交易上限為" + acc.getMoneyLimit() + ")");
            outputMoney = sc.nextInt();
            if (acc.getBalance() == 0) {
                System.out.println("餘額為0");
            } else if (outputMoney > acc.getMoneyLimit()) {
                System.out.println("交易金額超過上限 , 請重新輸入");
            } else if (Balance < outputMoney) {
                System.out.println("餘額不足 , 請重新輸入");
            } else {
                break;
            }

        }
        acc.setBalance((Balance - outputMoney));
        System.out.println("交易完成 , 您的餘額為" + acc.getBalance());
    }

    //修改交易上限
    public void ModifyLimit(UserAccount acc, Scanner sc) {
        System.out.println("請問希望修改上限為?");
        acc.setMoneyLimit(sc.nextInt());
        System.out.println("修改成功 , 目前交易上限為" + acc.getMoneyLimit());
    }

    public void ModifyPassword(UserAccount acc, Scanner sc) {
        System.out.println("請輸入原本密碼");
        boolean judge = sc.next().equals(acc.getPassword());
        if(judge == false){
            System.out.println("密碼錯誤");
            return;
        }

            while (true) {
                System.out.println("請輸入新的密碼");
                String newPd = sc.next();
                System.out.println("請再次輸入新的密碼");
                String newPdCk = sc.next();
                if (newPd.equals(newPdCk)) {
                    System.out.println("密碼修改成功");
                    acc.setPassword(newPd);
                    break;
                }
                System.out.println("第二次密碼錯誤 ,請重新輸入");
            }
    }

    public void info(UserAccount acc) {
        System.out.println("==============您的信息如下================");
        System.out.println("帳戶名稱 :" + acc.getUsername());
        System.out.println("卡號 :" + acc.getCardNumber());
        System.out.println("餘額 :" + acc.getBalance());
        System.out.println("交易限制金額 :" + acc.getMoneyLimit());
    }

    public void transfer(ArrayList<UserAccount> Account , UserAccount acc, Scanner sc) {
        System.out.println("請輸入對方卡號");
        String otherCardNum = sc.next();
        UserAccount otheracc = Tools.checkCardNum(Account , otherCardNum);
        if(otheracc == null){
            System.out.println("無此卡號:" + otherCardNum);
            return;
        }

        if(otheracc.getCardNumber().equals(acc.getCardNumber())){
            System.out.println("不能給自己進行轉帳");
            return;
        }

        System.out.println("輸入轉帳金額");
        int transfermoney = sc.nextInt();
        if(transfermoney > acc.getBalance()){
            System.out.println("帳戶內餘額不足");
            return;
        } else if (transfermoney > acc.getMoneyLimit()) {
            System.out.println("轉帳金額超過單次交易上限");
            return;
        }

        System.out.println("請輸入密碼進行轉帳認證");
        String pdCheck = sc.next();
        if(acc.getPassword().equals(pdCheck)) {
            acc.setBalance((acc.getBalance() - transfermoney));//帳戶餘額設定
            otheracc.setBalance((otheracc.getBalance() - transfermoney));
            System.out.println("轉帳成功, 您轉" + transfermoney + "給" + otheracc.getUsername());
            System.out.println("您的餘額為" + acc.getBalance());
        }else {
            System.out.println("密碼錯誤");
        }
    }
}
