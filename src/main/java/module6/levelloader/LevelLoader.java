package module6.levelloader;

public class LevelLoader {
    private static final LevelLoader instance = new LevelLoader();

    private LevelLoader() {
    }

    public static LevelLoader getInstance() {

        return instance;
    }

    public String load(String levelName) {

        return "Loading level " + levelName + " ...";
    }
}

