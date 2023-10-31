package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActionMatrictest {

    public static void main(String[] args) {

        ArrayList<ModelSchemaProperty> modelSchemaPropertyList = new ArrayList();

        modelSchemaPropertyList.add(new ModelSchemaProperty(null, "a", null));
        modelSchemaPropertyList.add(new ModelSchemaProperty(null, "b", getChildren()));
        ModelSchemaProperty modelSchemaProperty = new ModelSchemaProperty(null, "d", getChildren());
        modelSchemaPropertyList.add(new ModelSchemaProperty(modelSchemaProperty, "c", null));

        Map<String, AccessMatrix> fields = new HashMap<>();
        fields.put("a", new AccessMatrix(true, true, true));
        fields.put("b.x", new AccessMatrix(true, true, true));
        fields.put("c.x", new AccessMatrix(true, true, true));

        getThingsDone(modelSchemaPropertyList, fields);

        for (ModelSchemaProperty schemaProperty : modelSchemaPropertyList) {
            System.out.println(schemaProperty.key);
        }
    }

    private static void getThingsDone(ArrayList<ModelSchemaProperty> modelSchemaPropertyList, Map<String, AccessMatrix> fields) {

        ArrayList<ModelSchemaProperty> modelSchemaPropertyListTemp = new ArrayList<>();

//        for (String key : fields.keySet()) {
            for (ModelSchemaProperty modelSchemaProperty : modelSchemaPropertyList) {
                if (fields.containsKey(modelSchemaProperty.key)) {
                    modelSchemaPropertyListTemp.add(modelSchemaProperty);
                } else {

                }
            }
//        }

        modelSchemaPropertyList = new ArrayList<>(modelSchemaPropertyListTemp);

    }

    private static Map<String, ModelSchemaProperty> getChildren() {
        Map<String, ModelSchemaProperty> modelSchemaPropertyMap = new HashMap<>();
        modelSchemaPropertyMap.put("x", new ModelSchemaProperty(null, "x", null));
        modelSchemaPropertyMap.put("y", new ModelSchemaProperty(null, "y", null));
        return modelSchemaPropertyMap;
    }

    static class ModelSchemaProperty {
        ModelSchemaProperty item;
        Map<String, ModelSchemaProperty> properties;
        String key;

        public ModelSchemaProperty(ModelSchemaProperty item, String key, Map<String, ModelSchemaProperty> properties) {
            this.item = item;
            this.properties = properties;
            this.key = key;
        }
    }

    static  class AccessMatrix {
        boolean mandatory = false;
        boolean visibility = false;
        boolean readonly = false;
        public AccessMatrix(boolean mandatory, boolean visibility, boolean readonly) {
            this.mandatory = mandatory;
            this.visibility = visibility;
            this.readonly = readonly;
        }
    }
}


