package random;

import java.io.UnsupportedEncodingException;

public class GetBytes {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String alpha = "com.delusional.vehicleinfo."; //[B@60e53b93
        byte[] bArr = new byte[0];
        try {
            bArr = alpha.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
     //   String encodeToString = Base64.encodeToString(bArr, 0);
    }
}
