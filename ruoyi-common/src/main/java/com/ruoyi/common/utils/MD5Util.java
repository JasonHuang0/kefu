package com.ruoyi.common.utils;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * MD5加密工具类
 *
 *
 */
public class MD5Util {

    /** 
     * Field hexDigits
     * Description 
     */
    private final static String[] hexDigits = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
    };

    /**
     * Method byteArrayToHexString 
     * Description 说明：
     *
     * @param b 说明：
     *
     * @return 返回值说明：
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();

        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }

        return resultSb.toString();
    }

    /**
     * Method byteToHexString 
     * Description 说明：
     *
     * @param b 说明：
     *
     * @return 返回值说明：
     */
    private static String byteToHexString(byte b) {
        int n = b;

        if (n < 0) {
            n += 256;
        }

        int d1 = n >>> 4;
        int d2 = n % 16;

        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * Method MD5Encode 
     * Description 说明：
     *
     * @param origin 说明：
     *
     * @return 返回值说明：
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");

            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));

            //md.update(resultString.getBytes("utf-8"));
            //resultString = new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * Method md5 
     * Description 说明：
     *
     * @param password 说明：
     *
     * @return 返回值说明：
     *
     * @throws NoSuchAlgorithmException 异常：
     */
    public static String md5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }

    /**
     * Method md5 
     * Description 说明：
     *
     * @param username 说明：
     * @param password 说明：
     *
     * @return 返回值说明：
     *
     * @throws NoSuchAlgorithmException 异常：
     */
    public static String md5(String username, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(username.getBytes());
        md.update(password.getBytes());

        return new BigInteger(1, md.digest()).toString(16);
    }

    public static String md5T16(){
        String uuid = String.valueOf(UUID.randomUUID());
        return md5T16(uuid);
    }

    public static String md5T16(String origin){
       return  MD5Encode(origin).substring(8, 24);
    }

    public final static String signature(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes("utf-8");
            //使用MD5创建MessageDigest对象
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = md[i];
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }



    /**
     *
     * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br>
     * 实现步骤: <br>
     *
     * @param paraMap   要排序的Map对象
     * @param urlEncode   是否需要URLENCODE
     * @param keyToLower    是否需要将Key转换为全小写
     *            true:key转化成小写，false:不转化
     * @return
     */
    public static StringBuilder formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower)
    {
        Map<String, String> tmpMap = paraMap;
        StringBuilder buf = new StringBuilder();
        try
        {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()
            {

                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式

            for (Map.Entry<String, String> item : infoIds)
            {
                if (StringUtils.isNotBlank(item.getKey()))
                {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode)
                    {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower)
                    {
                        buf.append(key.toLowerCase() + "=" + val);
                    } else
                    {
                        buf.append(key + "=" + val);
                    }
                    buf.append("&");
                }

            }
        } catch (Exception e)
        {
            return null;
        }
        return buf;
    }


    public static String getMD5(byte[] bytes) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] str = new char[32];

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] tmp = md.digest();
            int k = 0;

            for(int i = 0; i < 16; ++i) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return new String(str);
    }
}