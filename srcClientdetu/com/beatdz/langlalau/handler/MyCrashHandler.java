package com.beatdz.langlalau.handler;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.beatdz.langlalau.DesktopLauncher;
import com.boot.GameM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class MyCrashHandler implements UncaughtExceptionHandler {

    private final DesktopLauncher launcher;

    public MyCrashHandler(DesktopLauncher launcher) {
        this.launcher = launcher;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        // Bỏ qua lỗi JVM không tương thích
        if (e instanceof IncompatibleClassChangeError) {
            return;
        }

        /* ================= GHI LOG CRASH ================= */
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        sw.append("======= LANG LA CRASH LOG =======\n");
        sw.append("Thread: ").append(t.getName()).append("\n");
        sw.append("Max memory: ").append(String.valueOf(Runtime.getRuntime().maxMemory())).append("\n");
        sw.append("Total memory: ").append(String.valueOf(Runtime.getRuntime().totalMemory())).append("\n");
        sw.append("Free memory: ").append(String.valueOf(Runtime.getRuntime().freeMemory())).append("\n");
        sw.append("Used memory: ")
                .append(String.valueOf(
                        Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
                ))
                .append("\n\n");

        e.printStackTrace(pw);

        writeCrashFile(sw.toString());

        /* ================= DEBUG CONSOLE ================= */
        e.printStackTrace();

        /* ================= XỬ LÝ THEO LOẠI LỖI ================= */

        if (e instanceof GdxRuntimeException) {

            String msg = String.valueOf(e.getMessage()); // tránh null

            /* ---------- LỖI OPENGL ---------- */
            if (msg.contains("OpenGL")) {
                handleOpenGLError();
                return;
            }

            /* ---------- OUT OF MEMORY ---------- */
            if (msg.contains("OutOfMemoryError")) {
                GameM.m();
                GameM.gI().k();
                return;
            }

            /* ---------- LỖI ASSET / FILE ---------- */
            if (msg.contains("Asset") || msg.contains("file") || msg.contains("atlas")) {
                launcher.a(
                        "Lỗi tài nguyên",
                        "Game bị thiếu hoặc lỗi file dữ liệu.\n" +
                        "Vui lòng kiểm tra lại thư mục game hoặc tải lại bản đầy đủ."
                );
                System.exit(0);
                return;
            }

            /* ---------- LỖI GDX KHÁC ---------- */
            launcher.a(
                    "Thông Báo",
                    "Rất tiếc! Trò chơi đã dừng hoạt động trên thiết bị của bạn.\n" +
                    "Vui lòng liên hệ BQT để được hỗ trợ.\n\n" +
                    "Chi tiết: " + e.getClass().getSimpleName()
            );
            System.exit(0);
        }
    }

    /* ================= GHI FILE CRASH ================= */
    private void writeCrashFile(String content) {
        try {
            File dir = new File("crash");
            if (!dir.exists()) dir.mkdirs();

            File file = new File(dir, "crash_" + System.currentTimeMillis() + ".log");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(content.getBytes("UTF-8"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* ================= XỬ LÝ LỖI OPENGL ================= */
    private void handleOpenGLError() {
        try {
            String arch = System.getenv("PROCESSOR_ARCHITECTURE");
            String archWow = System.getenv("PROCESSOR_ARCHITEW6432");

            boolean is64 = (arch != null && arch.endsWith("64"))
                    || (archWow != null && archWow.endsWith("64"));

            String bit = is64 ? "64" : "32";

            File target = new File("jre/bin/opengl32.dll");
            if (!target.exists()) {
                copyFile(
                        new File("support/x" + bit + "/opengl32.dll"),
                        target
                );
                launcher.a(); // restart
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        launcher.a(
                "Thông Báo",
                "Vui lòng cập nhật driver card màn hình (OpenGL)\n" +
                "sau đó mở lại game.\n\nThân ái!"
        );
    }

    /* ================= COPY FILE ================= */
    private void copyFile(File src, File dest) throws Exception {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)) {

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
    }
}
