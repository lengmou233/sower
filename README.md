![img](https://www.mcbbs.net/static/image/smiley/ornaments/Grid_Fire.gif)**插件简介**![img](https://www.mcbbs.net/static/image/smiley/ornaments/Grid_Fire.gif)

**这是一款非常便捷的种植插件，收割作物的同时自动种植作物** **分为两种模式:1. 破坏补种 2.右键收割补种** **下面是图片演示** ***\*1.破坏补种\****![img](https://attachment.mcbbs.net/data/myattachment/forum/202110/12/200507h5xic96ga6iaucr9.gif)   **2.右键收割补种**![img](https://attachment.mcbbs.net/data/myattachment/forum/202110/12/195828gizopry1knnzigd5.gif)支持的农作物有：**1.小麦**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/crop.gif)**2.土豆**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/Notch.gif)**3.胡萝卜**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/Notch.gif)**4.甜菜根**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/Notch.gif)**5.地狱疣**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/Notch.gif)  

![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/skeleton.gif) **版本机制说明**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/skeleton.gif)

| **功能**         | **1.12.2** | **1.13-1.17.1** |
| ---------------- | ---------- | --------------- |
| **右键种植收割** | **×**      | √               |
| **左键破坏补种** | √          | √               |
| **掉落扣除种子** | ×          | √               |
| **背包扣除种子** | √          | **×**           |

**受限于版本api的原因，1.12.2是通过玩家背包里的种子进行补种的，并且没有版办法使用右键收割补种功能。**



**而1.13-1.17.1版本是直接扣除掉落物里的种子进行补种，并且可以使用右键收割补种功能。**



![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/character.gif) **权限**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/character.gif)

| **SOWER.PLANT.ALL**        | 所有农作物的补种权限 |
| -------------------------- | -------------------- |
| **SOWER.PLANT.WHEAT**      | 小麦的补种权限       |
| **SOWER.PANT.POTATOES**    | 土豆的补种权限       |
| **SOWER.PANT.CARROTS**     | 胡萝卜的补种权限     |
| **SOWER.PANT.BEETROOTS**   | 甜菜根的补种权限     |
| **SOWER.PANT.NETHER_WART** | 地狱疣的补种权限     |
| **sower.admin**            | 命令的使用权限       |

默认普通玩家是没有任何权限的，管理默认拥有所有权限



![img](https://www.mcbbs.net/static/image/smiley/machine/cb_back.png) **命令**![img](https://www.mcbbs.net/static/image/smiley/machine/cb_conditional_1.png)

| **/sower off**      | **关闭插件**               |
| ------------------- | -------------------------- |
| **/sower on**       | **开启****插件**           |
| **/sower interact** | **切换为右键收割种植模式** |
| **/sower break**    | **切换为左键收割种植模式** |

注意：1.12.2版本仅支持 开关插件指令

![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/slime.gif)**配置文件**![img](https://www.mcbbs.net/static/image/smiley/mc_mob_food_plants/slime.gif) 

1. \# 设置为false 将关闭该插件的所有功能
2. sower: true
3. \# 开启后模式将改为 右键农作物进行收割 破坏自动补种将不会再生效
4. interaction: false



![img](https://www.mcbbs.net/static/image/smiley/colorblack/glass_blue.png) **最后**![img](https://www.mcbbs.net/static/image/smiley/colorblack/glass_blue.png) ![img](https://bstats.org/signatures/bukkit/sower.svg) **感谢您的使用 希望此插件对您有帮助 记得回来反馈 如果遇到bug或者更好的建议，请来联系我 觉得不错鼓励我？**[**爱发电**](https://afdian.net/@lengmou) **您的支持就是我更新的动力 ** **本插件为原创，无借鉴或抄袭代码。**

