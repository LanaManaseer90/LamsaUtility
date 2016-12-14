import java.io.*;
import java.util.HashMap;

/**
 *  Purpose:This Class includes the following methods:
 *  1- Method writeToFile that will take a file and it will save it.
 *  2- Method readFromFile that will read a file.
 *  3- Method getMapFromFile return a hashMap from a file.
 *
 *  Author: Lana Manaseer
 *  Data:13-12-2016
 *
 */
public class FileManager {

    /**
     * take hashMap Object and store it in a file.
     *
     * @param file a file that we want to store in it.
     * @param map  is the hashMap  that contains the stored Objects.
     * @throws IOException will be caused by not finding the file or cannot open the stream.
     */
    public void writeToFile(File file, HashMap<Integer, Object> map) throws IOException {

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
    public HashMap<Integer, Object> readFromFile(File file) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<Integer, Object> map = (HashMap<Integer, Object>) objectInputStream.readObject();
        objectInputStream.close();

        return map;
    }

    /**
     * method to load a hashMap from the supplied file
     *
     * @param file loaded file that contains a hashMap.
     * @return the loaded hashMap from the file.
     */
    public HashMap<Integer, Object> getMapFromFile(File file) {
        HashMap<Integer, Object> map = null;
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
}
