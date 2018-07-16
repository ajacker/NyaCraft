package ajacker.nyacraft.network;

import ajacker.nyacraft.api.VeinBlockCounter;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;

public class MessageVeinBlockCount implements IMessage {
    public int VeinBlockCount;
    @Override
    public void fromBytes(ByteBuf buf)
    {
        VeinBlockCount = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(VeinBlockCount);
    }
    public static class Handler implements IMessageHandler<MessageVeinBlockCount, IMessage>
    {
        @Override
        public IMessage onMessage(MessageVeinBlockCount message, MessageContext ctx)
        {
            if(ctx.side== Side.CLIENT) {
                VeinBlockCounter.count=message.VeinBlockCount;//同步方块数量
            }
            return null;
        }
    }
}
