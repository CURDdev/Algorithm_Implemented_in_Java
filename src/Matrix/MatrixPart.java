package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixPart {
    public class location{
        private Integer x;
        private Integer y;
        public location(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }
    }
    public int matrixpartion(Integer[][] teamMatrix){
        Integer[][] visited = new Integer[teamMatrix.length][teamMatrix[0].length];
        for (int i = 0; i <= teamMatrix.length - 1; i++){
            for(int j = 0; j <=teamMatrix[0].length - 1; j++){
                visited[i][j] = 0;
            }
        }
        int result = 0;
        for(int i = 0; i <= visited.length - 1; i++){
            for(int j = 0; j <= visited[0].length - 1; j++){
                if((teamMatrix[i][j].equals(1)) && (visited[i][j].equals(0))){
                    Queue<location> locations = new LinkedList<>();
                    locations.add(new location(i,j));
                    result++;
                    System.out.println("x: " + i + " y: " + j);
                    while(!locations.isEmpty()){
                        location tmp = locations.poll();
                        if(tmp.x - 1 >= 0){
                            if(teamMatrix[tmp.x - 1][tmp.y] == 1 && visited[tmp.x-1][tmp.y] == 0){
                                locations.add(new location(tmp.x-1,tmp.y));
                                visited[tmp.x-1][tmp.y] = 1;
                            }
                        }
                        if(tmp.x + 1 <= (teamMatrix.length - 1)){
                            if(teamMatrix[tmp.x+1][tmp.y] == 1 && visited[tmp.x+1][tmp.y] == 0){
                                locations.add(new location(tmp.x+1,tmp.y));
                                visited[tmp.x+1][tmp.y] = 1;
                            }
                        }
                        if(tmp.y - 1 >= 0){
                            if(teamMatrix[tmp.x][tmp.y-1] == 1 && visited[tmp.x][tmp.y-1] == 0){
                                locations.add(new location(tmp.x,tmp.y-1));
                                visited[tmp.x][tmp.y-1] = 1;
                            }
                        }
                        if(tmp.y + 1 <= (teamMatrix.length - 1)){
                            if(teamMatrix[tmp.x][tmp.y+1] == 1 && visited[tmp.x][tmp.y+1] == 0){
                                locations.add(new location(tmp.x,tmp.y+1));
                                visited[tmp.x][tmp.y+1] = 1;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        MatrixPart matrixPart = new MatrixPart();
        Integer[][] input = {{1,0,0,1},
                {0,1,1,1},
                {0,0,0,1},
                {0,0,1,1}};
        System.out.println(matrixPart.matrixpartion(input));
    }
}
