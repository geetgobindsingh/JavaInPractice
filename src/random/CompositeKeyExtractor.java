package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompositeKeyExtractor {
    /*
   /a => a
   /a/b => a.b
   /a/b/0/c => a.b#0.c
   /a/0/b/caption => a#0.b
   /b/0/i1 => b#0.i1
   /b/0/i1/caption => b#0.i1
   /a/0/b/0/i1 => a#0.b#0.i1
   /au/address => au
   /au/lonlat/0 => au
   /au/lonlat/1 => au

   au => location => answer => {'lonlat': [72.22, 27.22], 'address': 'asasasasas asasas'}

    */
    public static void main(String[] args) {
        System.out.println(convertIntoCompositeKey("/".split("/")));
        System.out.println(convertIntoCompositeKey("aaa".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/101".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/bbb".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/bbb/101".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/10/bbb".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/110/bbb/110".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/1110/bbb/1110/ccc".split("/")));
        System.out.println(convertIntoCompositeKey("/aaa/1110/bbb/1110/ccc/0".split("/")));
    }

    private static String convertIntoCompositeKey(String[] keys) {
        try {
            if (keys.length < 1) {
                return "";
            }
            if (keys.length < 2) {
                return (keys[0]);
            }
            if (keys.length < 3) {
                return (keys[1]);
            }

            String key = keys[1];
            for (int i = 2; i < (keys.length - 1); i++) {
                if (isIndex(keys[i])) {
                    key += ("#" + keys[i]);
                } else {
                    key += ("." + keys[i]);
                }
            }
            if (isIndex(keys[keys.length - 1])) {
                key += ("#" + keys[keys.length - 1]);
            } else {
                key += ("." + keys[keys.length - 1]);
            }
            return key;
        } catch (Exception ex) {
            ex.printStackTrace();
            return keys[1];
        }
    }

    public static boolean isIndex(String pattern) {
        String regex = "[0-9]+";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(pattern);

        return m.matches();
    }

    static class ModelSchemaProperty {
        public ArrayList<String> order = new ArrayList();

        public ArrayList<String> getOrder() {
            return order;
        }

        public ModelSchemaProperty items;

        public ModelSchemaProperty getItems() {
            return items;
        }

        public Map<String, ModelSchemaProperty> properties;

        public HashMap getProperties() {
            return (HashMap) properties;
        }

        public String description;

        public String getDescription() {
            return description;
        }

        public String type;

        public String getType() {
            return type;
        }
    }

    public String getCompositeKey(ModelSchemaProperty modelSchemaProperty, String path, String parent) {

        String initialCompositeKey = "";
        if (parent == null) {
            initialCompositeKey = path.substring(1).substring(0, firstLevelEndIndex(path.substring(1)));
        } else {
            initialCompositeKey = parent;
        }


        ArrayList<String> order = new ArrayList<>();
        HashMap properties = new HashMap();

        if (modelSchemaProperty.getOrder() == null) { // Array case
            order = (ArrayList<String>) modelSchemaProperty.getItems().getOrder();
            properties = (HashMap) modelSchemaProperty.getItems().getProperties();
        } else {
            order = (ArrayList<String>) modelSchemaProperty.getOrder();
            properties = (HashMap) modelSchemaProperty.getProperties();
        }

        for (String key : order) {
            if (key.equalsIgnoreCase(initialCompositeKey)) {
                ModelSchemaProperty schemaPropertyOfChild = (ModelSchemaProperty) properties.get(key);

                if (schemaPropertyOfChild == null) {
                    return initialCompositeKey;
                }

                if ("section".equalsIgnoreCase(schemaPropertyOfChild.getDescription())) {
                    if ("array".equalsIgnoreCase(schemaPropertyOfChild.getType())) {

                    } else {
                        return initialCompositeKey;
                    }
                } else {
                    if ("array".equalsIgnoreCase(schemaPropertyOfChild.getType())) {

                    } else {
                        return initialCompositeKey;
                    }
                }


                String second = "";
                String afterRemovingSecondString = "";

                String first = path.substring(1).substring(0, firstLevelEndIndex(path.substring(1)));
                String restOfString = path.substring(1).substring(firstLevelEndIndex("/"));

                if (restOfString.contains("/")) {

                    second = restOfString.substring(1).substring(0, firstLevelEndIndex(path.substring(1)));

                    afterRemovingSecondString = restOfString.substring(1).substring(firstLevelEndIndex("/"));
                }
                if (schemaPropertyOfChild.getType().equals("array")) {

                    initialCompositeKey = first + "#" + second;
                    String res = getCompositeKey(schemaPropertyOfChild, afterRemovingSecondString, null);
                    if (It.isNotEmpty(res)) {
                        return initialCompositeKey + "." + res;
                    } else {
                        return initialCompositeKey;
                    }
                } else if (schemaPropertyOfChild.getDescription().equals("section")) {
                    initialCompositeKey = first + "." + second;
                    String res = getCompositeKey(schemaPropertyOfChild, afterRemovingSecondString, null);
                    return initialCompositeKey + "." + res;

                } else {
                    if (It.isNotEmpty(second) && It.isNotEmpty(afterRemovingSecondString)) {
                        String temp = second + afterRemovingSecondString;

                        if (temp.equals("caption")) {
                            return first;
                        } else if (temp.equals("address")) {
                            return first;
                        } else if (temp.equals("clientTimestamp")) {
                            return first;
                        } else if (temp.equals("externalMedia")) {
                            return first;
                        } else {
                            return first + "." + temp;
                        }

                    }

                    return first;

                }


                // write logic
                // section - Simple/Array
                // non section - Simple/Array

            }
        }

        return initialCompositeKey;
    }

    public int firstLevelEndIndex(String path) {
        if (path.indexOf(".") > 0 && path.indexOf("[") > 0) {
            return path.indexOf("[");
        }

        if (path.indexOf("[") > 0) {
            return path.indexOf("[");
        }

        if (path.indexOf("/") > 0) {
            return path.indexOf("/");
        }

        return path.length();
    }
}
