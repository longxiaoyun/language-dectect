# language-detect
> 使用不同语言的unicode编码，来简单识别语种的小工具，对语言里边柔和了其他语种的复杂语言，识别不了，对字符串做了去除数字、标点字符及空格的处理

使用
```java
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
```
结果
```shell script
[main] INFO com.jonloong.is.detection.LanguageDetectionApplication - {str:十年生死两茫茫, lang: zh}
[main] INFO com.jonloong.is.detection.LanguageDetectionApplication - {str:不思量自難忘, lang: zh}
[main] INFO com.jonloong.is.detection.LanguageDetectionApplication - {str:To be, or not to be, lang: en}
[main] INFO com.jonloong.is.detection.LanguageDetectionApplication - {str:오늘 비가옵니다, lang: ko}
[main] INFO com.jonloong.is.detection.LanguageDetectionApplication - {str:こんにちは, lang: ja}
[main] INFO com.jonloong.is.detection.LanguageDetectionApplication - {str:私はあなたを愛しています中国, lang: }
```

可见日语中包含了中文的，识别不了，复杂的还是需要用语中是别的模型算法来做，比如 language-detector
https://github.com/optimaize/language-detector
