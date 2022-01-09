package January2022;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class RobotBoundedInCircle {
    private enum DIRECTION {
        NORTH,EAST,SOUTH,WEST
    }
    public boolean isRobotBounded(String instructions) {
        HashMap<DIRECTION, int[]> map = new HashMap<>();
        Deque<DIRECTION> direction = new ArrayDeque<>();

        /** These Values tell that if we move in the direction denoted by the key then what will be the change in the co-ordinates */
        map.put(DIRECTION.NORTH,new int[]{0,1});
        map.put(DIRECTION.SOUTH,new int[]{0,-1});
        map.put(DIRECTION.EAST,new int[]{1,0});
        map.put(DIRECTION.WEST,new int[]{-1,0});

        /** This Deque is created to keep tract of the current direction the robot is pointing to and the direction is the first element of the queue
         * For Example :
         * curr dir = [N, E, S, W] , Please note the order must be this only for it to work
         * suppose robot moves 'LEFT' so our final direction should be 'WEST' which we get by rotating the deque by 1 unit in clockwise
         *      direction.addFirst(direction.pollLast());
         * suppose robot moves 'RIGHT' so our final direction should be 'EAST' which we get by rotating the deque by 1 unit in anti-clockwise
         *      direction.addLast(direction.pollFirst());
         * */
        direction.add(DIRECTION.NORTH);
        direction.add(DIRECTION.EAST);
        direction.add(DIRECTION.SOUTH);
        direction.add(DIRECTION.WEST);
        int x = 0, y = 0;

        /** Now we are iterating the path for 4 time , because after 4 times it will have to come back to origin
         * else there will be some offset of the final position with the initial one and when the pattern is repeated
         * there will be further offset and when repeated will go out of bound
         * */

        /**
         * Now why 4 times ?
         * suppose after full iteration of instruction final direction is following :
         * case 1 : LEFT, RIGHT
         *          after 4 iteration the final direction will be north
         * case 2: DOWN
         *          after 2 iteration only we will get NORTH again and so is the case with 4 iteration
         * So after 4 iteration we will get another point (X,Y) which has the robot pointing to North,
         * Now it is kind of recursion and if (X !=0 && Y!=0 )  doing further recursion will make the situation worse and robot will
         * go out of bound if repeated forever.
         * */

        for(int i=0;i<4;i++){
            for(char ch: instructions.toCharArray()){
                if(ch == 'G'){
                    int[] step = map.get(direction.peek());
                    x+=step[0];
                    y+=step[1];
                }else if(ch == 'R'){
                    direction.addLast(direction.pollFirst());
                } else{
                    direction.addFirst(direction.pollLast());
                }
            }
        }
        return x == 0 && y == 0;

    }
}
