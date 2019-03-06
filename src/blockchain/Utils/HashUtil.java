package blockchain.Utils;
import java.security.*;
//HashSHA256函数传入byte数组得到对应的哈希字符串
public class HashUtil {
    public static String HashSHA256(byte[] b){
        MessageDigest alg = null;
        byte[] digest = null;
        try{
            alg = MessageDigest.getInstance("SHA-256");
            alg.update(b);
            digest = alg.digest();
        }catch (NoSuchAlgorithmException ex){
            System.out.println("没有该哈希算法");
        }

        String HashString = byteArrayToHexStr(digest);
        return HashString.toLowerCase();

    }

    //将byte数组转换成对应数字的字符串
    public static String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null){
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
