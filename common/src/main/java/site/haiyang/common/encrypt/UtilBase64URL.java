package site.haiyang.common.encrypt;

import org.apache.commons.codec.binary.Base64;

public class UtilBase64URL {
    
    public static String encodeURL(byte[] simple) {   
        String s = new String(Base64.encodeBase64(simple)); // Regular base64 encoder
        s = s.split("=")[0]; // Remove any trailing '='s
        s = s.replace('+', '-'); // 62nd char of encoding
        s = s.replace('/', '_'); // 63rd char of encoding
        return s;
    }

    public static String decodeURL(String cipher) {
        String s = cipher;
        s = s.replace('-', '+'); // 62nd char of encoding
        s = s.replace('_', '/'); // 63rd char of encoding
        switch (s.length() % 4) { // Pad with trailing '='s
            case 0:
                break; // No pad chars in this case
            case 2:
                s += "==";
                break; // Two pad chars
            case 3:
                s += "=";
                break; // One pad char
            default:
                System.err.println("Illegal base64url String!");
        }
        return new String(Base64.decodeBase64(s)); // Standard base64 decoder
    }
    
    public static void main(String[] args) {
        
        System.out.println(UtilBase64.decryptBASE64("MTE5MDMyMQ"));
//        System.out.println(encodeURL("1190321".getBytes()));
//        System.out.println(new String(UtilBase64.decryptBASE64("anVuZXI=")));
        
    }

}
