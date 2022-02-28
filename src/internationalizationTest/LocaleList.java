package internationalizationTest;

import java.util.Locale;

/**
 * Package: internationalizationTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/17 18:39
 * <p>
 * Version: 0.0.1
 */
public class LocaleList {
    public static void main(String[] args) {
        // 返回Java所支持的全部国家和语言的数组
        Locale[] localeList =Locale.getAvailableLocales();
        for (Locale locale : localeList){
            System.out.println(locale.getDisplayCountry()+ "=" + locale.getCountry()+" "
                    + locale.getDisplayLanguage()+ "=" +locale.getLanguage());
        }
    }
}
