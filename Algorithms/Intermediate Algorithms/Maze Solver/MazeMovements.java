package maze;

public class MazeMovements {
    private int rows;
    private int cols;  
    private int currXPosition;
    private int currYPosition;    
    private int mazeArray[][];
    private int currentDirection; //(1-go right, 2-go down, 3-go left, 4- go up)
    private int returnDirection; //opposite of current direction
    private boolean bBackingUp;
    
    public MazeMovements(int colsnum, int rowsnum){
        cols = colsnum;
        rows = rowsnum;
        mazeArray = new int[rows][cols]; 
        currXPosition = -1;
        currYPosition = -1;
        //bBackingUp = false;
    }
    
    public int[][] getMazeArray(){
        return mazeArray;
    }
    public void startMaze(){
        
        //1.Find start position
        findStartPosition();        
        //2.Start Moving (set to 2)
        move(currYPosition, currXPosition);//startMoving();
        //if get stuck (value 0), then set direction (clockwise from last direction except for the reverse)
        //if nowhere to go then backtrack (set to 3)
        
        
    }
    //1.Find start position
    public void findStartPosition() {
        for(int y = 0; y < rows; y++){
            for (int x = 0; x<cols; x++) {          
                if (mazeArray[y][x] == 1) {
                    currXPosition = x;
                    currYPosition = y;
                    break;
                }                
            }
            if(currXPosition != -1){ break;}
        }
    }
    
    
    //2.Set Direction
//    public void setDirection(){
//        int retD = returnDirection;
//        int curD = 0;
//        //(1-go right, 2-go down, 3-go left, 4- go up)
//        if(isValid(mazeArray[currYPosition][currXPosition + 1]) && returnDirection != 1){ //1-go right
//            curD = 1;
//            returnDirection = 3;
//        }else if (isValid(mazeArray[currYPosition + 1][currXPosition]) && returnDirection != 2){ //2-go down
//            curD = 2;
//            returnDirection = 4;
//        }else if (isValid(mazeArray[currYPosition][currXPosition - 1]) && returnDirection != 3){ //3-go left
//            curD = 3;
//            returnDirection = 1;
//        }else if (isValid(mazeArray[currYPosition - 1][currXPosition]) && returnDirection != 4){ //4-go up
//            curD = 4;
//            returnDirection = 2;
//        }
//        if (curD == 0){
//            bBackingUp = true;
//            currentDirection = retD;            
//        }else{
//            bBackingUp = false;
//            currentDirection = curD;
//        }
//    }
//    private void move(){
//         switch(currentDirection){
//                case 1: //go right
//                    mazeArray[currYPosition][currXPosition + 1] = 2; //2 means we were here, 3 means point of no return
//                    currXPosition += 1;
//                    break;
//                case 2: //go down
//                    mazeArray[currYPosition + 1][currXPosition] = 2;
//                    currYPosition += 1;
//                    break;
//                case 3: //go left
//                    mazeArray[currYPosition][currXPosition - 1] = 2;
//                    currXPosition -= 1;
//                    break;
//                case 4: //go up
//                    mazeArray[currYPosition - 1][currXPosition] = 2;
//                    currYPosition -= 1;
//                    break;
//            }
//    }
//    private boolean isValid(int val){
//        return val > 0 && val < 3;
//    }
    public void move(int currYPosition, int currXPosition) {
        if (currYPosition<0 || currXPosition<0 || currYPosition>rows || currXPosition>cols) { // Place debugger here!
            return;
        }
//        OutsideMaze(int y, int x) {
//        return y < 0 || y > (rows - 1) || x < 0 || x > (cols - 1);
//        }
        if (mazeArray[currYPosition][currXPosition] == 0) {
            return;
        }
        
        if (currYPosition==rows-1) {
            printFinalMaze();
            return;
        }
        
        down(currYPosition+1, currXPosition);
        left(currYPosition, currXPosition-1);
	right(currYPosition, currXPosition+1);
        up(currYPosition-1, currXPosition);
        
    }
    
    public void up(int currYPosition, int currXPosition) {
        if (currYPosition>(rows-1) || currXPosition>(cols-1)) {
            return;
        }
        if (mazeArray[currYPosition][currXPosition] == 1) {
            //System.out.println("CurrentX:" + (currXPosition +1) + " CurrentY: " + (currYPosition + 1));
            mazeArray[currYPosition][currXPosition] = 2;
            move(currYPosition, currXPosition);
        }
        return;
    } 
    
    public void left(int currYPosition, int currXPosition) {
        if (currYPosition>(rows-1) || currXPosition>(cols-1)) {
            return;
        }
        if (mazeArray[currYPosition][currXPosition] == 1) {
            //System.out.println("CurrentX:" + (currXPosition +1) + " CurrentY: " + (currYPosition + 1));
            mazeArray[currYPosition][currXPosition] = 2;
            move(currYPosition, currXPosition);
        }
        return;
    } 
    
    public void right(int currYPosition, int currXPosition) {
        if (currYPosition>(rows-1) || currXPosition>(cols-1)) {
            return;
        }
        if (mazeArray[currYPosition][currXPosition] == 1) {
            //System.out.println("CurrentX:" + (currXPosition +1) + " CurrentY: " + (currYPosition + 1));
            mazeArray[currYPosition][currXPosition] = 2;
            move(currYPosition, currXPosition);
        }
        return;
    } 
    
    public void down(int currYPosition, int currXPosition) {
        if (currYPosition>(rows-1) || currXPosition>(cols-1)) {
            return;
        }
        if (mazeArray[currYPosition][currXPosition] == 1) {
            //System.out.println("CurrentX:" + (currXPosition +1) + " CurrentY: " + (currYPosition + 1));
            mazeArray[currYPosition][currXPosition] = 2;
            move(currYPosition, currXPosition);
        }
        return;
        
    } 
    
    
    public void printFinalMaze() {
        System.out.println();
        for (int y=0; y<rows; y++) {
            for (int x = 0; x<cols; x++) {
                //System.out.print(mazeArray[y][x] + " ");
                
                if (mazeArray[y][x]==0)
                    System.out.print("0 ");			     /*  0 for walls   */
                else if (y==0 && x==27)
                    System.out.print("2 ");			     /*  * for start   */
                else if (y==40 && x==17)
                    System.out.print("2 ");			     /*  * for exit   */
                else if (mazeArray[y][x]==1)
                    System.out.print("  ");			     /*  * for traveled   */
                else
                    System.out.print(mazeArray[y][x] + " ");			     /*    empty space  */
            }
            System.out.println();
        }
    }
    
    
    //3 startMoving
//    public void startMoving(){
//        //Set Direction (1-go right, 2-go down, 3-go left, 4- go up)
//        setDirection(); 
//        if(bBackingUp==true){
//            //set value to 3. Point of no return
//            mazeArray[currYPosition][currXPosition] = 3;  //3 means point of no return          
//        }
//        move();   
//            
//        //check if not end of the maze
//        if(currYPosition < rows){
//            System.out.println("CurrentX:" + (currXPosition +1) + " CurrentY: " + (currYPosition + 1) + " Backtracking: " + bBackingUp);
//            startMoving();
//        }else{
//            //Print done
//            System.out.println("Done!");
//        }    
//        
//    }
       
}
