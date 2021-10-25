package lengmou.sower.dicts;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantDict {


    public static final Map<Material,Material> cropToSeedMap = new HashMap<>();

    public static final List<Material> cropList = Arrays.asList(Material.WHEAT, Material.POTATOES, Material.CARROTS, Material.BEETROOTS,Material.NETHER_WART);

    public static final Map<Material,String> plantPermissionsMap = new HashMap<>();

    public static final String ALL_PERMISSIONS = "SOWER.PLANT.ALL";



    static {
//        小麦
        cropToSeedMap.put(Material.WHEAT,Material.WHEAT_SEEDS);
        /*马铃薯*/
        cropToSeedMap.put(Material.POTATOES,Material.POTATO);
//        胡萝卜
        cropToSeedMap.put(Material.CARROTS,Material.CARROT);
//        甜菜根
        cropToSeedMap.put(Material.BEETROOTS,Material.BEETROOT_SEEDS);
//        地狱疣
        cropToSeedMap.put(Material.NETHER_WART,Material.NETHER_WART);
//        赋值权限
        plantPermissionsMap.put(Material.WHEAT,"SOWER.PLANT.WHEAT");
        plantPermissionsMap.put(Material.POTATOES,"SOWER.PANT.POTATOES");
        plantPermissionsMap.put(Material.CARROTS,"SOWER.PANT.CARROTS");
        plantPermissionsMap.put(Material.BEETROOTS,"SOWER.PANT.BEETROOTS");
        plantPermissionsMap.put(Material.NETHER_WART,"SOWER.PANT.NETHER_WART");
    }


}
