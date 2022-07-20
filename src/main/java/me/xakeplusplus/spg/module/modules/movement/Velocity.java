package me.xakeplusplus.spg.module.modules.movement;

import org.lwjgl.input.Keyboard;

import me.xakeplusplus.spg.event.Event;
import me.xakeplusplus.spg.event.events.PacketEvent;
import me.xakeplusplus.spg.module.Category;
import me.xakeplusplus.spg.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;

public class Velocity extends Module {
	private Minecraft mc = Minecraft.getMinecraft();
	
	public Velocity() {
		super ("Velocity", Category.MOVEMENT);
	}
	
	@EventHandler
	private Listener<PacketEvent.Receive> receiveListener = new Listener<>(event -> {
		if (event.getPacket() instanceof SPacketEntityVelocity) {
			
			if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId()) {
                event.cancel();
            }
			
	        
		} if (event.getPacket() instanceof SPacketExplosion) {
            event.cancel();
        }
	});
}
