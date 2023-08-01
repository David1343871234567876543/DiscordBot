package de.stardavid.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        TextChannel admin = event.getGuild().getTextChannelById("1094213528585523220");
        if (event.getName().equals("text")) {
            if (event.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {

                event.reply("Deine Nachricht wurde geschickt!").setEphemeral(true).queue();

                TextChannel channel = event.getOption("channel").getAsChannel().asTextChannel();
                String nachricht = event.getOption("nachricht").getAsString();

                EmbedBuilder nachrichte = new EmbedBuilder();
                nachrichte.setDescription(nachricht);

                channel.sendMessageEmbeds(nachrichte.build()).queue();
            }
        }
    }
}
