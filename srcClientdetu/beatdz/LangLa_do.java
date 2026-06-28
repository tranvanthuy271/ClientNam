package beatdz;
 public  class LangLa_do implements Runnable {
   
   public  LangLa_fb a;
   
   public  CheckVersionScreen b;

   public LangLa_do(CheckVersionScreen var1, LangLa_fb var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         String var3 = DataCenter.gI().aY + (DataCenter.a(this.a.d) + 1) + "/" + this.a.d;
         byte[] var1;
         if ((var1 = Binary.c(DataCenter.gI().aU + var3)) == null || Binary.isHtmlResponse(var1)) {
            Utlis.sleep(1000L);
            if ((var1 = Binary.c(DataCenter.gI().aU + var3)) == null || Binary.isHtmlResponse(var1)) {
               Utlis.sleep(1000L);
               var1 = Binary.c("http://103.69.86.15/" + var3);
            }
            if (var1 == null || Binary.isHtmlResponse(var1)) {
               CheckVersionScreen.a(this.b);
               return;
            }
         }

         Binary.a(var1, false);
         if (this.a.d.contains("Client")) {
            LangLa_fq.b();
         } else if (this.a.d.contains("Char")) {
            LangLa_fq.a();
         } else if (this.a.d.contains("font")) {
            mFont.a();
         }

         Binary.writeInt("arr_check_" + this.a.a, var1.length);
         this.a.f = true;
         CheckVersionScreen.b(this.b);
      } catch (Exception var2) {
         CheckVersionScreen.a(this.b);
         CheckVersionScreen.c(this.b).clear();
         CheckVersionScreen.d = true;
      }
   }
}
