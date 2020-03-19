package HHG;

//-----imports-----//
import arc.util.CommandHandler;
import arc.util.Log;
import mindustry.entities.type.Player;
import mindustry.gen.Call;
import mindustry.plugin.Plugin;

public class Main extends Plugin {
    public int halpX = 0;
    public int halpY = 0;
    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.<Player>register("halp","Calls for help and setups /go", (arg, player) -> {
            halpX = (int) (player.x/8);
            halpY = (int) (player.y/8);
            Call.sendMessage("[white]" + player.name + ": [white]Need help at ([lightgray]" + halpX + "[white],[lightgray]" + halpY + "[white]). \ndo `[lightgray]/go[white]` to come to me.");
            Log.info(player.name + ": [white]Need help at ([lightgray]" + halpX + "[white],[lightgray]" + halpY + "[white]). do `[lightgray]/go[white]` to come to me.");
        });
        handler.<Player>register("go","goes to location from /here or /halp", (arg, player) -> {
            player.set(halpX*8,halpY*8);
            player.setNet(halpX*8,halpY*8);
            player.set(halpX*8,halpY*8);
        });
        handler.<Player>register("here","setups /go to go to your location", (arg, player) -> {
            halpX = (int) (player.x/8);
            halpY = (int) (player.y/8);
            Call.sendMessage("[white]" + player.name + ": [white]Here at ([lightgray]" + halpX + "[white],[lightgray]" + halpY + "[white]). \ndo `[lightgray]/go[white]` to come to me.");
            Log.info(player.name + ": [white]Here at ([lightgray]" + halpX + "[white],[lightgray]" + halpY + "[white]). do `[lightgray]/go[white]` to come to me.");
        });
    }
}
