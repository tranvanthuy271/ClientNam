package beatdz;
 public class LangLa_ez implements Runnable {
   
  public   LangLa_fb a;
   
  public   CheckVersionScreen b;

   public  LangLa_ez(CheckVersionScreen var1, LangLa_fb var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         byte[] var1;
         if ((var1 = Binary.c(DataCenter.gI().aU + this.a.d)) == null || Binary.isHtmlResponse(var1)) {
            Utlis.sleep(1000L);
            if ((var1 = Binary.c(DataCenter.gI().aU + this.a.d)) == null || Binary.isHtmlResponse(var1)) {
               Utlis.sleep(1000L);
               var1 = Binary.c("http://103.69.86.15/" + this.a.d);
            }
            if (var1 == null || Binary.isHtmlResponse(var1)) {
               CheckVersionScreen.a(this.b);
               return;
            }
         }

         // Bật Binary.DEBUG_DOWNLOAD = true để xem log này
         Binary.dlog("Tai xong: " + this.a.d + " | Kich thuoc raw = " + var1.length + " bytes");
         Binary.dlog(">> Dung so nay cho checkpc/checkandroid/checkios: " + this.a.a + ";" + this.a.d + ";" + this.a.e + ";" + var1.length);

         if (!Binary.readBoolan("arr_savemap")) {
            Binary.write(this.a.e, var1);
         }

         Binary.writeInt("arr_check_" + this.a.a, var1.length);
         DataCenter.gI().readArrDataGame(true);
         this.a.f = true;
         CheckVersionScreen.b(this.b);
      } catch (Exception var2) {
         CheckVersionScreen.a(this.b);
         CheckVersionScreen.c(this.b).clear();
         CheckVersionScreen.d = true;
      }
   }
}
