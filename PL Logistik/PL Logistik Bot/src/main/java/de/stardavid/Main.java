package de.stardavid;

import de.stardavid.commands.SlashCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String prefix = "!";
        String status;
        status = "SpedV";
        String token = "MTEzNTgzMzE4NzkxOTA4MTU3NQ.G3sxBH.3T-8DYp7kcrchS4COPQzEJMsIzl88sZ6d-beNU";

        JDABuilder bauplan = JDABuilder.createDefault(token);
        bauplan.setStatus(OnlineStatus.ONLINE);
        bauplan.setActivity(Activity.playing(status));

        bauplan.setChunkingFilter(ChunkingFilter.ALL);
        bauplan.setMemberCachePolicy(MemberCachePolicy.ALL);
        bauplan.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_PRESENCES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES);
        bauplan.addEventListeners(new SlashCommand());
        JDA bot = bauplan.build();
        System.out.println("Der ist Online!");


        Guild server = bot.awaitReady().getGuildById("1026085255716814948");

        server.updateCommands().addCommands(

                Commands.slash("text","schreibe dein Text")
                        .addOption(OptionType.CHANNEL,"channel","Setze den Channel in dem die Nachricht kommen soll!",true)
                        .addOption(OptionType.STRING,"nachricht","Schreibe deine Nachricht die geschickt werden soll!",true)
        ).queue();

    }
}