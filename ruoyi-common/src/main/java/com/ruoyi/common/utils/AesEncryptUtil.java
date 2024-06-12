package com.ruoyi.common.utils;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * @Author xuhy
 * @Date 2021/1/28 14:01
 * @Version 1.0
 */
public class AesEncryptUtil {

    //使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
    private static String KEY = "Y2QE7H0J9IX368U5";
    private static String IV = "HITSC3XD861492U5";



    public static String dataEncrypt(String sSrc) throws Exception {
        return encrypt(sSrc,"utf-8",KEY,IV);
    }

    public static String dataDecrypt(String sSrc) throws Exception {
        return decrypt(sSrc,"utf-8",KEY,IV);
    }

    // 加密
    public static String encrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
        return new  org.apache.commons.codec.binary.Base64().encodeToString(encrypted);
    }

    // 解密
    public static String decrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        try {
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 =  new org.apache.commons.codec.binary.Base64().decode(sSrc);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,encodingFormat);
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }




    public static void main(String[] args) throws Exception {
//         需要加密的字串
        String cSrc = "{\"code\":0,\"msg\":\"成功\",\"data\":{\"page\":1,\"size\":20,\"totalNum\":5,\"totalPage\":1,\"resultList\":[{\"supplierName\":\"供货单位\",\"role\":0,\"mchId\":\"e76c15a383cb482bb375fa1bd76b3524\",\"poundModel\":0,\"consigneeNo\":\"\",\"carWeight\":0.00,\"supplierNo\":\"SR781824750597963776\",\"remark\":\"\",\"consigneeName\":\"\",\"realName\":\"许鸿毅\",\"breedName\":\"入库品类\",\"driverId\":\"22940be1fa514c7a83d244150a69425c\",\"carNo\":\"闽D34467\",\"phone\":\"18558984562\",\"name\":null,\"transportType\":0,\"id\":\"07c803ee18664430a5d4048f2fb5c916\",\"breedNo\":\"BD780452267017895936\"},{\"supplierName\":null,\"role\":0,\"mchId\":\"e76c15a383cb482bb375fa1bd76b3524\",\"poundModel\":0,\"consigneeNo\":null,\"carWeight\":null,\"supplierNo\":null,\"remark\":null,\"consigneeName\":null,\"realName\":\"阿阿\",\"breedName\":\"入库品类\",\"driverId\":\"4320d1b5229944c58771b787308e300d\",\"carNo\":\"京123\",\"phone\":\"17191555527\",\"name\":null,\"transportType\":0,\"id\":\"2741795f4d6742808a2218ec9506d731\",\"breedNo\":\"BD780452267017895936\"},{\"supplierName\":null,\"role\":0,\"mchId\":\"e76c15a383cb482bb375fa1bd76b3524\",\"poundModel\":0,\"consigneeNo\":null,\"carWeight\":null,\"supplierNo\":null,\"remark\":null,\"consigneeName\":null,\"realName\":\"啧啧啧\",\"breedName\":\"入库品类\",\"driverId\":\"27dc4302e3dc4eac955dbd52e609a311\",\"carNo\":\"鲁EEE\",\"phone\":\"15396212339\",\"name\":null,\"transportType\":0,\"id\":\"297b07bb9a1641348cdbb47642583a60\",\"breedNo\":\"BD780452267017895936\"},{\"supplierName\":null,\"role\":0,\"mchId\":\"e76c15a383cb482bb375fa1bd76b3524\",\"poundModel\":0,\"consigneeNo\":null,\"carWeight\":null,\"supplierNo\":null,\"remark\":null,\"consigneeName\":null,\"realName\":\"陈文牍\",\"breedName\":\"入库品类\",\"driverId\":\"2dbaee9f67844ca1b889d6526717efb1\",\"carNo\":\"闽D77777\",\"phone\":\"15750778770\",\"name\":null,\"transportType\":0,\"id\":\"993ae864df6643a597666ddbef252242\",\"breedNo\":\"BD780452267017895936\"},{\"supplierName\":\"\",\"role\":0,\"mchId\":\"e76c15a383cb482bb375fa1bd76b3524\",\"poundModel\":0,\"consigneeNo\":\"\",\"carWeight\":0.00,\"supplierNo\":\"\",\"remark\":\"\",\"consigneeName\":\"\",\"realName\":\"阿萨\",\"breedName\":\"入库品类\",\"driverId\":\"826bf7edc6f747078320a236a4af45de\",\"carNo\":\"豫6TGHUS7\",\"phone\":\"18538867188\",\"name\":null,\"transportType\":0,\"id\":\"a4b79dd32e094b0ab4bba22e8268e82b\",\"breedNo\":\"BD780452267017895936\"}]},\"success\":true}";
        System.out.println(cSrc);
        Map<String,String> map = JSONObject.parseObject(cSrc, Map.class);
        String time = String.valueOf(new Date().getTime());
        System.out.println(time);
        String sign = createSign(map, KEY, time);
        System.out.println(sign);

//        String  cSrc = "11625195288742";
//        // 加密
//        long lStart = System.currentTimeMillis();
        String enString = AesEncryptUtil.encrypt(cSrc,"utf-8",KEY, IV);
        System.out.println(enString);
        System.out.println(enString.length());
//        System.out.println("加密后的字串是："+ enString);
//
//        long lUseTime = System.currentTimeMillis() - lStart;
//        System.out.println("加密耗时：" + lUseTime + "毫秒");
//        // 解密

        String DeString = AesEncryptUtil.decrypt(enString,"utf-8",KEY,IV);
        System.out.println(cSrc.equals(DeString));
        System.out.println("解密后的字串是：" + DeString);
//        String sign = MD5Util.MD5Encode("page=1&size=20&t=1612517014000&key=DNMDGEPOGAIZAIAA").toUpperCase();
//        System.out.println(sign);

    }


    public static boolean verifySign(Map<String,String> parameters,String time,String requestSign,String appkey){
        String sign = createSign(parameters, appkey, time);
        if(sign == null || !sign.equals(requestSign)){
            return false;
        }
        return true;
    }


    /**
     * 生成签名
     * @param parameters
     * @param signKey
     * @param time
     * @return
     */
    public static String createSign(Map<String,String> parameters, String signKey,String time){
        StringBuffer sb = new StringBuffer();
        StringBuffer sbkey = new StringBuffer();
        if(parameters != null){
            Set es = parameters.entrySet();
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(es);
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>()
            {

                @Override
                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            for (Map.Entry<String, Object> item : infoIds){
                String k = (String)item.getKey();
                Object v = item.getValue();
                //空值不传递，不参与签名组串
                if(!StringUtils.isEmpty(v)) {
                    sb.append(k + "=" + v + "&");
                    sbkey.append(k + "=" + v + "&");
                }
            }
        }
        sbkey.append("t="+time);
        sbkey=sbkey.append("&key="+signKey);
        String sign = MD5Util.MD5Encode(sbkey.toString()).toUpperCase();
        return sign;
    }

}
