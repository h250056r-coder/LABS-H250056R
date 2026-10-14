/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 7, Basic 2 */
public class Q2_ArrayAccess {
    static String getAt(String[] names, int index) {
        try { return names[index]; }
        catch (ArrayIndexOutOfBoundsException ex) { return "No name is stored at position " + index; }
    }
    public static void main(String[] args) {
        String[] labPartners = { "Tishlee", "Tariro", "Anesu" };
        System.out.println(getAt(labPartners, 1));
        System.out.println(getAt(labPartners, 5));
    }
}
