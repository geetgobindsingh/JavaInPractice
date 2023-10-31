package serialisation;

import java.io.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A objA = new A();
        String serializedObjA = serializeObjectToString(objA);
        System.out.println(objA + " serialised: " + serializedObjA);
        objA.serialVersionUID = 123422122567L;
        System.out.println(objA + " deserialised: " + deSerializeObjectFromString(serializedObjA));

        B objB = new B();
        String serializedObjB = serializeObjectToString(objB);
        System.out.println(objB + " serialised: " + serializedObjB);
        System.out.println(objB + " deserialised: " + deSerializeObjectFromString(serializedObjB));

//        C objC = new C();
//        String serializedObjC = serializeObjectToString(objC);
//        System.out.println(objC + " serialised: " + serializedObjC);
//        System.out.println(objC + " deserialised: " + deSerializeObjectFromString(serializedObjC));
    }

    public static String serializeObjectToString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public static Object deSerializeObjectFromString(String s) throws IOException, ClassNotFoundException {

        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }
}
