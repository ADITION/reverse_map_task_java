import java.util.List;
import java.util.Map;

public class ReverseMapGenerator {

    public Map<Integer, Map<Integer, List<Integer>>> generateReverseMap(
            Map<Integer, List<Integer>> userIdToTagIds,
            Map<Integer, List<User>> bannerIdToUserIdsCount) {

        /*
        Generates a map that maps banner ID to its reverse map.
        A reverse map here maps the tag ID to the list of click IDs, where all the clicks were made by users that are
        tagged with this tag ID. Note that several clicks can be made by the same user.
        For simplicity we map the click IDs to 1,...,n for each banner ID, where the 1st click ID found is mapped to
        1, the 2nd to 2, etc.
        Args:
            userIdToTagIds: This map maps a user ID to a list of tag IDs that the user was tagged with.
            bannerIdToUserIdsCount: This map counts for each banner how many clicks a user made on this banner.
                A user is represented by 3 user IDs (aditionUserId, newUserId, externalUserId) and you can also find
                the number of clicks that user made in the clicks field of the User class.
        Returns:
            bannerIdToReverseMap: The map that maps a banner ID to its reverse map.
        */

        // your code here
        // ...
        return null;
    }
}
