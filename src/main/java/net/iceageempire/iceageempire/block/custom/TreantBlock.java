package net.iceageempire.iceageempire.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class TreantBlock extends HorizontalDirectionalBlock {

    public TreantBlock() {
        super(BlockBehaviour.Properties.of().strength(3.5f));
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        Random rand = new Random();
        int min = 1;
        int max = 3;
        int zombieCount = rand.nextInt(max - min + 1) + min;

        for(int i = 0; i < zombieCount; i++ ){
            if(!pLevel.isClientSide && pLevel instanceof ServerLevel serverLevel){
                Zombie zombie = EntityType.ZOMBIE.create(serverLevel);
                if(zombie!=null){
                    double offSetX = (Math.random() - 0.5) * 2;
                    double offSetZ = (Math.random() - 0.5) * 2;

                    zombie.moveTo(pPos.getX() + offSetX, pPos.getY(), pPos.getZ() + offSetZ);
                    pLevel.destroyBlock(pPos,false);
                    serverLevel.addFreshEntity(zombie);
                }
            }

        }
        return InteractionResult.SUCCESS;
    }

}
