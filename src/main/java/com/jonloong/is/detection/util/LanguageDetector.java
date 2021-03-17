/*
 * @(#) LanguageDetector.java 2021-03-17
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.jonloong.is.detection.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author longjiang
 * @version 2021-03-17
 */

public class LanguageDetector {

    private static final Logger logger = LoggerFactory.getLogger(LanguageDetector.class);

    private static Pattern filterNoisePattern =  Pattern.compile("[’·°–!\"#$%&'()*+,-./:;<=>?@，。?★、…【】（）《》？“”‘’！\\[\\]^_`{|}~]+");


    private static Pattern filterNumPattern = Pattern.compile("[0-9]+");
    private static String zhStr = "[\u4E00-\u9FA5]+";
    private static String koStr = "[\uac00-\ud7ff]+";
    private static String jaStr = "[\u30a0-\u30ff\u3040-\u309f]+";
    private static String enStr = "[a-zA-Z]+";

    /**
     * 通过unicode判断语种
     * @param str 带判断字符串
     * @return 语种 zh, en, ko, ja
     */
    public static String detectLanguage(String str) {
        if (StringUtils.isBlank(str.trim())) {
            logger.error("detector language, str is required");
            return "";
        }
        str = filterStr(str);
        str = filterNum(str);

        if (isEn(str)) {
            return "en";
        } else if (isZh(str)) {
            return "zh";
        } else if (isJa(str)) {
            return "ja";
        } else if (isKo(str)) {
            return "ko";
        } else {
            logger.warn("un detector language,{}", str);
            return "";
        }
    }


    private static String filterStr(String str) {
        Matcher matcher = filterNoisePattern.matcher(str);
        return matcher.replaceAll("").replaceAll(" +", "").trim();
    }

    private static String filterNum(String str) {
        Matcher matcher = filterNumPattern.matcher(str);
        return matcher.replaceAll("").trim();
    }


    private static boolean isEn(String str) {
        return str.matches(enStr);
    }

    private static boolean isKo(String str) {
        return str.matches(koStr);
    }

    private static boolean isJa(String str) {
        return str.matches(jaStr);
    }

    private static boolean isZh(String str) {
        return str.matches(zhStr);
    }

}
