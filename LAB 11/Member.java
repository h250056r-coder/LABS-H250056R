/* Tishlee Mvududu | H250056R | HIT Software Engineering | Lab 11 mini-project */
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Member {
    private final String id;
    private final String name;
    private final Set<String> activeItemIds = new LinkedHashSet<>();
    public Member(String id, String name) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) throw new IllegalArgumentException("Member id and name are required.");
        this.id = id.trim(); this.name = name.trim();
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public Set<String> getActiveItemIds() { return Collections.unmodifiableSet(activeItemIds); }
    void addLoan(String itemId) { activeItemIds.add(itemId); }
    void removeLoan(String itemId) { activeItemIds.remove(itemId); }
    @Override public String toString() { return id + " | " + name + " | active loans: " + activeItemIds.size(); }
}
