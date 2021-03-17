package com.jonloong.is.detection;

import com.jonloong.is.detection.util.LanguageDetector;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LanguageDetectionApplication {

    private static Logger logger = LoggerFactory.getLogger(LanguageDetectionApplication.class);

    public static void main(String[] args) {

        String zhSimp = "十年生死两茫茫";
        String zhTrad = "不思量自難忘";
        String en = "To be, or not to be";
        String ko = "오늘 비가옵니다";
        String ja = "こんにちは";
        String jaa = "私はあなたを愛しています中国";

        String langZh = LanguageDetector.detectLanguage(zhSimp);
        String langZhTrad = LanguageDetector.detectLanguage(zhTrad);
        String langEn = LanguageDetector.detectLanguage(en);
        String langKo = LanguageDetector.detectLanguage(ko);
        String langJa = LanguageDetector.detectLanguage(ja);
        String langJaa = LanguageDetector.detectLanguage(jaa);

        logger.info("{str:{}, lang: {}}", zhSimp, langZh);
        logger.info("{str:{}, lang: {}}", zhTrad, langZhTrad);
        logger.info("{str:{}, lang: {}}", en, langEn);
        logger.info("{str:{}, lang: {}}", ko, langKo);
        logger.info("{str:{}, lang: {}}", ja, langJa);
        logger.info("{str:{}, lang: {}}", jaa, langJaa);
    }

}
