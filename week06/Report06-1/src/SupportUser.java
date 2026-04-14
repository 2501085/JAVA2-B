public class SupportUser extends ElectricUser {

    public SupportUser(String userNo, String userName, int usage) {
        super(userNo, userName, usage);
    }

    @Override
    public boolean isSupport() { return true; }

    // 지원 가구: 100Kw까지 무료 공제
    @Override
    public int getEffectiveUsage() {
        return (usage > 100) ? usage - 100 : 0;
    }
}