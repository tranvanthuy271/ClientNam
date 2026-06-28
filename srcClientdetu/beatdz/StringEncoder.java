package beatdz;

/**
 * Class mã hóa/giải mã string để bảo vệ URL và thông tin nhạy cảm
 */
public class StringEncoder {
    
    // Key để mã hóa (có thể thay đổi)
    private static final byte[] ENCODE_KEY = {0x4A, 0x61, 0x76, 0x61, 0x45, 0x6E, 0x63, 0x6F};
    
    // Base64 alphabet
    private static final String BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    
    /**
     * Custom Base64 encode implementation for compatibility with older Java versions
     */
    private static String base64Encode(byte[] data) {
        if (data == null || data.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < data.length; i += 3) {
            int b1 = data[i] & 0xFF;
            int b2 = (i + 1 < data.length) ? (data[i + 1] & 0xFF) : 0;
            int b3 = (i + 2 < data.length) ? (data[i + 2] & 0xFF) : 0;
            
            int bitmap = (b1 << 16) | (b2 << 8) | b3;
            
            sb.append(BASE64_CHARS.charAt((bitmap >> 18) & 0x3F));
            sb.append(BASE64_CHARS.charAt((bitmap >> 12) & 0x3F));
            
            if (i + 1 < data.length) {
                sb.append(BASE64_CHARS.charAt((bitmap >> 6) & 0x3F));
            } else {
                sb.append('=');
            }
            
            if (i + 2 < data.length) {
                sb.append(BASE64_CHARS.charAt(bitmap & 0x3F));
            } else {
                sb.append('=');
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Custom Base64 decode implementation for compatibility with older Java versions
     */
    private static byte[] base64Decode(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return new byte[0];
        }
        
        // Remove whitespace and calculate padding
        encoded = encoded.trim();
        int padding = 0;
        if (encoded.endsWith("==")) {
            padding = 2;
        } else if (encoded.endsWith("=")) {
            padding = 1;
        }
        
        int length = encoded.length();
        int byteLength = ((length * 3) / 4) - padding;
        byte[] result = new byte[byteLength];
        
        int byteIndex = 0;
        for (int i = 0; i < length; i += 4) {
            // Read 4 characters and convert to indices
            int[] indices = new int[4];
            int validChars = 0;
            
            for (int j = 0; j < 4 && (i + j) < length; j++) {
                char c = encoded.charAt(i + j);
                if (c == '=') {
                    indices[j] = 0;
                } else {
                    int index = BASE64_CHARS.indexOf(c);
                    if (index >= 0) {
                        indices[j] = index;
                        validChars++;
                    }
                }
            }
            
            // Build 24-bit value: each char is 6 bits
            int bitmap = (indices[0] << 18) | (indices[1] << 12) | (indices[2] << 6) | indices[3];
            
            // Extract bytes
            if (validChars >= 2 && byteIndex < byteLength) {
                result[byteIndex++] = (byte) ((bitmap >> 16) & 0xFF);
            }
            if (validChars >= 3 && byteIndex < byteLength) {
                result[byteIndex++] = (byte) ((bitmap >> 8) & 0xFF);
            }
            if (validChars >= 4 && byteIndex < byteLength) {
                result[byteIndex++] = (byte) (bitmap & 0xFF);
            }
        }
        
        return result;
    }
    
    /**
     * Mã hóa string bằng Base64 và XOR
     */
    public static String encode(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        try {
            // XOR encoding với key
            byte[] bytes = input.getBytes("UTF-8");
            byte[] encoded = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                encoded[i] = (byte) (bytes[i] ^ ENCODE_KEY[i % ENCODE_KEY.length]);
            }
            // Base64 encoding
            return base64Encode(encoded);
        } catch (Exception e) {
            return input;
        }
    }
    
    /**
     * Giải mã string đã được mã hóa
     */
    public static String decode(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return encoded;
        }
        try {
            // Base64 decode
            byte[] decoded = base64Decode(encoded);
            // XOR decode với key
            byte[] result = new byte[decoded.length];
            for (int i = 0; i < decoded.length; i++) {
                result[i] = (byte) (decoded[i] ^ ENCODE_KEY[i % ENCODE_KEY.length]);
            }
            return new String(result, "UTF-8");
        } catch (Exception e) {
            return encoded;
        }
    }
    
    /**
     * Giải mã URL (helper method)
     */
    public static String decodeUrl(String encodedUrl) {
        return decode(encodedUrl);
    }
}

