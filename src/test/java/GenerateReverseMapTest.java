import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateReverseMapTest {

    private final ReverseMapGenerator reverseMapGenerator = new ReverseMapGenerator();

    /*
    This map maps all the user IDs (all the 3 user IDs above) to a list of tag IDs that the user was
    tagged with.

     userIdToTagId = Map {
            11: [200],
            13: [100, 200],
            21: [100],
            23: [400],
            31: [100],
            32: [100, 300],
            33: [100],
            41: [400]
     }
    */
    private final Map<Integer, List<Integer>> userIdToTagId = Map.ofEntries(
            Map.entry(11, Collections.singletonList(200)),
            Map.entry(13, Arrays.asList(100, 200)),
            Map.entry(21, Collections.singletonList(100)),
            Map.entry(23, Collections.singletonList(400)),
            Map.entry(31, Collections.singletonList(100)),
            Map.entry(32, Arrays.asList(100, 300)),
            Map.entry(33, Collections.singletonList(100)),
            Map.entry(41, Collections.singletonList(400))
    );

    /*
    This map counts for each banner id how many clicks a user made on this banner. A user is
    represented by a tuple of 3 user IDs (adition-user-ID, new-user-ID, external-user-ID).

    In class User there are 4 fields: aditionUserId, newUserId, externalUserId, clicks.
    First 3 user id fields represent the same user, but ids are taken from different systems.
    Clicks field shows how many times user clicked.

    bannerIdToUserIdsCount = Map {
        111111:                         // click ids for banner 111111
            [
                User (11, 12, 13, 2)    // click ids 1 and 2
            ]
        ),
        222222:                         // click ids for banner 222222
            [
                User (21, 22, 23, 1),   // click id 1
                User (31, 32, 33, 1),   // click id 2
                User (41, 42, 43, 1)    // click id 3
             ]
        )
    }
    */
    private final Map<Integer, List<User>> bannerIdToUserIdsCount = Map.ofEntries(
            Map.entry(111111, Collections.singletonList(
                    new User(11, 12, 13, 2))),
            Map.entry(222222, Arrays.asList(
                    new User(21, 22, 23, 1),
                    new User(31, 32, 33, 1),
                    new User(41, 42, 43, 1)))
    );

    /*
    This map maps the banner id to its reverse map.
    A reverse map is a map that maps tag IDs to list of click IDs (these are re-mapped to 1,...,n for each
    banner).
    Note that different clicks can be made by different users or also by the same user.

    expectedReverseMaps = Map {
        111111: {
            100: [1, 2],
            200: [1, 2]
        },
        222222: {
            100: [1, 2],
            300: [2],
            400: [1, 3]
        }
    }
    */
    private final Map<Integer, Map<Integer, List<Integer>>> expectedBannerIdToReverseMap = Map.ofEntries(
            Map.entry(111111, Map.ofEntries(
                    Map.entry(100, Arrays.asList(1, 2)),
                    Map.entry(200, Arrays.asList(1, 2))
            )),
            Map.entry(222222, Map.ofEntries(
                    Map.entry(100, Arrays.asList(1, 2)),
                    Map.entry(300, Collections.singletonList(2)),
                    Map.entry(400, Arrays.asList(1, 3))
            ))
    );

    @Test
    void GenerateReverseMap() {
        Map<Integer, Map<Integer, List<Integer>>> bannerIdToReverseMap =
                reverseMapGenerator.generateReverseMap(userIdToTagId, bannerIdToUserIdsCount);
        assertEquals(bannerIdToReverseMap, expectedBannerIdToReverseMap);
    }

}
