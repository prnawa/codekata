import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SkiMapTest {

    @Before
    public void setUp() {

    }

    @Test
    public void getLongestPath_should_return_expected_longest_path_when_map_is_1x1(){
        SkiMap map = new SkiMap(1, 1);
        map.Initialize(new int[]{1});

        ArrayList<String> longestPath = map.getLongestPath();
        Assert.assertEquals("1", longestPath.get(0));
    }

    @Test
    public void getLongestPath_should_return_expected_longest_path_when_map_is_2x2(){
        SkiMap map = new SkiMap(2, 2);
        map.Initialize(new int[]{1, 2, 4, 3});

        ArrayList<String> longestPath = map.getLongestPath();

        Assert.assertEquals(1, longestPath.size());
        Assert.assertTrue(longestPath.contains("4-3-2-1"));
    }

    @Test
    public void getLongestPath_should_return_expected_longest_path_when_map_is_3x3(){
        SkiMap map = new SkiMap(3, 3);
        map.Initialize(new int[]{ 1, 2, 3, 4, 5, 9, 7, 8, 6});

        ArrayList<String> longestPath = map.getLongestPath();
        Assert.assertEquals(6, longestPath.size());
        Assert.assertTrue(longestPath.contains("9-5-4-1"));
        Assert.assertTrue(longestPath.contains("9-5-2-1"));
        Assert.assertTrue(longestPath.contains("9-3-2-1"));
        Assert.assertTrue(longestPath.contains("8-7-4-1"));
        Assert.assertTrue(longestPath.contains("8-5-4-1"));
        Assert.assertTrue(longestPath.contains("8-5-2-1"));
    }

    @Test
    public void getLongestPath_should_return_expected_longest_path_when_map_is_4x4_and_values_are_random(){
        SkiMap map = new SkiMap(4, 4);

        map.Initialize(new int[]{4, 8, 7, 3, 2, 5, 9, 3, 6, 3, 2, 5, 4, 4, 1, 6});

        ArrayList<String> longestPath = map.getLongestPath();

        Assert.assertEquals(2, longestPath.size());
        Assert.assertTrue(longestPath.contains("8-5-3-2-1"));
        Assert.assertTrue(longestPath.contains("9-5-3-2-1"));
    }

    @Test
    public void getLongestDeepestPath_should_return_expected_single_path_when_map_is_4x4_and_values_are_random(){
        SkiMap map = new SkiMap(4, 4);

        map.Initialize(new int[]{4, 8, 7, 3, 2, 5, 9, 3, 6, 3, 2, 5, 4, 4, 1, 6});

        String longestPath = map.getLongestDeepestPath();

        Assert.assertTrue(longestPath.contains("9-5-3-2-1"));
    }
}