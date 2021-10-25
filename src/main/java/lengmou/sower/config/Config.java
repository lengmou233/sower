package lengmou.sower.config;

import lengmou.sower.Sower;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;

public class Config {

    private static Plugin plugin = Sower.getSower();

    private static boolean sowerFlag = true;

    private static boolean interact = false;

    private static YamlConfiguration config;

    static {
        config = getConfigFile();
    }




    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = Config.class.getClassLoader().getResourceAsStream(source.getPath());
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }


    //    创建配置文件
    public static YamlConfiguration getConfigFile() {
        File dataFolder = plugin.getDataFolder();
        File configFile = new File(dataFolder.getParent()+ "/sower/sower.yml");
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
                File thisConfigFile = new File("config.yml");
                plugin.getLogger().info(thisConfigFile.getPath());
                copyFileUsingFileStreams(thisConfigFile, configFile);
            } catch (IOException e) {
                e.printStackTrace();
                plugin.getLogger().warning(e.toString());
            }
        }

        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(configFile);
        interact = yamlConfiguration.getBoolean("interaction");
        sowerFlag = yamlConfiguration.getBoolean("sower");
        return yamlConfiguration;
    }


//    插件开关
    public static boolean getSower(){
        return sowerFlag;
    }

//    交互方式
    public static boolean getInteractPlant() {
        return interact;
    }

//    修改插件开关
    public static void setSower(boolean flag){
        config.set("sower",flag);
        sowerFlag = flag;
        try {
            config.save(new File(plugin.getDataFolder().getParent()+ "/sower/sower.yml"));
        } catch (IOException e) {
            e.printStackTrace();
            plugin.getLogger().warning(e.toString());
        }
    }

//   修改交互方式
    public static void setInteractPlant(boolean flag){
        config.set("interact",flag);
        interact = flag;
        try {
            config.save(new File(plugin.getDataFolder().getParent()+ "/sower/sower.yml"));
        } catch (IOException e) {
            e.printStackTrace();
            plugin.getLogger().warning(e.toString());
        }
    }

}
