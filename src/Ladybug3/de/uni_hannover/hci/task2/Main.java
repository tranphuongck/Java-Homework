package Ladybug3.de.uni_hannover.hci.task2;

import Ladybug3.de.uni_hannover.hci.task2.model.Direction;

public class Main
{
    private static void wallFollower(Game game) {
        while (true) {
            if (game.atGoal()) {
                System.out.println(game);
                return;
            }
            game.turnRight();
            boolean canEnterRight = game.canEnter();
            game.turnLeft();
            if (canEnterRight) {
                game.turnRight();
                game.forward();
                System.out.println(game);
            } else {
                while (!game.canEnter()) {
                    game.turnLeft();
                }
                game.forward();
                System.out.println(game);
            }
        }
    }
    public static void main(String[] args) {
        Game game = new Game(10, 7, 1, 0, 6, 6, Direction.SOUTH);
        int[][] lab = {{-1,0 ,-1,-1,-1,-1,-1,-1,-1,-1},
                       {-1,0 ,0 ,0 ,-1,0 ,0 ,0 ,0 ,-1},
                       {-1,0 ,-1,-1,-1,0 ,-1,-1,0 ,-1},
                       {-1,10,0 ,-1,0 ,20,-1,0 ,0 ,-1},
                       {-1,-1,0 ,0 ,0 ,-1,-1,-1,0 ,-1},
                       {-1,0 ,0 ,-1,0 ,-1,0 ,0 ,0 ,-1},
                       {-1,-1,-1,-1,-1,-1,0 ,-1,-1,-1}};
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == -1) {
                    game.toggleTree(j, i, true);
                } else if (lab[i][j] > 0) {
                    game.toggleClover(j, i, true, lab[i][j]);
                }
            }
        }
        TextInput.init();
        boolean active = true;
        while (active) {
            System.out.println(game);
            System.out.print("Command> ");
            String line = TextInput.getLine();
            switch (line) {
                case "forward":
                    game.forward();
                    break;
                case "turnLeft":
                    game.turnLeft();
                    break;
                case "turnRight":
                    game.turnRight();
                    break;
                case "pickUp":
                    game.pickUp();
                    break;
                case "canAdvance":
                    if (game.canEnter())
                        System.out.println("Ladybug can advance.");
                    else
                        System.out.println("Ladybug cannot advance.");
                    break;
                case "hasArrived":
                    if (game.atGoal())
                        System.out.println("Ladybug has reached the goal.");
                    else
                        System.out.println("Ladybug has not reached the goal.");
                    break;
                case "wallFollower":
                    Main.wallFollower(game);
                case "q":
                    active = false;
            }
        }
    }
}
