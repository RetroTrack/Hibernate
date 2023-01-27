package ga.volar.hibernate.mixin;

import ga.volar.hibernate.Hibernate;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static ga.volar.hibernate.Hibernate.timerEnabled;

@Mixin(MinecraftServer.class)
public class StuffTimer{

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo ci) {
        if(timerEnabled) Hibernate.CheckPlayers();
    }
}
