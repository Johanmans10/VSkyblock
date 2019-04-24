package com.github.Viduality.VSkyblock.Listener;

import com.github.Viduality.VSkyblock.Commands.Island;
import com.github.Viduality.VSkyblock.VSkyblock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    private VSkyblock plugin = VSkyblock.getInstance();


    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        if (Island.playerislands.containsKey(player.getUniqueId().toString())) {
            String island = Island.playerislands.get(player.getUniqueId().toString());
            Island.playerislands.remove(player.getUniqueId().toString());
            if (!Island.playerislands.containsValue(island)) {
                plugin.getMV().getCore().getMVWorldManager().unloadWorld(island);
            }
        }
    }
}
