package moe.plushie.armourers_workshop.plugin.core.blockentity;

import net.cocoonmc.core.BlockPos;
import net.cocoonmc.core.block.BlockState;
import org.bukkit.World;

public class ColorMixerBlockEntity extends UpdatableContainerBlockEntity {

    public ColorMixerBlockEntity(World world, BlockPos pos, BlockState blockState) {
        super(world, pos, blockState);
    }
}