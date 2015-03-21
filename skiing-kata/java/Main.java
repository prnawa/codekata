import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readStdIn();
        String[] rowsCols = input.get(0).split("\\s");
        int columns = Integer.parseInt(rowsCols[0]);
        int rows = Integer.parseInt(rowsCols[1]);

        SkiMap map = new SkiMap(columns, rows);
        int[] elevations = new int[columns*rows];
        int index = 0;

        for (int i = 1; i < input.size(); i++){
            String[] elevs = input.get(i).split("\\s");
            for (String ele : elevs){
                elevations[index] = Integer.parseInt(ele);
                index++;
            }
        }

        map.Initialize(elevations);
        String path = map.getLongestDeepestPath();
        String[] pathSplit = path.split("-");
        System.out.println(String.format("Length of travel : %d", pathSplit.length));
        System.out.println(String.format("Depth of travel : %d", Integer.parseInt(pathSplit[0]) - Integer.parseInt(pathSplit[pathSplit.length - 1])));
    }

    private static ArrayList<String> readStdIn(){
        ArrayList<String> input = new ArrayList<String>();

        try{
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);

            String line;

            while((line=br.readLine())!=null){
                input.add(line);
            }

        }catch(IOException io){
            io.printStackTrace();
        }

        return input;
    }
}
