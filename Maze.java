import java.util.*;

public class Maze {
    public static List<Character> escape(char[][] maze) {
        char[] pos = getPos(maze);
        List<List<Integer>> buffer = new ArrayList<>();
        List<Character> dir = new ArrayList<>();
        if(pos[2] == '>'){
            dir.add('r');
        }else if (pos[2] == 'v'){
            dir.add('d');
        }else if (pos[2] == '<'){
            dir.add('l');
        }else if (pos[2] == '^'){
            dir.add('u');
        }

        for(int i = 0; i < maze.length; i++){
            List<Integer> list = new ArrayList<>();
            buffer.add(list);
        }
        List<Character> result = new ArrayList<>();
        return move(maze,pos[0],pos[1],buffer,dir,result);
    }
    private static List<Character> move(char[][] maze, int a, int b,
                                        List<List<Integer>> buffer,
                                        List<Character> dir,
                                        List<Character> result){
        List<Character> output = new ArrayList<>();
        if(a == 0 || a == maze.length-1 || b == 0 || b == maze[0].length-1){
            output = result;
        }else {
            if (maze[a - 1][b] == ' ' && !buffer.get(a-1).contains(b)) {
                buffer.get(a-1).add(b);
                if(dir.get(dir.size()-1) == 'r'){
                    result.add('L');
                } else if (dir.get(dir.size()-1) == 'l'){
                    result.add('R');
                } else if (dir.get(dir.size()-1) == 'd'){
                    result.add('B');
                }
                dir.add('u');
                result.add('F');
                output = toSolve(maze, a - 1, b,buffer,dir,result);
            } else if (maze[a][b + 1] == ' ' && !buffer.get(a).contains(b+1)) {
                buffer.get(a).add(b+1);
                if(dir.get(dir.size()-1) == 'u'){
                    result.add('R');
                } else if (dir.get(dir.size()-1) == 'd'){
                    result.add('L');
                } else if (dir.get(dir.size()-1) == 'l'){
                    result.add('B');
                }
                dir.add('r');
                result.add('F');
                output = toSolve(maze, a, b + 1,buffer,dir,result);
            } else if (maze[a + 1][b] == ' ' && !buffer.get(a+1).contains(b)) {
                buffer.get(a+1).add(b);
                if(dir.get(dir.size()-1) == 'r'){
                    result.add('R');
                } else if (dir.get(dir.size()-1) == 'l'){
                    result.add('L');
                } else if (dir.get(dir.size()-1) == 'u'){
                    result.add('B');
                }
                dir.add('d');
                result.add('F');
                output = toSolve(maze, a + 1, b,buffer,dir,result);
            } else if (maze[a][b - 1] == ' ' && !buffer.get(a).contains(b-1)) {
                buffer.get(a).add(b-1);
                if(dir.get(dir.size()-1) == 'u'){
                    result.add('L');
                } else if (dir.get(dir.size()-1) == 'd'){
                    result.add('R');
                } else if (dir.get(dir.size()-1) == 'r'){
                    result.add('B');
                }
                dir.add('l');
                result.add('F');
                output = toSolve(maze, a, b - 1,buffer,dir,result);
            } else if(result.size() != 0){
                if (dir.get(dir.size()-1) == 'u'){
                    removeRes(dir, result);
                    output = toSolve(maze, a + 1, b,buffer,dir,result);
                } else if (dir.get(dir.size()-1) == 'd'){
                    removeRes(dir, result);
                    output = toSolve(maze, a - 1, b,buffer,dir,result);
                } else if (dir.get(dir.size()-1) == 'r'){
                    removeRes(dir, result);
                    output = toSolve(maze, a, b - 1,buffer,dir,result);
                } else if (dir.get(dir.size()-1) == 'l'){
                    removeRes(dir, result);
                    output = toSolve(maze, a, b + 1,buffer,dir,result);
                }
            } else {
                output = new ArrayList<>();
            }
        }
        return output;
    }

    private static List<Character> toSolve (char[][] maze, int a, int b,
                                            List<List<Integer>> buffer,
                                            List<Character> dir,
                                            List<Character> result){
        return move(maze, a, b, buffer, dir, result);
    }

    private static void removeRes(List<Character> dir, List<Character> result) {
        dir.remove(dir.size()-1);
        result.remove(result.size()-1);
        if(result.size() != 0) {
            if (result.get(result.size() - 1) == 'L' || result.get(result.size() - 1) == 'R'
                    || result.get(result.size() - 1) == 'B') {
                result.remove(result.size() - 1);
            }
        }
    }

    private static char[] getPos(char[][] maze){
        char[] pos = new char[3];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == '<' || maze[i][j] == '>'
                        || maze[i][j] == '^' || maze[i][j] == 'v'){
                    pos[0] = (char)i;
                    pos[1] = (char)j;
                    pos[2] = maze[i][j];
                    i = maze.length - 1;
                    break;
                }
            }
        }
        return pos;
    }
}
