package hackerrank.java.advanced;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-md5
 */
public class JavaMd5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final Scanner in = new Scanner(System.in);

        final String str = in.next();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String hex = (new HexBinaryAdapter()).marshal(md5.digest(str.getBytes()));
        System.out.println(hex.toLowerCase());
    }
}
