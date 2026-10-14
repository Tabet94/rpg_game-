package combat;

import characters.Player;
import characters.enemies.Enemy;

public class WarriorSkill implements Skill {

    @Override
    public int execute(Player player, Enemy enemy) {

        int damage = player.getAttack() * 2;

        int actualDamage = enemy.takeDamage(damage);

        return actualDamage;
    }
}