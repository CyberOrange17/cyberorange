package com.nogame.utils.string;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	
	 /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @return 签名结果
     */
    public static String md5(String text) {
        return DigestUtils.md5Hex(getContentBytes(text, "utf-8"));
    }
    
    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

}
