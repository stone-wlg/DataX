package com.alibaba.datax.core.transport.transformer;

import org.bouncycastle.crypto.digests.SM3Digest;
import javax.xml.bind.DatatypeConverter;

/**
 * GroovyTransformer的帮助类，供groovy代码使用，必须全是static的方法
 * Created by liqiang on 16/3/4.
 */
public class GroovyTransformerStaticUtil {

    public static String SM3(String data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        byte[] dataBytes = data.getBytes();

        SM3Digest sm3 = new SM3Digest();
        sm3.update(dataBytes, 0, dataBytes.length);
        byte[] digest = new byte[sm3.getDigestSize()];
        sm3.doFinal(digest, 0);

        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
