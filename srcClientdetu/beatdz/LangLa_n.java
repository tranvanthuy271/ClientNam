package beatdz;

import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_n extends LangLa_fo {
  private mTextBox a;
  
  private mTextBox b;
  
  public LangLa_n(MainScreen var1) {
    this.cF = 2;
    this.p = var1;
    this.r = false;
    a(200, 120);
    this.a = a(60, 40, 100, "", this, 0, 0);
    byte var2 = 12;
    this.a.a = var2;
    this.b = a(60, 65, 100, "", this, 0, 0);
    var2 = 3;
    this.b.a = var2;
    this.b.b(true);
    a(Caption.aP, 100);
  }
  
  public void a(int var1, Object var2, LangLa_cy var3) {}
  
  public void a(int var1, Object var2) {}
  
  public void a(Graphics var1) {
    a(var1, this.cx, this.cy, this.width, this.height, Caption.fX, (byte)2, true);
    mFont.c(mFont.d, var1, Caption.fY, 10, a_() + 20, 0, -1, -16777216);
  }
  
  public void b() {}
  
  public Vector c() {
    super.c();
    Vector<LangLa_jz> var1;
    (var1 = new Vector<>()).addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
    return var1;
  }
  
  public void a(LangLa_jz var1, int var2, int var3) {
    try {
      Message var5;
      switch (var1.b) {
        case 100:
          (var5 = Message.c((byte)-106)).writeUTF(this.a.f());
          var5.writeUTF(this.b.f());
          var5.send();
          break;
      } 
    } catch (Exception exception) {}
  }
}
