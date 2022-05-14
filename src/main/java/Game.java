import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }

    public int round(String namePlayerFirst, String namePlayerSecond) {
        int result = 0;
        int strenghtFirst = matches(namePlayerFirst);
        int strenghtSecond = matches(namePlayerSecond);

        if (strenghtFirst == 0 || strenghtSecond == 0) {
            throw new NotRegisteredException("Один из игроков не зарегистрирован!!!");
        }
        if (strenghtFirst == strenghtSecond) {
            return result = 0;
        }
        if (strenghtFirst > strenghtSecond) {
            return result = 1;
        }
        return result = 2;
    }

    public int matches(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player.getStrength();
            }
        }
        return 0;
    }


}





