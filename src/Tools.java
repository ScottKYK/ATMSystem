import java.util.ArrayList;

class Tools {
    //確認卡號是否有重複
    public static boolean ArrayCheck(ArrayList<UserAccount> Account, int[] CardNumber) {
        if (Account.size() == 0) {
            return true;
        }
        for (int i = 0; i < Account.size(); i++) {
            for (int j = 0 ; j < Account.get(i).getCardNumber().length; j++) {
                if (Account.get(i).getCardNumber()[j] == CardNumber[j]){
                    return false;
                }
            }
        }
        return true;
    }

    //判斷登入時是否一致
    public static boolean ArrayCheck2(ArrayList<UserAccount> Account, int[] CardNumber) {

        for (int i = 0; i < Account.size(); i++) {
            for (int j = 0 ; j < Account.get(i).getCardNumber().length; j++) {
                if (Account.get(i).getCardNumber()[j] == CardNumber[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void printArray(int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i]);
        }
        System.out.println("");
    }


}
