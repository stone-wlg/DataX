package com.alibaba.datax.core.transport.transformer;

import org.bouncycastle.crypto.digests.SM3Digest;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * GroovyTransformer的帮助类，供groovy代码使用，必须全是static的方法
 * Created by liqiang on 16/3/4.
 */
public class GroovyTransformerStaticUtil {

    public static String SM3(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }

        SM3Digest sm3 = new SM3Digest();
        byte[] dataBytes = data.getBytes();
        sm3.update(dataBytes, 0, dataBytes.length);
        byte[] digest = new byte[sm3.getDigestSize()];
        sm3.doFinal(digest, 0);

        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public static String MD5(String data) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data.getBytes());
        byte[] digest = md5.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public static String SHA256(String data) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        sha256.update(data.getBytes());
        byte[] digest = sha256.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
