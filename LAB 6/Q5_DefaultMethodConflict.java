/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 6, Challenge */
public class Q5_DefaultMethodConflict {
    interface CampusMember { default void hello() { System.out.println("Hello from the campus side."); } }
    interface ClubMember { default void hello() { System.out.println("Hello from the club side."); } }
    static class Student implements CampusMember, ClubMember {
        @Override public void hello() {
            CampusMember.super.hello();
            ClubMember.super.hello();
            System.out.println("A class must resolve two inherited defaults with the same signature.");
        }
    }
    public static void main(String[] args) { new Student().hello(); }
}
