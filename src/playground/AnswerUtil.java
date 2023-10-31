package playground;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class AnswerUtil {

    private AnswerUtil() {
    }

    /*
    Grammar:
    S -> a | a.S | a#{0..9} | a#{0..9}+.S
     */

    public static void main(String[] args) {

        String oldValue = null;
        String newValue = null;

        System.out.println(isEqual(oldValue, newValue));

//        AnswerUtil answerUtil = new AnswerUtil();
//        String key = "";
//        HashMap<Object, Object> answer = new HashMap<>();
//        HashMap<Object, Object> mapS = new HashMap<>();
//        mapS.put("a", "A");
//        mapS.put("b", "B");
//        HashMap<Object, ArrayList<Object>> mapSA = new HashMap<>();
//        ArrayList arrayList = new ArrayList();
//        arrayList.add('a');
//        arrayList.add('b');
//        mapSA.put("s", arrayList);
//        mapS.put("sa", mapSA);
//
//        answer.put("a", "A");
//        answer.put("b", "B");
//        mapS.put("s", mapS);
//
//
//        key = "s.se#0.e";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, "A", answer));
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, "B", answer));
//        key = "s.se#1.e";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, "C", answer));
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, answer));


//
//        HashMap<Object, Object> answer = new HashMap<>();
//        key = "t";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, "A", answer));
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, answer));
//
//        HashMap<Object, Object> mapB = new HashMap<>();
//        key = "t#0";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, "A", mapB));
//        key = "t#1";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, "B", mapB));
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, mapB));
//
//
//        HashMap<Object, Object> mapC = new HashMap<>();
//        key = "m";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, answer, mapC));
//        key = "m.t";
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, mapC));
//
//        HashMap<Object, Object> mapD = new HashMap<>();
//        mapD.put("m", mapC);
//        key = "m";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, mapC, mapD));
//        key = "m.m.t";
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, mapD));
//
//        HashMap<Object, Object> mapE = new HashMap<>();
//        key = "m";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, mapB, mapE));
//        key = "m.t#1";
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, mapE));
//
//        HashMap<Object, Object> mapF = new HashMap<>();
//        ArrayList arrayListF = new ArrayList();
//        arrayListF.add(answer);
//        arrayListF.add(answer);
//        key = "m";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, arrayListF, mapF));
//        key = "m#1.t";
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, mapF));
//
//        HashMap<Object, Object> mapG = new HashMap<>();
//        ArrayList arrayListG = new ArrayList();
//        arrayListG.add(mapC);
//        arrayListG.add(mapC);
//        key = "m";
//        System.out.println("Result for: " +  key + " is " + answerUtil.setValueFromAnswerFor(key, arrayListG, mapG));
//        key = "m#1.m.t";
//        System.out.println("Result for: " +  key + " is " + answerUtil.getValueFromAnswerFor(key, mapG));
    }

    private static boolean isEqual(Object oldValue, Object newValue) {
        if (oldValue == null) {
            if (newValue == null) {
                return true;
            }
            return false;
        } else {
            if (newValue == null) {
                return false;
            }
            return oldValue.equals(newValue);
        }
    }

    public static boolean setValueFromAnswerFor(String key, Object value, HashMap<Object, Object> map) {
        boolean result = false;

        if (key == null || key.isEmpty()) {
            return false;
        }
        if (map == null) {
            return false;
        }

        try {
            if (!containsHash(key) && !containsDot(key)) {
                if (value == null) {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                } else {
                    map.put(key, value);
                }
                return true;
            } else if (containsHash(key) && containsDot(key)) {
                int indexOfHash = key.indexOf("#");
                int indexOfDot = key.indexOf(".");
                if (indexOfDot < indexOfHash) {
                    String intermediateKey = key.substring(0, indexOfDot);
                    HashMap<Object, Object> intermediateMap = (HashMap<Object, Object>) map.get(intermediateKey);
                    if (intermediateMap == null) {
                        intermediateMap = new HashMap<>();
                        map.put(intermediateKey, intermediateMap);
                    }
                    return setValueFromAnswerFor(key.substring(indexOfDot + 1, key.length()), value, intermediateMap);
                } else {
                    String intermediateKey = key.substring(0, indexOfHash);
                    int index = Integer.parseInt(key.substring(indexOfHash + 1, indexOfDot));
                    ArrayList<HashMap> list = (ArrayList<HashMap>) map.get(intermediateKey);
                    if (list == null) {
                        list = new ArrayList<HashMap>();
                        map.put(intermediateKey, list);
                    }
                    //index can be equal to list size when list intaialize (first time)
                    if (index == list.size()) {
                        list.add(new HashMap());
                    }
                    if (index < list.size()) {
                        return setValueFromAnswerFor(key.substring(indexOfDot + 1, key.length()), value, list.get(index));
                    }
                }
            } else if (containsHash(key)) {
                int indexOfHash = key.indexOf("#");
                String intermediateKey = key.substring(0, indexOfHash);
                int index = Integer.parseInt(key.substring(indexOfHash + 1, key.length()));
                ArrayList list = (ArrayList) map.get(intermediateKey);
                if (list == null) {
                    list = new ArrayList();
                    map.put(intermediateKey, list);
                }
                if (value != null) {
                    if (index < list.size()) {
                        list.set(index, value);
                    } else {
                        list.add(value);
                    }
                } else {
                    if (index < list.size()) {
                        list.remove(index);
                    }
                }
                map.put(intermediateKey, list);
                result = true;
            } else if (containsDot(key)) {
                int indexOfDot = key.indexOf(".");
                String intermediateKey = key.substring(0, indexOfDot);
                HashMap<Object, Object> intermediateMap = (HashMap<Object, Object>) map.get(intermediateKey);
                if (intermediateMap == null) {
                    intermediateMap = new HashMap<>();
                    map.put(intermediateKey, intermediateMap);
                }
                return setValueFromAnswerFor(key.substring(indexOfDot + 1, key.length()), value, intermediateMap);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }


    public Object getValueFromAnswerFor(String key, HashMap map) {
        Object result = null;
        if (key == null || key.isEmpty() || map == null) {
            return null;
        }
        try {
            if (!containsHash(key) && !containsDot(key)) {
                if (map.containsKey(key)) {
                    result = map.get(key);
                }
            } else if (containsHash(key) && containsDot(key)) {
                int indexOfHash = key.indexOf("#");
                int indexOfDot = key.indexOf(".");
                if (indexOfDot < indexOfHash) {
                    String intermediateKey = key.substring(0, indexOfDot);
                    HashMap<Object, Object> intermediateMap = null;
                    if (map.containsKey(intermediateKey)) {
                        intermediateMap = (HashMap<Object, Object>) map.get(intermediateKey);
                    }
                    if (intermediateMap != null) {
                        result = getValueFromAnswerFor(key.substring(indexOfDot + 1, key.length()), intermediateMap);
                    }
                } else {
                    String intermediateKey = key.substring(0, indexOfHash);
                    int index = Integer.parseInt(key.substring(indexOfHash + 1, indexOfDot));
                    ArrayList<HashMap> list = null;
                    if (map.containsKey(intermediateKey)) {
                        list = (ArrayList<HashMap>) map.get(intermediateKey);
                    }
                    if (list != null && !list.isEmpty() && index < list.size()) {
                        result = getValueFromAnswerFor(key.substring(indexOfDot + 1, key.length()), list.get(index));
                    }
                }
            } else if (containsHash(key)) {
                int indexOfHash = key.indexOf("#");
                String intermediateKey = key.substring(0, indexOfHash);
                int index = Integer.parseInt(key.substring(indexOfHash + 1, key.length()));
                ArrayList list = null;
                if (map.containsKey(intermediateKey)) {
                    list = (ArrayList) map.get(intermediateKey);
                }
                if (list != null && !list.isEmpty() && index < list.size()) {
                    result = list.get(index);
                }
            } else if (containsDot(key)) {
                int indexOfDot = key.indexOf(".");
                String intermediateKey = key.substring(0, indexOfDot);
                HashMap<Object, Object> intermediateMap = null;
                if (map.containsKey(intermediateKey)) {
                    intermediateMap = (HashMap<Object, Object>) map.get(intermediateKey);
                }
                if (intermediateMap != null) {
                    result = getValueFromAnswerFor(key.substring(indexOfDot + 1, key.length()), intermediateMap);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private static boolean containsDot(String key) {
        return key.contains(".");
    }

    private static boolean containsHash(String key) {
        return key.contains("#");
    }
}
