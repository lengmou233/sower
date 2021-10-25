package lengmou.sower.events;

import lengmou.sower.Sower;
import lengmou.sower.config.Config;
import lengmou.sower.dicts.PlantDict;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlantBreak implements Listener {



    //    判断植物是否为最大生长等级 （判断植物是否成熟）
    private boolean plantIsMaxLevel(BlockData blockData) {
        Ageable age = (Ageable) blockData;

        return age.getAge() == age.getMaximumAge();
    }


    //  创建植物
    private void createPlant(Location location, Material cropBlockType) {
        Bukkit.getScheduler().runTaskLater(Sower.getSower(), () -> {

            location.getBlock().setType(cropBlockType);
        }, 15L);
    }

    @EventHandler
    public void plantBreak(BlockDropItemEvent event){
        if (Config.getInteractPlant()||!Config.getSower()){
            return;
        }
        BlockState blockState = event.getBlockState();
        Player player = event.getPlayer();
        if (player == null || player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        // 判断交互的是不是作物
        if (!PlantDict.cropList.contains(blockState.getType())) {
            return;
        }
//        判断是否成熟
        if (!plantIsMaxLevel(blockState.getBlockData())) {
            return;
        }
        //        判断该玩家有没有权限
        if(!(player.hasPermission(PlantDict.ALL_PERMISSIONS)||player.hasPermission(PlantDict.plantPermissionsMap.get(blockState.getType())))){
            return;
        }
        boolean removeFlag = true;
        ItemStack removeItem = null;
        for (Item item : event.getItems()) {
            ItemStack itemStack = item.getItemStack();
            if(PlantDict.cropToSeedMap.get(blockState.getType())==itemStack.getType()&& removeFlag){
                itemStack.setAmount(itemStack.getAmount()-1);
                if(itemStack.getAmount()==0){
                    removeItem = itemStack;
                }
            }
        }
        if(removeItem!=null){
            event.getItems().remove(removeItem);
        }

        createPlant(blockState.getLocation(),blockState.getType());
    }



}
