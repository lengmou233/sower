package lengmou.sower;

import lengmou.sower.command.SowerCommand;
import lengmou.sower.config.Config;
import lengmou.sower.events.InteractPlant;
import lengmou.sower.events.PlantBreak;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sower extends JavaPlugin {

    private static Sower sower;


    @Override
    public void onEnable() {
//        注册到事件
        sower = this;
        new Metrics(this,13006);
        Bukkit.getPluginManager().registerEvents(new InteractPlant(), this);
        Bukkit.getPluginManager().registerEvents(new PlantBreak(), this);
        getLogger().info("=============播种者加载完成============");
        this.getCommand("sower").setExecutor(new SowerCommand());

        String s = "/sower off";

    }

    public static Sower getSower() {
        return sower;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
