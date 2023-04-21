class UserAccount {
    private String Username;
    private String Password;
    private int[] CardNumber;
    private int Balance;

    public UserAccount() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int[] getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int[] cardNumber) {
        CardNumber = cardNumber;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
