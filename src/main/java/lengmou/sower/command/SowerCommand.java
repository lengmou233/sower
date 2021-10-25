package lengmou.sower.command;

import lengmou.sower.Sower;
import lengmou.sower.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class SowerCommand implements CommandExecutor {
    private Sower plugin = Sower.getSower();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length>0){
            if(!sender.hasPermission("sower.admin")){
                sender.sendMessage(ChatColor.BLUE +"[Sower]"+ ChatColor.RED +"抱歉您没有该命令的使用权限!");
                return false;
            }
            if(args[0].equalsIgnoreCase("off")){
                Config.setSower(false);
                plugin.getLogger().info(ChatColor.BLUE +"[Sower]"+ ChatColor.GRAY +"插件已关闭");
                sender.sendMessage(ChatColor.BLUE +"[Sower]"+ ChatColor.GRAY +"插件已关闭");
                return true;
            }else if(args[0].equalsIgnoreCase("on")){
                Config.setSower(true);
                plugin.getLogger().info(ChatColor.BLUE +"[Sower]"+ChatColor.GREEN+"插件已开启");
                sender.sendMessage(ChatColor.BLUE +"[Sower]"+ChatColor.GREEN+"插件已开启");
                return true;
            }else if(args[0].equalsIgnoreCase("interact")){
                Config.setInteractPlant(true);
                sender.sendMessage(ChatColor.BLUE +"[Sower]"+ChatColor.GREEN+"切换为右键模式");
                return true;
            }else if(args[0].equalsIgnoreCase("break")){
                Config.setInteractPlant(false);
                sender.sendMessage(ChatColor.BLUE +"[Sower]"+ChatColor.GREEN+"切换为左键模式");
                return true;
            }else{
                sender.sendMessage(ChatColor.BLUE +"[Sower]"+ChatColor.YELLOW+"使用帮助:\n" +
                        " /sower off 关闭插件\n" +
                        " /sower on 开启插件 \n" +
                        " /sower interact 切换为右键模式 \n" +
                        " /sower break 切换为左键模式");
            }
        }else{
            sender.sendMessage(ChatColor.BLUE +"[Sower]"+ChatColor.YELLOW+"使用帮助:\n" +
                    " /sower off 关闭插件\n" +
                    " /sower on 开启插件 \n" +
                    " /sower interact 切换为右键模式 \n" +
                    " /sower break 切换为左键模式");
        }
        return false;
    }
}
