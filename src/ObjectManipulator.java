import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  Purpose:This Class includes the following methods:
 *  1- Method SAVE that will take a any object and it will save it as a serialized object and returning a unique key.
 *  2- Method Find that i can lookup for this object by the unique key.
 *
 *  this class is build to store in memory and a file
 *  use the default constructor to store in memory while runtime.
 *  and to store in a file use ObjectManipulator(File file) constructor.
 *
 *  Author: Lana Manaseer
 *  Data:13-12-2016
 *
 */
public class ObjectManipulator implements Iterable {

    //hashMap to store key-value pairs of type (Integer and Object).
    private HashMap<Integer, Object> mHashMap;

    private File file;

    private FileManager mFileManager;

    /**
     * default contractor to initialize hashMap.
     */
    public ObjectManipulator() {
        mHashMap = new HashMap<>();
        mFileManager = new FileManager();
    }

    /**
     * Pass a file as a a parameter to store the objects in file.
     *
     * @param file a file where to store the objects.
     */
    public ObjectManipulator(File file) {
        this();
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
                    mHashMap = mFileManager.readFromFile(file);
                    mHashMap.put(generatedKey, object);
                    mFileManager.writeToFile(file, mHashMap);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return -1;
                }
            } else {// if the file doesn't exist write the file.
                try {
                    file.createNewFile();
                    mFileManager.writeToFile(file, mHashMap);
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
     * @param key key for an object in th hashMap
     * @return Object if found
     */
    public Object findObject(int key) {
    	if (file != null)mHashMap = mFileManager.getMapFromFile(file);
        return mHashMap.get(key);
    }

    @Override
    public Iterator iterator() {
    	if (file != null)mHashMap = mFileManager.getMapFromFile(file);
    	return mHashMap.keySet().iterator();
    }


}
