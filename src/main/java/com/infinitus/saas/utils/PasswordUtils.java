package com.infinitus.saas.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * <dl>
 * <dd>Description: 密码加密工具类 </dd>
 * <dd>Company: 大城若谷信息技术有限公司</dd>
 * <dd>@date：2016/12/13 下午1:41</dd>
 * <dd>@author：Aaron</dd>
 * </dl>
 */
public class PasswordUtils {

    /**
     * 盐值大小
     */
    private static final int SALT_SIZE = 8;
    public static final int HASH_ITERATIONS = 1024;

    private PasswordUtils() {

    }

    /**
     * 密码加密
     *
     * @param password 未加密密码
     * @param salt     盐值
     * @return
     */
    public static String encrypt(String password, String salt) {
        byte[] hashPassword = Digests.sha1(password.getBytes(), decodeHex(salt), HASH_ITERATIONS);
        return encodeHex(hashPassword);
    }

    /**
     * 随机生成盐值
     *
     * @return
     */
    public static String generateSalt() {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        return encodeHex(salt);
    }

    /**
     * Hex解码.
     */
    private static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Hex编码.
     */
    private static String encodeHex(byte[] input) {
        return Hex.encodeHexString(input);
    }
}
