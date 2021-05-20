package nl.itz_kiwisap_.gezelligediscordbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import nl.itz_kiwisap_.gezelligediscordbot.DiscordBot;
import nl.itz_kiwisap_.gezelligediscordbot.utils.AdvancementUtil;
import nl.itz_kiwisap_.gezelligediscordbot.utils.RestActionUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;
import java.util.Date;

public class PlayerListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        TextChannel channel = DiscordBot.getInstance().getMessageChannel();

        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&eSurvival Mensje &f" + player.getName() + " is gejoined!"));

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(player.getName().replace("_", "\\_") + " is gejoined")
                .setThumbnail("https://crafatar.com/avatars/" + player.getUniqueId())
                .setColor(Color.GREEN)
                .setTimestamp(new Date().toInstant());

        channel.sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        TextChannel channel = DiscordBot.getInstance().getMessageChannel();

        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&eSurvival Mensje &f" + player.getName() + " is geleaved!"));

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(player.getName().replace("_", "\\_") + " is geleaved")
                .setThumbnail("https://crafatar.com/avatars/" + player.getUniqueId())
                .setColor(Color.RED)
                .setTimestamp(new Date().toInstant());

        channel.sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);
    }

    @EventHandler
    public void on(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();
        TextChannel channel = DiscordBot.getInstance().getMessageChannel();
        String advancementKey = event.getAdvancement().getKey().getKey();
        String display = AdvancementUtil.getAdvancements().get(advancementKey);
        if(display == null) return;

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(player.getName().replace("_", "\\_") + " heeft de advancement [" + display + "] behaald!")
                .setThumbnail("https://crafatar.com/avatars/" + player.getUniqueId() + "")
                .setColor(Color.CYAN)
                .setTimestamp(new Date().toInstant());

        channel.sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);
    }

    @EventHandler
    public void on(PlayerDeathEvent event) {
        Player player = event.getEntity();
        TextChannel channel = DiscordBot.getInstance().getMessageChannel();
        String deathMessage = (event.getDeathMessage() == null) ? player.getName().replaceAll("_", "\\_") + " died." : event.getDeathMessage();

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(deathMessage.replace("_", "\\_"))
                .setThumbnail("https://crafatar.com/avatars/" + player.getUniqueId())
                .setColor(Color.BLACK)
                .setTimestamp(new Date().toInstant());

        channel.sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);

        event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&7[&e&lDOOD&7] &f" + deathMessage));
    }

    @EventHandler
    public void on(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        TextChannel channel = DiscordBot.getInstance().getChatChannel();
        String message = event.getMessage().replace("<3", "♥");

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(player.getName().replace("_", "\\_"))
                .setDescription(message)
                .setThumbnail("https://crafatar.com/avatars/" + player.getUniqueId())
                .setColor(Color.BLUE)
                .setFooter("Vanuit minecraft")
                .setTimestamp(new Date().toInstant());

        channel.sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);

        event.setMessage(message);
    }
}
