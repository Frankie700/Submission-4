import java.io.*;

public class GroupPersistence {
    public static void saveGroup(Group group, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(group);
        } catch (IOException e) {
            System.out.println("Problem saving the file: " + e.getMessage());
        }
    }

    public static Group loadGroup(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Group) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Problem loading the file: " + e.getMessage());
            return null;
        }
    }
}
