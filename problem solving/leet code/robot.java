import java.util.*;

class robot {

    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> blocked = new HashSet<>();

        for (int[] o : obstacles) {
            blocked.add(o[0] + "," + o[1]);
        }

        int[][] move = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int direction = 0;
        int x = 0, y = 0;
        int maxDistance = 0;

        for (int command : commands) {

            if (command == -1) {
                direction = (direction + 1) % 4;
            } 
            else if (command == -2) {
                direction = (direction + 3) % 4;
            } 
            else {

                for (int step = 0; step < command; step++) {

                    int nextX = x + move[direction][0];
                    int nextY = y + move[direction][1];

                    if (blocked.contains(nextX + "," + nextY)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;

                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}





// Robot Simulation Logic

// Start at (0,0) facing North.
// Commands:
// -2 -> Turn Left
// -1 -> Turn Right
// 1-9 -> Move forward step-by-step

// Directions:
// 0=N (0,1), 1=E (1,0), 2=S (0,-1), 3=W (-1,0)

// Turn:
// Right -> (dir + 1) % 4
// Left  -> (dir + 3) % 4

// Store obstacles in HashSet for fast checking.

// Move one step at a time.
// Stop if next position has obstacle.

// Track max distance:
// max = x*x + y*y

// Time Complexity: O(N)