package beatdz;

import com.listener.IKeyboard;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kl extends LangLa_ge implements IKeyboard {

    private int I;

    private int J;

    public int a;

    private LangLa_ij[][] K;

    public LangLa_ii[][] L;

    private LangLa_ii[] M;

    private LangLa_ii[] N;

    public LangLa_gx b;

    private LangLa_gx O;

    private LangLa_lf[] P;

    public mTextBox[] c;

    public boolean d;

    public int e;

    public int f;

    public int g;

    public int h;

    public int i;

    public int u;

    public int v;

    public int[] w;

    public int[] x;

    private LangLa_dz Q;

    private LangLa_dz R;

    private LangLa_dz S;

    private LangLa_dz T;

    private LangLa_dz U;

    private LangLa_dz discipleBtn;

    // Tab "Khác" (UI đệ tử)
    private LangLa_dz discipleFollowBtn;
    private LangLa_dz discipleAttackBtn;
    private LangLa_dz discipleHomeBtn;
    private LangLa_dz discipleFusionBtn;

    // Danh sách chức năng trợ thủ (hiển thị kiểu "danh hiệu" 1 dòng / 1 lựa chọn)
    private LangLa_ii discipleActionList;
    private String[] discipleActionNames;
    // Lưu lựa chọn hiện tại dạng static để khi mở lại UI vẫn giữ được dấu tích
    public static int discipleSelectedAction = -1;

    // Cooldown thao tác cho 4 nút trợ thủ (Đi theo / Tấn công / Về nhà / Hợp thể)
    // Mỗi lần bấm 1 trong 4 nút này sẽ phải chờ 10 giây mới bấm tiếp được.
    // Để tránh né cooldown bằng cách đóng/mở tab, dùng biến static.
    private static long discipleActionCooldownEndTime;

    private LangLa_dz[] V;

    private LangLa_lk[] W;

    public Char y;

    public Skill[] z;

    private LangLa_dz X;

    private LangLa_dz Y;

    private LangLa_dz Z;

    private LangLa_dz aa;

    private LangLa_dz ab;

    private LangLa_cg ac;

    public LangLa_cg A;

    public LangLa_ce B;

    private static LangLa_kl ad;

    public Item C;

    private LangLa_ij ae;

    private boolean af;

    protected String[] profileTabs;

    // Nội dung "Thông tin" (từ msg -73 / sendDiscipleInfo)
    public String[] discipleInfoLines;

    public String[] D;

    public int E;

    public int F;

    Vector G;

    public SkillClan H;

    public int exp;

    public int expMax;

    public int frameStart;

    public int frameEnd;

    public int tickSpeed;

    public int dxPet;

    public int dyPet;

    public int[] skillIcon = new int[4];

    private int tick;

    public void e() {
        int var2 = a_() + 35;
        if (this.profileTabs == null) {
            this.profileTabs = getProfileTabs();
        }
        this.K = new LangLa_ij[this.profileTabs.length][];
        this.K[0] = new LangLa_ij[8];
        this.K[0][0] = new LangLa_ij((byte) 1, this.b.c() + 8 + 10, var2, this.I, this.I * 5, this.I, 5, 1);
        this.K[0][1] = new LangLa_ij((byte) 1, this.b.c() + 8 + 160 + 76, var2, this.I, this.I * 5, this.I, 5, 1);
        this.K[0][2] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I + 10 + 32, var2 + this.I * 4, this.I * 4, this.I, this.I, 1, 4);
        this.K[0][3] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I + 10, var2 + this.I * 3 + 32, this.I, this.I, this.I, 1, 1);
        this.K[0][4] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I * 4 + 76, var2 + this.I * 3 + 32, this.I, this.I, this.I, 1, 1);
        this.K[0][5] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I * 4 + 76, var2 + this.I * 2 + 32, this.I, this.I, this.I, 1, 1);
        this.K[0][6] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I + 10, var2 + this.I + 32, this.I, this.I, this.I, 1, 1);
        this.K[0][7] = new LangLa_ij((byte) 1, this.b.c() + 8 + 160 + 76 - this.I, var2 + this.I * 2, this.I, this.I, this.I, 1, 1);
        this.K[1] = new LangLa_ij[8];
        this.K[1][0] = new LangLa_ij((byte) 1, this.b.c() + 8 + 10, var2, this.I, this.I * 5, this.I, 5, 1);
        this.K[1][1] = new LangLa_ij((byte) 1, this.b.c() + 8 + 160 + 76, var2, this.I, this.I * 5, this.I, 5, 1);
        this.K[1][2] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I + 10 + 32, var2 + this.I * 4, this.I * 4, this.I, this.I, 1, 4);
        this.K[1][3] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I + 10, var2 + this.I * 3 + 32, this.I, this.I, this.I, 1, 1);
        this.K[1][4] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I * 4 + 76, var2 + this.I * 3 + 32, this.I, this.I, this.I, 1, 1);
        this.K[1][5] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I * 4 + 76, var2 + this.I * 2 + 32, this.I, this.I, this.I, 1, 1);
        this.K[1][6] = new LangLa_ij((byte) 1, this.b.c() + 8 + this.I + 10, var2 + this.I + 32, this.I, this.I, this.I, 1, 1);
        this.K[1][7] = new LangLa_ij((byte) 1, this.b.c() + 8 + 160 + 76 - this.I, var2 + this.I * 2, this.I, this.I, this.I, 1, 1);
        this.L = new LangLa_ii[this.profileTabs.length][];
        this.L[0] = new LangLa_ii[1];
        int var1 = this.b.c() + 40;
        this.L[0][0] = new LangLa_ii((byte) 1, var1, var2, 128, 78, 13, Caption.rT.length);
        this.L[1] = new LangLa_ii[1];
        // Tab 1: player dùng cho trang bị dự phòng; UI đệ tử dùng làm "Thông tin"
        if (isDiscipleUI()) {
            int infoY = a_() + 24;
            int infoHeight = this.height - infoY - 20; // cao gần hết khung, chừa khoảng padding dưới
            if (infoHeight < 130) {
                infoHeight = 130;    // tối thiểu
            }
            this.L[1][0] = new LangLa_ii((byte) 1, this.b.c() + 15, infoY, this.width - 8 - 30, infoHeight, 15, this.x.length);
        } else {
            this.L[1][0] = new LangLa_ii((byte) 1, this.b.c() + 40, a_() + 11, 128, 91, 13, Caption.rT.length);
        }
        this.L[2] = new LangLa_ii[4];
        var1 = this.b.c() + 5;
        var2 = a_() + 34;
        this.L[2][0] = new LangLa_ii((byte) 1, var1 + 30, var2 + 108, 40, 12, 24, 4);
        this.L[2][1] = new LangLa_ii((byte) 1, var1 + 20, var2 + 30, this.width - 8 - 36, 120, 15, Caption.rd.length);
        this.L[2][2] = new LangLa_ii((byte) 1, var1 + 20, var2 + 30, this.width - 8 - 36, 120, 15, this.x.length);
        this.L[2][3] = new LangLa_ii((byte) 1, var1, var2, this.width - 8 - 96, 120, 15, Caption.rf.length);
        this.L[3] = new LangLa_ii[1];
        this.J = 26;
        var1 = this.b.c() + 8;
        int var10000 = this.b.cy + 7 + 6;
        DataCenter.gI();
        var2 = var10000 + 0;
        this.L[3][0] = new LangLa_ii((byte) 1, var1 + 10, var2 + 20, 260, this.J * 5 + 1, this.J, this.z.length);
        this.L[4] = new LangLa_ii[3];
        var1 = this.b.c() + 5;
        var2 = a_() + 34;
        this.L[4][0] = new LangLa_ii((byte) 1, var1 + 30, var2 + 30, this.width - 8 - 96, 119, 17, this.y.aG.length * 2);
        this.L[4][1] = new LangLa_ii((byte) 1, var1, var2, this.width - 8 - 96, 75, 15, 6);
        this.L[4][2] = new LangLa_ii((byte) 1, var1, var2, this.width - 8 - 96, 75, 15, 6);
        this.K[4] = new LangLa_ij[4];
        var1 = this.b.c() + 8;
        var2 = a_() + 11 + this.I * 4;
        this.K[4][0] = new LangLa_ij((byte) 1, var1 + 40, var2 + 20, this.I * 6, this.I, this.I, 1, 6);
        this.K[4][1] = new LangLa_ij((byte) 1, var1, var2 - this.I, this.I, this.I, this.I, 1, 1);
        this.K[4][2] = new LangLa_ij((byte) 1, var1 + 5, (int) (var2 - 2.5D * this.I), this.I, this.I * 4, this.I, 1, 4);
        this.K[4][3] = new LangLa_ij((byte) 1, var1 + 250, (int) (var2 - 2.5D * this.I), this.I, this.I * 4, this.I, 1, 4);
        g();
    }

    public void g() {
        this.G = new Vector();
        for (int var2 = 0; var2 < this.y.aH.size(); var2++) {
            SkillClan var1;
            if ((var1 = (SkillClan) this.y.aH.elementAt(var2)).id == 19) {
                this.H = var1;
            } else {
                this.G.add(var1);
            }
        }
    }

    public LangLa_kl(MainScreen var1, Char var2, Skill[] var3) {
        this(var1, var2, var3, new String[]{Caption.W});
    }

    public LangLa_kl(MainScreen var1, Char var2, Skill[] var3, String[] tabs) {
        super(var1, tabs);
        this.I = 32;
        this.J = 15;
        this.w = new int[18];
        this.x = new int[18];
        this.F = -1;
        try {
            ad = this;
            this.p = var1;
            this.y = var2;
            this.z = var3;
            this.r = false;
            a(299, 242);
            LangLa_kd var6 = new LangLa_kd(1001);
            DataCenter.gI();
            this.profileTabs = getProfileTabs();
            var6.c = this.profileTabs;
            int var10000 = a_() - 3;
            DataCenter.gI();
            int var9 = var10000 - 0;
            this.b = new LangLa_gx(var6, this.width, 1, var9, 87, G() + 6, 33, this);
            e();
            var10000 = this.width - 8 - 162;
            DataCenter.gI();
            int var7 = var10000 + 0;
            var10000 = a_() + G() - 134;
            DataCenter.gI();
            var9 = var10000 + 0;
            this.V = new LangLa_dz[4];
            for (int var4 = 0; var4 < this.V.length; ++var4) {
                this.V[var4] = new LangLa_dz(var7 + 45, var9 + 20 * var4 - 30000, 0, 0, Caption.tI[var4], this, 1100 + var4, -27);
                this.V[var4].setSize(30, 18);
                this.b.a(this.V[var4], 1);
            }
            Vector var10 = new Vector();
            var10000 = super.width - 8 - 45;
            DataCenter.gI();
            var7 = var10000 + 0;
            var10000 = this.height - 33;
            DataCenter.gI();
            var9 = var10000 + 0;
            LangLa_dz var8;
            (var8 = a(var7, var9, Caption.cP, this, 2010, 7)).setSize(40, 20);
            this.Q = var8;
            var10.addElement(this.Q);
            (var8 = a(this.Q.cx - 43, this.Q.cy, Caption.cQ, this, 2009, 7)).setSize(40, 20);
            var10.addElement(var8);
            this.R = var8;
            var10.addElement(this.R);
            var10000 = this.b.c() + 62;
            DataCenter.gI();
            var7 = var10000 + 0;
            var10000 = a_() + G() - 41;
            DataCenter.gI();
            var9 = var10000 + 0;
            this.B = a(var7 + 100, var9, Caption.cR, 1234);
            var10.addElement(this.B);
            this.P = new LangLa_lf[2];
            var10000 = this.b.c() + 5;
            DataCenter.gI();
            var7 = var10000 + 0;
            var10000 = a_() + 7;
            DataCenter.gI();
            var9 = var10000 + 0;
            this.P[0] = new LangLa_lf(new LangLa_kd(2000, Caption.sh), var7 + 2, var9 + 17, 286, 23, 94, this, false);
            this.P[1] = new LangLa_lf(new LangLa_kd(2011, Caption.sD), var7 + 2, var9 + 17, 286, 23, 94, this, false);
            this.c = new mTextBox[4];
            DataCenter.gI();
            DataCenter.gI();
            int offsetX = 30;
            int offsetY = 18;
            this.c[0] = a(this.b.c() + 62 + offsetX, a_() + 38 + offsetY, 72, "", this, 2);
            var10.addElement(this.c[0]);
            var8 = this.Z = a(this.b.c() + 145 - 5 + offsetX, a_() + 38 + 3 + offsetY, "", this, 2001, 58);
            var10.addElement(var8);
            var8 = this.aa = a(this.b.c() + 145 + 15 + offsetX, a_() + 38 + 3 + offsetY, "", this, 2002, 57);
            var10.addElement(var8);
            var8 = this.ab = a(this.b.c() + 145 + 35 + offsetX, a_() + 38 + 3 + offsetY, "", this, 2012, 244);
            var10.addElement(var8);
            this.c[1] = a(this.b.c() + 62 + offsetX, a_() + 38 + 25 + offsetY, 72, "", this, 2);
            var10.addElement(this.c[1]);
            var8 = a(this.b.c() + 145 - 5 + offsetX, a_() + 38 + 25 + 3 + offsetY, "", this, 2003, 58);
            var10.addElement(var8);
            var8 = a(this.b.c() + 145 + 15 + offsetX, a_() + 38 + 25 + 3 + offsetY, "", this, 2004, 57);
            var10.addElement(var8);
            var8 = a(this.b.c() + 145 + 35 + offsetX, a_() + 38 + 25 + 3 + offsetY, "", this, 2014, 244);
            var10.addElement(var8);
            this.c[2] = a(this.b.c() + 62 + offsetX, a_() + 38 + 50 + offsetY, 72, "", this, 2);
            var10.addElement(this.c[2]);
            var8 = a(this.b.c() + 145 - 5 + offsetX, a_() + 38 + 50 + 3 + offsetY, "", this, 2005, 58);
            var10.addElement(var8);
            var8 = a(this.b.c() + 145 + 15 + offsetX, a_() + 38 + 50 + 3 + offsetY, "", this, 2006, 57);
            var10.addElement(var8);
            var8 = a(this.b.c() + 145 + 35 + offsetX, a_() + 38 + 50 + 3 + offsetY, "", this, 2016, 244);
            var10.addElement(var8);
            this.c[3] = a(this.b.c() + 62 + offsetX, a_() + 38 + 75 + offsetY, 72, "", this, 2);
            var10.addElement(this.c[3]);
            var8 = a(this.b.c() + 145 - 5 + offsetX, a_() + 38 + 75 + 3 + offsetY, "", this, 2007, 58);
            var10.addElement(var8);
            var8 = a(this.b.c() + 145 + 15 + offsetX, a_() + 38 + 75 + 3 + offsetY, "", this, 2008, 57);
            var10.addElement(var8);
            var8 = a(this.b.c() + 145 + 35 + offsetX, a_() + 38 + 75 + 3 + offsetY, "", this, 2018, 244);
            var10.addElement(var8);
            this.b.a(var10, 2);
            this.P[0].a(var10, 0);
            var10 = new Vector<>();
            var10000 = this.width - 8 - 45;
            DataCenter.gI();
            var7 = var10000 + 0;
            var10000 = this.height - 33;
            DataCenter.gI();
            var9 = var10000 + 0;
            this.Y = a(var7, var9, Caption.cP, this, 3001, 7);
            this.Y.setSize(40, 20);
            var10.addElement(this.Y);
            this.X = a(this.Y.cx - 43, var9, Caption.bk, this, 3000, 7);
            this.X.setSize(40, 20);
            var10.addElement(this.X);
            this.b.a(var10, 3);
            LangLa_kd var11;
            (var11 = new LangLa_kd(1235)).c = Caption.tJ;
            var10000 = this.b.c() + 71;
            DataCenter.gI();
            var7 = var10000 + 0;
            var10000 = a_() + G() - 61;
            DataCenter.gI();
            var9 = var10000 + 0;
            this.A = a(var7 + 50, var9 - 10, 64, 4, var11, this, 1);
            this.A.a(var2.selectCaiTrang);
            this.b.a(this.A, 0);
            if (isDiscipleUI()) {
                // Tab "Khác" của đệ tử: danh sách 4 chức năng trợ thủ (chỉ hiển thị tên)
                this.discipleActionNames = new String[]{"Trợ thủ đi theo bạn", "Trợ thủ tự động tấn công", "Gọi trợ thủ trở về nhà", "Hợp thể hoặc tách hợp thể với trợ thủ"};
                int listX = this.b.c() + 30;
                int listY = a_() + 50;
                int rowHeight = 30;
                int numRows = this.discipleActionNames.length; // 4 dòng, mỗi dòng 1 lựa chọn
                int listHeight = rowHeight * numRows;
                this.discipleActionList = new LangLa_ii((byte) 1, listX, listY, this.width - 8 - 96, listHeight, rowHeight, numRows);
            } else {
                (var8 = a(this.width - 8 - 55, this.height - 68, Caption.bj, this, 4001, 7)).setSize(50, 20);
                this.S = var8;
                this.b.a(this.S, 4);
                (var8 = a(this.width - 8 - 110, this.height - 68, Caption.qi, this, 4002, 7)).setSize(50, 20);
                this.T = var8;
                this.b.a(this.T, 4);
                (var8 = a(this.width - 8 - 165, this.height - 68, Caption.lQ, this, 4003, 7)).setSize(50, 20);
                this.U = var8;
                this.b.a(this.U, 4);
            }
            this.b.a(!v());
            this.P[0].a(!v());
            this.b.a(0);
            b(0);
            if (var2.isMe()) {
                a((GameSrc.gI()).aw);
            } else {
                a(0);
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
        if (v()) {
            this.i = (GameSrc.gI()).diemTiemNang;
            this.v = (GameSrc.gI()).diemKyNang;
        }
    }

    public static LangLa_kl l() {
        return ad;
    }

    private boolean t() {
        return (this.y.idClass == 0 || this.y.idClass == 1 || this.y.idClass == 5);
    }

    public int m() {
        return k();
    }

    public int n() {
        return this.b.b.b;
    }

    private void a(LangLa_ii var1, int var2) {
        this.af = false;
        for (int var3 = 0; var3 < this.K.length; var3++) {
            if (this.K[var3] != null) {
                for (int var4 = 0; var4 < (this.K[var3]).length; var4++) {
                    if (this.K[var3][var4] != null) {
                        (this.K[var3][var4]).k = -1;
                    }
                }
            }
        }
        var1.k = var2;
    }

    public void d() {
        super.d();
        (GameSrc.gI()).aw = k();
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        boolean var13 = false;
        try {
            LangLa_kl var4;
            Message var22;
            var13 = true;
            if (!this.d) {
                LangLa_kl langLa_kl = this;
                try {
                    Message var5;
                    (var5 = new Message((byte) 63)).writeUTF(langLa_kl.y.name);
                    var5.send();
                } catch (Exception var16) {
                    Utlis.println(var16);
                }
            }
            super.a(var1, var2, var3);
            // UI đệ tử: tab "Thông tin" (index 1) là màn hình chỉ xem -> chặn click "trang bị dự phòng"
            if (k() == 0 && isDiscipleUI() && this.b != null && this.b.b.b == 1) {
                if (var1.b >= 1020 && var1.b <= 1027) {
                    var13 = false;
                    return;
                }
            }
            switch (var1.b) {
                case 200:
                    var4 = this;
                    try {
                        Message var5;
                        (var5 = new Message((byte) -24)).writeByte(var4.ac.b.b);
                        var5.send();
                        var13 = false;
                    } catch (Exception var15) {
                        Utlis.println(var15);
                        var13 = false;
                    }
                    break;
                case 1001:
                    if (var1.j.k >= 0) {
                        this.b.a(var1.j.k);
                        switch (this.b.b.b) {
                            case 0:
                                e(this.b.b.b);
                                var13 = false;
                                break;
                            case 1:
                                if (!isDiscipleUI()) {
                                    e(this.b.b.b);
                                } else {
                                    // Đóng popup thông tin kiểu cũ (nếu đang mở)
                                    this.cL = null;
                                    // UI đệ tử: vào tab "Thông tin" thì xin dữ liệu theo msg -73 (sendDiscipleInfo)
                                    try {
                                        Message rq = Message.c((byte) -73);
                                        rq.writeUTF(this.y.name);
                                        rq.send();
                                    } catch (Exception ex) {
                                        Utlis.println(ex);
                                    }
                                }
                                var13 = false;
                                break;
                            case 2:
                                DataCenter.gI();
                                this.P[0].a((this.P[0]).b.b);
                                var13 = false;
                                break;
                            default:
                                var13 = false;
                                break;
                            case 4:
                                break;
                        }
                        DataCenter.gI();
                        this.P[1].a((this.P[1]).b.b);
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 1002:
                    if (var1.j.k >= 0) {
                        this.O.a(var1.j.k);
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 1030:
                    if (var1.j.k < 0) {
                        var13 = false;
                        break;
                    }
                    this.a = var1.j.k;
                    if (var1.j.k < this.z.length) {
                        if (var2 - var1.j.cx >= 56) {
                            var13 = false;
                            break;
                        }
                        String var24 = b(var1.j.k);
                        w();
                        boolean var25 = this.X.u;
                        boolean var28 = this.Y.u;
                        if (this.y.idClass == 0 || !v()) {
                            var28 = true;
                            var25 = true;
                        }
                        String var10001 = var24;
                        int var10003 = var1.j.cx + 27;
                        int var10004 = var1.j.cy + var1.j.k * var1.j.h - var1.j.f + 1;
                        // Cho phép UI đệ tử (manageDisciple + LangLa_kl_dt) hiển thị nút chọn/bỏ chọn skill
                        // giống như khi xem chính mình (isMe).
                        boolean var7 = this.y.isMe() || (GameSrc.gI().manageDisciple && this instanceof LangLa_kl_dt);
                        boolean var6 = var28;
                        boolean var20 = true;
                        var2 = var10004;
                        int var21 = var10003;
                        String var30 = var10001;
                        LangLa_ie var27;
                        if ((var27 = new LangLa_ie(var21, var2, 220, this, var30, var25, var6, var7)).cx > (DataCenter.gI()).widthScreen - var27.width - this.cx) {
                            var27.cx = (short) ((DataCenter.gI()).widthScreen - var27.width - this.cx);
                        }
                        if (var27.cx < var21) {
                            var27.cx = (short) (var21 - var27.width + 3);
                        }
                        if (var27.cx < -this.cx) {
                            var27.cx = (short) -this.cx;
                        }
                        if (var27.cy > (DataCenter.gI()).heightScreen - var27.height - this.cy) {
                            var27.cy = (short) ((DataCenter.gI()).heightScreen - var27.height - this.cy);
                        }
                        a(var27);
                        this.cL = var27;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 1040:
                case 1041:
                case 1042:
                    a(var1.j, var1.j.k);
                    this.cL = a(var1, this, (Item) null);
                    var13 = false;
                    break;
                case 1100:
                    g(0);
                    var13 = false;
                    break;
                case 1101:
                    g(1);
                    var13 = false;
                    break;
                case 1102:
                    g(2);
                    var13 = false;
                    break;
                case 1103:
                    g(3);
                    var13 = false;
                    break;
                case 1200:
                    DataCenter.gI();
                    if ((this.P[0]).b.b == 0) {
                        if (var1.j.k >= 0) {
                            String var19;
                            LangLa_jz var29 = var1;
                            if (t()) {
                                var19 = Caption.rM[0];
                            } else {
                                var19 = Caption.rM[1];
                            }
                            w();
                            this.cL = a(var19, this, var29.j.cx + 40, var29.j.cy, 205);
                            var13 = false;
                            break;
                        }
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 1201:
                    if (var1.j.k >= 0) {
                        if (var1.j.k % 2 == 0) {
                            Message message;
                            (message = Message.c((byte) -74)).writeByte(var1.j.k / 2 - 1);
                            message.send();
                            var13 = false;
                            break;
                        }
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2000:
                    if (var1.j.k >= 0) {
                        this.P[0].a(var1.j.k);
                        A();
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2001:
                    if (this.c[0].e() - 1 >= (this.c[0]).n) {
                        Utlis.println("TN DEBUG 2001 (-1) BEFORE: str=" + this.c[0].e() + ", i=" + this.i);
                        this.c[0].a(this.c[0].e() - 1);
                        this.i++;
                        Utlis.println("TN DEBUG 2001 (-1)  AFTER: str=" + this.c[0].e() + ", i=" + this.i);
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2002:
                    if (this.i > 0) {
                        Utlis.println("TN DEBUG 2002 (+1) BEFORE: str=" + this.c[0].e() + ", i=" + this.i);
                        this.c[0].a(this.c[0].e() + 1);
                        this.i--;
                        Utlis.println("TN DEBUG 2002 (+1)  AFTER: str=" + this.c[0].e() + ", i=" + this.i);
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2003:
                    if (this.c[1].e() - 1 >= (this.c[1]).n) {
                        this.c[1].a(this.c[1].e() - 1);
                        this.i++;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2004:
                    if (this.i > 0) {
                        this.c[1].a(this.c[1].e() + 1);
                        this.i--;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2005:
                    if (this.c[2].e() - 1 >= (this.c[2]).n) {
                        this.c[2].a(this.c[2].e() - 1);
                        this.i++;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2006:
                    if (this.i > 0) {
                        this.c[2].a(this.c[2].e() + 1);
                        this.i--;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2007:
                    if (this.c[3].e() - 1 >= (this.c[3]).n) {
                        this.c[3].a(this.c[3].e() - 1);
                        this.i++;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2008:
                    if (this.i > 0) {
                        this.c[3].a(this.c[3].e() + 1);
                        this.i--;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2009:
                    Utlis.println("TN DEBUG 2009 (RESET) BEFORE: "
                            + "str=" + this.c[0].e()
                            + ", chak=" + this.c[1].e()
                            + ", agi=" + this.c[2].e()
                            + ", vit=" + this.c[3].e()
                            + ", base=[" + this.e + "," + this.f + "," + this.h + "," + this.g + "], i=" + this.i);
                    this.i += this.c[0].e() + this.c[1].e() + this.c[2].e() + this.c[3].e() - this.e + this.f + this.h + this.g;
                    this.c[0].a("" + this.e);
                    this.c[1].a("" + this.f);
                    this.c[2].a("" + this.h);
                    this.c[3].a("" + this.g);
                    Utlis.println("TN DEBUG 2009 (RESET)  AFTER: "
                            + "str=" + this.c[0].e()
                            + ", chak=" + this.c[1].e()
                            + ", agi=" + this.c[2].e()
                            + ", vit=" + this.c[3].e()
                            + ", i=" + this.i);
                    var13 = false;
                    break;
                case 2010:
                    var4 = this;
                    try {
                        Utlis.println("TN DEBUG 2010 (XAC NHAN) Gửi MSG 62: str=" + var4.c[0].e() + ", chak=" + var4.c[1].e() + ", agi=" + var4.c[2].e() + ", vit=" + var4.c[3].e());
                        Message var5;
                        (var5 = new Message((byte) 62)).writeShort(var4.c[0].e());
                        var5.writeShort(var4.c[1].e());
                        var5.writeShort(var4.c[2].e());
                        var5.writeShort(var4.c[3].e());
                        var5.send();
                        Utlis.println("TN DEBUG 2010 (XAC NHAN) Đã gửi MSG 62");
                        var13 = false;
                    } catch (Exception var14) {
                        Utlis.println(var14);
                        var13 = false;
                    }
                    break;
                case 2011:
                    if (var1.j.k >= 0) {
                        this.P[1].a(var1.j.k);
                        B();
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2012:
                    if (this.i > 10) {
                        Utlis.println("TN DEBUG 2012 (+10) BEFORE: str=" + this.c[0].e() + ", i=" + this.i);
                        this.c[0].a(this.c[0].e() + 10);
                        this.i -= 10;
                        Utlis.println("TN DEBUG 2012 (+10)  AFTER: str=" + this.c[0].e() + ", i=" + this.i);
                        var13 = false;
                        break;
                    }
                    if (this.i > 0) {
                        Utlis.println("TN DEBUG 2012 (+ALL) BEFORE: str=" + this.c[0].e() + ", i=" + this.i);
                        this.c[0].a(this.c[0].e() + this.i);
                        this.i = 0;
                        Utlis.println("TN DEBUG 2012 (+ALL)  AFTER: str=" + this.c[0].e() + ", i=" + this.i);
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2014:
                    if (this.i > 10) {
                        this.c[1].a(this.c[1].e() + 10);
                        this.i -= 10;
                        var13 = false;
                        break;
                    }
                    if (this.i > 0) {
                        this.c[1].a(this.c[1].e() + this.i);
                        this.i = 0;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2016:
                    if (this.i > 10) {
                        this.c[2].a(this.c[2].e() + 10);
                        this.i -= 10;
                        var13 = false;
                        break;
                    }
                    if (this.i > 0) {
                        this.c[2].a(this.c[2].e() + this.i);
                        this.i = 0;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2018:
                    if (this.i > 10) {
                        this.c[3].a(this.c[3].e() + 10);
                        this.i -= 10;
                        var13 = false;
                        break;
                    }
                    if (this.i > 0) {
                        this.c[3].a(this.c[3].e() + this.i);
                        this.i = 0;
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 2050:
                    var22 = Message.c((byte) -18);
                    var3 = u();
                    var22.writeByte(var3);
                    var22.send();
                    var13 = false;
                    break;
                case 3000:
                    r();
                    var13 = false;
                    break;
                case 3001:
                    q();
                    var13 = false;
                    break;
                case 4001:
                    if (this.F >= 0) {
                        var2 = u();
                        SkillClan var23 = (SkillClan) this.y.aH.elementAt(var2);
                        this.p.a(new LangLa_aq(this.p, var2, var23));
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 4002:
                    if (this.F >= 0) {
                        var2 = u();
                        if (((SkillClan) this.y.aH.elementAt(var2)).id == 19) {
                            Message var26;
                            (var26 = Message.c((byte) -26)).writeByte(var2);
                            var26.writeBoolean(true);
                            var26.send();
                            var13 = false;
                            break;
                        }
                        this.p.a(new LangLa_f(this.p, var2));
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 4003:
                    if (this.F >= 0) {
                        (DataCenter.gI()).currentScreen.a(Caption.qF, 2050, this);
                        var13 = false;
                        break;
                    }
                    var13 = false;
                    break;
                case 4004:
                    // Mở hành trang đệ tử - CHỈ mở khi có currentDisciple (đã được set đúng trong discipleSpawn)
                    Char disciple = GameSrc.gI().currentDisciple;
                    // Debug
                    Utlis.println("DEBUG case 4004: currentDisciple=" + disciple + ", Char.gI().name=" + (Char.gI() != null ? Char.gI().name : "null"));
                    if (disciple != null) {
                        Utlis.println("DEBUG: Opening disciple UI for " + disciple.name);
                        // Mở UI đệ tử (currentDisciple đã được kiểm tra khi set trong discipleSpawn)
                        GameSrc.gI().manageDisciple = true;
                        LangLa_kl_dt.open(this.p, disciple);
                    } else {
                        // Debug: thử tìm trong vChar
                        Utlis.println("DEBUG: currentDisciple is null, checking vChar...");
                        for (int i = 0; i < GameSrc.gI().vChar.size(); i++) {
                            Char c = (Char) GameSrc.gI().vChar.elementAt(i);
                            if (c != null && c.name != null) {
                                Utlis.println("DEBUG vChar[" + i + "]: name=" + c.name + ", isMe=" + c.isMe());
                            }
                        }
                        // Không có đệ tử hoặc chưa được triệu hồi
                        DataCenter.gI().currentScreen.showMessage("Bạn chưa có trợ thủ.", -1);
                    }
                    var13 = false;
                    break;
                case 4100:
                    // 4 chức năng trợ thủ: Đi theo / Tấn công / Về nhà / Hợp thể
                    // Hiển thị dạng danh sách giống "Danh hiệu", một id chung (4100) và phân biệt theo index var1.j.k.
                    // Thêm cooldown 10 giây cho cả nhóm để tránh spam (không thể né bằng cách đóng/mở tab).
                    long now = System.currentTimeMillis();
                    if (now < discipleActionCooldownEndTime) {
                        long remain = (discipleActionCooldownEndTime - now) / 100L + 1;
                        if (remain < 1) {
                            remain = 1;
                        }
                        DataCenter.gI().currentScreen.showMessage("Vui lòng chờ " + remain + " giây nữa mới có thể thao tác trợ thủ.", -1);
                        var13 = false;
                        break;
                    }
                    discipleActionCooldownEndTime = now + 1000L;
                    int actionIndex = 0;
                    if (var1.j != null) {
                        actionIndex = var1.j.k; // mỗi dòng là một chức năng
                        if (actionIndex < 0) {
                            actionIndex = 0;
                        }
                        if (actionIndex > 3) {
                            actionIndex = 3;
                        }
                    }
                    discipleSelectedAction = actionIndex;
                    switch (actionIndex) {
                        case 0:
                            // Trợ thủ: Đi theo
                            discipleCommand((byte) 0);
                            break;
                        case 1:
                            // Trợ thủ: Tấn công
                            discipleCommand((byte) 1);
                            break;
                        case 2:
                            // Trợ thủ: Về nhà
                            discipleCommand((byte) 2);
                            break;
                        case 3:
                            // Trợ thủ: Hợp thể / Tách hợp thể (toggle)
                            discipleCommand((byte) 3);
                            break;
                    }
                    var13 = false;
                    break;
                default:
                    if (k() == 0) {
                        if (var1.b == 1010) {
                            a(var1.j, var1.j.k);
                            switch (var1.j.k) {
                                case 0:
                                    this.cL = a(var1, this, this.y.arrItemBody[0]);
                                    // Luôn hiển thị menu khi click vào trang bị đã mặc
                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                        ((LangLa_mk) this.cL).a();
                                    }
                                    var13 = false;
                                    break;
                                case 1:
                                    this.cL = a(var1, this, this.y.arrItemBody[2]);
                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                        ((LangLa_mk) this.cL).a();
                                    }
                                    var13 = false;
                                    break;
                                case 2:
                                    this.cL = a(var1, this, this.y.arrItemBody[4]);
                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                        ((LangLa_mk) this.cL).a();
                                    }
                                    var13 = false;
                                    break;
                                case 3:
                                    this.cL = a(var1, this, this.y.arrItemBody[6]);
                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                        ((LangLa_mk) this.cL).a();
                                    }
                                    var13 = false;
                                    break;
                                case 4:
                                    this.cL = a(var1, this, this.y.arrItemBody[8]);
                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                        ((LangLa_mk) this.cL).a();
                                    }
                                    var13 = false;
                                    break;
                                default:
                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                        ((LangLa_mk) this.cL).a();
                                    }
                                    var13 = false;
                                    break;
                            }
                        } else {
                            if (var1.b == 1011) {
                                a(var1.j, var1.j.k);
                                switch (var1.j.k) {
                                    case 0:
                                        this.cL = a(var1, this, this.y.arrItemBody[1]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    case 1:
                                        this.cL = a(var1, this, this.y.arrItemBody[3]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    case 2:
                                        this.cL = a(var1, this, this.y.arrItemBody[5]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    case 3:
                                        this.cL = a(var1, this, this.y.arrItemBody[7]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    case 4:
                                        this.cL = a(var1, this, this.y.arrItemBody[9]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    default:
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                }
                            } else {
                                if (var1.b == 1012) {
                                    a(var1.j, var1.j.k);
                                    switch (var1.j.k) {
                                        case 0:
                                            this.cL = a(var1, this, this.y.arrItemBody[10]);
                                            if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                ((LangLa_mk) this.cL).a();
                                            }
                                            var13 = false;
                                            break;
                                        case 1:
                                            this.cL = a(var1, this, this.y.arrItemBody[11]);
                                            if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                ((LangLa_mk) this.cL).a();
                                            }
                                            var13 = false;
                                            break;
                                        case 2:
                                            this.cL = a(var1, this, this.y.arrItemBody[12]);
                                            if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                ((LangLa_mk) this.cL).a();
                                            }
                                            var13 = false;
                                            break;
                                        case 3:
                                            this.cL = a(var1, this, this.y.arrItemBody[13]);
                                            if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                ((LangLa_mk) this.cL).a();
                                            }
                                            var13 = false;
                                            break;
                                        default:
                                            if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                ((LangLa_mk) this.cL).a();
                                            }
                                            var13 = false;
                                            break;
                                    }
                                } else {
                                    if (var1.b == 1013) {
                                        a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[14]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    }
                                    if (var1.b == 1014) {
                                        a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[15]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    }
                                    if (var1.b == 1015) {
                                        a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[16]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    }
                                    if (var1.b == 1016) {
                                        a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[17]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    }
                                    if (var1.b == 1017) {
                                        a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[18]);
                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                            ((LangLa_mk) this.cL).a();
                                        }
                                        var13 = false;
                                        break;
                                    }
                                    if (var1.b == 1020) {
                                        a(var1.j, var1.j.k);
                                        switch (var1.j.k) {
                                            case 0:
                                                this.cL = a(var1, this, this.y.arrItemBody2[0]);
                                                if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                    ((LangLa_mk) this.cL).a();
                                                }
                                                var13 = false;
                                                break;
                                            case 1:
                                                this.cL = a(var1, this, this.y.arrItemBody2[2]);
                                                if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                    ((LangLa_mk) this.cL).a();
                                                }
                                                var13 = false;
                                                break;
                                            case 2:
                                                this.cL = a(var1, this, this.y.arrItemBody2[4]);
                                                if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                    ((LangLa_mk) this.cL).a();
                                                }
                                                var13 = false;
                                                break;
                                            case 3:
                                                this.cL = a(var1, this, this.y.arrItemBody2[6]);
                                                if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                    ((LangLa_mk) this.cL).a();
                                                }
                                                var13 = false;
                                                break;
                                            case 4:
                                                this.cL = a(var1, this, this.y.arrItemBody2[8]);
                                                if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                    ((LangLa_mk) this.cL).a();
                                                }
                                                var13 = false;
                                                break;
                                            default:
                                                if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                    ((LangLa_mk) this.cL).a();
                                                }
                                                var13 = false;
                                                break;
                                        }
                                    } else {
                                        if (var1.b == 1021) {
                                            a(var1.j, var1.j.k);
                                            switch (var1.j.k) {
                                                case 0:
                                                    this.cL = a(var1, this, this.y.arrItemBody2[1]);
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                                case 1:
                                                    this.cL = a(var1, this, this.y.arrItemBody2[3]);
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                                case 2:
                                                    this.cL = a(var1, this, this.y.arrItemBody2[5]);
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                                case 3:
                                                    this.cL = a(var1, this, this.y.arrItemBody2[7]);
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                                case 4:
                                                    this.cL = a(var1, this, this.y.arrItemBody2[9]);
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                                default:
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                            }
                                        } else {
                                            if (var1.b == 1022) {
                                                a(var1.j, var1.j.k);
                                                switch (var1.j.k) {
                                                    case 0:
                                                        this.cL = a(var1, this, this.y.arrItemBody2[10]);
                                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                            ((LangLa_mk) this.cL).a();
                                                        }
                                                        var13 = false;
                                                        break;
                                                    case 1:
                                                        this.cL = a(var1, this, this.y.arrItemBody2[11]);
                                                        var13 = false;
                                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                            ((LangLa_mk) this.cL).a();
                                                        }
                                                        break;
                                                    case 2:
                                                        this.cL = a(var1, this, this.y.arrItemBody2[12]);
                                                        var13 = false;
                                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                            ((LangLa_mk) this.cL).a();
                                                        }
                                                        break;
                                                    case 3:
                                                        this.cL = a(var1, this, this.y.arrItemBody2[13]);
                                                        var13 = false;
                                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                            ((LangLa_mk) this.cL).a();
                                                        }
                                                        break;
                                                    default:
                                                        var13 = false;
                                                        if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                            ((LangLa_mk) this.cL).a();
                                                        }
                                                        break;
                                                }
                                            } else {
                                                if (var1.b == 1023) {
                                                    a(var1.j, var1.j.k);
                                                    this.cL = a(var1, this, this.y.arrItemBody2[14]);
                                                    if (this.cL != null && this.cL instanceof LangLa_mk) {
                                                        ((LangLa_mk) this.cL).a();
                                                    }
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1024) {
                                                    a(var1.j, var1.j.k);
                                                    this.cL = a(var1, this, this.y.arrItemBody2[15]);
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1025) {
                                                    a(var1.j, var1.j.k);
                                                    this.cL = a(var1, this, this.y.arrItemBody2[16]);
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1026) {
                                                    a(var1.j, var1.j.k);
                                                    this.cL = a(var1, this, this.y.arrItemBody2[17]);
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1027) {
                                                    a(var1.j, var1.j.k);
                                                    this.cL = a(var1, this, this.y.arrItemBody2[18]);
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1028) {
                                                    Message var5;
                                                    (var5 = Message.c((byte) -73)).writeUTF(this.y.name);
                                                    var5.send();
                                                    LangLa_dp.a().h();
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1090) {
                                                    // Xử lý sách kỹ năng chiến đấu cho cả player và đệ tử
                                                    a(var1.j, var1.j.k);
                                                    this.af = true;
                                                    this.cL = a(var1, this, this.C);
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1401) {
                                                    this.E = 0;
                                                    this.D = null;
                                                    if (var1.j.k >= 0 && var1.j.k < this.y.aH.size()) {
                                                        this.F = var1.j.k;
                                                        o();
                                                        var13 = false;
                                                        break;
                                                    }
                                                    this.F = -1;
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1403) {
                                                    this.E = 1;
                                                    if (var1.j.k >= 0) {
                                                        this.F = var1.j.k;
                                                        o();
                                                        var13 = false;
                                                        break;
                                                    }
                                                    this.F = -1;
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1501) {
                                                    a(var1.j, var1.j.k);
                                                    if (var1.j.k < this.y.arrItemPet.length) {
                                                        this.cL = a(var1, this, this.y.arrItemPet[var1.j.k]);
                                                    }
                                                    var13 = false;
                                                    break;
                                                }
                                                if (var1.b == 1503) {
                                                    a(var1.j, var1.j.k);
                                                    var13 = false;
                                                    break;
                                                }
                                                var13 = false;
                                                break;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        var13 = false;
                        break;
                    }
                    return;
            }
        } catch (Exception var17) {
            Utlis.println(var17);
            var13 = false;
        } finally {
            // Luôn hiển thị menu nếu có menu được tạo
            if (this.cL != null && this.cL instanceof LangLa_mk) {
                ((LangLa_mk) this.cL).a();
            }
        }
        // Menu đã được hiển thị trong finally block, không cần kiểm tra lại
    }

    private int u() {
        boolean var2 = false;
        for (int var3 = 0; var3 < this.y.aH.size(); var3++) {
            SkillClan var1 = (SkillClan) this.y.aH.get(var3);
            if (this.E == 0) {
                if (var1.id == 19) {
                    var2 = true;
                }
                if (this.F == var3) {
                    if (var2) {
                        return var3 + 1;
                    }
                    return var3;
                }
            } else {
                for (int var4 = 0; var4 < this.y.aH.size(); var4++) {
                    if (((SkillClan) this.y.aH.get(var4)).id == 19) {
                        return var4;
                    }
                }
            }
        }
        return this.F;
    }

    public void o() {
        this.D = mFont.c(mFont.d, j(this.F), this.width - 20);
    }

    public void q() {
        h((this.z[this.a]).idTemplate);
    }

    public void r() {
        i((this.z[this.a]).idTemplate);
    }

    protected boolean v() {
        // Kiểm tra nếu đang ở chế độ quản lý đệ tử
        if (GameSrc.gI().manageDisciple) {
            return true;
        }
        return this.y.name.equals((Char.gI()).name);
    }

    /**
     * Tab con trong UI thông tin nhân vật (k == 0). Mặc định dùng Caption.rb
     * (player). UI đệ tử override để đổi nhãn + mapping.
     */
    protected String[] getProfileTabs() {
        return Caption.rb;
    }

    protected boolean isDiscipleUI() {
        return this instanceof LangLa_kl_dt;
    }

    private static void a(Vector<String> var0, SkillClan var1) {
        ItemOption[] var5;
        int var2 = (var5 = var1.b()).length;
        for (int var3 = 0; var3 < var2; var3++) {
            String var4;
            if ((var4 = var5[var3].a(0)) != null && var4.length() > 0) {
                var0.addElement(var4);
            }
        }
    }

    private void a(Vector<String> var1, Skill var2) {
        if (this.y.level() >= var2.levelNeed) {
            var1.addElement("c#white" + Caption.rH[3] + var2.levelNeed);
        } else {
            var1.addElement("c#red" + Caption.rH[3] + var2.levelNeed);
        }
        if (var2.idTemplate >= 15 && var2.idTemplate <= 17) {
            StringBuilder var10001 = (new StringBuilder()).append(Caption.cT);
            int i = this.y.aU;
            var1.addElement(var10001.append((short) (var2.rangeNgang + i)).toString());
        }
        if ((var2.getSkillTemplate()).type < 5) {
            var1.addElement(Caption.rH[7] + var2.mpUse);
            var1.addElement(Caption.rH[8] + (var2.coolDown / 1000.0F) + Caption.cU);
            if (!var2.d()) {
                StringBuilder var10001 = (new StringBuilder()).append(Caption.rH[9]);
                int i = this.y.aU;
                var1.addElement(var10001.append((short) (var2.rangeNgang + i)).toString());
                var1.addElement(Caption.rH[10] + var2.maxTarget);
            }
        } else if (var2.idTemplate == 29) {
            var1.addElement(Caption.rH[8] + (var2.coolDown / 1000.0F) + Caption.cU);
        }
        ItemOption[] var6;
        int var3 = (var6 = var2.g()).length;
        for (int var4 = 0; var4 < var3; var4++) {
            String var5;
            if ((var5 = var6[var4].a(this.y.idClass)) != null && var5.length() > 0) {
                var1.addElement(var5);
            }
        }
    }

    public String skillPet(int var1) {
        this.a = var1;
        Skill var6, var2 = b((var6 = this.y.arrSkillPet[var1]).idTemplate, var6.level + 1);
        Vector<String> var3;
        (var3 = new Vector<>()).addElement("c#moc" + (var6.getSkillTemplate()).name);
        if ((var6.getSkillTemplate()).detail != null && (var6.getSkillTemplate()).detail.length() > 0) {
            var3.addElement((var6.getSkillTemplate()).detail);
        }
        var3.addElement(Caption.rH[4] + (var6.getSkillTemplate()).levelMax);
        if ((var6.getSkillTemplate()).type >= 5) {
            var3.addElement("c#green" + Caption.cV);
        } else if (var6.d()) {
            var3.addElement("c#green" + Caption.lk);
        }
        if (var6.level == 0) {
            var3.addElement("c#red" + Caption.cW + var2.level + Caption.cX);
            a(var3, var2);
        } else if (var6.level == (var6.getSkillTemplate()).levelMax) {
            var3.addElement("c#yellow" + Caption.cY);
            a(var3, var6);
        } else {
            var3.addElement("c#yellow" + Caption.cZ + var6.level);
            a(var3, var6);
            if (var2 != null) {
                var3.addElement("c#red" + Caption.da + var2.level);
                a(var3, var2);
            }
        }
        Vector<LangLa_lk> var7 = new Vector();
        int var4;
        for (var4 = 0; var4 < var3.size(); var4++) {
            String str = String.valueOf(var3.elementAt(var4));
            if (var4 == 0) {
                Vector<String> var9 = mFont.a(mFont.e, str, 180);
                for (int var5 = 0; var5 < var9.size(); var5++) {
                    var7.add(new LangLa_lk(0, var9.elementAt(var5)));
                }
            } else {
                Vector<String> var9 = mFont.a(mFont.d, str, 180);
                for (int var5 = 0; var5 < var9.size(); var5++) {
                    var7.add(new LangLa_lk(1, var9.elementAt(var5)));
                }
            }
        }
        String var8 = "";
        this.W = new LangLa_lk[var7.size()];
        for (var4 = 0; var4 < var7.size(); var4++) {
            this.W[var4] = var7.elementAt(var4);
            var8 = var8 + (this.W[var4]).b;
            if (var4 < this.W.length - 1) {
                var8 = var8 + "\r\n";
            }
        }
        return var8;
    }

    public String b(int var1) {
        this.a = var1;
        Skill var6, var2 = b((var6 = this.z[var1]).idTemplate, var6.level + 1);
        Vector<String> var3;
        (var3 = new Vector<>()).addElement("c#moc" + (var6.getSkillTemplate()).name);
        if ((var6.getSkillTemplate()).detail != null && (var6.getSkillTemplate()).detail.length() > 0) {
            var3.addElement((var6.getSkillTemplate()).detail);
        }
        var3.addElement(Caption.rH[4] + (var6.getSkillTemplate()).levelMax);
        if ((var6.getSkillTemplate()).type >= 5) {
            var3.addElement("c#green" + Caption.cV);
        } else if (var6.d()) {
            var3.addElement("c#green" + Caption.lk);
        }
        if (var6.level == 0) {
            var3.addElement("c#red" + Caption.cW + var2.level + Caption.cX);
            a(var3, var2);
        } else if (var6.level == (var6.getSkillTemplate()).levelMax) {
            var3.addElement("c#yellow" + Caption.cY);
            a(var3, var6);
        } else {
            var3.addElement("c#yellow" + Caption.cZ + var6.level);
            a(var3, var6);
            if (var2 != null) {
                var3.addElement("c#red" + Caption.da + var2.level);
                a(var3, var2);
            }
        }
        Vector<LangLa_lk> var7 = new Vector();
        int var4;
        for (var4 = 0; var4 < var3.size(); var4++) {
            String str = String.valueOf(var3.elementAt(var4));
            if (var4 == 0) {
                Vector<String> var9 = mFont.a(mFont.e, str, 180);
                for (int var5 = 0; var5 < var9.size(); var5++) {
                    var7.add(new LangLa_lk(0, var9.elementAt(var5)));
                }
            } else {
                Vector<String> var9 = mFont.a(mFont.d, str, 180);
                for (int var5 = 0; var5 < var9.size(); var5++) {
                    var7.add(new LangLa_lk(1, var9.elementAt(var5)));
                }
            }
        }
        String var8 = "";
        this.W = new LangLa_lk[var7.size()];
        for (var4 = 0; var4 < var7.size(); var4++) {
            this.W[var4] = var7.elementAt(var4);
            var8 = var8 + (this.W[var4]).b;
            if (var4 < this.W.length - 1) {
                var8 = var8 + "\r\n";
            }
        }
        return var8;
    }

    private static void g(int var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 35)).writeByte(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private static void h(int var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 14)).writeShort(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private static void i(int var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 126)).writeShort(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private static void discipleCommand(byte action) {
        try {
            Message m = Message.c((byte) -121);
            m.writeByte(action);
            m.send();
        } catch (Exception e) {
            Utlis.println(e);
        }
    }

    public void a(int var1, Object var2) {
    }

    public void a(Graphics var1) {
        try {
            if (v()) {
                super.a(var1);
            } else {
                a(var1, this.cx, this.cy, this.width, this.height, Caption.db, (byte) 2, this.r);
            }
            if (k() == 0) {
                String var10002;
                int var3, var10003, var4;
                Graphics var2;
                LangLa_kl var8;
                Item var9;
                mImage var23;
                this.b.a(var1, 61);
                this.b.a(var1, this.cx, this.cy);
                switch (this.b.b.b) {
                    case 0:
                        var2 = var1;
                        var8 = this;
                        try {
                            Item item = null;
                            // Chỉ hiển thị sách kỹ năng chiến đấu cho player bản thân
                            Char me = Char.gI();
                            Char currentDisciple = GameSrc.gI().currentDisciple;
                            boolean isOwnerChar = (me != null && var8.y != null && var8.y.idEntity == me.idEntity);
                            boolean isOwnerDisciple = (currentDisciple != null && var8.y != null && var8.y.idEntity == currentDisciple.idEntity);
                            boolean isPlayerCharacter = (var8.y != null && !var8.y.name.endsWith("Trợ Thủ"));
                            if (var8.C != null && (isOwnerChar || isOwnerDisciple || isPlayerCharacter)) {
                                a(var2, var8.ae.cx, var8.ae.cy, var8.C, var8.af, "");
                            }
                            mImage mImage = LangLa_fq.a(9308);
                            var1.a(mImage, 105, 127);
                            DataCenter.gI();
                            int i;
                            for (i = 0; i < (var8.K[var8.b.b.b][0]).i; i++) {
                                switch (i) {
                                    case 0:
                                        item = var8.y.arrItemBody[0];
                                        break;
                                    case 1:
                                        item = var8.y.arrItemBody[2];
                                        break;
                                    case 2:
                                        item = var8.y.arrItemBody[4];
                                        break;
                                    case 3:
                                        item = var8.y.arrItemBody[6];
                                        break;
                                    case 4:
                                        item = var8.y.arrItemBody[8];
                                        break;
                                }
                                a(var2, (var8.K[var8.b.b.b][0]).cx, (var8.K[var8.b.b.b][0]).cy + i * (var8.K[var8.b.b.b][0]).h, item, (i == (var8.K[var8.b.b.b][0]).k), Caption.qT[i]);
                            }
                            for (i = 0; i < (var8.K[var8.b.b.b][1]).i; i++) {
                                switch (i) {
                                    case 0:
                                        item = var8.y.arrItemBody[1];
                                        break;
                                    case 1:
                                        item = var8.y.arrItemBody[3];
                                        break;
                                    case 2:
                                        item = var8.y.arrItemBody[5];
                                        break;
                                    case 3:
                                        item = var8.y.arrItemBody[7];
                                        break;
                                    case 4:
                                        item = var8.y.arrItemBody[9];
                                        break;
                                }
                                a(var2, (var8.K[var8.b.b.b][1]).cx, (var8.K[var8.b.b.b][1]).cy + i * (var8.K[var8.b.b.b][1]).h, item, (i == (var8.K[var8.b.b.b][1]).k), Caption.qU[i]);
                            }
                            for (i = 0; i < (var8.K[var8.b.b.b][2]).r; i++) {
                                switch (i) {
                                    case 0:
                                        item = var8.y.arrItemBody[10];
                                        break;
                                    case 1:
                                        item = var8.y.arrItemBody[11];
                                        break;
                                    case 2:
                                        item = var8.y.arrItemBody[12];
                                        break;
                                    case 3:
                                        item = var8.y.arrItemBody[13];
                                        break;
                                }
                                a(var2, (var8.K[var8.b.b.b][2]).cx + i * var8.I, (var8.K[var8.b.b.b][2]).cy, item, (i == (var8.K[var8.b.b.b][2]).k), Caption.qV[i]);
                            }
                            a(var2, (var8.K[var8.b.b.b][3]).cx, (var8.K[var8.b.b.b][3]).cy, var8.y.arrItemBody[14], ((var8.K[var8.b.b.b][3]).k == 0), Caption.rS[0]);
                            a(var2, (var8.K[var8.b.b.b][4]).cx, (var8.K[var8.b.b.b][4]).cy, var8.y.arrItemBody[15], ((var8.K[var8.b.b.b][4]).k == 0), Caption.rS[1]);
                            a(var2, (var8.K[var8.b.b.b][5]).cx, (var8.K[var8.b.b.b][5]).cy, var8.y.arrItemBody[16], ((var8.K[var8.b.b.b][5]).k == 0), Caption.rS[2]);
                            a(var2, (var8.K[var8.b.b.b][6]).cx, (var8.K[var8.b.b.b][6]).cy, var8.y.arrItemBody[17], ((var8.K[var8.b.b.b][6]).k == 0), "Mắt");
                            a(var2, (var8.K[var8.b.b.b][7]).cx, (var8.K[var8.b.b.b][7]).cy, var8.y.arrItemBody[18], ((var8.K[var8.b.b.b][7]).k == 0), "Cánh");
                            DataCenter.gI();
                            var8.y.a(var2, 150, 137, var8.y.a(var8.y.arrItemBody, false), (DataCenter.gI()).i / 8 % 2, var8.y.m, false);
                            var8.y.b(var2, 150, 82);
                            mFont var10000 = mFont.b;
                            String str = Caption.cj;
                            DataCenter.gI();
                            mFont.a(var10000, var2, str, 150, 155, 2, -1, -10275328);
                            var2.f(-1);
                            var2.a(130, 159, 170, 144);
                            return;
                        } catch (Exception var6) {
                            Utlis.println(var6);
                        }
                        return;
                    case 1:
                        if (isDiscipleUI()) {
                            a(var1, this.L[1][0]);
                            String[] lines = (this.discipleInfoLines != null && this.discipleInfoLines.length > 0)
                                    ? this.discipleInfoLines
                                    : new String[]{"Đang tải thông tin..."};
                            for (int i = 0; i < lines.length; i++) {
                                int yy = i * (this.L[1][0]).h;
                                if ((this.L[1][0]).c(yy)) {
                                    mFont.c(mFont.d, var1, lines[i], 10, yy + 5, 0, -1, -16777216);
                                }
                            }
                            b(var1);
                            (this.L[1][0]).b(var1, -17, -13);
                            return;
                        }
                        var2 = var1;
                        var8 = this;
                        DataCenter.gI();
                        var9 = null;
                        var23 = LangLa_fq.a(9308);
                        var1.a(var23, 105, 127);
                        for (var4 = 0; var4 < (var8.K[var8.b.b.b][0]).i; var4++) {
                            switch (var4) {
                                case 0:
                                    var9 = var8.y.arrItemBody2[0];
                                    break;
                                case 1:
                                    var9 = var8.y.arrItemBody2[2];
                                    break;
                                case 2:
                                    var9 = var8.y.arrItemBody2[4];
                                    break;
                                case 3:
                                    var9 = var8.y.arrItemBody2[6];
                                    break;
                                case 4:
                                    var9 = var8.y.arrItemBody2[8];
                                    break;
                            }
                            a(var2, (var8.K[var8.b.b.b][0]).cx, (var8.K[var8.b.b.b][0]).cy + var4 * (var8.K[var8.b.b.b][0]).h, var9, (var4 == (var8.K[var8.b.b.b][0]).k), Caption.qT[var4]);
                        }
                        for (var4 = 0; var4 < (var8.K[var8.b.b.b][1]).i; var4++) {
                            switch (var4) {
                                case 0:
                                    var9 = var8.y.arrItemBody2[1];
                                    break;
                                case 1:
                                    var9 = var8.y.arrItemBody2[3];
                                    break;
                                case 2:
                                    var9 = var8.y.arrItemBody2[5];
                                    break;
                                case 3:
                                    var9 = var8.y.arrItemBody2[7];
                                    break;
                                case 4:
                                    var9 = var8.y.arrItemBody2[9];
                                    break;
                            }
                            a(var2, (var8.K[var8.b.b.b][1]).cx, (var8.K[var8.b.b.b][1]).cy + var4 * (var8.K[var8.b.b.b][1]).h, var9, (var4 == (var8.K[var8.b.b.b][1]).k), Caption.qU[var4]);
                        }
                        for (var4 = 0; var4 < (var8.K[var8.b.b.b][2]).r; var4++) {
                            switch (var4) {
                                case 0:
                                    var9 = var8.y.arrItemBody2[10];
                                    break;
                                case 1:
                                    var9 = var8.y.arrItemBody2[11];
                                    break;
                                case 2:
                                    var9 = var8.y.arrItemBody2[12];
                                    break;
                                case 3:
                                    var9 = var8.y.arrItemBody2[13];
                                    break;
                            }
                            a(var2, (var8.K[var8.b.b.b][2]).cx + var4 * var8.I, (var8.K[var8.b.b.b][2]).cy, var9, (var4 == (var8.K[var8.b.b.b][2]).k), Caption.qV[var4]);
                        }
                        a(var2, (var8.K[var8.b.b.b][3]).cx, (var8.K[var8.b.b.b][3]).cy, var8.y.arrItemBody2[14], ((var8.K[var8.b.b.b][3]).k == 0), Caption.rS[0]);
                        a(var2, (var8.K[var8.b.b.b][4]).cx, (var8.K[var8.b.b.b][4]).cy, var8.y.arrItemBody2[15], ((var8.K[var8.b.b.b][4]).k == 0), Caption.rS[1]);
                        a(var2, (var8.K[var8.b.b.b][5]).cx, (var8.K[var8.b.b.b][5]).cy, var8.y.arrItemBody2[16], ((var8.K[var8.b.b.b][5]).k == 0), Caption.rS[2]);
                        a(var2, (var8.K[var8.b.b.b][6]).cx, (var8.K[var8.b.b.b][6]).cy, var8.y.arrItemBody2[17], ((var8.K[var8.b.b.b][6]).k == 0), "Mắt");
                        a(var2, (var8.K[var8.b.b.b][7]).cx, (var8.K[var8.b.b.b][7]).cy, var8.y.arrItemBody2[18], ((var8.K[var8.b.b.b][7]).k == 0), "Cánh");
                        DataCenter.gI();
                        var8.y.a(var2, 150, 137, var8.y.a(var8.y.arrItemBody2, false), (DataCenter.gI()).i / 8 % 2, var8.y.m, false);
                        var8.y.b(var2, 150, 82);
                        return;
                    case 2:
                        var2 = var1;
                        var8 = this;
                        DataCenter.gI();
                        var3 = this.b.c() + 2;
                        var4 = (this.P[0]).cy + (this.P[0]).height + 10;
                        this.P[0].a(var1);
                        switch ((this.P[0]).b.b) {
                            case 0:
                                var3 += 10;
                                var10002 = Caption.rc[1];
                                var10003 = var3 + 6;
                                var4 += 10;
                                mFont.a(mFont.d, var1, var10002, var10003, var4, 0, -1, 0);
                                var10002 = Caption.rc[2];
                                var10003 = var3 + 6;
                                var4 += 24;
                                mFont.a(mFont.d, var1, var10002, var10003, var4, 0, -1, 0);
                                var10002 = Caption.rc[3];
                                var10003 = var3 + 6;
                                var4 += 25;
                                mFont.a(mFont.d, var1, var10002, var10003, var4, 0, -1, 0);
                                var10002 = Caption.rc[4];
                                var10003 = var3 + 6;
                                var4 += 25;
                                mFont.a(mFont.d, var1, var10002, var10003, var4, 0, -1, 0);
                                if (v() && this.y.idClass > 0) {
                                    mFont var10000 = mFont.b;
                                    var10002 = Caption.dd;
                                    var10003 = var3 + 6;
                                    DataCenter.gI();
                                    var4 += 21;
                                    mFont.a(var10000, var1, var10002, var10003, var4, 0, -1, -10275328);
                                    var1.f(-1);
                                    var1.a(var3 + 6, var4 + 4, var3 + 6 + mFont.b(mFont.b, Caption.dd), var4 + 4);
                                }
                                mFont.a(mFont.d, var1, Caption.rc[0] + " " + this.i + Caption.dc, var3 + 6, this.b.cy + 7 + 23 + 145, 0, -1, 0);
                                return;
                            case 1:
                                a(var1, this.L[this.b.b.b][1]);
                                for (var3 = 0; var3 < Caption.rd.length; var3++) {
                                    var4 = var3 * (var8.L[var8.b.b.b][1]).h;
                                    if (var8.L[var8.b.b.b][1].c(var4)) {
                                        if ((var8.L[var8.b.b.b][1]).k == var3) {
                                            var2.f(-6488);
                                            var2.c(3, var4, (var8.L[var8.b.b.b][1]).width - 9, (var8.L[var8.b.b.b][1]).h);
                                        }
                                        if (var3 == 0) {
                                            mFont.a(mFont.d, var2, Caption.rd[var3] + ": " + (var8.w[var3] * 90 / 100) + " - " + var8.w[var3], 10, var4 + (var8.L[var8.b.b.b][1]).h / 2, 0, -1, 0);
                                        } else {
                                            mFont.a(mFont.d, var2, Caption.rd[var3] + ": " + var8.w[var3] + ((var3 != 5 && var3 != 16 && var3 != 17) ? "" : "%"), 10, var4 + (var8.L[var8.b.b.b][1]).h / 2, 0, -1, 0);
                                        }
                                    }
                                }
                                var8.b(var2);
                                var8.L[var8.b.b.b][1].b(var2, -17, -13);
                                return;
                            case 2:
                                a(var1, this.L[this.b.b.b][2]);
                                for (var3 = 0; var3 < (var8.L[var8.b.b.b][2]).i; var3++) {
                                    var4 = var3 * (var8.L[var8.b.b.b][2]).h;
                                    if (var8.L[var8.b.b.b][2].c(var4)) {
                                        if ((var8.L[var8.b.b.b][2]).k == var3) {
                                            var2.f(-6488);
                                            var2.c(3, var4, (var8.L[var8.b.b.b][2]).width - 9, (var8.L[var8.b.b.b][2]).h);
                                        }
                                        if (var3 == 10) {
                                            if (var8.y.idhe > 0) {
                                                mFont.a(mFont.d, var2, Caption.re[var3] + Caption.ro[var8.y.L() - 1] + ": " + var8.x[var3], 10, var4 + (var8.L[var8.b.b.b][2]).h / 2, 0, -1, 0);
                                            } else {
                                                mFont.a(mFont.d, var2, Caption.kl + ": " + var8.x[var3], 10, var4 + (var8.L[var8.b.b.b][2]).h / 2, 0, -1, 0);
                                            }
                                        } else if (var3 == 11) {
                                            if (var8.y.idhe > 0) {
                                                mFont.a(mFont.d, var2, Caption.re[var3] + Caption.ro[var8.y.M() - 1] + ": " + var8.x[var3], 10, var4 + (var8.L[var8.b.b.b][2]).h / 2, 0, -1, 0);
                                            } else {
                                                mFont.a(mFont.d, var2, Caption.km + ": " + var8.x[var3], 10, var4 + (var8.L[var8.b.b.b][2]).h / 2, 0, -1, 0);
                                            }
                                        } else {
                                            mFont.a(mFont.d, var2, Caption.re[var3] + ": " + var8.x[var3] + ((var3 != 8 && var3 != 9) ? "" : "%"), 10, var4 + (var8.L[var8.b.b.b][2]).h / 2, 0, -1, 0);
                                        }
                                    }
                                }
                                var8.b(var2);
                                var8.L[var8.b.b.b][2].b(var2, -17, -13);
                                return;
                        }
                        return;
                    case 3:
                        h(var1);
                        return;
                    case 4:
                        if (isDiscipleUI()) {
                            // Tab "Khác" của đệ tử: danh sách chức năng trợ thủ hiển thị giống dòng danh hiệu (chỉ 1 dòng tên)
                            if (this.discipleActionList != null && this.discipleActionNames != null) {
                                a(var1, this.discipleActionList);
                                for (int row = 0; row < this.discipleActionList.i; row++) {
                                    int centerY = row * this.discipleActionList.h + this.discipleActionList.h / 2;
                                    // Vòng tròn chọn
                                    LangLa_fq.a(var1, 10, 0, 15, centerY, 3);
                                    if (row == this.discipleSelectedAction) {
                                        LangLa_fq.a(var1, 11, 0, 15, centerY, 3);
                                    }
                                    String name = this.discipleActionNames[row];
                                    mFont.a(mFont.d, var1, name, 28, centerY , 0, -6488, 0);
                                }
                                b(var1);
                            }
                 //           mFont.a(mFont.d, var1, "", this.b.c() + 10, a_() + 50, 0, -1, 0);
                            return;
                        }
                        i(var1);
                        return;
                    case 5:
                        d(var1);
                        return;
                }
                return;
            }
            if (k() == 2 && k() != j()) {
                e(var1);
            }
        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    private void e(Graphics var1) {
        int var2 = this.b.c() + 15;
        int var3 = this.b.cy + 7 + 18;
        if (!this.y.isMe() && this.B.a) {
            mFont.a(mFont.d, var1, Caption.dg, var2, var3, 0, -6488, 0);
        } else {
            mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.v + Caption.dc, var2, a_() + G() - 16, 0, -1, 0);
            a(var1, this.N[0]);
            for (var3 = 0; var3 < this.z.length; var3++) {
                var2 = var3 * (this.N[0]).h;
                if (this.N[0].c(var2)) {
                    if (this.a == var3) {
                        a(var1, 28, var2 + 1, (this.N[0]).width - 29, 25, -15, 84, 5, 1, 1);
                    } else {
                        a(var1, 28, var2 + 1, (this.N[0]).width - 29, 25, -14, 84, 5, 1, 1);
                    }
                    mFont.a(mFont.e, var1, (this.z[var3].getSkillTemplate()).name, 35, var2 + 8, 0, -7812062, 0);
                    if ((this.z[var3]).level == (this.z[var3].getSkillTemplate()).levelMax) {
                        mFont.a(mFont.d, var1, Caption.cY, 35, var2 + 18, 0, -2560, 0);
                    } else {
                        mFont.a(mFont.d, var1, Caption.cZ + (this.z[var3]).level, 35, var2 + 18, 0, -1, 0);
                    }
                    LangLa_fq.a(var1, (this.z[var3].getSkillTemplate()).idIcon, 0, 1, var2 + 1, 20);
                }
            }
            if (this.cL != null && this.cL instanceof LangLa_ie) {
                var2 = this.a * (this.N[0]).h;
                var1.f(-1);
                var1.b(0, var2, 26, 26);
            }
            b(var1);
            this.N[0].b(var1, -7, -6);
        }
    }

    private void f(Graphics var1) {
        this.O.c();
        int var10000 = this.O.cy + 7;
        a(var1, this.M[2]);
        for (int var3 = 0; var3 < (this.M[2]).i; var3++) {
            int var2 = var3 * (this.M[2]).h;
            if (this.M[2].c(var2)) {
                if ((this.M[2]).k == var3) {
                    var1.f(-6488);
                    var1.c(3, var2, (this.M[2]).width - 9, (this.M[2]).h);
                }
                if (var3 == 10) {
                    if (this.y.idhe > 0) {
                        mFont.a(mFont.d, var1, Caption.re[var3] + Caption.ro[this.y.L() - 1] + ": " + this.x[var3], 10, var2 + (this.M[2]).h / 2, 0, -1, 0);
                    } else {
                        mFont.a(mFont.d, var1, Caption.kl + ": " + this.x[var3], 10, var2 + (this.M[2]).h / 2, 0, -1, 0);
                    }
                } else if (var3 == 11) {
                    if (this.y.idhe > 0) {
                        mFont.a(mFont.d, var1, Caption.re[var3] + Caption.ro[this.y.M() - 1] + ": " + this.x[var3], 10, var2 + (this.M[2]).h / 2, 0, -1, 0);
                    } else {
                        mFont.a(mFont.d, var1, Caption.km + ": " + this.x[var3], 10, var2 + (this.M[2]).h / 2, 0, -1, 0);
                    }
                } else {
                    mFont.a(mFont.d, var1, Caption.re[var3] + ": " + this.x[var3] + ((var3 != 8 && var3 != 9) ? "" : "%"), 10, var2 + (this.M[2]).h / 2, 0, -1, 0);
                }
            }
        }
        b(var1);
        this.M[2].b(var1, -17, -13);
    }

    private void g(Graphics var1) {
        a(var1, this.M[1]);
        for (int var3 = 0; var3 < Caption.rd.length; var3++) {
            int var2 = var3 * (this.M[1]).h;
            if (this.M[1].c(var2)) {
                if ((this.M[1]).k == var3) {
                    var1.f(-6488);
                    var1.c(3, var2, (this.M[1]).width - 9, (this.M[1]).h);
                }
                if (var3 == 0) {
                    mFont.a(mFont.d, var1, Caption.rd[var3] + ": " + (this.w[var3] * 90 / 100) + " - " + this.w[var3], 10, var2 + (this.M[1]).h / 2, 0, -1, 0);
                } else {
                    mFont.a(mFont.d, var1, Caption.rd[var3] + ": " + this.w[var3] + ((var3 != 5 && var3 != 16) ? "" : "%"), 10, var2 + (this.M[1]).h / 2, 0, -1, 0);
                }
            }
        }
        b(var1);
        this.M[1].b(var1, -17, -13);
    }

    private void h(Graphics var1) {
        DataCenter.gI();
        int var2 = this.b.c() + 15;
        int var3 = this.b.cy + 7 + 18;
        if (!this.y.isMe() && this.B.a) {
            mFont.a(mFont.d, var1, Caption.dg, var2, var3, 0, -6488, 0);
        } else {
            mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.v + Caption.dc, var2 - 7, var3 + 5 + 135 + 10, 0, -6488, 0);
            a(var1, this.L[3][0]);
            for (var3 = 0; var3 < this.z.length; var3++) {
                var2 = var3 * (this.L[3][0]).h;
                if (this.L[3][0].c(var2)) {
                    if (this.a == var3) {
                        a(var1, 28, var2 + 1, (this.L[3][0]).width - 29, 25, -15, 84, 5, 1, 1);
                    } else {
                        a(var1, 28, var2 + 1, (this.L[3][0]).width - 29, 25, -14, 84, 5, 1, 1);
                    }
                    mFont.a(mFont.e, var1, (this.z[var3].getSkillTemplate()).name, 35, var2 + 8, 0, -7812062, 0);
                    if ((this.z[var3]).level == (this.z[var3].getSkillTemplate()).levelMax) {
                        mFont.a(mFont.d, var1, Caption.cY, 35, var2 + 18, 0, -2560, 0);
                    } else {
                        mFont.a(mFont.d, var1, Caption.cZ + (this.z[var3]).level, 35, var2 + 18, 0, -1, 0);
                    }
                    LangLa_fq.a(var1, (this.z[var3].getSkillTemplate()).idIcon, 0, 1, var2 + 1, 20);
                }
            }
            if (this.cL != null && this.cL instanceof LangLa_ie) {
                var2 = this.a * (this.L[3][0]).h;
                var1.f(-1);
                var1.b(0, var2, 26, 26);
            }
            b(var1);
        }
    }

    private void i(Graphics var1) {
        int var2, var5;
        Item var3;
        int percent, x, y;
        DataCenter.gI();
        this.P[1].a(var1);
        switch ((this.P[1]).b.b) {
            case 0:
                a(var1, this.L[this.b.b.b][(this.P[1]).b.b]);
                for (var5 = 0; var5 < (this.L[this.b.b.b][(this.P[1]).b.b]).i; var5 += 2) {
                    if (this.L[this.b.b.b][(this.P[1]).b.b].b(var5)) {
                        int i = var5 * (this.L[this.b.b.b][(this.P[1]).b.b]).h + (this.L[this.b.b.b][(this.P[1]).b.b]).h / 2;
                        LangLa_fq.a(var1, 10, 0, 15, i, 3);
                        if (var5 / 2 == this.y.selectDanhHieu) {
                            LangLa_fq.a(var1, 11, 0, 15, i, 3);
                        }
                        mFont.a(mFont.d, var1, (this.y.aG[var5 / 2]).a, 28, i, 0, -6488, 0);
                        mFont.a(mFont.d, var1, Caption.fw + (((this.y.aG[var5 / 2]).b == -1) ? Caption.ln : Utlis.f((this.y.aG[var5 / 2]).b * 1000L)), 28, i + (this.L[this.b.b.b][(this.P[1]).b.b]).h, 0, -1, 0);
                    }
                }
                b(var1);
                return;
            case 1:
                if ((var3 = this.y.arrItemBody[10]) == null || !var3.aa()) {
                    this.S.b(true);
                    this.T.b(true);
                    this.U.b(true);
                    mFont var10000 = mFont.e;
                    String var10002 = Caption.qd;
                    int var10003 = 49 + (this.width - 8) / 2;
                    DataCenter.gI();
                    mFont.a(var10000, var1, var10002, var10003 - 40, a_() + G() / 2, 2, -2560, 2, 1, 3);
                    return;
                }
                if (this.F == -1 || this.F >= this.y.aH.size()) {
                    this.F = -1;
                    this.S.b(true);
                    this.T.b(true);
                    this.U.b(true);
                }
                if (this.D != null) {
                    a(var1, this.L[4][1]);
                    for (int i = 0; i < this.D.length; i++) {
                        mFont.c(mFont.d, var1, this.D[i], 8, i * (this.L[4][1]).h + 5, 0, -1, -16777216);
                    }
                    b(var1);
                }
                if (this.y.arrItemBody[10] != null) {
                    int icon = 0;
                    int i = (this.K[this.b.b.b][0]).cx + this.I + 2;
                    int j = (this.K[this.b.b.b][0]).cy - 120;
                    switch ((this.y.arrItemBody[10]).id) {
                        case 476:
                            icon = 3920;
                            j += 30;
                            break;
                        case 477:
                            icon = 3910;
                            break;
                        case 478:
                            icon = 4006;
                            j += 30;
                            break;
                        case 479:
                            icon = 3961;
                            j += 30;
                            break;
                        case 480:
                            icon = 3969;
                            j += 30;
                            i += 10;
                            break;
                        case 481:
                            icon = 3992;
                            j += 30;
                            i += 10;
                            break;
                        case 482:
                            icon = 4015;
                            j += 20;
                            i += 20;
                            break;
                        case 483:
                            icon = 3984;
                            j += 20;
                            i += 10;
                            break;
                        case 484:
                            icon = 3976;
                            break;
                    }
                    LangLa_fq.reqestIconChar(icon);
                    int frame1 = icon;
                    mImage image1 = LangLa_fq.reqestIconChar(frame1);
                    var1.a(image1, i + 14, j + 5);
                }
                for (var2 = 0; var2 < 6; var2++) {
                    a(var1, (this.K[this.b.b.b][0]).cx + var2 * this.I, (this.K[this.b.b.b][0]).cy, this.y.arrItemSkillViThu[var2], (var2 == (this.K[this.b.b.b][0]).k && this.E == 0), Caption.tl[var2]);
                    if (var2 < this.G.size()) {
                        int var10003 = (this.K[this.b.b.b][0]).cx + var2 * this.I + 2;
                        LangLa_fq.a(var1, ((SkillClan) this.G.elementAt(var2)).idIcon, 0, var10003, (this.K[this.b.b.b][0]).cy + 2, 20);
                    }
                }
                if (this.H != null) {
                    for (var2 = 0; var2 < (this.K[this.b.b.b][1]).r; var2++) {
                        a(var1, (this.K[this.b.b.b][1]).cx + var2 * this.I, (this.K[this.b.b.b][1]).cy, this.y.arrItemSkillViThu[var2], (var2 == (this.K[this.b.b.b][1]).k && this.E == 1), Caption.tl[var2]);
                        LangLa_fq.a(var1, this.H.idIcon, 0, (this.K[this.b.b.b][1]).cx + var2 * this.I + 2, (this.K[this.b.b.b][1]).cy + 2, 20);
                    }
                }
                break;
            case 2:
                // Hiển thị thông báo "Sắp ra mắt"
                DataCenter.gI();
                int centerX = (this.K[this.b.b.b][0]).cx;
                int centerY = (this.K[this.b.b.b][0]).cy;
                
                // Hiển thị text "Sắp ra mắt (dự kiến quý 1 2026)" màu vàng, phía trên character
                String comingSoonText = "Sắp ra mắt (dự kiến quý 1 2026)";
                int textX = centerX - 80 + 180;
                int textY = centerY - this.I * 2 - 20 + 30;
                mFont.a(mFont.h, var1, comingSoonText, textX, textY, 2, -2560, 2, 1, 3);  
                if (isDiscipleUI()) {
                    var1.f(-11184811);
                    percent = this.exp * 100 / this.expMax;
                    x = (this.K[this.b.b.b][0]).cx + this.I + 12;
                    y = this.height - this.I;
                    Binary2.a(var1, 375, 0, x, y, 100, 10);
                    Binary2.a(var1, 93, 0, x, y, percent, 10);
                    mFont.a(mFont.c, var1, "Kinh Nghiệm" + this.exp + "/" + this.expMax, x + 50, y + 5, 2, -7079423);
                }
                break;
        }
    }

    public void b() {
        Step var4;
        super.b();
        // Hiển thị sách kỹ năng chiến đấu cho cả player và đệ tử
        if (this.y != null && this.y.sachChienDau > 0) {
            if (this.C == null) {
                this.C = new Item(435);
                this.C.strOptions = "207,0,-1;208,0,-1";
                this.C.a(this.y.sachChienDau);
                if (this.y.sachChienDau > 39) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,500,-1;68,462,-1;69,462,-1;70,462,-1;71,462,-1;72,462,-1;149,125,-1;371,30,-1;0,26000,-1;1,26000,-1;151,2600,-1;167,2600,-1;152,2600,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2700,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 38) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,480,-1;68,452,-1;69,452,-1;70,452,-1;71,452,-1;72,452,-1;149,120,-1;371,29,-1;0,25000,-1;1,25000,-1;151,2500,-1;167,2500,-1;152,2500,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2600,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 37) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,460,-1;68,442,-1;69,442,-1;70,442,-1;71,442,-1;72,442,-1;149,115,-1;371,28,-1;0,24000,-1;1,24000,-1;151,2400,-1;167,2400,-1;152,2400,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2500,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 36) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,440,-1;68,432,-1;69,432,-1;70,432,-1;71,432,-1;72,432,-1;149,110,-1;371,27,-1;0,23000,-1;1,23000,-1;151,2300,-1;167,2300,-1;152,2300,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2400,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 35) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,420,-1;68,422,-1;69,422,-1;70,422,-1;71,422,-1;72,422,-1;149,105,-1;371,26,-1;0,22000,-1;1,22000,-1;151,2200,-1;167,2200,-1;152,2200,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2300,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 34) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,400,-1;68,412,-1;69,412,-1;70,412,-1;71,412,-1;72,412,-1;149,100,-1;371,25,-1;0,21000,-1;1,21000,-1;151,2100,-1;167,2100,-1;152,2100,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2200,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 33) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,380,-1;68,402,-1;69,402,-1;70,402,-1;71,402,-1;72,402,-1;149,95,-1;371,24,-1;0,20000,-1;1,20000,-1;151,2000,-1;167,2000,-1;152,2000,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2100,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 32) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,360,-1;68,392,-1;69,392,-1;70,392,-1;71,392,-1;72,392,-1;149,90,-1;371,23,-1;0,19000,-1;1,19000,-1;151,1900,-1;167,1900,-1;152,1900,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2000,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 31) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,340,-1;68,382,-1;69,382,-1;70,382,-1;71,382,-1;72,382,-1;149,85,-1;371,22,-1;0,18000,-1;1,18000,-1;151,1800,-1;167,1800,-1;152,1800,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1900,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 30) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,320,-1;68,372,-1;69,372,-1;70,372,-1;71,372,-1;72,372,-1;149,80,-1;371,21,-1;0,17000,-1;1,17000,-1;151,1700,-1;167,1700,-1;152,1700,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1800,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 29) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,310,-1;68,422,-1;69,422,-1;70,422,-1;71,422,-1;72,422,-1;149,115,-1;371,25,-1;0,24000,-1;1,24000,-1;151,2400,-1;167,2400,-1;152,2400,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2500,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 28) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,300,-1;68,392,-1;69,392,-1;70,392,-1;71,392,-1;72,392,-1;149,105,-1;371,23,-1;0,22000,-1;1,22000,-1;151,2200,-1;167,2200,-1;152,2200,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2300,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 27) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,290,-1;68,362,-1;69,362,-1;70,362,-1;71,362,-1;72,362,-1;149,95,-1;371,21,-1;0,20000,-1;1,20000,-1;151,2000,-1;167,2000,-1;152,2000,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,2100,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 26) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,280,-1;68,332,-1;69,332,-1;70,332,-1;71,332,-1;72,332,-1;149,85,-1;371,19,-1;0,18000,-1;1,18000,-1;151,1800,-1;167,1800,-1;152,1800,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1900,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 25) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,270,-1;68,302,-1;69,302,-1;70,302,-1;71,302,-1;72,302,-1;149,75,-1;371,17,-1;0,16000,-1;1,16000,-1;151,1600,-1;167,1600,-1;152,1600,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1700,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 24) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,260,-1;68,272,-1;69,272,-1;70,272,-1;71,272,-1;72,272,-1;149,65,-1;371,15,-1;0,14000,-1;1,14000,-1;151,1400,-1;167,1400,-1;152,1400,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1500,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 23) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,250,-1;68,242,-1;69,242,-1;70,242,-1;71,242,-1;72,242,-1;149,55,-1;371,13,-1;0,12000,-1;1,12000,-1;151,1200,-1;167,1200,-1;152,1200,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1300,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 22) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,240,-1;68,212,-1;69,212,-1;70,212,-1;71,212,-1;72,212,-1;149,45,-1;371,11,-1;0,10000,-1;1,10000,-1;151,1000,-1;167,1000,-1;152,1000,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,1100,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 21) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,230,-1;68,182,-1;69,182,-1;70,182,-1;71,182,-1;72,182,-1;149,35,-1;371,9,-1;0,8000,-1;1,8000,-1;151,800,-1;167,800,-1;152,800,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,900,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 20) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,220,-1;68,152,-1;69,152,-1;70,152,-1;71,152,-1;72,152,-1;149,25,-1;371,7,-1;0,6000,-1;1,6000,-1;151,600,-1;167,600,-1;152,600,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,700,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 19) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,210,-1;68,122,-1;69,122,-1;70,122,-1;71,122,-1;72,122,-1;149,15,-1;371,5,-1;0,4000,-1;1,4000,-1;151,400,-1;167,400,-1;152,400,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,500,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 18) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";306,200,-1;68,42,-1;69,42,-1;70,42,-1;71,42,-1;72,42,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,300,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 17) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,300,-1").toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
                    var10000 = new StringBuilder();
                    var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
                } else if (this.y.sachChienDau > 16) {
                    StringBuilder var10000 = new StringBuilder();
                    Item var10002 = this.C;
                    var10002.strOptions = var10000.append(var10002.strOptions).append(";311,150,-1").toString();
                }
                int var10004 = this.b.c();
                DataCenter.gI();
                var10004 = var10004 + 8 + this.I;
                int var10005 = a_();
                DataCenter.gI();
                this.ae = new LangLa_ij((byte) 1, var10004 + 10, var10005 + 35 + this.I * 2 + 32, this.I, this.I, this.I, 5, 1);
            }
        } else {
            this.C = null;
            this.ae = null;
        }
        if (v()) {
            boolean var1 = false;
            this.B.v = var1;
        } else {
            boolean var1 = true;
            this.B.v = var1;
        }
        if (v() && !t()) {
            this.ab.v = true;
            (this.c[0]).u = true;
        }
        if (k() == 0) {
            this.b.a();
            int i;
            for (i = 0; i < this.K.length; i++) {
                if (this.K[i] != null) {
                    for (int var2 = 0; var2 < (this.K[i]).length; var2++) {
                        if (this.K[i][var2] != null) {
                            this.K[i][var2].a();
                        }
                    }
                }
            }
            for (i = 0; i < this.L.length; i++) {
                if (this.L[i] != null) {
                    for (int var2 = 0; var2 < (this.L[i]).length; var2++) {
                        if (this.L[i][var2] != null) {
                            this.L[i][var2].a();
                        }
                    }
                }
            }
        } else if (k() == 1) {
            this.O.a();
            if (this.M != null) {
                for (int i = 0; i < this.M.length; i++) {
                    if (this.M[i] != null) {
                        this.M[i].a();
                    }
                }
            }
        } else if (k() == 2 && this.N != null) {
            for (int i = 0; i < this.N.length; i++) {
                if (this.N[i] != null) {
                    this.N[i].a();
                }
            }
        }
        w();
        switch ((GameSrc.gI()).Task) {
            case 0:
                if ((GameSrc.gI()).idStep == 0) {
                    if (k() != j()) {
                        DataCenter.gI();
                        int var10001 = this.cx + 135;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                        break;
                    }
                    if (this.cL == null) {
                        int[] var5;
                        if ((var5 = this.y.c(28)) == null) {
                            var5 = this.y.c(188);
                        }
                        if (this.cL == null && this.y.arrItemBody[1] == null) {
                            int var10001 = this.cx + var5[0] + 15;
                            (DataCenter.gI()).aO.a(var10001, this.cy + 25 + var5[1] + 15);
                            (DataCenter.gI()).aO.a = true;
                        }
                    }
                }
                break;
            case 3:
                if ((GameSrc.gI()).idStep == 1) {
                    Step step = GameSrc.gI().B();
                    if (k() != j()) {
                        DataCenter.gI();
                        int var10001 = this.cx + 135;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                        break;
                    }
                    if (this.cL == null && step != null) {
                        int[] var5 = this.y.c(step.b());
                        int var10001 = this.cx + var5[0] + 15;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 25 + var5[1] + 15);
                        (DataCenter.gI()).aO.a = true;
                    }
                    break;
                }
                if ((GameSrc.gI()).idStep == 2) {
                    (DataCenter.gI()).aO.a(this.cx + this.width - 5, this.cy + 5);
                    (DataCenter.gI()).aO.a = true;
                }
                break;
            case 6:
                var4 = GameSrc.gI().B();
                if ((GameSrc.gI()).idStep >= 0 && var4 != null && (Char.gI()).cx == var4.x && (Char.gI()).cy == var4.y) {
                    if (k() != j()) {
                        DataCenter.gI();
                        int var10001 = this.cx + 135;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                        break;
                    }
                    if (this.cL == null && var4 != null) {
                        int[] var5 = this.y.c(var4.b());
                        int var10001 = this.cx + var5[0] + 15;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 25 + var5[1] + 15);
                        (DataCenter.gI()).aO.a = true;
                    }
                }
                break;
            case 8:
                if ((GameSrc.gI()).idStep == 9) {
                    if (k() != j()) {
                        DataCenter.gI();
                        int var10001 = this.cx + 135;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                        break;
                    }
                    if (this.cL == null) {
                        int[] var5 = this.y.u();
                        int var10001 = this.cx + var5[0] + 20;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 30 + var5[1] + 15);
                        (DataCenter.gI()).aO.a = true;
                    }
                    break;
                }
                if ((GameSrc.gI()).idStep == 10) {
                    DataCenter.gI();
                    if (k() == 0) {
                        if (this.b.b.b != 2) {
                            int var10001 = this.cx + 70;
                            (DataCenter.gI()).aO.a(var10001, this.cy + 120);
                            (DataCenter.gI()).aO.a = true;
                        } else if (this.Q.u) {
                            int var10001 = this.cx + 255;
                            (DataCenter.gI()).aO.a(var10001, this.cy + 100);
                            (DataCenter.gI()).aO.a = true;
                        } else {
                            int var10001 = this.cx + 255;
                            (DataCenter.gI()).aO.a(var10001, this.cy + 190);
                            (DataCenter.gI()).aO.a = true;
                        }
                    } else {
                        int var10001 = this.cx + 60;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                    }
                    if (this.cL != null) {
                        (DataCenter.gI()).aO.a = false;
                    }
                    break;
                }
                if ((GameSrc.gI()).idStep == 11) {
                    DataCenter.gI();
                    if (k() == 0) {
                        if (this.b.b.b != 3) {
                            int i = this.cx + 70;
                            (DataCenter.gI()).aO.a(i, this.cy + 150);
                            (DataCenter.gI()).aO.a = true;
                        } else if (this.Y.u) {
                            int i = this.cx + 280;
                            (DataCenter.gI()).aO.a(i, this.cy + 80);
                            (DataCenter.gI()).aO.a = true;
                        } else {
                            int i = this.cx + 280;
                            (DataCenter.gI()).aO.a(i, this.cy + 190);
                            (DataCenter.gI()).aO.a = true;
                        }
                        if (this.cL != null) {
                            (DataCenter.gI()).aO.a = false;
                        }
                        break;
                    }
                    int var10001 = this.cx + 60;
                    (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                    (DataCenter.gI()).aO.a = true;
                }
                break;
            case 11:
                var4 = GameSrc.gI().B();
                if ((GameSrc.gI()).idStep >= 0 && (GameSrc.gI()).idStep <= 3 && var4 != null && (Char.gI()).cx == var4.x && (Char.gI()).cy == var4.y) {
                    if (k() != j()) {
                        DataCenter.gI();
                        int var10001 = this.cx + 135;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                        break;
                    }
                    if (this.cL == null) {
                        int[] var5 = this.y.c(383);
                        if (this.cL == null && this.y.arrItemBody[1] == null) {
                            int var10001 = this.cx + var5[0] + 15;
                            (DataCenter.gI()).aO.a(var10001, this.cy + 25 + var5[1] + 15);
                            (DataCenter.gI()).aO.a = true;
                        }
                    }
                }
                break;
            case 15:
                var4 = GameSrc.gI().B();
                if ((GameSrc.gI()).idStep >= 0 && (GameSrc.gI()).idStep <= 3 && var4 != null && (Char.gI()).cx == var4.x && (Char.gI()).cy == var4.y) {
                    if (k() != j()) {
                        DataCenter.gI();
                        int var10001 = this.cx + 135;
                        (DataCenter.gI()).aO.a(var10001, this.cy + 10);
                        (DataCenter.gI()).aO.a = true;
                        break;
                    }
                    if (this.cL == null) {
                        int[] var5 = this.y.c(205);
                        if (this.cL == null && this.y.arrItemBody[1] == null) {
                            int var10001 = this.cx + var5[0] + 15;
                            (DataCenter.gI()).aO.a(var10001, this.cy + 25 + var5[1] + 15);
                            (DataCenter.gI()).aO.a = true;
                        }
                    }
                }
                break;
        }
        if (v()) {
            DataCenter.gI();
            if (this.y.idClass != 0 && this.i > 0) {
                this.b.c[2] = true;
            } else {
                this.b.c[2] = false;
            }
            if (this.y.idClass != 0 && this.v > 0) {
                this.b.c[3] = true;
            } else {
                this.b.c[3] = false;
            }
        }
        for (int var3 = 0; var3 < this.c.length; var3++) {
            this.c[var3].a(true);
        }
    }

    private void w() {
        if (this.S != null) {
            this.S.b(true);
        }
        if (this.T != null) {
            this.T.b(true);
        }
        if (this.U != null) {
            this.U.b(true);
        }
        if (this.k() == 0) {
            switch (this.b.b.b) {
                case 2:
                    DataCenter.gI();
                    this.z();
                    break;
                case 3:
                    this.y();
                    break;
                case 4:
                    if (!isDiscipleUI()) {
                        this.x();
                    }
                default:
                    return;
            }
        } else {
            if (k() == 1) {
                switch (this.O.b.b) {
                    case 0:
                        z();
                        break;
                }
                return;
            }
            if (k() == 2) {
                y();
            }
        }

    }

    private void x() {
        if (isDiscipleUI()) {
            return;
        }
        if (this.P != null && this.P[1] != null) {
            this.P[1].b();
        }
        if (this.y.isMe()) {
            DataCenter.gI();
            if (this.P != null && this.P[1] != null && (this.P[1]).b.b == 1 && this.F >= 0) {
                if (this.S != null) {
                    this.S.b(false);
                }
                if (this.T != null) {
                    this.T.b(false);
                }
                if (this.U != null) {
                    this.U.b(false);
                }
                return;
            }
        } else {
            if (this.S != null) {
                this.S.b(true);
            }
            if (this.T != null) {
                this.T.b(true);
            }
            if (this.U != null) {
                this.U.b(true);
            }
        }
    }

    private void y() {
        this.J = 15;
        if (this.y.idClass != 0 && v()) {
            this.X.b(false);
            this.Y.b(false);
            // Mặc định: dùng mảng skill của nhân vật hiện tại (player)
            Skill[] skills = GameSrc.gI().p;
            boolean isDiscipleUI = GameSrc.gI().manageDisciple && this instanceof LangLa_kl_dt && this.z != null;
            // Nếu đang ở UI đệ tử thì dùng mảng skill riêng của đệ tử (this.z)
            if (isDiscipleUI) {
                skills = this.z;
            }
            if (skills != null && this.a >= 0 && this.a < skills.length) {
                Skill var1 = skills[this.a];
                if (var1 == null) {
                    return;
                }
                // Nút "Bỏ chọn" (Caption.bk) – chỉ bật khi skill đã học và có thể bỏ chọn
                if (var1.level != 0 && var1.c()) {
                    this.X.a(false);
                    // Player: so sánh với Char.ay; Đệ tử: so sánh với discipleFightSkillId
                    if (isDiscipleUI) {
                        LangLa_kl_dt ui = (LangLa_kl_dt) this;
                        if (ui.getDiscipleFightSkillId() > 0 && var1.id == ui.getDiscipleFightSkillId()) {
                            this.X.a(true); // đang là chiêu đánh chính -> chỉ còn "Bỏ chọn"
                        } else {
                            this.X.a(false);
                        }
                    } else if (this.y.ay != null && this.y.ay.idTemplate == var1.idTemplate) {
                        this.X.a(true);
                    } else {
                        this.X.a(false);
                    }
                } else {
                    this.X.a(true);
                }
                // Nút "Chọn / Tăng" (Caption.cP) – giống logic player, áp dụng cho cả đệ tử
                if (this.v <= 0 || var1.level >= (var1.getSkillTemplate()).levelMax
                        || (b(var1.idTemplate, var1.level + 1)).levelNeed > this.y.level()) {
                    this.Y.a(true);
                    return;
                }
                this.Y.a(false);
            } else {
                this.X.a(true);
                this.Y.a(true);
            }
        } else {
            this.X.b(true);
            this.Y.b(true);
        }
    }

    private void z() {
        if (this.P != null && this.P[0] != null) {
            this.P[0].b();
        }
        this.Q.u = true;
        this.R.u = true;
        if (this.d && (this.c[0].e() != this.e || this.c[1].e() != this.f || this.c[2].e() != this.h || this.c[3].e() != this.g)) {
            this.Q.u = false;
            this.R.u = false;
        }
    }

    public void a(int var1) {
        super.a(var1);
        if (this.b != null) {
            this.b.d();
        }
        if (this.O != null) {
            this.O.d();
        }
        if (var1 == 0 && this.b != null) {
            this.b.a(this.b.b.b);
            switch (this.b.b.b) {
                case 0:
                    this.A.b(!this.y.isMe());
                case 1:
                    e(this.b.b.b);
                    return;
                case 2:
                    this.P[0].a();
                    A();
                    return;
                case 4:
                    this.P[1].a();
                    B();
                    break;
            }
            return;
        }
        if (var1 == 1 && this.O != null) {
            this.O.a(this.O.b.b);
            this.O.a(false);
        }
    }

    public void e(int var1) {
        if (var1 == 0) {
            for (int var2 = 0; var2 < this.y.arrItemBody.length; var2++) {
                Item var3;
                if ((var3 = this.y.arrItemBody[var2]) != null && ((var3.isTypeTrangBi() && var3.a(var1, this.y) > 0) || (var3.getItemTemplate()).type == 15)) {
                    var3.c();
                }
            }
        } else if (var1 == 4) {
            for (int var2 = 0; var2 < this.y.arrItemPet.length; var2++) {
                Item var3;
                if ((var3 = this.y.arrItemPet[var2]) != null && var3.isTypeTrangBi() && var3.a(var1, this.y) > 0) {
                    var3.c();
                }
            }
        } else {
            for (int var2 = 0; var2 < this.y.arrItemBody2.length; var2++) {
                Item var3;
                if ((var3 = this.y.arrItemBody2[var2]) != null && ((var3.isTypeTrangBi() && var3.a(var1, this.y) > 0) || (var3.getItemTemplate()).type == 15)) {
                    var3.c();
                }
            }
        }
    }

    private void A() {
        this.P[0].a((this.P[0]).b.b);
        switch ((this.P[0]).b.b) {
            case 0:
                return;
            case 1:
                this.L[this.b.b.b][0].d();
                return;
            case 2:
                this.L[this.b.b.b][1].d();
                return;
            case 3:
                this.L[this.b.b.b][2].d();
                break;
        }
    }

    private void B() {
        this.P[1].a((this.P[1]).b.b);
    }

    private String j(int var1) {
        SkillClan var5;
        if (this.E == 0) {
            var5 = (SkillClan) this.G.elementAt(var1);
        } else {
            var5 = this.H;
        }
        Vector var2;
        (var2 = new Vector()).addElement("c#moc" + var5.name);
        if (var5.detail != null && var5.detail.length() > 0) {
            var2.addElement(var5.detail);
        }
        var2.addElement("c#green" + Caption.cV);
        var2.addElement("c#yellow" + Caption.cW + (var5.levelNeed + 1));
        a(var2, var5);
        Vector<LangLa_lk> var6 = new Vector();
        for (int var4 = 0; var4 < var2.size(); var4++) {
            String str = String.valueOf(var2.elementAt(var4));
            if (var4 == 0) {
                var6.add(new LangLa_lk(0, str));
            } else {
                var6.add(new LangLa_lk(1, str));
            }
        }
        String var3 = "";
        LangLa_lk[] var8 = new LangLa_lk[var6.size()];
        for (int var7 = 0; var7 < var6.size(); var7++) {
            var8[var7] = var6.elementAt(var7);
            var3 = var3 + (var8[var7]).b;
            if (var7 < var8.length - 1) {
                var3 = var3 + "\r\n";
            }
        }
        return var3;
    }

    public Vector c() {
        Vector<LangLa_jz> var1 = super.c();
        if (!v()) {
            var1.removeElementAt(0);
        }
        DataCenter.gI();
        if (k() == 0) {
            int var4;
            var1.addElement(this.b.b());
            switch (this.b.b.b) {
                case 0:
                    // Hiển thị sách kỹ năng chiến đấu cho cả player và đệ tử
                    if (this.ae != null) {
                        var1.addElement(this.ae.a(1090, this));
                    }
                    for (var4 = 0; var4 < (this.K[this.b.b.b]).length; var4++) {
                        var1.addElement(this.K[this.b.b.b][var4].a(1010 + var4, this));
                    }
                    DataCenter.gI();
                    DataCenter.gI();
                    var1.addElement(new LangLa_jz(1028, 130, 155, 170, 165, null, this));
                    break;
                case 1:
                    if (isDiscipleUI()) {
                        // Tab "Thông tin" (đệ tử): chỉ cần list để scroll
                        if (this.L[1] != null && this.L[1][0] != null) {
                            var1.addElement(this.L[1][0].a(1600, this));
                        }
                        return var1;
                    } else {
                        for (var4 = 0; var4 < (this.K[this.b.b.b]).length; var4++) {
                            var1.addElement(this.K[this.b.b.b][var4].a(1020 + var4, this));
                        }
                        return var1;
                    }
                case 2:
                    var1.addElement(this.P[0].c());
                    var1.addElement(this.L[this.b.b.b][(this.P[0]).b.b].a(1200, this));
                    break;
                case 3:
                    if (this.y.isMe() || (!this.y.isMe() && !this.B.a)) {
                        var1.addElement(this.L[3][0].a(1030, this));
                    }
                    break;
                case 4:
                    if (isDiscipleUI()) {
                        // Tab "Khác" trong UI đệ tử: danh sách chức năng trợ thủ
                        if (this.discipleActionList != null) {
                            var1.addElement(this.discipleActionList.a(4100, this));
                        }
                        return var1;
                    }
                    var1.addElement(this.P[1].c());
                    if ((this.P[1]).b.b == 0) {
                        var1.addElement(this.L[this.b.b.b][(this.P[1]).b.b].a(1201, this));
                        break;
                    }
                    if ((this.P[1]).b.b == 1) {
                        Item var2;
                        if ((var2 = this.y.arrItemBody[10]) != null && var2.aa()) {
                            var1.addElement(this.K[this.b.b.b][0].a(1401, this));
                            if (this.H != null) {
                                var1.addElement(this.K[this.b.b.b][1].a(1403, this));
                            }
                        }
                        if (this.L[4][1] != null) {
                            var1.addElement(this.L[4][1].a(1402, this));
                        }
                        break;
                    }
                    if ((this.P[1]).b.b == 2) {
                        Item var2;
                        if ((var2 = this.y.arrItemPet[0]) != null) {
                            var1.addElement(this.K[this.b.b.b][2].a(1501, this));
                            var1.addElement(this.K[this.b.b.b][3].a(1503, this));
                        }
                        if (this.L[4][2] != null) {
                            var1.addElement(this.L[4][2].a(1502, this));
                        }
                    }
                    break;
            }
        }
        return var1;
    }

    public void a(mTextBox var1) {
        if (var1.equals(this.c[0])) {
            mTextBox var10000 = this.c[0];
            int var2 = this.c[0].e() + this.i;
            var10000.o = var2;
        } else if (var1.equals(this.c[1])) {
            mTextBox var10000 = this.c[1];
            int var2 = this.c[1].e() + this.i;
            var10000.o = var2;
        } else if (var1.equals(this.c[2])) {
            mTextBox var10000 = this.c[2];
            int var2 = this.c[2].e() + this.i;
            var10000.o = var2;
        } else if (var1.equals(this.c[3])) {
            mTextBox var10000 = this.c[3];
            int var2 = this.c[3].e() + this.i;
            var10000.o = var2;
        }
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        super.a(var1, var2, var3);
        try {
            Message var5;
            switch (var1) {
                case 1234:
                    (var5 = Message.c((byte) -109)).writeBoolean(this.B.a);
                    var5.send();
                    return;
                case 1235:
                    (var5 = Message.c((byte) -58)).writeByte(this.A.b.b);
                    var5.send();
                    break;
            }
            return;
        } catch (Exception exception) {
        }
    }

    public void b(mTextBox var1) {
        int var2;
        if ((var2 = var1.e()) > var1.o) {
            var1.a("" + var1.o);
        }
        if (var2 < var1.n) {
            var1.a("" + var1.n);
        }
        this.i = this.u - this.c[0].e() - this.e + this.c[1].e() - this.f + this.c[2].e() - this.h + this.c[3].e() - this.g;
    }

    private static Skill b(int var0, int var1) {
        for (int var2 = 0; var2 < (DataCenter.gI()).Skill.length; var2++) {
            if (((DataCenter.gI()).Skill[var2]).idTemplate == var0 && ((DataCenter.gI()).Skill[var2]).level == var1) {
                return (DataCenter.gI()).Skill[var2];
            }
        }
        return null;
    }

    public boolean f(int var1) {
        int var2 = 0;
        for (int var3 = 0; var3 < this.y.arrItemBody.length; var3++) {
            if (this.y.arrItemBody[var3] != null && this.y.arrItemBody[var3].v() && (this.y.arrItemBody[var3]).level >= var1) {
                var2++;
            }
        }
        if (var2 >= 10) {
            return true;
        }
        return false;
    }
}
