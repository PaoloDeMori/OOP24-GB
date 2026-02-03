package it.unibo.geometrybash;

import it.unibo.geometrybash.commons.assets.AssetStore;
import it.unibo.geometrybash.commons.assets.ResourceLoader;
import it.unibo.geometrybash.commons.assets.ResourceLoaderImpl;
import it.unibo.geometrybash.controller.StaticDeltaTimeControllerImpl;
import it.unibo.geometrybash.controller.Controller;
import it.unibo.geometrybash.model.GameModel;
import it.unibo.geometrybash.model.GameModelImpl;
import it.unibo.geometrybash.model.physicsengine.impl.jbox2d.JBox2dPhysicsEngineFactory;
import it.unibo.geometrybash.view.ViewImpl;
import it.unibo.geometrybash.view.View;

/**
 * The entry point class of Geometry-Bash.
 */
public final class App {

    private App() {
        // Default constructor to avoid initialization of this class.
    }

    /**
     * The entry point of Geometry-Bash.
     * 
     * @param args the input parameters for the entry point.
     */
    public static void main(final String[] args) {
        final ResourceLoader resourceLoader = new ResourceLoaderImpl();
        final AssetStore assetStore = new AssetStore(resourceLoader);
        final JBox2dPhysicsEngineFactory physicsEngineFactory = new JBox2dPhysicsEngineFactory();
        final View view = new ViewImpl(resourceLoader, assetStore);
        final GameModel gameModel = new GameModelImpl(resourceLoader, physicsEngineFactory);
        final Controller controller = new StaticDeltaTimeControllerImpl(gameModel, view, resourceLoader);
        controller.start();
    }
}
