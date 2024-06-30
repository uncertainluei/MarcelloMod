package io.github.luisrandomness.marcellomod.init;

import io.github.luisrandomness.marcellomod.MarcelloMod;
import io.github.luisrandomness.marcellomod.entity.MarcelloEntity;
import io.github.luisrandomness.marcellomod.entity.MarkEntity;
import io.github.luisrandomness.marcellomod.entity.MoldyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.*;

public class MM_EntityTypes {

    public static <T extends Entity> EntityType<T> registerEntityType(String identifier, EntityType<T> type) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, MarcelloMod.modIdentifier(identifier), type);
    }

    public static EntityType<MarcelloEntity> MARCELLO = registerEntityType("marcello",
            EntityType.Builder.of(MarcelloEntity::new, MobCategory.MONSTER).sized(0.6F, 1.8F).ridingOffset(-0.6F).build());
    public static EntityType<MoldyEntity> MOLDY = registerEntityType("moldy",
            EntityType.Builder.of(MoldyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.8F).ridingOffset(-0.6F).build());

    public static EntityType<MarkEntity> MARK = registerEntityType("mark",
            EntityType.Builder.of(MarkEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).ridingOffset(-0.7F).fireImmune().build());

    public static void registerEntities()
    {
        FabricDefaultAttributeRegistry.register(MARCELLO, MarcelloEntity.createMarcelloAttributes());
        FabricDefaultAttributeRegistry.register(MOLDY, MoldyEntity.createMoldyAttributes());
        FabricDefaultAttributeRegistry.register(MARK, MarkEntity.createMarkAttributes());
    }
}