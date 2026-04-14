public abstract class AbstractUser {
    protected String userNo;
    protected String userName;
    protected int usage;

    public AbstractUser(String userNo, String userName, int usage) {
        this.userNo   = userNo;
        this.userName = userName;
        this.usage    = usage;
    }

    public String getUserNo()   { return userNo; }
    public String getUserName() { return userName; }
    public int    getUsage()    { return usage; }

    // 지원 가구 여부
    public boolean isSupport() { return false; }

    // 실효 사용량: 자식 클래스에서 반드시 구현
    public abstract int getEffectiveUsage();
}