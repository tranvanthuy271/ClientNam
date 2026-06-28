package beatdz;
import java.util.Base64;

public class TestEncode {
    public static void main(String[] args) {
        String[] urls = {
            "http://langlabang.com/",
            "http://langlabang.com/server.txt"
        };
        
        byte[] key = {0x4A, 0x61, 0x76, 0x61, 0x45, 0x6E, 0x63, 0x6F};
        
        for (String url : urls) {
            try {
                byte[] bytes = url.getBytes("UTF-8");
                byte[] encoded = new byte[bytes.length];
                for (int i = 0; i < bytes.length; i++) {
                    encoded[i] = (byte)(bytes[i] ^ key[i % key.length]);
                }
                String result = Base64.getEncoder().encodeToString(encoded);
                System.out.println("URL: " + url);
                System.out.println("Encoded: " + result);
                System.out.println("Code: StringEncoder.decodeUrl(\"" + result + "\")");
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}