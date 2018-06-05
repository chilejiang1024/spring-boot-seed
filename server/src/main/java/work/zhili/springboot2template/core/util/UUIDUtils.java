package work.zhili.springboot2template.core.util;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUIDUtils {

    private final static Logger logger = LoggerFactory.getLogger(UUIDUtils.class);

    /**
     * 得到uuid
     *
     * @return the uuid
     */
    public static String getUuid() {
        try {
            UUID uuid = UUID.randomUUID();
            return encrypt(uuid.toString()).toUpperCase();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "";
    }

    private static String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(str.getBytes());
        byte[] abResult = md5.digest();

        return byte2hex(abResult);
    }

    private static String byte2hex(byte[] data) {
        if (data == null) {
            return null;
        }
        return new String(Hex.encodeHex(data));
    }

}
