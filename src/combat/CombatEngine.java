package combat;

import characters.Archer;
import characters.Mage;
import characters.Player;
import characters.Warrior;
import characters.enemies.Enemy;

public class CombatEngine {

    public int basicAttack(Player player, Enemy enemy) {

        int damage = player.getAttack();

        if (player.getWeapon() != null) {
            damage += player.getWeapon().getDamageBonus();
        }



        int actualDamage = enemy.takeDamage(damage);

        return actualDamage;
    }

    public int useSkill(Player player, Enemy enemy) {

        Skill skill = player.getSkill();
        if (skill == null){
            return 0;
        }
        System.out.println("skill used");
        return skill.execute(player, enemy);

    }
}