package xiaohei.oregrowthchamber;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(OreGrowthChamber.BOX_SCREEN_HANDLER, BoxScreen::new);
    }
}