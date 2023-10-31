package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by geetgobindsingh on 03/11/17.
 */
public class LanguageCodeTest {

    public static void main(String[] args) {
        System.out.println(getRelevantLanguageCodeForGivenLanguageCode("en"));
    }

    public static String getRelevantLanguageCodeForGivenLanguageCode(String languageCode) {
        if (It.isNotNull(languageCode) && (languageCode.equals("en"))) {
            ArrayList<String> latinLanguageCodes = getLatinLanguageCodes();

            if (It.isFalse(latinLanguageCodes.isEmpty())) {
                // Sorting it in ascending order
                Collections.sort(latinLanguageCodes);
                for (String latinLanguageCode : latinLanguageCodes) {
                    languageCode = languageCode + "-" + latinLanguageCode;
                }
            }
        }

        return languageCode;
    }

    public static ArrayList<String> getLatinLanguageCodes() {
        ArrayList<String> latinLanguagesCodes = new ArrayList<>();
        int count = 0;

        List<BobbleKeyboardLanguage> keyboardLanguages = getAllDownloadedBobbleKeyboardLanguagesWithIsInTransliterationFalse();
        for (BobbleKeyboardLanguage keyboardLanguage : keyboardLanguages) {
            if (It.isFalse( keyboardLanguage.getLanguageCode().equals("en"))) {
                if (true) {
                    if (count >= 3) {
                        break;
                    } else {
                        latinLanguagesCodes.add(keyboardLanguage.getLanguageCode());
                        count++;
                    }
                }
            }
        }

        return latinLanguagesCodes;
    }

    private static List<BobbleKeyboardLanguage> getAllDownloadedBobbleKeyboardLanguagesWithIsInTransliterationFalse() {
        List<BobbleKeyboardLanguage> list = new ArrayList<>();

        BobbleKeyboardLanguage bobbleKeyboardLanguageEn = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguageEn.setLanguageCode("en");
        list.add(bobbleKeyboardLanguageEn);
        BobbleKeyboardLanguage bobbleKeyboardLanguageHi = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguageHi.setLanguageCode("hi");
        list.add(bobbleKeyboardLanguageHi);
        BobbleKeyboardLanguage bobbleKeyboardLanguageHi2 = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguageHi2.setLanguageCode("hi");
        list.add(bobbleKeyboardLanguageHi2);
        BobbleKeyboardLanguage bobbleKeyboardLanguageHi3 = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguageHi3.setLanguageCode("hi");
        list.add(bobbleKeyboardLanguageHi3);

        BobbleKeyboardLanguage bobbleKeyboardLanguage = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguage.setLanguageCode("en");
        list.add(bobbleKeyboardLanguage);
        BobbleKeyboardLanguage bobbleKeyboardLanguagebn = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguagebn.setLanguageCode("bn");
        list.add(bobbleKeyboardLanguagebn);
        BobbleKeyboardLanguage bobbleKeyboardLanguagehi4 = new BobbleKeyboardLanguage();
        bobbleKeyboardLanguagehi4.setLanguageCode("hi");
        list.add(bobbleKeyboardLanguagehi4);
        return list;
    }

    public static class BobbleKeyboardLanguage {
        public BobbleKeyboardLanguage() {

        }
        public String getLanguageCode() {
            return languageCode;
        }

        public void setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
        }

        private String languageCode;
    }

}
