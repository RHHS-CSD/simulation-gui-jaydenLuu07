/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatastarter;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Scanner;
import utils.Constants;
import utils.ImageUtil;

/**
 *
 * @author jayde
 */
public class LangtonsAnt {
    
    //Variables for the grid
    int[][] grid;
    int columns = Constants.MINCOLUMN;
    int rows = Constants.MINROW;
    int cellSize = 2;
    
    //Variables for the ants
    int antNumber;
    int[] antsRow;
    int[] antsColumn;
    String[] antDirection;
    int[] antHealth;
    int maxAntHealth;
    int antsAlive;
    
    //Variables for the boot
    int bootRow;
    int bootColumn;
    boolean needsBoot;
    
    //Variales for the sugar cubes
    int[] sugarRow;
    int[] sugarColumn;
    boolean[] isEaten;
    boolean needsSugar;
    int cubesLeft;
    
    //Methods for setting 
    public void setRows(int rows){
        this.rows = rows;
    }
    public void setColumns(int columns){
        this.columns = columns;
    }
    public void setAntNumber(int antNumber){
        this.antNumber = antNumber;
    }
    public void setMaxAntHealth(int maxAntHealth){
        this.maxAntHealth = maxAntHealth;
    }
    public void setNeedsBoot(boolean needsBoot){
        this.needsBoot = needsBoot;
    }
    public void setNeedsSugar(boolean needsSugar){
        this.needsSugar = needsSugar;
    }
    public void setCellSize(){
        if(rows<columns){
            cellSize = (Constants.HEIGHT-50)/(columns+1);
        }
        else{
            cellSize = (Constants.HEIGHT-50)/(rows+1);
        }
    }
    
    /**
     * Sets all of the tiles in the grid to a certain colour
     * @param startingColour 
     */
    //Intiialzing the grid with variable starting colour as well as number of rows and colums
    public void makeGrid(int startingColour){
        grid = new int[rows][columns];
        
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                grid[i][j]=startingColour;
            }
        }
    }
    
    /**
     * Draws the grid cells and its borders
     * @param g 
     */
    //Printing out the grid
    public void printGrid(Graphics g){
        
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if (grid[i][j]==0){
                    g.setColor(Color.WHITE);
                }
                else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i*cellSize, j*cellSize, cellSize, cellSize);
                //Drawing borders
                g.setColor(Color.RED);
                g.drawRect(i*cellSize, j*cellSize,cellSize,cellSize);
            }
        }
        
    }
    
    /**
     * Gives values to ant related variables when the game is started
     */
    //Determines the starting coords and direction for all of the ants
    public void antStart(){
        //Setting the index of ant coordinate lists
        antsRow = new int[antNumber];
        antsColumn = new int[antNumber];
        antDirection = new String[antNumber];
        antHealth = new int[antNumber];
        
        //Determining starting position of ants 
        for(int i=0;i<antNumber;i++){
            antsRow[i] = (int)(Math.random()*rows);

            antsColumn[i] = (int)(Math.random()*columns);
            
            int randomDirection = (int)(Math.random()*4);
            switch (randomDirection) {
                case 0:
                    antDirection[i] = "UP";
                    break;
                case 1:
                    antDirection[i] = "RIGHT";
                    break;
                case 2:
                    antDirection[i] = "DOWN";
                    break;
                default:
                    antDirection[i] = "LEFT";
                    break;
            }
            
            //Setting ant health
            antHealth[i] = maxAntHealth;
            
            //All ants start alive
            antsAlive = antNumber;
        }
    }
    
    //Turning ants to the right
    private void turnRight(int antIndex){
        switch(antDirection[antIndex]){
            case "UP":
                antDirection[antIndex] = "RIGHT";
                break;
            case "RIGHT":
                antDirection[antIndex] = "DOWN";
                break;
            case "DOWN":
                antDirection[antIndex] = "LEFT";
                break;
            case "LEFT":
                antDirection[antIndex] = "UP";
                break;
        }
    }
    //Turning ants to the left by turning the ant 3 times to the right
    private void turnLeft(int antIndex){
        turnRight(antIndex);
        turnRight(antIndex);
        turnRight(antIndex);
    }
    
    /**
     * Changes the direction of all the ants, depending what tile they are on 
     */
    //Turning stage for all ants
    public void turnAnts(){
        int cellState;
        //Looping through every ant cell to see which colour that cell is 
        for (int i=0;i<antNumber;i++){
            //Making sure that dead ants can't turn
            if(antHealth[i]==0){
                continue;
            }
            cellState = grid[antsRow[i]][antsColumn[i]];
            //Turning based on cell colour accordingly
            if (cellState==0){
                turnRight(i);
            }
            else if (cellState==1){
                turnLeft(i);
            }
        }
    }
    
    /**
     * Flips the colour of each occupied cell (with an alive ant)
     */
    //Flipping the cell colour for all ants
    public void flipColour(){
        int cellState;
        //Looping through every ant cell to see which colour that cell is 
        for (int i=0;i<antNumber;i++){
            //Making sure that dead ants can't flip cell colour
            if(antHealth[i]==0){
                continue;
            }
            
            cellState = grid[antsRow[i]][antsColumn[i]];
            //Flipping based on cell colour accordingly
            if (cellState==0){
                grid[antsRow[i]][antsColumn[i]]=1;
            }
            else if (cellState==1){
                grid[antsRow[i]][antsColumn[i]]=0;
            }
        }
    }
    
    /**
     * Translating the coordinate position of every alive ant by 1 depending on what direction they are facing, as well as if they will hit a wall.  Ants will also eat sugar if they share the same cell
     */
    //Moving all of the ants
    public void moveAnts(){
        
        //Looping through every ant cell to see which colour that cell is 
        for (int i=0;i<antNumber;i++){
            
            //Making sure that dead ants can't move
            if(antHealth[i]==0){
                continue;
            }
            
            //Moving depending on direction
            switch(antDirection[i]){
                case "LEFT":
                    //If the ant is on the edge, then turn it around and move the opposite direction
                    if(antsRow[i]==0){
                        turnRight(i);
                        turnRight(i);
                        antsRow[i] = antsRow[i]+1;
                    }
                    //Moving normally
                    else{
                        antsRow[i]=antsRow[i]-1;
                    }
                    break;
                case "DOWN":
                    if(antsColumn[i]==(columns-1)){
                        turnRight(i);
                        turnRight(i);
                        antsColumn[i] = antsColumn[i]-1;
                    }
                    else{
                        antsColumn[i]=antsColumn[i]+1;
                    }
                    break;
                case "RIGHT":
                    if(antsRow[i]==(rows-1)){
                        turnRight(i);
                        turnRight(i);
                        antsRow[i] = antsRow[i]-1;
                    }
                    else{
                        antsRow[i]=antsRow[i]+1;
                    }
                    break;
                case "UP":
                    if(antsColumn[i]==0){
                        turnRight(i);
                        turnRight(i);
                        antsColumn[i] = antsColumn[i]+1;
                    }
                    else{
                        antsColumn[i]=antsColumn[i]-1;
                    }
                    break;
            }
            
            //Ant eats any sugar cube that is on here
            for(int j=0;j<antNumber;j++){
                if(antsColumn[i]==sugarColumn[j]&&antsRow[i]==sugarRow[j]&&isEaten[j]==false){
                    isEaten[j]=true;
                    cubesLeft = cubesLeft-1;
                    //Maxes out an ant's health if it eats a sugar cube
                    antHealth[i]=maxAntHealth;
                }
            }
        }
    }
    
    /**
     * Randomly moves the boot and places it in a 3x3 area around a random ant
     */
    public void moveBoot(){
        boolean targetFound = false;
        int target = 0;
        
        //Choosing a random ant
        while (targetFound==false){
            target = (int)(Math.random()*antNumber);
            //Making sure the ant is not dead
            if (antHealth[target]!=0){
                targetFound=true;
            }
        }
        
        //Placing the boot somewhere near the ant
        bootRow = (int)(Math.random()*3);
        bootRow = bootRow+antsRow[target]-1;
        bootColumn = (int)(Math.random()*3);
        bootColumn = bootColumn+antsColumn[target]-1;
        
        //Edge cases
        if(bootRow==rows){
           bootRow = bootRow-1; 
        }
        else if (bootRow<0){
            bootRow=0;
        }
        if(bootColumn==columns){
            bootColumn = bootColumn -1;
        }
        else if (bootColumn<0){
            bootColumn = 0;
        }
    }
    
    /**
     * Kill any ant that shares a cell with a boot
     */
    public void killAnt(){
        for (int i=0;i<antNumber;i++){
            //Making sure they are on the same cell and are alive
            if(antsRow[i]==bootRow&&antsColumn[i]==bootColumn&&antHealth[i]!=0){
                antHealth[i] = antHealth[i] -1;
                if(antHealth[i]==0){
                    antsAlive=antsAlive-1;
                }
            }
        }
    }
    
    /**
     * Setting the coordinates of the sugar tiles, number is equal to the amount of ants
     */
    public void setSugar(){
        sugarRow = new int[antNumber];
        sugarColumn = new int[antNumber];
        isEaten = new boolean[antNumber];
        
        //Giving each sugar cube a random tile position, as well as making sure that they are not eaten
        for (int i=0;i<antNumber;i++){
            sugarRow[i] = (int)(Math.random()*rows);
            sugarColumn[i] = (int)(Math.random()*columns);
            isEaten[i] = false;
        }
        cubesLeft = antNumber;
    }
    
    /**
     * Determines if the simulation's stopping requirements are met (all ants dead/all sugar cubes eaten)
     * @return 
     */
    public int needsToStop(){
        int antsDead = 0;
        int sugarsEaten = 0;
        
        for (int i=0;i<antNumber;i++){
            if(antHealth[i]==0)
                antsDead = antsDead+1;
            if(isEaten[i]==true){
                sugarsEaten= sugarsEaten+1;
            }
        }
        
        //If the boot wins
        if(antsDead==antNumber){
            return 0;
        }
        //If ants win
        else if (sugarsEaten==antNumber){
            return 1;
        } 
        //If no one has won yet
        return 2;
    }
}
