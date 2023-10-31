package random;

/**
 * Created by geetgobindsingh on 16/10/17.
 */
public class PersonalisedDictNameTest {
    public static void main(String[] args) {
        String languageCode = getLanguageCode("en.dict.dict");
        System.out.print(languageCode);
    }


    public static String getLanguageCode(String fileName) {
        try {
            int indexOfDot = fileName.lastIndexOf('.');
            String fileNameWithoutFileExt = fileName.substring(0, indexOfDot);
            String[] splitedFileName = fileNameWithoutFileExt.split("_");

            if (splitedFileName.length > 2) {
                return splitedFileName[1] + '_' + splitedFileName[2];
            }

            return splitedFileName.length > 1 ? splitedFileName[1] : splitedFileName.length > 0 ? splitedFileName[0] : "";
        } catch (Exception ex) {
            return "";
        }
    }
}
