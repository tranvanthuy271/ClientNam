package beatdz;

/**
 * Class để làm rối code và chống reverse engineering
 * Thêm các dummy methods và fake code để làm khó phân tích
 */
public class CodeObfuscator {
    
    // Dummy variables để làm rối
    private static final int DUMMY_CONST1 = 0xDEADBEEF;
    private static final int DUMMY_CONST2 = 0xCAFEBABE;
    private static final String DUMMY_STR = "dummy";
    
    /**
     * Dummy method để làm rối reverse engineering
     */
    public static void dummyMethod1() {
        int x = DUMMY_CONST1 ^ DUMMY_CONST2;
        String s = DUMMY_STR + x;
        if (s.length() > 0) {
            // Dummy code
        }
    }
    
    /**
     * Dummy method 2
     */
    public static boolean dummyMethod2(int value) {
        int result = value ^ DUMMY_CONST1;
        return result != 0;
    }
    
    /**
     * Anti-debugging check (có thể mở rộng)
     */
    public static boolean isDebugging() {
        try {
            // Check for debugger
            long start = System.currentTimeMillis();
            Thread.sleep(1);
            long end = System.currentTimeMillis();
            return (end - start) > 100; // Nếu sleep lâu hơn bình thường có thể đang debug
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Mã hóa số với XOR
     */
    public static int encodeInt(int value) {
        return value ^ DUMMY_CONST1;
    }
    
    /**
     * Giải mã số
     */
    public static int decodeInt(int encoded) {
        return encoded ^ DUMMY_CONST1;
    }
}

