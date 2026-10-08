package tips;

import java.util.Random;

public class SlotGame {
    public static void main(String[] args) {
        Random random = new Random();

        String[] symbols = { "🍒", "🍋", "🍊", "🍇", "🔔", "⭐", "7️⃣" };

        String slot1 = symbols[random.nextInt(symbols.length)];
        String slot2 = symbols[random.nextInt(symbols.length)];
        String slot3 = symbols[random.nextInt(symbols.length)];

        System.out.println("🎰 スロットスタート！");
        System.out.println("-------------");
        System.out.println(slot1 + slot2 + slot3);

        System.out.println("-------------");
        if (slot1.equals(slot2) && slot2.equals(slot3)) {
            System.out.println("🎉 大当たり！");
        } else {
            System.out.println("😢 残念！");
        }
    }
}
