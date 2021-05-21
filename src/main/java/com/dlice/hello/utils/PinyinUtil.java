package com.dlice.hello.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mubai
 **/
public class PinyinUtil {
    private static final String SIGN = "#";
    private static final String REGEX = "[`1234567890_~!@?#$%^&*()+=|{}':;,\\[\\].<>/！￥…（）—【】‘；：”“’。，、？]";
    private static final String EMOJI = "[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]";
    private static final String STANDARD = "[^A-Z\\\\s]";

    public PinyinUtil() {
    }

    public static String convertFirstPinyinChar(String str) {
        if (StringUtils.isEmpty(str)) {
            return "#";
        } else {
            Pattern p = Pattern.compile("[`1234567890_~!@?#$%^&*()+=|{}':;,\\[\\].<>/！￥…（）—【】‘；：”“’。，、？]");
            Matcher m = p.matcher(str);
            String ms = m.replaceAll("");
            Pattern pm = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]");
            Matcher mm = pm.matcher(ms);
            String msm = mm.replaceAll("");
            String[] arrays = msm.split(" ");
            StringBuilder result = new StringBuilder();
            String[] var9 = arrays;
            int var10 = arrays.length;

            for(int var11 = 0; var11 < var10; ++var11) {
                String arr = var9[var11];
                result.append(convertPinyinChar(arr));
            }

            String convertStr = result.toString();
            Pattern pr = Pattern.compile("[^A-Z\\\\s]");
            Matcher mr = pr.matcher(convertStr);
            if (!"#".equals(convertStr) && mr.find()) {
                convertStr = "#";
            }

            if (convertStr.length() <= 0) {
                convertStr = "#";
            }

            System.out.println("最终字符串：" + convertStr);
            return convertStr;
        }
    }

    private static String convertPinyinChar(String name) {
        char[] charArray = name.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        boolean containChinese = false;
        StringBuilder engPrefix = new StringBuilder();
        StringBuilder engSuffix = new StringBuilder();
        StringBuilder pinyin = new StringBuilder();

        try {
            char[] var7 = charArray;
            int var8 = charArray.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                char aCharArray = var7[var9];
                if (Character.toString(aCharArray).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] pinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(aCharArray, defaultFormat);
                    if (pinyinStringArray != null) {
                        pinyin.append(pinyinStringArray[0].charAt(0));
                    }

                    containChinese = true;
                } else if (containChinese) {
                    engSuffix.append(aCharArray);
                } else {
                    engPrefix.append(aCharArray);
                }
            }

            if (engPrefix.length() > 0) {
                pinyin = (new StringBuilder()).append(engPrefix.substring(0, 1).toUpperCase()).append(pinyin.toString());
            }

            if (engSuffix.length() > 0) {
                pinyin.append(engSuffix.substring(0, 1).toUpperCase());
            }
        } catch (Exception var12) {
            System.err.println(var12.getMessage());
        }

        return pinyin.toString();
    }
}
