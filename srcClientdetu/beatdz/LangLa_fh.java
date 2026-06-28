package beatdz;import com.tgame.model.Caption;

 class LangLa_fh implements Runnable {
   public void run() {
      try {
         for(int var1 = 0; var1 < DataCenter.gI().ai.size(); ++var1) {
            String var2 = (String)DataCenter.gI().ai.get(var1);
            String var7 = DataCenter.gI().aY.replaceAll("img", "imgios") + (DataCenter.a(var2) + 1) + "/" + var2;
            byte[] var6;
            var6 = Binary.c(DataCenter.gI().aU + var7);
            if (var6 == null || Binary.isHtmlResponse(var6)) {
               var6 = Binary.c("http://103.69.86.15/" + var7);
            }
            if (var6 != null && !Binary.isHtmlResponse(var6)) {
               Binary.a(var6, true);
            }
         }

         LangLa_cz.cZ = false;
         Binary.writeBoolean("arr_full", true);
         DataCenter.gI().a(false);
         DataCenter.bd = 1;
         Caption.loadVN();
         GameSrc var5 = GameSrc.gI();

         try {
            var5.al.a(var5.mapID);
         } catch (Exception var3) {
         }

         DataCenter.gI().aH = false;
      } catch (Exception var4) {
         DataCenter.gI().setScreen((MainScreen)(new CheckVersionScreen()));
      }
   }
}
