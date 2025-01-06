package com.electrifiedded.icwth.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import java.util.Random;

public class EntityThrownVillager extends EntityThrowable {

    public EntityThrownVillager(World world) {
        super(world);
    }

    public EntityThrownVillager(World world, EntityLivingBase thrower) {
        super(world, thrower);
        // Задаем начальную скорость в направлении взгляда игрока
        this.shoot(thrower, thrower.rotationPitch, thrower.rotationYaw, 0.0F, 1.5F, 1.0F);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        // Спавн частиц
        for (int i = 0; i < 10; ++i) {
            this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ,
                    MathHelper.nextDouble(this.rand, -0.1, 0.1),
                    MathHelper.nextDouble(this.rand, -0.1, 0.1),
                    MathHelper.nextDouble(this.rand, -0.1, 0.1));
        }

        if (!this.world.isRemote) {
            this.setDead(); // Удаляем сущность

            Random r = new Random();
            int rnum = r.nextInt(20); // Случайное число для силы взрыва
            this.world.createExplosion(null, this.posX, this.posY, this.posZ, (float) rnum, true); // Создаем взрыв
        }
    }
}