package samplee;

import sample.Serializer;
import sample.dances.DanceList;

import java.lang.reflect.Method;

/**
 * Created by Seagull on 23.06.2015.
 */
public class CipherSerializer extends Serializer{
    private Class clazz;

    public CipherSerializer() {
        try {
            ClassLoader loader = getClass().getClassLoader();
            clazz = loader.loadClass("sample.cli.CipherCommand");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void serialize(DanceList list) {
        super.serialize(list);
        try {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.getName().equals("run")) {
                    method.invoke(clazz.newInstance(), null,
                            new String[]{"", "+", "DESede", ".key", Serializer.defaultXML, Serializer.filePath});
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public DanceList deserialize() {
        try {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.getName().equals("run")) {
                    method.invoke(clazz.newInstance(), null,
                            new String[]{"", "-", "DESede", ".key", Serializer.filePath, Serializer.defaultXML});
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return super.deserialize();
    }
}
