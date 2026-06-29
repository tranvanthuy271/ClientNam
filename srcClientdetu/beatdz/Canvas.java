package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.net.InetAddress;
import java.util.Vector;

public abstract class Canvas implements Screen {

    public static final boolean DEBUG_RENDER_LOG = false;
    public Graphics graphics;
    public static float elapsed; //sửa
    public OrthographicCamera camera;
    public int width;
    public int height;
    public Viewport viewport;
    private InputMultiplexer input;
    public Stage stage;
    public int g = 60;
    public static Vector vTexture = new Vector();
    public static Vector vImage = new Vector();
    private boolean l = false;
    public static boolean disposeGraphics = false;
    private static long m;
    private static int n;

    private static int bientuychinh = 2; //sửa

    private int frameCount = 0;
    private long startTime = System.currentTimeMillis();
    private static int fps = 0;
    private static long ping; //sửa

    // Biến để quản lý frame rate ổn định
    private static final float TARGET_FPS = 60.0f;
    private static final float FRAME_TIME = 1.0f / TARGET_FPS; // ~16.67ms per frame
    private long lastFrameTime;

    public static void setBientuychinh(int value) {
        bientuychinh = value;
    }

    public static int getBientuychinh() {
        return bientuychinh;
    }

    public static int getfps() {
        return fps;
    }

    public static long getping() { // sửa
        return ping;
    }

    public Canvas() {
        try {
            this.create();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void create() {
        try {
            // Khởi tạo lastFrameTime để tính toán frame rate chính xác
            this.lastFrameTime = System.nanoTime();

            this.width = Gdx.graphics.getWidth();
            this.height = Gdx.graphics.getHeight();
            Vector2 vector2;
            int x = (int) (vector2 = new Vector2()).x;
            int y = (int) vector2.y;
            this.width -= x * 2;
            this.camera = new OrthographicCamera((float) this.width, (float) this.height);
            this.camera.setToOrtho(true, (float) this.width, (float) this.height);
            this.graphics = new Graphics(this);
            this.setZoomLevel();
            Graphics.createFont();
            this.viewport = new MyViewport(Scaling.fill, (float) (this.width * DataCenter.gI().zoomLevel / DataCenter.gI().zoomLevelScreen - this.width % DataCenter.gI().zoomLevelScreen), (float) (this.height * DataCenter.gI().zoomLevel / DataCenter.gI().zoomLevelScreen - this.height % DataCenter.gI().zoomLevelScreen), this.camera);
            ((MyViewport) this.viewport).x = x;
            ((MyViewport) this.viewport).y = y;
            this.stage = new Stage(this.viewport, this.graphics.getSpriteBatch());
            this.input = new InputMultiplexer();
            this.input.addProcessor(new mInputProcessor(this, -x, 0));
            this.input.addProcessor(this.stage);
            Gdx.input.setInputProcessor(this.input);
            Gdx.input.setCatchKey(com.badlogic.gdx.Input.Keys.BACK, true);
            Gdx.input.setCatchKey(com.badlogic.gdx.Input.Keys.MENU, true);
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    private void rebuildStageInput() {
        try {
            if (this.stage != null) {
                this.stage.dispose();
            }
        } catch (Exception var3) {
            Utlis.println(var3);
        }

        try {
            this.stage = new Stage(this.viewport, this.graphics.getSpriteBatch());
            int var1 = this.viewport instanceof MyViewport ? ((MyViewport) this.viewport).x : 0;
            this.input = new InputMultiplexer();
            this.input.addProcessor(new mInputProcessor(this, -var1, 0));
            this.input.addProcessor(this.stage);
            Gdx.input.setInputProcessor(this.input);
            Gdx.input.setCatchKey(com.badlogic.gdx.Input.Keys.BACK, true);
            Gdx.input.setCatchKey(com.badlogic.gdx.Input.Keys.MENU, true);
            debugLog("LLVIEW", "rebuild-stage-input batch=" + this.graphics.spriteBatch + " stage=" + this.stage);
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    private void rebuildGraphicsResources(String var1) {
        try {
            debugLog("LLVIEW", "rebuild-gl-start reason=" + var1);
            if (this.graphics != null) {
                if (this.graphics.spriteBatch != null) {
                    this.graphics.spriteBatch.dispose();
                    this.graphics.spriteBatch = null;
                }

                if (this.graphics.shapeRenderer != null) {
                    this.graphics.shapeRenderer.dispose();
                }

                this.graphics.getSpriteBatch().setProjectionMatrix(this.camera.combined);
                LangLa_cr.rebuild();
                this.graphics.shapeRenderer = new ShapeRenderer();
                this.graphics.shapeRenderer.setProjectionMatrix(this.camera.combined);
                this.rebuildStageInput();
                DataCenter.gI().aH = false;
            }
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    private void clearScissors() {
        try {
            while (ScissorStack.peekScissors() != null) {
                ScissorStack.popScissors();
            }

            Gdx.gl.glDisable(3089);
            if (this.graphics != null) {
                this.graphics.j = false;
            }
        } catch (Exception var1) {
        }
    }

    public void setZoomLevel() {
        if (Gdx.app.getType() != ApplicationType.Android && Gdx.app.getType() != ApplicationType.iOS) {
            if (this.width >= 640 && this.height >= 480) {
                DataCenter.gI().zoomLevel = 2;
            } else {
                DataCenter.gI().zoomLevel = 1;
            }
        } else if (this.width >= 2560 && this.height >= 1440) {
            DataCenter.gI().zoomLevel = 6;
        } else if (this.width >= 1920 && this.height >= 1200) {
            DataCenter.gI().zoomLevel = 5;
        } else if (this.width >= 1280 && this.height >= 960) {
            DataCenter.gI().zoomLevel = 4;
        } else if (this.width >= 960 && this.height >= 720) {
            DataCenter.gI().zoomLevel = 3;
        } else if (this.width >= 640 && this.height >= 480) {
            DataCenter.gI().zoomLevel = 2;
        } else {
            DataCenter.gI().zoomLevel = 1;
        }
        DataCenter.gI().zoomLevelScreen = DataCenter.gI().zoomLevel;
        if (DataCenter.gI().zoomLevelScreen == 3 && (mConfig.gI().readByte(2) == 0 || mConfig.gI().readByte(2) == 3)) {
            DataCenter.gI().zoomLevel = 2;
        } else if ((DataCenter.gI().zoomLevelScreen == 4 || DataCenter.gI().zoomLevelScreen == 5 || DataCenter.gI().zoomLevelScreen == 6) && mConfig.gI().readByte(2) == 0) {
            DataCenter.gI().zoomLevel = 3;
        }

        if (DataCenter.gI().zoomLevel > 4) {
            DataCenter.gI().zoomLevel = 4;
        }

        if ((Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS) && DataCenter.gI().zoomLevelScreen != DataCenter.gI().zoomLevel) {
            debugLog("LLVIEW", "sync-mobile-zoom screen=" + DataCenter.gI().zoomLevelScreen + " render=" + DataCenter.gI().zoomLevel);
            DataCenter.gI().zoomLevelScreen = DataCenter.gI().zoomLevel;
        }

    }

    private long startPingTime; // Biến để lưu thời gian bắt đầu tính ping

    private long debugViewportLogAt;
    private int debugViewportW = -1;
    private int debugViewportH = -1;

    private static void debugLog(String var0, String var1) {
        if (!DEBUG_RENDER_LOG) {
            return;
        }

        try {
            Gdx.app.log(var0, var1);
        } catch (Exception var3) {
        }

        System.out.println("[" + var0 + "] " + var1);
    }

    private void debugViewportState(String var1, boolean var2) {
        try {
            long var3 = System.currentTimeMillis();
            int var5 = Gdx.graphics.getWidth();
            int var6 = Gdx.graphics.getHeight();
            if (!var2 && var3 - this.debugViewportLogAt < 1500L && this.debugViewportW == var5 && this.debugViewportH == var6) {
                return;
            }

            this.debugViewportLogAt = var3;
            this.debugViewportW = var5;
            this.debugViewportH = var6;
            MainScreen var7 = DataCenter.gI().currentScreen;
            String var8 = var7 == null ? "null" : var7.getClass().getSimpleName();
            debugLog("LLVIEW", var1
                    + " app=" + Gdx.app.getType()
                    + " gfx=" + var5 + "x" + var6
                    + " canvas=" + this.width + "x" + this.height
                    + " dc=" + DataCenter.gI().widthScreen + "x" + DataCenter.gI().heightScreen
                    + " zoom=" + DataCenter.gI().zoomLevel + "/" + DataCenter.gI().zoomLevelScreen
                    + " q/r=" + DataCenter.gI().q + "/" + DataCenter.gI().r
                    + " aH=" + DataCenter.gI().aH
                    + " screen=" + var8);
        } catch (Exception var9) {
            Utlis.println(var9);
        }
    }

    private void syncViewportSize() {
        try {
            int var1 = Gdx.graphics.getWidth();
            int var2 = Gdx.graphics.getHeight();
            if (var1 > 0 && var2 > 0 && (this.width != var1 || this.height != var2)) {
                this.debugViewportState("sync-resize-before", true);
                this.resize(var1, var2);
            } else if (this.viewport != null) {
                this.viewport.apply(true);
            }

            Gdx.gl.glViewport(0, 0, var1, var2);
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    private void calculatePing() { //sửa
        try {
            // Khởi tạo socket để kết nối đến server (ví dụ: Google DNS)
            InetAddress address = InetAddress.getByName("8.8.8.8"); // Google DNS
            startPingTime = System.currentTimeMillis(); // Ghi lại thời gian bắt đầu gửi gói tin
            boolean reachable = address.isReachable(1000); // Kiểm tra kết nối, timeout 1 giây

            if (reachable) {
                ping = System.currentTimeMillis() - startPingTime; // Tính thời gian phản hồi
            } else {
                ping = -1; // Nếu không thể kết nối, gán ping là -1
            }

        } catch (Exception e) {
            Utlis.println(e);
        }
    }

    private void render(boolean var1) { //sửa

        // Tính thời gian hiện tại và cập nhật số khung hình
        frameCount++; // Tăng số khung hình

        long currentTime = System.currentTimeMillis(); // Lấy thời gian hiện tại

        // Nếu đã qua 1 giây (1000 milliseconds)
        if (currentTime - startTime >= 1000) {
            fps = frameCount;  // Gán số khung hình vào FPS
            frameCount = 0;    // Đặt lại số khung hình về 0
            startTime = currentTime;  // Đặt lại thời gian bắt đầu

        }

        // Bắt đầu đo thời gian frame
        long frameStartTime = System.nanoTime();

        // Sử dụng delta time từ libGDX với giới hạn để tránh frame spike
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), FRAME_TIME * 2);
        elapsed += deltaTime; //ửa
        long var2 = System.currentTimeMillis();

        int var15;
        try {
            Graphics var4;
            if (disposeGraphics) {
                disposeGraphics = false;
                this.rebuildGraphicsResources("disposeGraphics");
            }

            ++DataCenter.gI().i;
            ++DataCenter.gI().h;
            DataCenter.gI().aO.a = false;
            this.syncViewportSize();
            this.camera.update();
            this.update();
            this.debugViewportState("render-loop", false);
            if (var1) {
                if (!Graphics.m()) {
                    Gdx.gl.glDisable(3089);
                    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
                    Gdx.gl.glClear(16384);
                    Gdx.gl.glEnable(3042);
                    this.clearScissors();
                    Gdx.gl20.glLineWidth((float) DataCenter.gI().zoomLevel);
                    var4 = this.graphics;

                    try {
                        var4.shapeRenderer.setProjectionMatrix(var4.canvas.camera.combined);
                        var4.getSpriteBatch().setProjectionMatrix(var4.canvas.camera.combined);
                    } catch (Exception var11) {
                        Utlis.println(var11);
                    }

                    var4 = this.graphics;

                    try {
                        if (mConfig.gI().readByte(18) > 1) {
                            if (var4.spriteBatch == null) {
                                var4.dispose();
                            }
                        } else {
                            var4.getSpriteBatch().begin();
                            var4.getSpriteBatch().enableBlending();
                            var4.c();
                            var4.shapeRenderer.begin(ShapeType.Line);

                        }
                    } catch (Exception var10) {
                        Utlis.println(var10);
                    }

                    this.graphics.clean();
                    this.clearScissors();
                    this.graphics.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
                    this.paint(this.graphics);
                    LangLa_gg var10000 = DataCenter.gI().aO;
                    Graphics var5 = this.graphics;
                    LangLa_gg var16 = var10000;
                    GameSrc var14;
                    if (var10000.a && GameSrc.gI().i() && !GameSrc.gI().bb && ((var14 = GameSrc.gI()).cL == null || !(var14.cL instanceof LangLa_kn))) {
                        if (DataCenter.gI().i % 6 >= 3) {
                            LangLa_fq.a(var5, 419, 0, var16.b + 1, var16.c + 1, 20);
                        } else {
                            LangLa_fq.a(var5, 419, 0, var16.b, var16.c, 20);
                        }

                        if (var16.f && LangLa_gg.e != null && var16.d <= 4) {
                            var5.a(LangLa_gg.e, 0, 0, LangLa_gg.e.c, LangLa_gg.e.d, 0, var16.b - 25, var16.c - 25, 50 * DataCenter.gI().zoomLevel, 50 * DataCenter.gI().zoomLevel, 0);
                            if (Gdx.app.getType() != ApplicationType.Android && Gdx.app.getType() != ApplicationType.iOS) {
                                var5.f(0);
                                var5.d(60);
                                var5.c(0, 0, var16.b - 25, DataCenter.gI().heightScreen);
                                var5.c(var16.b + 25, 0, DataCenter.gI().widthScreen - (var16.b + 25), DataCenter.gI().heightScreen);
                                var5.c(var16.b - 25, 0, 50, var16.c - 25);
                                var5.c(var16.b - 25, var16.c + 25, 50, DataCenter.gI().heightScreen - (var16.c + 25));
                                var5.m = 1.0F;
                                var5.c();
                            }
                        }
                    }

                    try {
                        if (mConfig.gI().readByte(18) > 1) {
                            if (var4.spriteBatch == null) {
                                var4.dispose();
                            }
                        } else {
                            var4.j = false;
                            var4.getSpriteBatch().end();
                            var4 = this.graphics;

                            var4.shapeRenderer.end();
                            var4.getSpriteBatch().flush();
                            this.clearScissors();
                        }
                    } catch (Exception var9) {
                        this.clearScissors();
                    }
                } else {
                    Gdx.gl.glClear(16384);
                    this.clearScissors();
                }
            }

            while (vTexture.size() > 0) {
                try {
                    ((Texture) vTexture.remove(0)).dispose();
                } catch (Exception var8) {
                    Utlis.println("khong xoa dc textures");
                }
            }

            for (var15 = vImage.size() - 1; var15 >= 0; --var15) {
                try {
                    mImage var17 = (mImage) vImage.get(var15);
                    if (var2 - var17.e > 10000L) {
                        vImage.remove(var17);
                        var17.c();
                    }
                } catch (Exception var7) {
                    Utlis.println("khong xoa dc textures");
                }
            }
        } catch (Exception var13) {
            Utlis.println(var13);
        }

        if (Session.r > 0) {
            --Session.r;
        }

        // Tối ưu frame rate limiting: sử dụng nano time để chính xác hơn
        long frameEndTime = System.nanoTime();
        long frameElapsedNanos = frameEndTime - frameStartTime;
        long targetNanos = (long) (FRAME_TIME * 1000000000L); // Convert to nanoseconds (~16.67ms)

        // Chỉ sleep nếu frame hoàn thành quá nhanh (để đảm bảo 60 FPS ổn định)
        // Điều này giúp giảm CPU usage và đảm bảo frame rate ổn định
        if (false && frameElapsedNanos < targetNanos) {
            long sleepTime = (targetNanos - frameElapsedNanos) / 1000000L; // Convert to milliseconds
            if (sleepTime > 0 && sleepTime < 16) { // Chỉ sleep tối đa 16ms để tránh oversleep
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // Cập nhật lastFrameTime cho frame tiếp theo
        lastFrameTime = System.nanoTime();
    }

    public void render(float var1) {
        this.render(true);
        // Sử dụng delta time đã được giới hạn để đảm bảo stage cập nhật ổn định
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), FRAME_TIME * 2);
        this.stage.act(Math.min(deltaTime, 0.033333335F));
        this.stage.draw();
    }

    public int getWidth() {
        return DataCenter.gI().zoomLevel != DataCenter.gI().zoomLevelScreen ? this.width / DataCenter.gI().zoomLevelScreen : this.width / DataCenter.gI().zoomLevel;
    }

    public int getHeight() {
        return DataCenter.gI().zoomLevel != DataCenter.gI().zoomLevelScreen ? this.height / DataCenter.gI().zoomLevelScreen : this.height / DataCenter.gI().zoomLevel;
    }

    public abstract void update();

    public abstract void paint(Graphics var1);

    public abstract void a(int var1);

    public abstract void a(char var1);

    public abstract void b(int var1);

    public abstract void a(int var1, int var2);

    public abstract void b(int var1, int var2);

    public abstract void c(int var1, int var2);

    public void show() {
    }

    public void resize(int var1, int var2) {
        if (var1 <= 0 || var2 <= 0) {
            return;
        }

        this.width = var1;
        this.height = var2;
        this.setZoomLevel();
        this.camera.setToOrtho(true, (float) this.width, (float) this.height);
        this.camera.update();

        float var3 = (float) (this.width * DataCenter.gI().zoomLevel / DataCenter.gI().zoomLevelScreen - this.width % DataCenter.gI().zoomLevelScreen);
        float var4 = (float) (this.height * DataCenter.gI().zoomLevel / DataCenter.gI().zoomLevelScreen - this.height % DataCenter.gI().zoomLevelScreen);
        this.viewport.setWorldSize(var3, var4);
        this.stage.getViewport().update(this.width, this.height, true);

        DataCenter.gI().widthScreen = this.getWidth();
        DataCenter.gI().heightScreen = this.getHeight();
        float var5 = DataCenter.gI().widthScreen / 640.0F;
        float var6 = DataCenter.gI().heightScreen / 360.0F;
        float var7 = var5 > var6 ? var5 : var6;
        DataCenter.gI().q = (int) (640.0F * var7 * DataCenter.gI().zoomLevel);
        DataCenter.gI().r = (int) (360.0F * var7 * DataCenter.gI().zoomLevel);

        if (DataCenter.gI().currentScreen != null) {
            DataCenter.gI().currentScreen.setSize(DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
        }

        DataCenter.gI().aH = false;
        this.debugViewportState("resize-invalidate-hud", true);

        if (this.graphics != null) {
            this.graphics.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
        }
    }

    public void pause() {
        LangLa_dp var1;
        (var1 = LangLa_dp.a()).a = true;
        var1.b();
        if (GameSrc.gI().cx.size() > 0) {
            for (int var2 = GameSrc.gI().cx.size() - 1; var2 >= 0; --var2) {
                ((LangLa_en) GameSrc.gI().cx.get(var2)).d();
            }
        }

        if (Gdx.app.getType() != ApplicationType.Desktop) {
            this.l = true;
            if (Gdx.app.getType() != ApplicationType.iOS) {
                (new Thread(new LangLa_dj(this))).start();
            }
        }
    }

    public void resume() {
        this.l = false;
        disposeGraphics = true;
        DataCenter.gI().aH = false;
        debugLog("LLVIEW", "resume-request-rebuild-gl");
        LangLa_dp var1;
        (var1 = LangLa_dp.a()).a = false;
        var1.c = false;

        try {
            if (mConfig.gI().readBoolean(1)) {
                var1.f();
            }

            if (GameSrc.gI().cx.size() > 0) {
                for (int var3 = GameSrc.gI().cx.size() - 1; var3 >= 0; --var3) {
                    ((LangLa_en) GameSrc.gI().cx.get(var3)).a();
                }
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void hide() {
    }

    public void dispose() {
        LangLa_dp var1;
        (var1 = LangLa_dp.a()).d();
        var1.e();
    }

    static boolean a(Canvas var0) {
        return var0.l;
    }

    static void a(Canvas var0, boolean var1) {
        var0.render(false);
    }
}
