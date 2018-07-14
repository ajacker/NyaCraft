package ajacker.nyacraft.creativetab;

import ajacker.nyacraft.items.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsFMLTutor extends CreativeTabs {

    public CreativeTabsFMLTutor() {
        super("NyaCraft");
        this.setBackgroundImageName("NyaCraft.png");//创造栏背景图片
    }

    @Override
    public Item getTabIconItem() {
        return ItemLoader.nyaIngot;//创造栏图标
    }

    @Override
    public boolean hasSearchBar() {
        return true;//有搜索栏
    }
}
