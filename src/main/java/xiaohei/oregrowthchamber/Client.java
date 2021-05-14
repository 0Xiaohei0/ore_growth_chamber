package xiaohei.oregrowthchamber;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import xiaohei.oregrowthchamber.GUI.ExampleBlockScreen;
import xiaohei.oregrowthchamber.GUI.ExampleGuiDescription;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.<ExampleGuiDescription, ExampleBlockScreen>register(OreGrowthChamber.SCREEN_HANDLER_TYPE,
                (gui, inventory, title) -> new ExampleBlockScreen(gui, inventory.player, title));
    }
}
