package beatdz;

import java.util.Base64;
import java.util.Random;

/**
 * Class mã hóa nâng cao với nhiều lớp bảo vệ
 * Sử dụng multi-layer encryption để làm code khó giải mã hơn
 */
public class AdvancedEncoder {
    
    // Multiple keys để tăng độ bảo mật
    private static final byte[] KEY1 = {0x4A, 0x61, 0x76, 0x61, 0x45, 0x6E, 0x63, 0x6F};
    private static final byte[] KEY2 = {0x53, 0x65, 0x63, 0x75, 0x72, 0x65, 0x43, 0x6F};
    private static final byte[] KEY3 = {0x45, 0x6E, 0x63, 0x72, 0x79, 0x70, 0x74, 0x4B};
    
    // XOR rotation để tăng độ phức tạp
    private static int rotateKey(int pos, int length) {
        return (pos * 17 + length * 3) % 256;
    }
    
    /**
     * Mã hóa nhiều lớp với XOR + Base64 + Rotation
     */
    public static String encodeAdvanced(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        try {
            byte[] bytes = input.getBytes("UTF-8");
            
            // Layer 1: XOR với KEY1
            byte[] layer1 = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                layer1[i] = (byte) (bytes[i] ^ KEY1[i % KEY1.length]);
            }
            
            // Layer 2: XOR với KEY2 (reverse)
            byte[] layer2 = new byte[layer1.length];
            for (int i = 0; i < layer1.length; i++) {
                int reverseIdx = layer1.length - 1 - i;
                layer2[i] = (byte) (layer1[reverseIdx] ^ KEY2[i % KEY2.length]);
            }
            
            // Layer 3: XOR với KEY3 + rotation
            byte[] layer3 = new byte[layer2.length];
            for (int i = 0; i < layer2.length; i++) {
                int rotated = KEY3[i % KEY3.length] ^ rotateKey(i, layer2.length);
                layer3[i] = (byte) (layer2[i] ^ rotated);
            }
            
            // Base64 encoding
            return Base64.getEncoder().encodeToString(layer3);
        } catch (Exception e) {
            return input;
        }
    }
    
    /**
     * Giải mã nhiều lớp (ngược lại)
     */
    public static String decodeAdvanced(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return encoded;
        }
        try {
            // Base64 decode
            byte[] layer3 = Base64.getDecoder().decode(encoded);
            
            // Reverse Layer 3: XOR với KEY3 + rotation
            byte[] layer2 = new byte[layer3.length];
            for (int i = 0; i < layer3.length; i++) {
                int rotated = KEY3[i % KEY3.length] ^ rotateKey(i, layer3.length);
                layer2[i] = (byte) (layer3[i] ^ rotated);
            }
            
            // Reverse Layer 2: XOR với KEY2 (reverse back)
            byte[] layer1 = new byte[layer2.length];
            for (int i = 0; i < layer2.length; i++) {
                int reverseIdx = layer2.length - 1 - i;
                layer1[reverseIdx] = (byte) (layer2[i] ^ KEY2[i % KEY2.length]);
            }
            
            // Reverse Layer 1: XOR với KEY1
            byte[] result = new byte[layer1.length];
            for (int i = 0; i < layer1.length; i++) {
                result[i] = (byte) (layer1[i] ^ KEY1[i % KEY1.length]);
            }
            
            return new String(result, "UTF-8");
        } catch (Exception e) {
            return encoded;
        }
    }
    
    /**
     * Mã hóa string với random padding để làm rối thêm
     */
    public static String encodeWithPadding(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        try {
            Random rand = new Random(input.hashCode());
            byte[] bytes = input.getBytes("UTF-8");
            
            // Thêm padding ngẫu nhiên
            int paddingSize = 2 + (rand.nextInt(5));
            byte[] padded = new byte[bytes.length + paddingSize];
            
            // Padding ở đầu
            padded[0] = (byte) paddingSize;
            for (int i = 1; i < paddingSize; i++) {
                padded[i] = (byte) rand.nextInt(256);
            }
            
            // Data + XOR
            for (int i = 0; i < bytes.length; i++) {
                padded[paddingSize + i] = (byte) (bytes[i] ^ KEY1[i % KEY1.length] ^ rand.nextInt(256));
            }
            
            return Base64.getEncoder().encodeToString(padded);
        } catch (Exception e) {
            return input;
        }
    }
    
    /**
     * Giải mã string có padding
     */
    public static String decodeWithPadding(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return encoded;
        }
        try {
            byte[] padded = Base64.getDecoder().decode(encoded);
            int paddingSize = padded[0] & 0xFF;
            
            if (paddingSize < 0 || paddingSize >= padded.length) {
                return encoded; // Invalid padding
            }
            
            byte[] data = new byte[padded.length - paddingSize];
            System.arraycopy(padded, paddingSize, data, 0, data.length);
            
            // Decode XOR (cần reverse hash để tạo cùng random seed)
            // Simplified version - có thể cải thiện
            byte[] result = new byte[data.length];
            for (int i = 0; i < data.length; i++) {
                result[i] = (byte) (data[i] ^ KEY1[i % KEY1.length]);
            }
            
            return new String(result, "UTF-8");
        } catch (Exception e) {
            return encoded;
        }
    }
}

