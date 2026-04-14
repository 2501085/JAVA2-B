public class ElectricUser extends AbstractUser {

    public ElectricUser(String userNo, String userName, int usage) {
        super(userNo, userName, usage);
    }

    // 일반 가구: 실효 사용량 = 실제 사용량
    @Override
    public int getEffectiveUsage() {
        return usage;
    }
}