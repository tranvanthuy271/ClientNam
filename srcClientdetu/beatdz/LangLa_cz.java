/*
 * Decompiled with CFR 0.152.
 */
package beatdz;

import beatdz.Binary;
import beatdz.Binary2;
import beatdz.DataCenter;
import beatdz.GameSrc;
import beatdz.Graphics;
import beatdz.Item;
import beatdz.LangLa_cb;
import beatdz.LangLa_cx;
import beatdz.LangLa_da;
import beatdz.LangLa_db;
import beatdz.LangLa_ep;
import beatdz.LangLa_fb;
import beatdz.LangLa_fe;
import beatdz.LangLa_fg;
import beatdz.LangLa_fh;
import beatdz.LangLa_fq;
import beatdz.LangLa_hx;
import beatdz.LangLa_ij;
import beatdz.LangLa_jz;
import beatdz.LangLa_kd;
import beatdz.LangLa_kn;
import beatdz.LangLa_mk;
import beatdz.LangLa_mq;
import beatdz.LangLa_u;
import beatdz.Utlis;
import beatdz.XYEntity;
import beatdz.mFont;
import beatdz.mImage;
import java.util.Vector;

public class LangLa_cz
extends XYEntity {
    public short width;
    public short height;
    public int cS = 0;
    private int a;
    private String b;
    private boolean c;
    public static Object cT = new Object();
    public static Object cU = new Object();
    public static Vector cV = new Vector();
    public static Vector cW = new Vector();
    public static Vector cX = new Vector();
    public static boolean cY;
    public static boolean cZ;
    private int d = 0;
    private int e = 0;
    private int f = 10;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void S() {
        if (!LangLa_ep.a()) {
            if (!cY) {
                LangLa_cz.a();
            }
        } else {
            while (true) {
                if (cW.size() <= 0) {
                    while (cX.size() > 0) {
                        LangLa_cz.b((LangLa_fb)cX.remove(0));
                    }
                    break;
                }
                LangLa_cz.a((LangLa_fb)cW.remove(0));
            }
        }
        Object object = cT;
        synchronized (object) {
            cT.notify();
        }
    }

    private static void a() {
        cY = true;
        new Thread(new LangLa_da()).start();
        new Thread(new LangLa_db()).start();
        new Thread(new LangLa_fg()).start();
    }

    public void setSize(int var1, int var2) {
        this.width = (short)var1;
        this.height = (short)var2;
    }

    public void a(Graphics var1, int var2, int var3) {
        var1.a(-var1.a, -var1.b);
        var1.a(var2, var3);
    }

    public void a(Graphics var1, int var2, int var3, int var4, int var5, String var6, byte var7) {
        this.a(var1, var2, var3, var4, var5, var6, (byte)2, false);
        if (this.cS >= 2) {
            var2 = var1.a;
            var3 = var1.b;
            this.a(var1, 6, 33, var4 - 12, var5 - 27 - 12, -11, 55, 56);
            this.a(var1, var2, var3);
        }
    }

    public void a(Graphics var1, int var2, int var3, int var4, int var5, String var6, byte var7, boolean var8) {
        int var9 = var1.a;
        int var10 = var1.b;
        this.b = var6;
        this.a = var7;
        this.c = var8;
        this.a(var1, var2, var3);
        Binary2.a(var1, LangLa_fq.a(643), 20, 5, var4 - 6, var5 - 6, 0, 3, 3, (var4 - 6) * DataCenter.gI().zoomLevel, (var5 - 6) * DataCenter.gI().zoomLevel, 20);
        Binary2.a(var1, LangLa_fq.a(645), 0, 0, 5, 5, 0, 0, 5, 5 * DataCenter.gI().zoomLevel, (var5 - 10) * DataCenter.gI().zoomLevel, 20);
        Binary2.a(var1, LangLa_fq.a(645), 0, 0, 5, 5, 180, var4, 5, 5 * DataCenter.gI().zoomLevel, (var5 - 10) * DataCenter.gI().zoomLevel, 24);
        Binary2.a(var1, LangLa_fq.a(646), 0, 0, 5, 5, 0, 20, 0, (var4 - 40) * DataCenter.gI().zoomLevel, 5 * DataCenter.gI().zoomLevel, 20);
        Binary2.a(var1, LangLa_fq.a(646), 0, 0, 5, 5, 180, 20, var5, (var4 - 40) * DataCenter.gI().zoomLevel, 5 * DataCenter.gI().zoomLevel, 36);
        LangLa_fq.a(var1, 644, -180, 0, var5 - 20, 20);
        LangLa_fq.a(var1, 644, 180, var4 - 20, var5 - 20, 20);
        LangLa_fq.a(var1, 644, -360, var4 - 20, 0, 20);
        LangLa_fq.a(var1, 644, 0, 0, 0, 20);
        if (var7 == 2) {
            mFont.a(mFont.f, var1, var6, var4 / 2, 15, 2, -2560, 0);
        } else if (var7 == 0) {
            mFont.a(mFont.f, var1, var6, 10, 15, 0, -2560, 0);
        }
        var1.c();
        this.a(var1, var9, var10);
    }

    public void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
        int var11 = var1.a;
        int var12 = var1.b;
        var1.a(var2, var3);
        Binary2.a(var1, var6, 0, var9, var10, var4 - var9 * 2, var5 - var10 * 2);
        Binary2.a(var1, var8, 0, 6, 0, var4 - 12, 20);
        Binary2.a(var1, var8, 180, 6, var5 - 20, var4 - 12, 20);
        Binary2.a(var1, var8, -90, 0, 6, 20, var5 - 12);
        Binary2.a(var1, var8, 90, var4 - 20, 6, 20, var5 - 12);
        LangLa_fq.a(var1, var7, 0, 0, 0, 20);
        LangLa_fq.a(var1, var7, -360, var4, 0, 24);
        LangLa_fq.a(var1, var7, -180, 0, var5, 36);
        LangLa_fq.a(var1, var7, 180, var4, var5, 40);
        this.a(var1, var11, var12);
    }

    public void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        this.a(var1, var2, var3, var4, var5, var6, var7, var8, 3, 3);
    }

    public void b(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        var2 = var1.a;
        var3 = var1.b;
        var1.a(0, 0);
        Binary2.a(var1, 314, 0, 2, 2, var4 - 3, var5 - 3);
        var1.f(-11657441);
        var1.b(0, 0, var4 - 1, var5 - 1);
        var1.f(-9490898);
        var1.b(1, 1, var4 - 3, var5 - 3);
        this.a(var1, var2, var3);
    }

    public static void a(Graphics var0, int var1, int var2, String var3, byte var4) {
        var1 = var1 + mFont.b(mFont.d, var3) + 5;
        switch (var4) {
            case 0: 
            case 1: {
                LangLa_fq.a(var0, 35, 0, var1 + 1, var2 - 7, 0);
                break;
            }
            case 2: 
            case 3: {
                LangLa_fq.a(var0, 25, 0, var1, var2 - 6, 0);
                break;
            }
            case 4: {
                LangLa_fq.a(var0, 234, 0, var1 - 3, var2 - 6, 0);
                break;
            }
            case 5: {
                LangLa_fq.a(var0, 842, 0, var1 - 3, var2 - 6, 0);
                break;
            }
            case 6: {
                LangLa_fq.a(var0, 377, 0, var1 - 3, var2 - 6, 0);
                break;
            }
            case 7: {
                LangLa_fq.a(var0, 842, 0, var1 - 3, var2 - 6, 0);
            }
        }
        switch (var4) {
            case 1: 
            case 5: {
                LangLa_fq.a(var0, 44, 0, var1 + 10, var2, 0);
                return;
            }
            case 3: {
                LangLa_fq.a(var0, 44, 0, var1 + 10, var2 - 1, 0);
            }
        }
    }

    public static void a(Graphics var0, int var1, int var2, Item var3, boolean var4, int var5) {
        LangLa_cz.a(var0, var1, var2, var3, var4, true, var5, null);
    }

    public static void a2(Graphics var0, int var1, int var2, Item var3, boolean var4, int var5) {
        LangLa_cz.a(var0, var1, var2, var3, var4, true, var5, null);
    }

    public static void a(Graphics var0, int var1, int var2, Item var3, boolean var4, String var5) {
        LangLa_cz.a(var0, var1, var2, var3, var4, true, -1, var5);
    }

    public static void a(Graphics var0, int var1, int var2, Item var3, boolean var4) {
        LangLa_cz.a(var0, var1, var2, var3, var4, true, -1, null);
    }

    public static void b(Graphics var0, int var1, int var2, Item var3, boolean var4) {
        LangLa_cz.a(var0, var1, var2, var3, var4, false, -1, null);
    }

    public static void b(Graphics var0, int var1, int var2, Item var3, boolean var4, String var5) {
        LangLa_cz.a(var0, var1, var2, var3, var4, false, -1, var5);
    }

    private static void a(Graphics var0, int var1, int var2, Item var3, boolean var4, boolean var5, int var6, String var7) {
        LangLa_fq.a(var0, 53, 0, var1, var2, 0);
        if (var6 >= 0 && var3 == null) {
            LangLa_fq.a(var0, var6, 0, var1 + 14, var2 + 14, 3);
        }
        if (var3 == null && var7 != null) {
            String[] var8 = Utlis.split(var7, " ");
            if (var8.length >= 2) {
                mFont.a(mFont.b, var0, var8[0], var1 + 14, var2 + 10, 2, -1, -10275328);
                mFont.a(mFont.b, var0, var8[1], var1 + 14, var2 + 18, 2, -1, -10275328);
            } else {
                mFont.a(mFont.b, var0, var8[0], var1 + 14, var2 + 14, 2, -1, -10275328);
            }
        }
        int var9 = var0.a;
        var6 = var0.b;
        if (var3 != null) {
            var0.a(-var0.a + var9 + var1 + 14, -var0.b + var6 + var2 + 15);
            var3.a(var0);
        }
        var0.a(-var0.a + var9, -var0.b + var6);
        if (var3 != null) {
            if (var3.getAmount() > 1) {
                if (var3.getAmount() >= 1000000000) {
                    mFont.d(mFont.b, var0, var3.getAmount() / 1000000 + "M", var1 + 26, var2 + 23, 1, -1, -10275328);
                } else if (var3.getAmount() >= 1000000) {
                    mFont.d(mFont.b, var0, var3.getAmount() / 1000 + "K", var1 + 26, var2 + 23, 1, -1, -10275328);
                } else {
                    mFont.d(mFont.b, var0, "" + var3.getAmount(), var1 + 26, var2 + 23, 1, -1, -10275328);
                }
            }
            if (var3.isLock) {
                Binary2.a(var0, 44, 0, var1 + 3, var2 + 3, 6, 7);
            }
        }
        if (var3 != null) {
            if (var3.level > 0 && var3.level < 8 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -1, -10275328);
            } else if (var3.level >= 8 && var3.level < 12 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -26215, -10275328);
            } else if (var3.level >= 12 && var3.level < 14 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -16777077, -10275328);
            } else if (var3.level >= 14 && var3.level < 16 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -16711936, -10275328);
            } else if (var3.level == 16 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -256, -10275328);
            } else if (var3.level == 17 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -8388480, -10275328);
            } else if (var3.level == 18 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -65536, -10275328);
            } else if (var3.level == 19 && var3.isTypeTrangBi()) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -16711681, -10275328);
            } else if (var3.level > 19) {
                mFont.a(mFont.b, var0, "+" + var3.level, var1 + 26 - 4, var2 + 23, 2, -4351915, -10275328);
            }
        }
        if (var4) {
            var0.f(-1);
            var0.b(var1, var2, 28, 28);
        }
    }

    public static LangLa_hx a(String var0, LangLa_cx var1, int var2, int var3, int var4) {
        LangLa_hx var5 = new LangLa_hx(var2, var3, var4, var1, var0);
       if ((var5 = new LangLa_hx(var2, var3, var4, var1, var0)).cx > DataCenter.gI().widthScreen - var5.width - var1.cx) {
         var5.cx = (short)(DataCenter.gI().widthScreen - var5.width - var1.cx);
      }

        if (var5.cx < var2) {
            var5.cx = (short)(var2 - (var5.width + 3));
        }
        if (var5.cx < -var1.cx) {
            var5.cx = (short) -var1.cx;
        }
        if (var5.cy > DataCenter.gI().heightScreen - var5.height - var1.cy) {
            var5.cy = (short)(DataCenter.gI().heightScreen - var5.height - var1.cy);
        }
        var1.a(var5);
        return var5;
    }

    public static LangLa_fe a(String var0, String var1, LangLa_cx var2, int var3, int var4) {
        LangLa_fe var5 = new LangLa_fe(var3, var4, var2, var0, var1);
        var2.a(var5);
        return var5;
    }

    public static LangLa_cb b(String var0, LangLa_cx var1, int var2, int var3, int var4) {
        LangLa_cb var5 = new LangLa_cb(var2, var3, var1, var0);
        if (var5.cx > DataCenter.gI().widthScreen - var5.width - var1.cx) {
            var5.cx = (short)(DataCenter.gI().widthScreen - var5.width - var1.cx);
        }
        if (var5.cx < var2 - var4 / 2) {
            var5.cx = (short)(var2 - (var5.width + var4 + 3));
        }
        if (var5.cx < -var1.cx) {
            var5.cx =  (short)-var1.cx;
        }
        if (var5.cy > DataCenter.gI().heightScreen - var5.height - var1.cy) {
            var5.cy = (short)(DataCenter.gI().heightScreen - var5.height - var1.cy);
        }
        var1.a(var5);
        return var5;
    }

    public static LangLa_kn a(LangLa_cx var0, int var1, int var2, LangLa_kd var3) {
        LangLa_kn var4 = new LangLa_kn(var1, var2, var0, var3);
        if (var4.cx > DataCenter.gI().widthScreen - var4.width - var0.cx) {
            var4.cx = (short)(DataCenter.gI().widthScreen - var4.width - var0.cx);
        }
        if (var4.cx < -var0.cx) {
            var4.cx = (short) -var0.cx;
        }
        if (var4.cy > DataCenter.gI().heightScreen - var4.height - var0.cy) {
            var4.cy = (short)(DataCenter.gI().heightScreen - var4.height - var0.cy);
        }
        var0.a(var4);
        return var4;
    }

    public static LangLa_mq a(LangLa_cx var0, int var1, int var2, int var3, Item var4) {
        if (var4 == null) {
            return null;
        }
        LangLa_mk var6 = new LangLa_mk(var1, var2, 1044, var0, var4);
        if (var6.cx > DataCenter.gI().widthScreen - var6.width - var0.cx) {
            var6.cx = (short)(var1 - var3 - 3 - var6.width);
        } else if (var6.cx < var1 - var3 / 2) {
            var6.cx = (short)(var1 - (var6.width + 3));
        }
        if (var6.cx < -var0.cx) {
            var6.cx = (short) -var0.cx;
        }
        if (var6.cy > DataCenter.gI().heightScreen - var6.height - var0.cy) {
            var6.cy = (short)(DataCenter.gI().heightScreen - var6.height - var0.cy);
        }
        LangLa_mq var5 = new LangLa_mq(var1 - 32, var2 + 32, var6);
        var0.a(var5);
        return var5;
    }

    public static LangLa_mq a(LangLa_jz var0, LangLa_cx var1, Item var2) {
        if (var2 == null) {
            return null;
        }
        LangLa_ij var5 = (LangLa_ij)var0.j;
        if (var5.k >= 0 && var5.k < var5.i * var5.r) {
            var5.d();
            int var3 = var5.k % var5.r;
            int var4 = var5.k / var5.r - (var5.j >= 0 ? var5.j : 0);
            if (var5.n == 0) {
                var3 = var5.k % var5.i - (var5.j >= 0 ? var5.j : 0);
                var4 = var5.k / var5.i;
            }
            var3 = var3 * var5.h + var5.h + var5.cx;
            var4 = var4 * var5.h + var5.cy;
            return LangLa_cz.a(var1, var3, var4, var5.h, var2);
        }
        return null;
    }

    public static LangLa_mq b(LangLa_jz var0, LangLa_cx var1, Item var2) {
        if (var2 == null) {
            return null;
        }
        LangLa_ij var5 = (LangLa_ij)var0.j;
        if (var5.k >= 0) {
            var5.d();
            int var3 = var5.k % var5.r;
            int var4 = var5.k / var5.r - (var5.j >= 0 ? var5.j : 0);
            if (var5.n == 0) {
                var3 = var5.k % var5.i - (var5.j >= 0 ? var5.j : 0);
                var4 = var5.k / var5.i;
            }
            var3 = var3 * var5.h + var5.h + var5.cx;
            var4 = var4 * var5.h + var5.cy;
            return LangLa_cz.a(var1, var3, var4, var5.h, var2);
        }
        return null;
    }

    public static void a(LangLa_fb var0) {
        mImage var1 = null;
        try {
            var1 = Binary.createImage(var0.e);
            if (var1 != null) {
                var0.g.put(var0.a, var1);
                return;
            }
            cX.add(var0);
        }
        catch (Exception var4) {
            return;
        }
        finally {
            if (var1 != null) {
                GameSrc.gI().cb.add(var1);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void b(LangLa_fb var0) {
        mImage var1 = null;
        try {
            DataCenter.gI();
            if (!DataCenter.a()) {
                return;
            }
            StringBuilder var10000 = new StringBuilder().append(DataCenter.gI().aU).append(DataCenter.gI().aY);
            DataCenter.gI();
            String assetPath = DataCenter.gI().aY + (DataCenter.a(var0.d) + 1) + "/" + var0.d;
            String url = var10000.append(DataCenter.a(var0.d) + 1).append("/").append(var0.d).toString();
            byte[] var2 = Binary.b(url);
            if (var2 == null) {
                var2 = Binary.b("http://103.69.86.15/" + assetPath);
            }
            if (var2 != null) {
                // Lưu bytes đã mã hoá gốc ra file cache
                Binary.write(var0.e, var2);
                if (var0.e.startsWith("mapscale_")) {
                    GameSrc.gI().al.a(GameSrc.gI().mapID);
                    return;
                }
                if (var0.e.startsWith("mapsmall_") && GameSrc.gI().cE instanceof LangLa_u) {
                    ((LangLa_u)GameSrc.gI().cE).f();
                    return;
                }
                // Đọc lại qua Binary.read để tự chọn đúng kiểu giải mã (mới/cũ) theo tên file
                var1 = Binary.createImage(var0.e);
                if (var1 != null && var0.g != null) {
                    var0.g.put(var0.a, var1);
                }
                return;
            }
        }
        catch (Exception var6) {
            var6.printStackTrace();
            return;
        }
        finally {
            if (var1 != null) {
                GameSrc.gI().cb.add(var1);
            }
        }
    }

    public static void T() {
        if (!cZ && DataCenter.j() && !cZ) {
            cZ = true;
            new Thread(new LangLa_fh()).start();
        }
    }

    static {
        LangLa_cz.a();
    }
}

