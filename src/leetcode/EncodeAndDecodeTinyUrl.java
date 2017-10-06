package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 03/10/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/encode-and-decode-tinyurl
 */
public class EncodeAndDecodeTinyUrl {
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private int count = 1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }
        final String shortUrl = String.valueOf(count++);
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.getOrDefault(shortUrl, "");
    }
}
