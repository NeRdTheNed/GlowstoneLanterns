package com.timvisee.glowstonelanterns.command;

import com.timvisee.dungeonmaze.command.executable.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
public class CommandManager {

    /** The list of commandDescriptions. */
    private List<CommandDescription> commandDescriptions = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param registerCommands True to register the commands, false otherwise.
     */
    public CommandManager(boolean registerCommands) {
        // Register the commands
        if(registerCommands)
            registerCommands();
    }

    /**
     * Register all commands.
     */
    @SuppressWarnings("SpellCheckingInspection")
    public void registerCommands() {
        // Register the base Dungeon Maze command
        CommandDescription dungeonMazeCommand = new CommandDescription(
                new DungeonMazeCommand(),
                new ArrayList<String>() {{
                    add("dungeonmaze");
                    add("dm");
                }},
                "Main command",
                "The main Dungeon Maze command. The root for all the other commands.", null);

        // Register the help command
        CommandDescription helpCommand = new CommandDescription(
                new HelpCommand(),
                new ArrayList<String>() {{
                    add("help");
                    add("hlp");
                    add("h");
                    add("sos");
                    add("?");
                }},
                "View help",
                "View detailed help pages about Dungeon Maze commands.",
                dungeonMazeCommand);
        helpCommand.addArgument(new CommandArgumentDescription("query", "The command or query to view help for.", true));
        helpCommand.setMaximumArguments(false);

        // Register the create command
        CommandDescription createWorldCommand = new CommandDescription(
                new CreateWorldCommand(),
                new ArrayList<String>() {{
                    add("createworld");
                    add("cw");
                }},
                "Create world",
                "Create a new Dungeon Maze world, the name of the world must be unique.",
                dungeonMazeCommand);
        createWorldCommand.addArgument(new CommandArgumentDescription("world", "The name of the world to create.", false));
        createWorldCommand.addArgument(new CommandArgumentDescription("preload", "True or False to preload the world on startup.", true));
        createWorldCommand.setCommandPermissions("dungeonmaze.command.createworld", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the teleport command
        CommandDescription teleportCommand = new CommandDescription(
                new TeleportCommand(),
                new ArrayList<String>() {{
                    add("teleport");
                    add("tp");
                    add("warp");
                    add("goto");
                    add("move");
                }},
                "Teleport to world",
                "Teleports to any another world, such as a Dungeon Maze world." ,
                dungeonMazeCommand);
        teleportCommand.addArgument(new CommandArgumentDescription("world", "The name of the world to teleport to.", false));
        teleportCommand.setCommandPermissions("dungeonmaze.command.teleport", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the load world command
        CommandDescription loadWorldCommand = new CommandDescription(
                new LoadWorldCommand(),
                new ArrayList<String>() {{
                    add("loadworld");
                    add("load");
                }},
                "Load a world",
                "Load a world if it isn't loaded." ,
                dungeonMazeCommand);
        loadWorldCommand.addArgument(new CommandArgumentDescription("world", "The name of the world to load.", false));
        loadWorldCommand.setCommandPermissions("dungeonmaze.command.loadworld", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the unload world command
        CommandDescription unloadWorldCommand = new CommandDescription(
                new UnloadWorldCommand(),
                new ArrayList<String>() {{
                    add("unloadworld");
                    add("unload");
                }},
                "Unload a world",
                "Unload a loaded world." ,
                dungeonMazeCommand);
        unloadWorldCommand.addArgument(new CommandArgumentDescription("world", "The name of the world to unload.", false));
        unloadWorldCommand.setCommandPermissions("dungeonmaze.command.unloadworld", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the list world command
        CommandDescription listWorldCommand = new CommandDescription(
                new ListWorldCommand(),
                new ArrayList<String>() {{
                    add("listworlds");
                    add("listworld");
                    add("list");
                    add("worlds");
                    add("lw");
                }},
                "List Dungeon Mazes",
                "Lists the available Dungeon Maze worlds and shows some additional information.",
                dungeonMazeCommand);
        listWorldCommand.setCommandPermissions("dungeonmaze.command.listworlds", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the reload command
        CommandDescription reloadCommand = new CommandDescription(
                new ReloadCommand(),
                new ArrayList<String>() {{
                    add("reload");
                    add("rld");
                    add("r");
                }},
                "Reload Dungeon Maze",
                "Reload the Dungeon Maze plugin.",
                dungeonMazeCommand);
        reloadCommand.setCommandPermissions("dungeonmaze.command.reload", CommandPermissions.DefaultPermission.OP_ONLY);
        reloadCommand.addArgument(new CommandArgumentDescription("force", "True or False to force reload.", true));

        // Register the reload permissions command
        CommandDescription reloadPermissionsCommand = new CommandDescription(
                new ReloadPermissionsCommand(),
                new ArrayList<String>() {{
                    add("reloadpermissions");
                    add("reloadpermission");
                    add("reloadperms");
                    add("rp");
                }},
                "Reload permissions",
                "Reload the permissions system and rehook the installed permissions system.",
                dungeonMazeCommand);
        reloadPermissionsCommand.setCommandPermissions("dungeonmaze.command.reloadpermissions", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the restart command
        CommandDescription restartCommand = new CommandDescription(
                new RestartCommand(),
                new ArrayList<String>() {{
                    add("restart");
                    add("rstrt");
                }},
                "Restart Dungeon Maze",
                "Restart the Dungeon Maze plugin.",
                dungeonMazeCommand);
        restartCommand.setCommandPermissions("dungeonmaze.command.restart", CommandPermissions.DefaultPermission.OP_ONLY);
        restartCommand.addArgument(new CommandArgumentDescription("force", "True or False to force restart.", true));

        // Register the check updates command
        CommandDescription checkUpdatesCommand = new CommandDescription(
                new CheckUpdatesCommand(),
                new ArrayList<String>() {{
                    add("checkupdates");
                    add("checkupdate");
                    add("check");
                    add("updates");
                    add("update");
                    add("cu");
                }},
                "Check updates",
                "Check for available updates to install.",
                dungeonMazeCommand);
        checkUpdatesCommand.setCommandPermissions("dungeonmaze.command.checkupdates", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the install update command
        CommandDescription installUpdateCommand = new CommandDescription(
                new InstallUpdateCommand(),
                new ArrayList<String>() {{
                    add("installupdates");
                    add("installupdate");
                    add("install");
                    add("iu");
                }},
                "Install update",
                "Try to install any availble update.",
                dungeonMazeCommand);
        installUpdateCommand.setCommandPermissions("dungeonmaze.command.installupdate", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the status command
        CommandDescription statusCommand = new CommandDescription(
                new StatusCommand(),
                new ArrayList<String>() {{
                    add("status");
                    add("stats");
                    add("s");
                }},
                "Status info",
                "Show detailed plugin status.",
                dungeonMazeCommand);
        statusCommand.setMaximumArguments(false);
        statusCommand.setCommandPermissions("dungeonmaze.command.status", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the status command
        CommandDescription serviceCommand = new CommandDescription(
                new ServiceCommand(),
                new ArrayList<String>() {{
                    add("services");
                    add("service");
                    add("serv");
                }},
                "Services command",
                "Show detailed information about all the Dungeon Maze serivces.",
                dungeonMazeCommand);
        serviceCommand.setMaximumArguments(false);
        serviceCommand.setCommandPermissions("dungeonmaze.command.services", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the version command
        CommandDescription versionCommand = new CommandDescription(
                new VersionCommand(),
                new ArrayList<String>() {{
                    add("version");
                    add("ver");
                    add("v");
                    add("about");
                    add("info");
                }},
                "Version info",
                "Show detailed information about the installed Dungeon Maze version, and shows the developers, contributors, license and other information.",
                dungeonMazeCommand);
        versionCommand.setMaximumArguments(false);

        // Add the base command to the commands array
        this.commandDescriptions.add(dungeonMazeCommand);
    }

    /**
     * Get the list of command descriptions
     *
     * @return List of command descriptions.
     */
    public List<CommandDescription> getCommandDescriptions() {
        return this.commandDescriptions;
    }

    /**
     * Get the number of command description count.
     *
     * @return Command description count.
     */
    public int getCommandDescriptionCount() {
        return this.getCommandDescriptions().size();
    }

    /**
     * Find the best suitable command for the specified reference.
     *
     * @param queryReference The query reference to find a command for.
     *
     * @return The command found, or null.
     */
    public FoundCommandResult findCommand(CommandParts queryReference) {
        // Make sure the command reference is valid
        if(queryReference.getCount() <= 0)
            return null;

        // Get the base command description
        for(CommandDescription commandDescription : this.commandDescriptions) {
            // Check whether there's a command description available for the current command
            if(!commandDescription.isSuitableLabel(queryReference))
                continue;

            // Find the command reference, return the result
            return commandDescription.findCommand(queryReference);
        }

        // No applicable command description found, return false
        return null;
    }
}
