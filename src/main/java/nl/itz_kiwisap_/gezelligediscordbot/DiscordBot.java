package nl.itz_kiwisap_.gezelligediscordbot;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import nl.itz_kiwisap_.gezelligediscordbot.listeners.PlayerListener;
import nl.itz_kiwisap_.gezelligediscordbot.listeners.discord.DiscordListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class DiscordBot extends JavaPlugin {

    @Getter
    private static DiscordBot instance;

    @Getter
    private JDA jda;
    @Getter
    private Guild guild;
    @Getter
    private TextChannel messageChannel;
    @Getter
    private TextChannel chatChannel;

    @Override
    public void onEnable() {
        instance = this;

        registerBot();

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;

        jda.shutdownNow();
    }

    private void registerBot() {
        try {
            jda = JDABuilder.createDefault("")
                    .setChunkingFilter(ChunkingFilter.ALL)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);

            jda.getPresence().setActivity(Activity.of(Activity.ActivityType.DEFAULT, "survival wereldje :D"));

            jda.addEventListener(new ListenerAdapter() {
                public void onReady(@NotNull ReadyEvent event) {
                    guild = event.getJDA().getGuildById("814804164323573790");
                    if(guild == null) return;

                    messageChannel = guild.getTextChannelById("844579337856614441");
                    chatChannel = guild.getTextChannelById("844579297221017661");

                    if(messageChannel == null || chatChannel == null) return;

                    jda.addEventListener(new DiscordListener());
                    System.out.println("De discord bot is nu klaar voor gebruik met guild id " + guild.getId());
                }
            });
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}