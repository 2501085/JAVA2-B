public class Employee {
    // ── 인사 정보 ──────────────────────────────
    private int    id;       // 사번 (5자리)
    private String name;     // 이름 (한글 4자리 기준)
    private int    part;     // 부서코드 (1~5)
    private boolean special; // 보훈 대상자 여부
    private int    grade;    // 급 (1~3)
    private int    cls;      // 호봉 (1~5)
    private int    aid;      // 개인 공제금(개인 저축)

    // ── 계산 결과 ──────────────────────────────
    private int basicPay;    // 기본급
    private int gradePay;    // 직급 수당
    private int partPay;     // 업무 수당
    private int deduction;   // 공제액 (기본공제 + 개인공제)
    private int tax;         // 세금
    private int netPay;      // 수령액(지급액)

    // ── 생성자 ─────────────────────────────────
    public Employee(int id, String name, int part,
                    boolean special, int grade, int cls, int aid) {
        this.id      = id;
        this.name    = name;
        this.part    = part;
        this.special = special;
        this.grade   = grade;
        this.cls     = cls;
        this.aid     = aid;
    }

    // ── Getter / Setter ────────────────────────
    public int     getId()      { return id; }
    public String  getName()    { return name; }
    public int     getPart()    { return part; }
    public boolean isSpecial()  { return special; }
    public int     getGrade()   { return grade; }
    public int     getCls()     { return cls; }
    public int     getAid()     { return aid; }

    public int  getBasicPay()   { return basicPay; }
    public int  getGradePay()   { return gradePay; }
    public int  getPartPay()    { return partPay; }
    public int  getDeduction()  { return deduction; }
    public int  getTax()        { return tax; }
    public int  getNetPay()     { return netPay; }

    public void setBasicPay(int v)   { basicPay  = v; }
    public void setGradePay(int v)   { gradePay  = v; }
    public void setPartPay(int v)    { partPay   = v; }
    public void setDeduction(int v)  { deduction = v; }
    public void setTax(int v)        { tax       = v; }
    public void setNetPay(int v)     { netPay    = v; }
}