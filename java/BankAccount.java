package Morris;

public class BankAccount {
    private String accountNumber; // 帳戶號碼
    private double balance;       // 帳戶餘額

    // 構造函數
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // 存款方法
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存款: " + amount + "，新餘額: " + balance);
        } else {
            System.out.println("存款金額必須大於零");
        }
    }

    // 提款方法
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("提款: " + amount + "，新餘額: " + balance);
        } else {
            System.out.println("提款金額無效或餘額不足");
        }
    }

    // 獲取餘額方法
    public double getBalance() {
        return balance;
    }

    // 獲取帳戶號碼方法
    public String getAccountNumber() {
        return accountNumber;
    }
}
