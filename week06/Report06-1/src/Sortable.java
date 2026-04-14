public interface Sortable {
    // 납부 요금 내림차순 버블 정렬
    void sortByPayment(AbstractUser[] users, int[] payments);
}