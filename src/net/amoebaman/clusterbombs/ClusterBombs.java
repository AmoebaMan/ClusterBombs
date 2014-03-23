package net.amoebaman.clusterbombs;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class ClusterBombs extends JavaPlugin implements Listener{
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event){
		if(event.getEntityType() == EntityType.CREEPER)
			for(int i = 0; i < (Math.random() * 3) + 3; i++){
				Entity creeper = event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.CREEPER);
				creeper.setVelocity(new Vector((Math.random() - 0.5) * 0.5, Math.random() * 0.5, (Math.random() - 0.5) * 0.5));
				if(Math.random() < 0.05)
					((Creeper) creeper).setPowered(true);
			}
	}
	
}
