package me.seanpilkington;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Main {

    private final ShardManager shardManager;

    public Main() {
        Dotenv dotenv = Dotenv.load();;
        String token = dotenv.get("BOT_TOKEN");

        // Shard Manager Builder
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);

        // Builder Customisation
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("0 Player's Games"));

        // Build
        shardManager = builder.build();

    }

    public static void main(String[] args) {
        Main bot = new Main();
    }

    // Getters
    public ShardManager getShardManager() {
        return shardManager;
    }
}