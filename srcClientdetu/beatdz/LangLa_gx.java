/*
 * Decompiled with CFR 0.152.
 */
package beatdz;

import beatdz.Binary2;
import beatdz.DataCenter;
import beatdz.Graphics;
import beatdz.LangLa_cl;
import beatdz.LangLa_cs;
import beatdz.LangLa_cx;
import beatdz.LangLa_cz;
import beatdz.LangLa_dz;
import beatdz.LangLa_gw;
import beatdz.LangLa_ii;
import beatdz.LangLa_jz;
import beatdz.LangLa_kd;
import beatdz.Utlis;
import beatdz.mFont;
import beatdz.mTextBox;
import java.util.Vector;

public class LangLa_gx
extends LangLa_cz {
    public LangLa_ii a;
    public LangLa_kd b;
    private LangLa_gw e;
    private Vector[] f;
    private LangLa_cx g;
    private short h = (short)307;
    private int i;
    private String[][] j;
    public boolean[] c;
    public boolean[] d;

    public LangLa_gx(LangLa_kd var1, int var2, int var3, int var4, int var5, int var6, int var7, LangLa_cx var8) {
        boolean var10 = false;
        int var16 = 33;
        int var15 = 87;
        int var13 = 1;
        LangLa_kd var12 = var1;
        LangLa_gx var11 = this;
        this.setXY(var13, var4);
        DataCenter.gI();
        this.setSize(this.width, var6);
        this.i = var2;
        this.g = var8;
        this.b = var1;
        var7 = var1.c.length * var16 > var6 - 20 ? (var6 - 20) / var16 * var16 : var1.c.length * var16;
        DataCenter.gI();
        int tabWidth = 58;
        int totalTabWidth = var1.c.length * tabWidth;
        this.a = new LangLa_ii((byte) 0, 3, 2, totalTabWidth, 20, tabWidth, var1.c.length);
        this.e = new LangLa_gw(0, 0, 0, 2, (byte) 7, var1.c.length);
        this.f = new Vector[var1.c.length];
        this.j = new String[var1.c.length][];
        this.c = new boolean[var1.c.length];
        this.d = new boolean[var1.c.length];
        for (var3 = 0; var3 < var11.f.length; ++var3) {
            var11.f[var3] = new Vector();
            String[] var14 = var12.c[var3].trim().split(" ");
            if (var14.length >= 3 && !var12.c[var3].contains("\n")) {
                String[] var10002;
                StringBuilder var10000;
                var11.j[var3] = new String[2];
                if (var14.length >= 4) {
                    var11.j[var3][0] = var14[0] + " " + var14[1];
                    var11.j[var3][1] = "";
                    for (var5 = 2; var5 < var14.length; ++var5) {
                        var10000 = new StringBuilder();
                        var10002 = var11.j[var3];
                        var10002[1] = var10000.append(var10002[1]).append(var14[var5]).append(" ").toString();
                    }
                    var11.j[var3][1] = var11.j[var3][1].trim();
                    continue;
                }
                var11.j[var3][0] = var14[0];
                var11.j[var3][1] = "";
                for (var5 = 1; var5 < var14.length; ++var5) {
                    var10000 = new StringBuilder();
                    var10002 = var11.j[var3];
                    var10002[1] = var10000.append(var10002[1]).append(var14[var5]).append(" ").toString();
                }
                var11.j[var3][1] = var11.j[var3][1].trim();
                continue;
            }
            var11.j[var3] = mFont.c(mFont.e, var12.c[var3], var15 - 10);
        }
    }

    public void a() {
        this.a.a();
        this.e.a();
    }

    public LangLa_jz b() {
        return this.a.a(this.b.a, this.cx, this.cy, this.g);
    }

    public int c() {
        return this.cx + this.width;
    }

    public void a(int var1) {
        if (!this.d[var1]) {
            this.b.b = var1;
            for (var1 = 0; var1 < this.f.length; ++var1) {
                for (int var2 = 0; var2 < this.f[var1].size(); ++var2) {
                    this.g.cG.removeElement(this.f[var1].elementAt(var2));
                }
            }
            for (var1 = 0; var1 < this.f[this.b.b].size(); ++var1) {
                this.g.cG.addElement(this.f[this.b.b].elementAt(var1));
            }
        }
    }

    public void a(Graphics var1, int var2) {
        DataCenter.gI();
        int var3 = var1.a;
        int var4 = var1.b;
        this.a(var1, this.g.cx + this.cx + 2, this.g.cy + this.cy);
        this.a(var1, (int)this.cx, this.cy - 2, this.i - this.cx - 5, this.height - 32, var2, 55, 56);
        if (this.b.c.length * this.a.h <= this.width - 4) {
            Binary2.a(var1, 24, 0, 2 + this.b.b * this.a.h, 2, this.a.h, 20, 20, 20);
            Binary2.a(var1, 60, 0, 2, 2, this.width - 4, 20, 20, 20);
        }
        Utlis.a(var1, this.width + 292, 23);
        if (!this.e.a && this.b.c.length * this.a.h <= this.width - 4) {
            this.a.b(var1, this.g.cx + this.cx, this.g.cy + this.cy, this.a.width, this.a.height);
        } else {
            this.a.a(var1, this.g.cx + this.cx, this.g.cy + this.cy, this.a.width, this.a.height);
            if (this.b.c.length * this.a.h > this.width - 4) {
                Binary2.a(var1, 24, 0, this.b.b * this.a.h, 0, this.a.h, 20, 20, 20);
                Binary2.a(var1, 60, 0, 0, 0, this.b.c.length * this.a.h, 20, 20, 20);
            }
        }
        for (int var5 = 0; var5 < this.a.i; ++var5) {
            if (!this.a.b(var5)) continue;
            String var6 = this.b.c[var5];
            if (var5 == this.b.b) {
                mFont.b(mFont.e, var1, var6, 1 + var5 * this.a.h + this.a.h / 2 - 1, 11 + this.e.b(var5) - 2, 2, -2560, -11184811);
                continue;
            }
            if (var5 == this.a.l) {
                mFont.b(mFont.e, var1, var6, 1 + var5 * this.a.h + this.a.h / 2, 12 + this.e.b(var5) - 2, 2, -1, -11184811);
                continue;
            }
            mFont.b(mFont.e, var1, var6, 1 + var5 * this.a.h + this.a.h / 2 - 1, 11 + this.e.b(var5) - 2, 2, -1, -11184811);
        }
        if (this.e.a || this.b.c.length * this.a.h > this.width - 4) {
            this.a(var1, 0, 0);
            var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
        }
        this.a(var1, var3, var4);
    }

    public void a(LangLa_cs var1, int var2) {
        this.f[var2].addElement(var1);
    }

    public void a(Vector var1, int var2) {
        for (int var3 = 0; var3 < var1.size(); ++var3) {
            this.f[var2].addElement((LangLa_cs)var1.elementAt(var3));
        }
    }

    public void d() {
        for (int var1 = 0; var1 < this.f.length; ++var1) {
            for (int var2 = 0; var2 < this.f[var1].size(); ++var2) {
                this.g.cG.removeElement(this.f[var1].elementAt(var2));
            }
        }
    }

    public void a(boolean var1) {
        for (int var3 = 0; var3 < this.f.length; ++var3) {
            for (int var4 = 0; var4 < this.f[var3].size(); ++var4) {
                LangLa_cs var2 = (LangLa_cs)this.f[var3].elementAt(var4);
                if (var2 instanceof LangLa_dz) {
                    ((LangLa_dz)var2).b(var1);
                    continue;
                }
                if (var2 instanceof mTextBox) {
                    var2.a(var1);
                    continue;
                }
                if (!(var2 instanceof LangLa_cl)) continue;
                var2.b(var1);
            }
        }
    }
}

