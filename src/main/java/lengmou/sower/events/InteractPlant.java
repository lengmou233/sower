package lengmou.sower.events;

import lengmou.sower.Sower;
import lengmou.sower.config.Config;
import lengmou.sower.dicts.PlantDict;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractPlant implements Listener {


    //    判断植物是否为最大生长等级 （判断植物是否成熟）
    private boolean plantIsMaxLevel(BlockData blockData) {
        Ageable age = (Ageable) blockData;

        return age.getAge() == age.getMaximumAge();
    }

    //    修改植物掉落
    private void editPlantDrop(Block block) {
        Bukkit.getScheduler().runTaskLater(Sower.getSower(), () -> {
            World world = block.getLocation().getWorld();
            boolean removeFlag = true;
            for (ItemStack drop : block.getDrops()) {
                if (PlantDict.cropToSeedMap.get(block.getType()) == drop.getType()&& removeFlag) {
                    removeFlag = false;
                    drop.setAmount(drop.getAmount() - 1);
                    if(drop.getAmount()==0){
                        continue;
                    }
                }
                world.dropItem(block.getLocation(), drop);
            }
            block.setType(block.getType());
        }, 1L);
    }


    /**
     * 交互植物事件
     *
     * @param e
     */
    @EventHandler
     public void interactPlant(PlayerInteractEvent e) {
        if (!(Config.getInteractPlant()&&Config.getSower())){
            return;
        }
        Block block = e.getClickedBlock();
        if(block==null){
            return;
        }
        Player player = e.getPlayer();
        Material material = block.getBlockData().getMaterial();
        if (player == null || player.getGameMode() == GameMode.CREATIVE) {
            return;
        }

//        判断交互的是不是作物
        if (!PlantDict.cropList.contains(material)) {
            return;
        }
//        判断该玩家有没有权限
        if(!(player.hasPermission(PlantDict.ALL_PERMISSIONS)||player.hasPermission(PlantDict.plantPermissionsMap.get(block.getType())))){
            return;
        }
//        判断是否成熟
        if (!plantIsMaxLevel(block.getBlockData())) {
            return;
        }
//         修改植物的掉落
        editPlantDrop(block);

    }


}
