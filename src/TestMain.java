import java.io.File;
import java.util.Iterator;


public class TestMain {


    public static void main(String[] args) {

        ObjectManipulator manipulator = new ObjectManipulator();

        //books
        Book blink = new Book("Blink", "Malcome Gladwell", "Self-Published");
        Book javaFirst = new Book("Java First", "Don't Know", "Self-Published");

        //Song
        Song oneMoreChance = new Song("One More Chance", "Michael Jackson", "MJ LTD");
        Song worldHoldOn = new Song("Hold On", "Bob Sincler", "MTV");

//        int chance = manipulator.saveObject(oneMoreChance);
//        int bli = manipulator.saveObject(blink);
//        int java = manipulator.saveObject(javaFirst);
//        int world = manipulator.saveObject(worldHoldOn);


        File f = new File("/Users/Lana_Manaseer/Desktop/Java1.txt");

        ObjectManipulator objectManipulator = new ObjectManipulator(f);

//        int chKey = objectManipulator.saveObject(oneMoreChance);
//        System.out.println(chKey);
//        System.out.println(objectManipulator.saveObject(worldHoldOn));
//        System.out.println(objectManipulator.findObject(chKey).getClass().toString());
//        objectManipulator.saveObject(blink);
//        objectManipulator.saveObject(javaFirst);

        objectManipulator.saveObject(oneMoreChance);
        objectManipulator.saveObject(worldHoldOn);
        objectManipulator.saveObject(blink);
        objectManipulator.saveObject(javaFirst);
        Iterator iterator = objectManipulator.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
