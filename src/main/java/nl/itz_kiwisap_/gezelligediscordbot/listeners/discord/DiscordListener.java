package nl.itz_kiwisap_.gezelligediscordbot.listeners.discord;

import me.codedred.playtimes.utils.PAPIHolders;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import nl.itz_kiwisap_.gezelligediscordbot.DiscordBot;
import nl.itz_kiwisap_.gezelligediscordbot.utils.RestActionUtil;
import nl.itz_kiwisap_.gezelligediscordbot.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DiscordListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        if(event.getMessage().getContentRaw().toLowerCase().startsWith("%") && event.getMessage().getContentRaw().length() > 1) {
            event.getMessage().delete().queue(null, RestActionUtil.ignore);

            if(event.getChannel().getId().equalsIgnoreCase("844601049654362152")) {
                if (event.getMessage().getContentRaw().toLowerCase().startsWith("%info")) {
                    String[] args = event.getMessage().getContentRaw().split(" ");

                    if (args.length > 1) {
                        String player = args[1];

                        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player);

                        if (!offlinePlayer.hasPlayedBefore()) {
                            event.getChannel().sendMessage(new EmbedBuilder().setDescription("Dit is geen geldige speler").setColor(Color.RED).setTimestamp(new Date().toInstant()).build()).queue((m) -> m.delete().queueAfter(5, TimeUnit.SECONDS), RestActionUtil.ignore);
                            return;
                        }

                        String playTime = PAPIHolders.getHolders(offlinePlayer, "%time% (#%place%)");
                        String joins = PAPIHolders.getHolders(offlinePlayer, "%timesjoined%");

                        EmbedBuilder embedBuilder = new EmbedBuilder()
                                .setTitle("Informatie " + offlinePlayer.getName().replace("_", "\\_"))
                                .addField("Speeltijd", (playTime.isEmpty()) ? "Kon niet laden..." : playTime, true)
                                .addField("Joins", (joins.isEmpty()) ? "Kon niet laden..." : joins, true)
                                .addField("Dieren voortgepland", getStatistic(offlinePlayer, Statistic.ANIMALS_BRED), true)
                                .addField("Armor gerepareert", getStatistic(offlinePlayer, Statistic.ARMOR_CLEANED), true)
                                .addField("Barrels geopend", getStatistic(offlinePlayer, Statistic.OPEN_BARREL), true)
                                .addField("Bellen geluid", getStatistic(offlinePlayer, Statistic.BELL_RING), true)
                                .addField("Taart stukjes gegeten", getStatistic(offlinePlayer, Statistic.CAKE_SLICES_EATEN), true)
                                .addField("Kisten geopend", getStatistic(offlinePlayer, Statistic.CHEST_OPENED), true)
                                .addField("Damage geabsorbeerd", getStatistic(offlinePlayer, Statistic.DAMAGE_ABSORBED), true)
                                .addField("Damage uitgedeeld", getStatistic(offlinePlayer, Statistic.DAMAGE_DEALT), true)
                                .addField("Damage gekregen", getStatistic(offlinePlayer, Statistic.DAMAGE_TAKEN), true)
                                .addField("Afstand gelopen (m)", getStatistic(offlinePlayer, Statistic.WALK_ONE_CM, 100), true)
                                .addField("Afstand geklommen (m)", getStatistic(offlinePlayer, Statistic.CLIMB_ONE_CM, 100), true)
                                .addField("Afstand gesneakt (m)", getStatistic(offlinePlayer, Statistic.CROUCH_ONE_CM, 100), true)
                                .addField("Afstand gerend (m)", getStatistic(offlinePlayer, Statistic.SPRINT_ONE_CM, 100), true)
                                .addField("Items gedropped", getStatistic(offlinePlayer, Statistic.DROP_COUNT), true)
                                .addField("Gesprongen", getStatistic(offlinePlayer, Statistic.JUMP), true)
                                .addField("Mobs vermoord", getStatistic(offlinePlayer, Statistic.MOB_KILLS), true)
                                .addField("Items enchanted", getStatistic(offlinePlayer, Statistic.ITEM_ENCHANTED), true)
                                .addField("Nachten geslapen", getStatistic(offlinePlayer, Statistic.SLEEP_IN_BED), true)
                                .setColor(Color.CYAN)
                                .setTimestamp(new Date().toInstant());

                        event.getChannel().sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);
                    }

                    return;
                } else if(event.getMessage().getContentRaw().toLowerCase().startsWith("%online")) {
                    EmbedBuilder embedBuilder = new EmbedBuilder()
                            .setTitle("Online survival mensjes (" + Bukkit.getOnlinePlayers().size() + ")")
                            .setColor(Color.CYAN)
                            .setTimestamp(new Date().toInstant());

                    if(!Bukkit.getOnlinePlayers().isEmpty()) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            embedBuilder.appendDescription("- **" + player.getName().replace("_", "\\_") + "**\n");
                        }
                    } else {
                        embedBuilder.setDescription("Er is momenteel niemand online \uD83D\uDE26");
                    }

                    event.getChannel().sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);

                    return;
                }
            }
        }

        if(event.getChannel().getId().equalsIgnoreCase(DiscordBot.getInstance().getChatChannel().getId())) {
            if(event.getMessage().getContentRaw().toLowerCase().startsWith("%")) {
                event.getMessage().delete().queue(null, RestActionUtil.ignore);
                return;
            }

            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b[&9DISCORD&b] " + event.getAuthor().getName() + ": &f" + event.getMessage().getContentRaw()));

            EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setTitle(event.getMessage().getAuthor().getName())
                    .setDescription(event.getMessage().getContentDisplay())
                    .setThumbnail(event.getMessage().getAuthor().getAvatarUrl())
                    .setColor(Color.CYAN)
                    .setFooter("Vanuit discord")
                    .setTimestamp(new Date().toInstant());

            event.getMessage().delete().queue(null, RestActionUtil.ignore);
            event.getChannel().sendMessage(embedBuilder.build()).queue(null, RestActionUtil.ignore);
        }
    }

    private String getStatistic(OfflinePlayer player, Statistic statistic) {
        return getStatistic(player, statistic, 1);
    }

    private String getStatistic(OfflinePlayer player, Statistic statistic, int divideBy) {
        int value = player.getStatistic(statistic) / divideBy;
        return Utils.numberWithDots(value);
    }
}