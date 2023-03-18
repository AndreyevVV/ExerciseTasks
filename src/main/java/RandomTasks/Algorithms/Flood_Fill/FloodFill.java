package RandomTasks.Algorithms.Flood_Fill;

public interface FloodFill {
    void flood(final String map, final FloodLogger logger);


    static FloodFill getInstance() {
        FloodMe floodMe = new FloodMe();
        return floodMe;
    }

    char LAND = '█';
    char WATER = '░';
}
