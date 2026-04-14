public class ElectricUser {
    protected String userNo;
    protected String userName;
    protected int usage;

    public ElectricUser(String userNo, String userName, int usage) {
        this.userNo = userNo;
        this.userName = userName;
        this.usage = usage;
    }

    public String getUserNo()   { return userNo; }
    public String getUserName() { return userName; }
    public int    getUsage()    { return usage; }

    // 지원 가구 여부 (자식 클래스에서 override)
    public boolean isSupport() { return false; }

    // 요금 계산에 사용할 실효 사용량 (자식에서 override)
    public int getEffectiveUsage() { return usage; }
}