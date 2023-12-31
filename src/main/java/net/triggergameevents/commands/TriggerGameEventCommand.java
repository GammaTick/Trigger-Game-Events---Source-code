package net.triggergameevents.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.BlockPosArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class TriggerGameEventCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("gameevent").requires(source -> source.hasPermissionLevel(2))
                .then(literal("spawn_pillager_patrol")
                        .executes(context -> spawnPillagerPatrol(context, null, null, false, -1))

                        .then(literal("at")
                                .then(argument("entity", EntityArgumentType.entity())
                                        .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), null, false, -1))
                                        .then(argument("target_entity_position", EntityArgumentType.entity())
                                                .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), EntityArgumentType.getEntity(context, "target_entity_position").getBlockPos(), false, -1))
                                                .then(argument("force_spawn", BoolArgumentType.bool())
                                                        .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), EntityArgumentType.getEntity(context, "target_entity_position").getBlockPos(), BoolArgumentType.getBool(context, "force_spawn"), -1))
                                                        .then(argument("number_of_pillagers", IntegerArgumentType.integer(0, 8192))
                                                                .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), EntityArgumentType.getEntity(context, "target_entity_position").getBlockPos(), BoolArgumentType.getBool(context, "force_spawn"), IntegerArgumentType.getInteger(context, "number_of_pillagers"))))))

                                        .then(argument("target_block_position", BlockPosArgumentType.blockPos())
                                                .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), BlockPosArgumentType.getBlockPos(context, "target_block_position"), false, -1))
                                                .then(argument("force_spawn", BoolArgumentType.bool())
                                                        .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), BlockPosArgumentType.getBlockPos(context, "target_block_position"), BoolArgumentType.getBool(context, "force_spawn"), -1))
                                                        .then(argument("number_of_pillagers", IntegerArgumentType.integer(0, 8192))
                                                                .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), BlockPosArgumentType.getBlockPos(context, "target_block_position"), BoolArgumentType.getBool(context, "force_spawn"), IntegerArgumentType.getInteger(context, "number_of_pillagers"))))))

                                        .then(literal("random_target_position")
                                                .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), null, false, -1))
                                                .then(argument("force_spawn", BoolArgumentType.bool())
                                                        .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), null, BoolArgumentType.getBool(context, "force_spawn"), -1))
                                                        .then(argument("number_of_pillagers", IntegerArgumentType.integer(0, 8192))
                                                                .executes(context -> spawnPillagerPatrol(context, EntityArgumentType.getEntity(context, "entity").getBlockPos(), null, BoolArgumentType.getBool(context, "force_spawn"), IntegerArgumentType.getInteger(context, "number_of_pillagers")))))))

                                .then(argument("block_position", BlockPosArgumentType.blockPos())
                                        .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), null, false, -1))
                                        .then(argument("target_entity_position", EntityArgumentType.entity())
                                                .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), EntityArgumentType.getEntity(context, "target_entity_position").getBlockPos(), false, -1))
                                                .then(argument("force_spawn", BoolArgumentType.bool())
                                                        .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), EntityArgumentType.getEntity(context, "target_entity_position").getBlockPos(), BoolArgumentType.getBool(context, "force_spawn"), -1))
                                                        .then(argument("number_of_pillagers", IntegerArgumentType.integer(0, 8192))
                                                                .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), EntityArgumentType.getEntity(context, "target_entity_position").getBlockPos(), BoolArgumentType.getBool(context, "force_spawn"), IntegerArgumentType.getInteger(context, "number_of_pillagers"))))))

                                        .then(argument("target_block_position", BlockPosArgumentType.blockPos())
                                                .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), BlockPosArgumentType.getBlockPos(context, "target_block_position"), false, -1))
                                                .then(argument("force_spawn", BoolArgumentType.bool())
                                                        .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), BlockPosArgumentType.getBlockPos(context, "target_block_position"), BoolArgumentType.getBool(context, "force_spawn"), -1))
                                                        .then(argument("number_of_pillagers", IntegerArgumentType.integer(0, 8192))
                                                                .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), BlockPosArgumentType.getBlockPos(context, "target_block_position"), BoolArgumentType.getBool(context, "force_spawn"), IntegerArgumentType.getInteger(context, "number_of_pillagers"))))))

                                        .then(literal("random_target_position")
                                                .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), null, false, -1))
                                                .then(argument("force_spawn", BoolArgumentType.bool())
                                                        .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), null, BoolArgumentType.getBool(context, "force_spawn"), -1))
                                                        .then(argument("number_of_pillagers", IntegerArgumentType.integer(0, 8192))
                                                                .executes(context -> spawnPillagerPatrol(context, BlockPosArgumentType.getBlockPos(context, "block_position"), null, BoolArgumentType.getBool(context, "force_spawn"), IntegerArgumentType.getInteger(context, "number_of_pillagers")))))))))
        ));
    }

    public static int spawnPillagerPatrol(CommandContext<ServerCommandSource> context, BlockPos spawnPos, BlockPos targetPos, boolean forceSpawn, int pillagerCount) {
        return PillagerPatrol.spawn(context, spawnPos, targetPos, forceSpawn, pillagerCount);
    }

    public static int spawnWanderingTrader(CommandContext<ServerCommandSource> context, BlockPos spawnPos, BlockPos targetPos, boolean forceSpawn) {
        return WanderingTrader.spawn(context, spawnPos, targetPos, forceSpawn);
    }

    public static int spawnZombieSiege(CommandContext<ServerCommandSource> context, BlockPos spawnPos, boolean forceSpawn) {
        return ZombieSiege.spawn(context, spawnPos, forceSpawn);
    }
}
