import java.util.Arrays;
import java.util.List;

public class User {

    public final int aditionUserId;
    public final int newUserId;
    public final int externalUserId;
    public final int clicks;

    public User(int aditionUserId, int newUserId, int externalUserId, int clicks) {
        this.aditionUserId = aditionUserId;
        this.newUserId = newUserId;
        this.externalUserId = externalUserId;
        this.clicks = clicks;
    }

    public int getClicks() {
        return clicks;
    }

    public List<Integer> getAllIdsInAList() {
        return Arrays.asList(aditionUserId, newUserId, externalUserId);
    }
}
