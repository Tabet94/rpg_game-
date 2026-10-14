package combat;

import characters.Player;
import characters.enemies.Enemy;

public interface Skill {

    int execute(Player player, Enemy enemy);
}
