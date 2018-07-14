package ajacker.nyacraft.api;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;

@Cancelable
@Event.HasResult
public class EventHANDRU extends Event {
    public final EntityPlayer entityPlayer;

    public EventHANDRU(EntityPlayer entity) {
        super();
        entityPlayer = entity;
    }
}
