package combat;

import characters.Player;
import characters.enemies.Enemy;

public class ArcherSkill implements Skill {

    private final CombatEngine combatEngine;

    public ArcherSkill(CombatEngine combatEngine) {
        this.combatEngine = combatEngine;
    }

    @Override
    public int execute(Player player, Enemy enemy) {

        int totalDamage = 0;

        // 2 arrows = 2 basic attacks
        totalDamage += combatEngine.basicAttack(player, enemy);
        totalDamage += combatEngine.basicAttack(player, enemy);

        return totalDamage;
    }
}