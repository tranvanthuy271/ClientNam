package beatdz;

import beatdz.libForBeatdz.WaitAuto;
import java.io.IOException;

public class AutoPro {

    static String tk = "";

    static String mk = "";

    static mImage iconTool = null;

    static mImage iconTool2 = null;

    static mImage iconTool3 = null;

    static String VER = "0.4";

    private static long delayCheckPL;

    public static LangLa_bg srcPL;

    private static long delayNhanPhucLoi;

    public static mImage getIconTool() {
        return mImage.a(1, 1);
    }

    public static mImage getIconTool2() {
        return mImage.a(1, 1);
    }

    public static mImage getIconTool3() {
        try {
            if (iconTool3 == null || iconTool3.b() == null) {
                iconTool3 = Binary2.a("f", (MainScreen) null);
            }
            return iconTool3;
        } catch (Exception ex) {
            Utlis.println(ex);
            return mImage.a(1, 1);
        }
    }

    private static boolean isTat = false;

    public static boolean isBuyHPMP = false;

    public static boolean isBuyTA = false;

    private static long delayMuaHPMP;

    static {
        (new Thread(new Runnable() {
            public void run() {
                while (true) {
                    AutoPro.update();
                }
            }
        })).start();
        (new Thread(new Runnable() {
            public void run() {
                boolean b = false;
                while (true) {
                    long var2 = System.currentTimeMillis();
                    try {
                        if (Session.gI().isConnected() && (DataCenter.gI()).currentScreen instanceof GameSrc) {
                            if (Graphics.m()) {
                                GameSrc.gI().updateMove();
                                GameSrc.gI();
                                GameSrc.Char_O();
                            }
                        } else {
                            b = true;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        int var15;
                        if ((var15 = 28 - (int) (System.currentTimeMillis() - var2)) <= 0) {
                            var15 = 1;
                        }
                        Utlis.sleep(var15);
                    }
                }
            }
        })).start();
    }

    public static void update() {
        long time = System.currentTimeMillis();
        try {
            if ((DataCenter.gI()).currentScreen != null && (DataCenter.gI()).currentScreen instanceof GameSrc) {
                if (isAuto(0)) {
                    if (srcPL == null || System.currentTimeMillis() - delayCheckPL >= 0L) {
                        srcPL = null;
                        GameSrc.gI();
                        GameSrc.openFunc(88);
                        WaitAuto.get("OpenFunc88").waitObject(5000L);
                        if (srcPL == null) {
                            delayCheckPL = System.currentTimeMillis() + 5000L;
                        } else {
                            if ((GameSrc.gI()).as) {
                                isTat = true;
                            }
                            delayCheckPL = System.currentTimeMillis() + 10000L;
                        }
                    } else if (srcPL != null) {
                        if (System.currentTimeMillis() - delayNhanPhucLoi >= 2000L) {
                            srcPL.nhanPhucLoi();
                            delayNhanPhucLoi = System.currentTimeMillis() + 10000L;
                        }
                        if (isTat && !(GameSrc.gI()).as) {
                            isTat = false;
                            srcPL = null;
                            (GameSrc.gI()).as = false;
                            delayCheckPL = System.currentTimeMillis() + 30000L;
                        }
                    }
                }
                if (isAuto(6)
                        && isBuyHPMP
                        && System.currentTimeMillis() - delayMuaHPMP >= 2000L) {
                    int idItemHP = findIdItemWithTypeAndLevel(22, 1);
                    int idItemMP = findIdItemWithTypeAndLevel(23, 1);
                    if (Char.gI().level() >= 60) {
                        idItemHP = findIdItemWithTypeAndLevel(22, 60);
                        idItemMP = findIdItemWithTypeAndLevel(23, 60);
                    } else if (Char.gI().level() >= 55) {
                        idItemHP = findIdItemWithTypeAndLevel(22, 55);
                        idItemMP = findIdItemWithTypeAndLevel(23, 55);
                    } else if (Char.gI().level() >= 50) {
                        idItemHP = findIdItemWithTypeAndLevel(22, 50);
                        idItemMP = findIdItemWithTypeAndLevel(23, 50);
                    } else if (Char.gI().level() >= 40) {
                        idItemHP = findIdItemWithTypeAndLevel(22, 40);
                        idItemMP = findIdItemWithTypeAndLevel(23, 40);
                    } else if (Char.gI().level() >= 30) {
                        idItemHP = findIdItemWithTypeAndLevel(22, 30);
                        idItemMP = findIdItemWithTypeAndLevel(23, 30);
                    } else if (Char.gI().level() >= 20) {
                        idItemHP = findIdItemWithTypeAndLevel(22, 20);
                        idItemMP = findIdItemWithTypeAndLevel(23, 20);
                    }
                    if (idItemHP != -1 && (GameSrc.gI()).bu == 0) {
                        autoBuyItem(1, idItemHP, 500);
                    }
                    if (idItemMP != -1 && (GameSrc.gI()).bw == 0) {
                        autoBuyItem(1, idItemMP, 500);
                    }
                    delayMuaHPMP = System.currentTimeMillis();
                }
                if (isAuto(7)
                        && isBuyTA
                        && System.currentTimeMillis() - delayMuaHPMP >= 2000L) {
                    int level = Char.gI().level() / 5 * 5;
                    if (level < 10) {
                        level = 1;
                    }
                    autoBuyItem(5, findIdItemWithTypeAndLevel(24, level), 10);
                    delayMuaHPMP = System.currentTimeMillis();
                }
            }
        } catch (Exception exception) {

        } finally {
            long time2 = 100L - System.currentTimeMillis() - time;
            if (time2 <= 0L) {
                time2 = 1L;
            }
            Utlis.sleep(time2);
        }
    }

    private static int findIdItemWithTypeAndLevel(int type, int level) {
        for (int i = 0; i < (DataCenter.gI()).ItemTemplate.length; i++) {
            if (((DataCenter.gI()).ItemTemplate[i]).type == type && ((DataCenter.gI()).ItemTemplate[i]).levelNeed == level) {
                return ((DataCenter.gI()).ItemTemplate[i]).id;
            }
        }
        return -1;
    }

    public static boolean isAuto(int i) {
        return ((SettingsTab.gI()).a[i + 100] == 0);
    }

    public static void autoBuyItem(int func, int id, int amount) {
        (GameSrc.gI()).l.clear();
        GameSrc.gI();
        GameSrc.openFunc(func);
        if (WaitAuto.get("openFunc" + func).waitObject(2000L) && (GameSrc.gI()).l.size() > 0) {
            int i;
            for (i = 0; i < (GameSrc.gI()).l.size(); i++) {
                Item item = (Item) GameSrc.gI().l.get(i);
                if (item.id == id) {
                    try {
                        Message var46;
                        (var46 = new Message((byte) 121)).writeShort(item.idBuy);
                        var46.writeShort(amount);
                        var46.send();
                    } catch (IOException iOException) {
                    }
                    WaitAuto.get("BuyItem").waitObject(2000L);
                    return;
                }
            }
            for (i = 0; i < (GameSrc.gI()).l.size(); i++) {
                Item item = (Item) GameSrc.gI().l.get(i);
                if (item.idBuy == id) {
                    try {
                        Message var46;
                        (var46 = new Message((byte) 121)).writeShort(item.idBuy);
                        var46.writeShort(amount);
                        var46.send();
                    } catch (IOException iOException) {
                    }
                    WaitAuto.get("BuyItem").waitObject(2000L);
                    return;
                }
            }
        }
    }
}
