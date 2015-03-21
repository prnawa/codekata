import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SkiMap {
    private int[] elevations;
    private int sizeX;
    private int sizeY;
    private HashMap<Integer, ArrayList<String>> cache = new HashMap<Integer, ArrayList<String>>();

    public SkiMap(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void Initialize(int[] elevations) {
        this.elevations = Arrays.copyOfRange(elevations, 0, sizeX * sizeY);
    }

    public ArrayList<String> getLongestPath() {

        ArrayList<String> paths = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < elevations.length; i++){
            paths.addAll(visit(i));
        }

        paths.sort(new LengthComparator(""));

        result.add(paths.get(0));

        for(int i = 1; i< paths.size(); i++){
            if(paths.get(0).length() == paths.get(i).length()){
                result.add(paths.get(i));
            }else {
                break;
            }
        }

        return result;
    }

    public String getLongestDeepestPath() {
        ArrayList<String> paths = getLongestPath();
        int index = 0;
        int deep = 0;

        for (String path : paths){
            String[] boxes = path.split("-");
            int tempDeep = Integer.parseInt(boxes[0]) - Integer.parseInt(boxes[boxes.length - 1]);
            if (deep < tempDeep){
                deep = tempDeep;
                index = paths.indexOf(path);
            }
        }

        return paths.get(index);
    }

    class LengthComparator implements java.util.Comparator<String> {

        private int referenceLength;

        public LengthComparator(String reference) {
            super();
            this.referenceLength = reference.length();
        }

        public int compare(String s1, String s2) {
            int dist1 = Math.abs(s1.length() - referenceLength);
            int dist2 = Math.abs(s2.length() - referenceLength);

            return dist2 - dist1;
        }
    }

    private ArrayList<String> visit(int i) {

        if(cache.containsKey(i)){
            return cache.get(i);
        }

        ArrayList<String> paths = new ArrayList<String>();

        ArrayList<Integer> directions = getDirections(i);

        if (directions.size() == 0) {
            paths.add(String.valueOf(elevations[i]));
            cache.put(i, paths);
            return paths;
        }

        for (int direction : directions){
            ArrayList<String> subPaths = visit(direction);
            for (String subPath : subPaths){
                paths.add(elevations[i] + "-" + subPath);
            }
        }
        cache.put(i, paths);

        return paths;
    }



    private ArrayList<Integer> getDirections(int currentBox){
        ArrayList<Integer> directions = new ArrayList<Integer>();

        int yDir = currentBox / sizeX;
        int xDir = currentBox - sizeX * yDir;

        if(xDir - 1 >= 0 && elevations[currentBox] > elevations[(xDir - 1) + sizeX * yDir]){
            directions.add((xDir - 1) + sizeX * yDir);
        }

        if(xDir + 1 <= sizeX -1 && elevations[currentBox] > elevations[(xDir + 1) + sizeX * yDir]){
            directions.add((xDir + 1) + sizeX * yDir);
        }

        if(yDir - 1 >= 0 && elevations[currentBox] > elevations[xDir + sizeX * (yDir - 1)]){
            directions.add(xDir + sizeX * (yDir - 1));
        }

        if(yDir + 1 <= sizeY - 1 && elevations[currentBox] > elevations[xDir + sizeX * (yDir + 1)]){
            directions.add(xDir + sizeX * (yDir + 1));
        }

        return directions;
    }
}
