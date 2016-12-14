import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  Purpose:This Class includes the following methods:
 *  1- Method SAVE that will take a any object and it will save it as a serialized object and returning a unique key.
 *  2- Method Find that i can lookup for this object by the unique key.
 *
 *  Author: Lana Manaseer
 *  Data:13-12-2016
 *
 */
public class ObjectManipulator implements Iterable {

    //hashMap to store key-value pairs of type (Integer and Object).
    private HashMap<Integer, Object> mHashMap;

    File file;

    /**
     * default contractor to initialize hashMap.
     */
    public ObjectManipulator() {
        mHashMap = new HashMap<>();
    }

    /**
     * Pass a file as a a parameter to store the objects in file.
     *
     * @param file a file where to store the objects.
     */
    public ObjectManipulator(File file) {
//        super();
        mHashMap = new HashMap<>();
        this.file = file;
    }

    /**
     * take the argument and save in memory only while runtime.
     *
     * @param object that intended to be stored
     * @return integer indicating the key of the stored object.
     * if -1 it means that the storing process has failed.
     */
    public int saveObject(Object object) {
        //get a uniquely generated key for an object.
        int generatedKey = object.hashCode();

        if (file != null) {
            if (file.exists()) {//if file exist load it to the hashMap and put new Objects
                try {
                    mHashMap = readFromFile(file);
                    mHashMap.put(generatedKey, object);
                    writeToFile(file, mHashMap);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return -1;
                }
            } else {// if the file doesn't exist write the file.
                try {
                    file.createNewFile();
                    writeToFile(file, mHashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    return -1;
                }
            }
        } else {
            mHashMap.put(generatedKey, object);
        }
        //return the Object's Key.
        return generatedKey;
    }

    /**
     * method to search for an object using a key,
     * if it's found it will return the object.
     * if not it will return null
     *
     * @param key
     * @return Object if found
     */
    public Object findObject(int key) {
        mHashMap = getMapFromFile(file);
        return mHashMap.get(key);
    }

    /**
     * method to load a hashMap from the supplied file
     *
     * @param file loaded file that contains a hashMap.
     * @return the loaded hashMap from the file.
     */
    private HashMap getMapFromFile(File file) {
        HashMap map = null;
        if (file != null) {
            if (file.exists()) {
                try {
                    map = readFromFile(file);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    /**
     * take hashMap Object and store it in a file.
     *
     * @param file a file that we want to store in it.
     * @param map  is the hashMap  that contains the stored Objects.
     * @throws IOException will be caused by not finding the file or cannot open the stream.
     */
    private void writeToFile(File file, HashMap map) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(map);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * takes a file and returns the hashMap stored inside it.
     *
     * @param file is the file that contains the HashMap
     * @return a hashMap object that is stored inside the file.
     * @throws IOException            if we couldn't read from the file.
     * @throws ClassNotFoundException if the OutputStream couldn't read the object
     */
    private HashMap readFromFile(File file) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<Integer, Object> map = (HashMap<Integer, Object>) objectInputStream.readObject();
        objectInputStream.close();

        return map;
    }

    @Override
    public Iterator iterator() {
        mHashMap = getMapFromFile(file);
        return mHashMap.keySet().iterator();
    }


}
