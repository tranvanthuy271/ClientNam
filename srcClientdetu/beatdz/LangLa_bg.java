package beatdz;

import com.tgame.model.Caption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

public class LangLa_bg extends LangLa_fn {

    private LangLa_ij[][] o;

    private LangLa_ii[][][] s;

    public LangLa_dz[][][] a;

    private LangLa_vlxx[] t;

    public LangLa_jv[][][] b;

    private LangLa_bh[] u = new LangLa_bh[]{new LangLa_bh(this, 301, 360), new LangLa_bh(this, 241, 300), new LangLa_bh(this, 181, 240), new LangLa_bh(this, 121, 180), new LangLa_bh(this, 61, 120), new LangLa_bh(this, 0, 60)};

    public int c = 0;

    public int d = 50;

    public int e = -1;

    public int f = 0;

    public int g = 0;

    public int h = 0;

    private boolean v;

    private int w = 50;

    private int x = 76;

    private int y;

    private int z;

    private int A;

    public int i;

    public int j;

    private LangLa_dz[] U = new LangLa_dz[2];

    private LangLa_dz[] V = new LangLa_dz[2];

    private LangLa_dz W;

    private LangLa_dz X;

    private int[] ar = new int[]{0, 80, 480, 880, 1880, 3280};

    public PhucLoiTong[] dataPhucLoi;

    public LangLa_bg(MainScreen var1, Message var2) {
        super(var1);
        this.dataPhucLoi = new PhucLoiTong[4];
        this.l = 5;
        a(306, 230);
        LangLa_kd var9;
        (var9 = new LangLa_kd(5000)).c = new String[]{Caption.lp, Caption.my, Caption.mz, Caption.mB, Caption.mA};
        this.o = new LangLa_ij[var9.c.length][];
        this.s = new LangLa_ii[var9.c.length][][];
        this.a = new LangLa_dz[var9.c.length][][];
        this.t = new LangLa_vlxx[var9.c.length];
        this.b = new LangLa_jv[var9.c.length][][];
        a(var9, 170, 55, 5);
        String[][] var3 = {Caption.sH, Caption.sL, Caption.sO, Caption.sN, Caption.sM};
        int var4;
        for (var4 = 0; var4 < this.a.length; var4++) {
            (var9 = new LangLa_kd(1001)).c = var3[var4];
            this.t[var4] = new LangLa_vlxx(var9, this.width, 1, a_() - 3, 87, G() + 6, 33, this);
            this.o[var4] = new LangLa_ij[(this.t[var4]).b.c.length];
            this.s[var4] = new LangLa_ii[(this.t[var4]).b.c.length][];
            this.a[var4] = new LangLa_dz[(this.t[var4]).b.c.length][];
            this.b[var4] = new LangLa_jv[(this.t[var4]).b.c.length][];
        }
        a(var2);
        for (var4 = 0; var4 < this.b.length; var4++) {
            for (int var10 = 0; var10 < (this.b[var4]).length; var10++) {
                int var5 = var10;
                int var12 = var4;
                LangLa_bg var11 = this;
                this.A = -1;
                this.a[var4][var10] = new LangLa_dz[(this.b[var4][var10]).length];
                this.s[var4][var10] = new LangLa_ii[(this.b[var4][var10]).length];
                DataCenter.gI();
                this.o[var4][var10] = new LangLa_ij((byte) 1, this.t[var4].c() + 8, a_() + 11, this.w * 4, this.x * 2, this.x, Utlis.c((this.b[var4][var10]).length, 4), 4);
                this.y = 0;
                this.z = 0;
                int var6 = 0;
                for (int var7 = 0; var7 < (var11.o[var12][var5]).i; var7++) {
                    var11.z = var7 * var11.x;
                    for (int var8 = 0; var8 < (var11.o[var12][var5]).r; var8++) {
                        var11.y = var8 * var11.w;
                        var11.a[var12][var5][var6] = new LangLa_dz(var11.y + 6, var11.z + var11.x - 28, 0, 0, Caption.lq, var11, 1100, 7);
                        var11.a[var12][var5][var6].setSize(35, 20);
                        var11.s[var12][var5][var6] = new LangLa_in((byte) 1, 0, 0, (var11.a[var12][var5][var7]).width, (var11.a[var12][var5][var7]).height, (var11.a[var12][var5][var7]).height, 1, var11.o[var12][var5]);
                        var6++;
                        if (var6 >= (var11.a[var12][var5]).length) {
                            break;
                        }
                    }
                    if (var6 >= (var11.a[var12][var5]).length) {
                        break;
                    }
                }
            }
        }
        H();
        this.X = a(this.width - 14, -7, "", this, 1206, 6);
        for (var4 = 0; var4 <= j(); var4++) {
            a(this.X, var4);
        }
        a(0);
    }

    public void a(Message var1) {
        try {
            Hashtable<Object, Object> var2 = new Hashtable<>();
            Vector<LangLa_jv> vec = new Vector();
            byte size = var1.readByte();
            for (int i = 0; i < size; i++) {
                this.dataPhucLoi[i] = new PhucLoiTong(var1.readUTF());
                int len = var1.readByte();
                for (int k = 0; k < len; k++) {
                    PhucLoi phucLoi = new PhucLoi(var1.readUTF(), new LangLa_jv[]{(LangLa_jv) null});
                    phucLoi.id = var1.readInt();
                    phucLoi.text1 = phucLoi.textGioiThieuGoi = var1.readUTF();
                    String[] strings = phucLoi.text1.split("@");
                    if (strings.length > 1) {
                        phucLoi.text1 = strings[0];
                        phucLoi.text2 = strings[1];
                    }
                    phucLoi.isMuaGoi = var1.readBoolean();
                    byte sizeItem = var1.readByte();
                    for (int m = 0; m < sizeItem; m++) {
                        LangLa_jv var5;
                        (var5 = new LangLa_jv()).a = var1.reader.dis.readShort();
                        var5.b = var1.readUTF();
                        var5.c = var1.reader.dis.readShort();
                        var5.d = new Item();
                        var5.d.read(var1);
                        var5.e = var1.reader.dis.readBoolean();
                        Vector<LangLa_jv> var6;
                        if ((var6 = (Vector) var2.get(Integer.valueOf(var5.c))) == null) {
                            var6 = new Vector();
                        }
                        phucLoi.listLangLa_jv.add(var5);
                        var6.add(var5);
                        var2.put(Integer.valueOf(var5.c), var6);
                        vec.add(var5);
                    }
                    phucLoi.isDaMua = var1.readBoolean();
                    (this.dataPhucLoi[i]).listPhucLoi.add(phucLoi);
                }
            }
            String[] dataSTR = new String[this.dataPhucLoi.length];
            for (int j = 0; j < dataSTR.length; j++) {
                dataSTR[j] = (this.dataPhucLoi[j]).name;
            }
            LangLa_kd var9;
            (var9 = new LangLa_kd(5000)).c = dataSTR;
            this.o = new LangLa_ij[var9.c.length][];
            this.s = new LangLa_ii[var9.c.length][][];
            this.a = new LangLa_dz[var9.c.length][][];
            this.t = new LangLa_vlxx[var9.c.length];
            this.b = new LangLa_jv[var9.c.length][][];
            a(var9, 170, 55, 5);
            for (int var4 = 0; var4 < this.a.length; var4++) {
                (var9 = new LangLa_kd(1001)).c = this.dataPhucLoi[var4].getText();
                this.t[var4] = new LangLa_vlxx(var9, this.width, 1, a_() - 3, 87, G() + 6, 33, this);
                this.o[var4] = new LangLa_ij[(this.t[var4]).b.c.length];
                this.s[var4] = new LangLa_ii[(this.t[var4]).b.c.length][];
                this.a[var4] = new LangLa_dz[(this.t[var4]).b.c.length][];
                this.b[var4] = new LangLa_jv[(this.t[var4]).b.c.length][];
                for (int k = 0; k < (this.b[var4]).length; k++) {
                    this.b[var4][k] = new LangLa_jv[((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).listLangLa_jv.size()];
                    if (((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).isVongXoay) {
                        LangLa_dz vx = a((this.t[var4]).width + (this.width - (this.t[var4]).width) / 2 - 30, (this.t[var4]).cy + (this.height - (this.t[var4]).cy) / 2 - 35, "", this, 1205, 709);
                        a(vx, var4);
                        this.t[var4].a(vx, k);
                    } else {
                        if (((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).isMuaGoi) {
                            ((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn = a(this.width - 74, this.height - 35, Caption.mC, this, 2907, 7);
                            ((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn.setSize(60, 22);
                            a(((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn, var4);
                            this.t[var4].a(((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn, k);
                            if (((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).isDaMua) {
                                ((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn.a = Caption.nh;
                                ((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn.a(true);
                                ((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).btn.d = 9;
                            }
                        }
                        for (int m = 0; m < (this.b[var4][k]).length; m++) {
                            this.b[var4][k][m] = ((PhucLoi) (this.dataPhucLoi[var4]).listPhucLoi.get(k)).listLangLa_jv.get(m);
                        }
                    }
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
        e();
    }

    public static String[] get(Message read) throws IOException {
        String[] data = new String[read.readByte()];
        for (int i = 0; i < data.length; i++) {
            data[i] = read.readUTF();
        }
        return data;
    }

    public void e() {
        boolean var1 = false;
        for (int var2 = 0; var2 < this.b.length; var2++) {
            this.m[var2] = false;
            for (int var3 = 0; var3 < (this.b[var2]).length; var3++) {
                (this.t[var2]).c[var3] = false;
                if (((PhucLoi) (this.dataPhucLoi[var2]).listPhucLoi.get(var3)).isVongXoay && f() > 0) {
                    (this.t[var2]).c[var3] = true;
                    this.m[var2] = true;
                    var1 = true;
                }
                for (int var4 = 0; var4 < (this.b[var2][var3]).length; var4++) {
                    if ((this.b[var2][var3][var4]).e) {
                        (this.t[var2]).c[var3] = true;
                        this.m[var2] = true;
                        var1 = true;
                        break;
                    }
                }
            }
        }
        (GameSrc.gI()).as = var1;
    }

    public void nhanPhucLoi() {
        for (int var2 = 0; var2 < this.b.length; var2++) {
            for (int var3 = 0; var3 < (this.b[var2]).length; var3++) {
                for (int var4 = 0; var4 < (this.b[var2][var3]).length; var4++) {
                    if ((this.b[var2][var3][var4]).e) {
                        try {
                            Message var12;
                            (var12 = Message.c((byte) -70)).writeShort((this.b[var2][var3][var4]).a);
                            var12.send();
                        } catch (Exception exception) {
                        }
                        break;
                    }
                }
            }
        }
    }

    public void a(Graphics var1) {
        super.a(var1);
        this.t[k()].a(var1, -11);
        this.t[k()].a(var1, this.cx, this.cy);
        PhucLoi data = (this.dataPhucLoi[k()]).listPhucLoi.get((this.t[k()]).b.b);
        if (data != null
                && !data.isVongXoay) {
            if (data.isChiTiet) {
                mFont.a(mFont.d, var1, Caption.mK, (this.t[k()]).width + 10, this.height - 36, 0, -7812062, 0);
            }
            if (data.isMuaGoi && data.textGioiThieuGoi.length() > 0) {
                String[] data2 = Utlis.split(data.textGioiThieuGoi, "@");
                for (int i = 0; i < data2.length; i++) {
                    mFont.a(mFont.d, var1, data2[i], (this.t[k()]).width + 10, (this.t[k()]).cy + 20 + 5 + 15 * i, 0, -1, 0);
                }
            } else {
                mFont.a(mFont.d, var1, data.text1, (this.t[k()]).width + 10, this.height - 26, 0, data.color1, 0);
                mFont.a(mFont.d, var1, data.text2, (this.t[k()]).width + 10, this.height - 16, 0, data.color2, 0);
            }
        }
        a(var1, this.o[k()][(this.t[k()]).b.b]);
        e(var1);
        b(var1);
    }

    private void e(Graphics var1) {
        this.y = 0;
        this.z = 0;
        int var2 = 0;
        int var10000 = var1.a;
        var10000 = var1.b;
        for (int var6 = 0; var6 < (this.o[k()][(this.t[k()]).b.b]).i; var6++) {
            this.z = var6 * this.x;
            for (int var7 = 0; var7 < (this.o[k()][(this.t[k()]).b.b]).r; var7++) {
                this.y = var7 * this.w;
                if (this.o[k()][(this.t[k()]).b.b].b(var6)) {
                    LangLa_jv var5 = this.b[k()][(this.t[k()]).b.b][var2];
                    a(var1, this.y, this.z, this.w - 3, this.x - 3, -22, 55, 56);
                    mFont.a(mFont.b, var1, var5.b, this.y + this.w / 2, this.z + 9, 2, -1, -10275328);
                    b(var1, this.y + 9, this.z + 16, var5.d, (this.A == var2));
                    int var3 = var1.a;
                    int var4 = var1.b;
                    a(var1, var3 + (this.a[k()][(this.t[k()]).b.b][var2]).cx, var4 + (this.a[k()][(this.t[k()]).b.b][var2]).cy);
                    this.a[k()][(this.t[k()]).b.b][var2].a(!var5.e);
                    this.a[k()][(this.t[k()]).b.b][var2].a(var1);
                    a(var1, var3, var4);
                }
                var2++;
                if (var2 >= (this.a[k()][(this.t[k()]).b.b]).length) {
                    break;
                }
            }
            if (var2 >= (this.a[k()][(this.t[k()]).b.b]).length) {
                break;
            }
        }
    }

    public void a(int var1) {
        super.a(var1);
        this.t[k()].a((this.t[k()]).b.b);
    }

    public void b() {
        this.t[k()].a();
        this.o[k()][(this.t[k()]).b.b].a();
        for (int var1 = 0; var1 < (this.a[k()][(this.t[k()]).b.b]).length; var1++) {
            this.a[k()][(this.t[k()]).b.b][var1].b();
            this.s[k()][(this.t[k()]).b.b][var1].a();
            if ((this.s[k()][(this.t[k()]).b.b][var1]).l != -1) {
                (this.a[k()][(this.t[k()]).b.b][var1]).h = true;
            } else {
                (this.a[k()][(this.t[k()]).b.b][var1]).h = false;
            }
        }
        if (this.v) {
            this.f++;
            this.c += this.d;
            if (this.c >= 360) {
                this.c = 0;
            }
            if (this.f % 5 == 0 && this.e >= 0) {
                this.d -= 5;
                if (this.d < 5) {
                    this.d = 5;
                    LangLa_bh var3 = this.u[this.e];
                    if (this.c - this.g >= var3.a && this.c <= var3.b) {
                        this.v = false;
                        if (this.j > 0) {
                            String var4 = Caption.k + " " + Utlis.numberFormat(this.j) + " " + Caption.rs[1];
                            (DataCenter.gI()).currentScreen.showMessage(var4, -2560);
                            this.j = 0;
                        }
                    }
                }
            }
        }
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
    }

    public Vector c() {
        Vector<LangLa_jz> var1 = super.c();
        for (int var4 = 0; var4 < (this.b[k()][(this.t[k()]).b.b]).length; var4++) {
            int var2 = (this.o[k()][(this.t[k()]).b.b]).cx + (this.a[k()][(this.t[k()]).b.b][var4]).cx;
            int var3 = (this.o[k()][(this.t[k()]).b.b]).cy + (this.a[k()][(this.t[k()]).b.b][var4]).cy - (this.o[k()][(this.t[k()]).b.b]).f;
            if (Utlis.inRange((this.o[k()][(this.t[k()]).b.b]).cx, (this.o[k()][(this.t[k()]).b.b]).cy, (this.o[k()][(this.t[k()]).b.b]).cx + (this.o[k()][(this.t[k()]).b.b]).width, (this.o[k()][(this.t[k()]).b.b]).cy + (this.o[k()][(this.t[k()]).b.b]).height, var2, var3) && Utlis.inRange((this.o[k()][(this.t[k()]).b.b]).cx, (this.o[k()][(this.t[k()]).b.b]).cy, (this.o[k()][(this.t[k()]).b.b]).cx + (this.o[k()][(this.t[k()]).b.b]).width, (this.o[k()][(this.t[k()]).b.b]).cy + (this.o[k()][(this.t[k()]).b.b]).height, var2 + (this.a[k()][(this.t[k()]).b.b][var4]).width, var3 + (this.a[k()][(this.t[k()]).b.b][var4]).height)) {
                (this.s[k()][(this.t[k()]).b.b][var4]).cx = (short) var2;
                (this.s[k()][(this.t[k()]).b.b][var4]).cy = (short) var3;
                var1.addElement(new LangLa_jz(2000, (this.s[k()][(this.t[k()]).b.b][var4]).cx, (this.s[k()][(this.t[k()]).b.b][var4]).cy, (this.s[k()][(this.t[k()]).b.b][var4]).cx + (this.s[k()][(this.t[k()]).b.b][var4]).width, (this.s[k()][(this.t[k()]).b.b][var4]).cy + (this.s[k()][(this.t[k()]).b.b][var4]).height, this.s[k()][(this.t[k()]).b.b][var4], this, this.b[k()][(this.t[k()]).b.b][var4]));
                var1.addElement(new LangLa_jz(3000, var2 + 3, var3 - 32, var2 + 3 + 28, var3 - 32 + 28, this.o[k()][(this.t[k()]).b.b], this, Integer.valueOf(var4)));
            }
        }
        if (((PhucLoi) (this.dataPhucLoi[k()]).listPhucLoi.get((this.t[k()]).b.b)).isVongXoay) {
            DataCenter.gI();
            var1.addElement(new LangLa_jz(1207, (this.t[k()]).width + 7, this.height - 60, (this.t[k()]).width + 47, this.height - 49, (LangLa_ii) null, this));
        } else if (((PhucLoi) (this.dataPhucLoi[k()]).listPhucLoi.get((this.t[k()]).b.b)).isChiTiet) {
            var1.addElement(new LangLa_jz(1204, (this.t[k()]).width + 7, this.height - 36 - 6, (this.t[k()]).width + 47, this.height - 25 - 6, (LangLa_ii) null, this));
        }
        var1.addElement(this.t[k()].b());
        var1.addElement(new LangLa_jz(1002, (this.o[k()][(this.t[k()]).b.b]).cx, (this.o[k()][(this.t[k()]).b.b]).cy, (this.o[k()][(this.t[k()]).b.b]).cx + (this.o[k()][(this.t[k()]).b.b]).width, (this.o[k()][(this.t[k()]).b.b]).cy + (this.o[k()][(this.t[k()]).b.b]).height, this.o[k()][(this.t[k()]).b.b], this));
        return var1;
    }

    public void a(int var1, Object var2) {
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (!this.v) {
            LangLa_bg var11;
            LangLa_jv var10;
            super.a(var1, var2, var3);
            this.A = -1;
            switch (var1.b) {
                case 2907:
                    (DataCenter.gI()).currentScreen.a("Ghhoa: " + Utlis.numberFormat(10000) + " v--- Cht" + Utlis.numberFormat(30000) + " v", Caption.bz, 2908, 2909, this);
                    break;
                case 2908:
          try {
                    PhucLoi data = (this.dataPhucLoi[k()]).listPhucLoi.get((this.t[k()]).b.b);
                    Message m = Message.c((byte) -66);
                    m.writeInt(data.id);
                    m.send();
                } catch (Exception var8) {
                    return;
                }
                break;
                case 1001:
                    if (var1.j.k >= 0) {
                        this.t[k()].a(var1.j.k);
                        return;
                    }
                    break;
                case 1200:
          try {
                    Message.c((byte) -66).send();
                } catch (Exception var8) {
                    return;
                }
                break;
                case 1201:
          try {
                    Message.c((byte) -65).send();
                } catch (Exception var7) {
                    return;
                }
                break;
                case 1202:
          try {
                    Message.c((byte) -63).send();
                } catch (Exception var6) {
                    return;
                }
                break;
                case 1203:
          try {
                    Message.c((byte) -62).send();
                } catch (Exception var5) {
                    return;
                }
                break;
                case 1204:
                    this.cL = a(((PhucLoi) (this.dataPhucLoi[k()]).listPhucLoi.get((this.t[k()]).b.b)).textChiTiet, this, (this.t[k()]).width + 45, this.height - 124, 200);
                    return;
                case 1205:
                    var11 = this;
                    break;
                case 1206:
                    J();
                    return;
                case 1207:
                    this.cL = a(((this.dataPhucLoi[k()]).listPhucLoi.get((this.t[k()]).b.b)).textChiTietVongXoay, this, (this.t[k()]).width + 45, this.height - 160, 220);
                    break;
                case 2000:
                    var10 = (LangLa_jv) var1.k;
                    try {
                        if (var10.e) {
                            Message var12;
                            (var12 = Message.c((byte) -70)).writeShort(var10.a);
                            var12.send();
                        }
                    } catch (Exception var9) {
                        return;
                    }
                    break;
                case 3000:
                    this.A = ((Integer) var1.k).intValue();
                    this.cL = a(this, var2, var3, 28, (this.b[k()][(this.t[k()]).b.b][this.A]).d);
                    return;
            }
        }
    }

    private int f() {
        return 0;
    }

    public static class PhucLoiTong {

        public ArrayList<LangLa_bg.PhucLoi> listPhucLoi = new ArrayList<>();

        public String name;

        private PhucLoiTong(String pL1) {
            this.name = pL1;
        }

        private String[] getText() {
            String[] data = new String[this.listPhucLoi.size()];
            for (int i = 0; i < data.length; i++) {
                data[i] = ((LangLa_bg.PhucLoi) this.listPhucLoi.get(i)).name;
            }
            return data;
        }
    }

    public static class PhucLoi {

        public int id;

        public ArrayList<LangLa_jv> listLangLa_jv = new ArrayList<>();

        public String name;

        public int color1 = -1;

        public String text1 = Utlis.nextUTF(15);

        public int color2 = -1;

        public String text2 = "";

        public boolean isVongXoay;

        public boolean isChiTiet = false;

        public String textChiTiet = Utlis.nextUTF(105);

        public boolean isMuaGoi = true;

        public String textGioiThieuGoi = "";

        public boolean isDaMua = false;

        public LangLa_dz btn;

        public int idOrder = (new Random()).nextInt();

        private int idVongXoay = (new Random()).nextInt();

        private String textChiTietVongXoay = Caption.nj;

        private PhucLoi(String ph, LangLa_jv... object) {
            this.name = ph;
            if (object != null && (object.length != 1 || object[0] != null)) {
                this.listLangLa_jv.addAll(Arrays.asList(object));
            }
        }

        private PhucLoi(String ph, String text) {
            this.name = ph;
            this.isMuaGoi = true;
            this.textGioiThieuGoi = text;
        }
    }
}
