package Morris;

public class AccountHolder {
    private String name;       // 持有人姓名
    private String idNumber;   // 身份證號碼

    // 構造函數
    public AccountHolder(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    // 獲取姓名方法
    public String getName() {
        return name;
    }

    // 獲取身份證號碼方法
    public String getIdNumber() {
        return idNumber;
    }
}
