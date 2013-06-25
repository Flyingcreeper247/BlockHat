package whoppercraft;


import javax.naming.Binding;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Platform;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.getspout.spout.Spout;
import org.getspout.spoutapi.keyboard.Keyboard;

public class Hat implements Listener {
	private static Main pl;

    public Hat(Main instance) {
            pl = instance;
        }

        public Hat() {
        }

        @EventHandler(priority = EventPriority.HIGH)
        public void onPlayerInteract(PlayerInteractEvent event) {
                Player player = event.getPlayer();
                Action action = event.getAction();
                if (Spout.getPlatform() == Platform.CLIENT)
                {
                    Client c = (Client) Spout.getEngine();
                    InputManager in = c.getInputManager();
                    in.bind (new Binding ("my command", Keyboard.KEY_F5));
                }
                if (action == Action.LEFT_CLICK_AIR) {
                        setHat(player);

                }
        }

        public static void setHat(Player player) {
                ItemStack hand = player.getItemInHand().clone();
                PlayerInventory inv = player.getInventory();
                ItemStack head = inv.getHelmet();
                hand.setAmount(1);
                inv.remove(hand);
                inv.setHelmet(hand);
                inv.setItemInHand(head);
                player.sendMessage(ChatColor.AQUA + "Enjoy your hat!");
		}

		public static void setHat(Player player, ItemStack item) {
                PlayerInventory inv = player.getInventory();
                inv.setHelmet(item);
                player.sendMessage(ChatColor.AQUA + "Enjoy your hat!");
        }
		
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event) {
                        setHat(event.getPlayer(), new ItemStack(pl.getConfig().getInt("startID")));
                }
        @EventHandler
        public void getHelmet(EntityDamageEvent event){
            DamageCause drowning = DamageCause.DROWNING;
            DamageCause cause = event.getCause();
     
                if(cause == drowning && event.getEntity() instanceof Player){
                    Player player = (Player) event.getEntity();
                    ItemStack helmet = player.getInventory().getHelmet();
                    if(helmet.getType().equals(Material.GLASS));
                    event.setCancelled(true);
                    }
                }
        }
