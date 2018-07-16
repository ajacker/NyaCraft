package ajacker.nyacraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityNyaFX extends EntityFX {
    private final float PI3 = (float) (Math.PI / 3.0);
    private final float PI6 = (float) (Math.PI / 6.0);
    public EntityNyaFX(World world, double posX, double posY, double posZ, Vec3 direction) {
        super(world, posX, posY, posZ);
        //setParticleTextureIndex(rand.nextInt(8));
        double speed = rand.nextDouble() * 0.3d; //设定速度为0.0~0.3范围内的随机数
        direction.rotateAroundY((rand.nextFloat() - 0.5f) * PI3); //让喷血方向带有一定的随机性
        direction.rotateAroundX((rand.nextFloat() - 0.5f) * PI6);
        direction.rotateAroundZ((rand.nextFloat() - 0.5f) * PI6);
        setVelocity(direction.xCoord * speed, direction.yCoord * speed, direction.zCoord * speed); //根据方向矢量设定速度矢量
        setSize(0.1f, 0.1f); //设定粒子的碰撞尺寸,如果不想要碰撞的话不妨试试noClip = true ?
        this.particleMaxAge = (int) (15f / (this.rand.nextFloat() * 0.75f + 0.25f)); //设定粒子的寿命,单位为tick
        this.particleGravity = 0.3f; //受重力加速度影响的系数,1.0为每tick Y方向速度减-0.04 (不考虑空气阻力的话)
        this.particleGreen = rand.nextFloat(); //RGB三颜色中的G系数,默认全为1.0,即白色/显示纹理正常颜色
        this.particleBlue = rand.nextFloat(); //将G和B全改为0的话,那就是红色/纹理"偏"红
        this.particleRed = rand.nextFloat();
        this.particleAlpha = 1.0f; //不透明度,默认就是1.0...
        this.particleScale = 2.0f; //尺寸系数,默认是1.0~2.0之间的随机数
    }
}

