package maze;

import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.net.URL;

public class Maze {


    public static void main(String[] args) {
               
        MazeMovements objMaze = new MazeMovements(41,41);
        int[][] mazeArray = objMaze.getMazeArray();
        // obj.run();
        
        String URL = Maze.class.getResource("Maze - Input MAC.csv").getPath();
        String URL2 = "maze/Maze - Input MAC.csv";

        String csvFile;
        csvFile = "/Users/davidsabzanov/Documents/mze/maze/Maze - Input MAC.csv";  // FULL file path might be needed to read file
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
   
        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            int y = 0;
            while ((line = br.readLine()) != null) {
         
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
         
                for (int x = 0; x<41; x++) {
                    mazeArray[y][x] = Integer.parseInt(data[x+1]); 
                    System.out.print(mazeArray[y][x] + " ");
                }
                System.out.println();
                y++;
            }           
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
                try {
                br.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
    // ---- END IMPORT CSV FILE ----- 
    objMaze.startMaze();
    
    
    }
    
    
    
}
