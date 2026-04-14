public interface Chargeable {
    int BASE_FEE = 1660;       // interface 상수 (public static final 자동 적용)
    double TAX_RATE = 0.07;

    int calcCharge(AbstractUser user);   // 사용 요금
    int calcTax(int charge);             // 세금
    int calcPayment(int charge, int tax); // 납부 요금
}