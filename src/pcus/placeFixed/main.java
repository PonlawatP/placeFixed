package pcus.placeFixed;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void event(BlockPlaceEvent e){
        boolean c_w = e.getPlayer().getWorld().getName().equalsIgnoreCase(e.getBlockPlaced().getWorld().getName());
        boolean c_x = e.getBlockReplacedState().getX() == e.getPlayer().getLocation().getBlockX();
        boolean c_y = e.getBlockReplacedState().getY() == e.getPlayer().getLocation().getBlockY();
        boolean c_z = e.getBlockReplacedState().getZ() == e.getPlayer().getLocation().getBlockZ();

        boolean c_upper = ((e.getBlockReplacedState().getY() - 1) <= e.getPlayer().getLocation().getY()) && (e.getBlockReplacedState().getY() >= e.getPlayer().getLocation().getY());
        boolean c_current = e.getBlockReplacedState().getY() == e.getPlayer().getLocation().getBlockY();

        boolean tf_ft;

        boolean cx_x = (e.getBlockReplacedState().getX() + 1.3) > e.getPlayer().getLocation().getX();
        boolean cxa_x = (e.getBlockReplacedState().getX() + 1.3) < e.getPlayer().getLocation().getX();

        boolean cx_z = (e.getBlockReplacedState().getZ() + 1.3) > e.getPlayer().getLocation().getZ();
        boolean cxa_z = (e.getBlockReplacedState().getZ() + 1.3) < e.getPlayer().getLocation().getZ();

        boolean cs_x = (e.getBlockReplacedState().getX() - 0.3) > e.getPlayer().getLocation().getX();
        boolean csa_x = (e.getBlockReplacedState().getX() - 0.3) < e.getPlayer().getLocation().getX();

        boolean cs_z = (e.getBlockReplacedState().getZ() - 0.3) > e.getPlayer().getLocation().getZ();
        boolean csa_z = (e.getBlockReplacedState().getZ() - 0.3) < e.getPlayer().getLocation().getZ();
        tf_ft = cx_x && !cxa_x && !cs_x && csa_x && cx_z && !cxa_z && !cs_z && csa_z;

        if(c_w) {
            if(c_current && ((c_x && c_y && c_z) || (tf_ft && c_y)) ) { //Place block Lower body
                e.setBuild(false);
                return;
            }

            if(c_upper && (c_x && c_upper && c_z) || (tf_ft && c_upper) ) { //Place block Upper body
                e.setBuild(false);
                return;
            }
        }

    }
}
