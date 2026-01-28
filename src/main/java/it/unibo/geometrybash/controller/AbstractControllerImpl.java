package it.unibo.geometrybash.controller;

import java.util.Optional;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unibo.geometrybash.commons.UpdateInfoDto;
import it.unibo.geometrybash.commons.input.StandardViewEventType;
import it.unibo.geometrybash.commons.pattern.observerpattern.modelobserver.ModelEvent;
import it.unibo.geometrybash.controller.gameloop.GameLoop;
import it.unibo.geometrybash.controller.gameloop.GameLoopImpl;
import it.unibo.geometrybash.controller.gameloop.exceptions.InvalidGameLoopConfigurationException;
import it.unibo.geometrybash.controller.gameloop.exceptions.InvalidGameLoopStatusException;
import it.unibo.geometrybash.controller.gameloop.exceptions.NotOnPauseException;
import it.unibo.geometrybash.controller.gameloop.exceptions.NotStartedException;
import it.unibo.geometrybash.model.GameModel;
import it.unibo.geometrybash.model.exceptions.InvalidModelMethodInvocationException;
import it.unibo.geometrybash.model.physicsengine.exception.ModelExecutionException;
import it.unibo.geometrybash.view.ErrorMessageView;
import it.unibo.geometrybash.view.View;
import it.unibo.geometrybash.view.ViewScene;
import it.unibo.geometrybash.view.exceptions.ExecutionWithIllegalThreadException;
import it.unibo.geometrybash.view.exceptions.NotStartedViewException;

/**
 * Abstract Implementation of the controller interface with an undefined method to evaluate deltatime.
 */
public abstract class AbstractControllerImpl implements Controller {
    /**
     * Logger instance to handle errors and sending debug information.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractControllerImpl.class);

    private final GameModel gameModel;
    private final View view;
    private final InputHandler inputHandler;
    private final GameLoop gameLoop;
    private String levelName = "Primo livello";

    /**
     * The constructor of the controller with game model, view and input handler creation delegated.
     * 
     * @param gameModel the model of the game
     * @param view the main view class of the game
     * @param inputHandler the input handler and view listener of the game
     */
    public AbstractControllerImpl(final GameModel gameModel, final View view, final InputHandler inputHandler) {
        this.gameModel = gameModel;
        this.gameModel.addObserver(this);
        this.view = view;
        this.inputHandler = inputHandler;
        this.initInputHandler();
        this.view.addObserver(inputHandler);
        gameLoop = new GameLoopImpl(this::onEveryFrame);

    }

    /**
     * {@inheritDoc}
     */
    abstract protected float evaluateDeltaTime();

    /**
     * Sets the action to execute on input messages receiver
     */
    private void initInputHandler() {
        this.inputHandler.setOnMainKeyPressed(this::onJumpAction);
        this.inputHandler.setOnMenuKeyPressed(this::gamePause);
        this.inputHandler.setActionForEvent(StandardViewEventType.START, this::startLevel);
        this.inputHandler.setActionForEvent(StandardViewEventType.RESTART, this::gameRestart);
        this.inputHandler.setActionForEvent(StandardViewEventType.RESUME, this::gameResume);
        this.inputHandler.setGenericCommandHandler(this::onGenericCommand);
    }

    private void onJumpAction() {
        this.gameModel.jumpSignal();
    }

    private void onGenericCommand(final String command) {
        switch (command) {
            case "close":
            case "quit":
                try {
                    gameLoop.stop();
                } catch (NotStartedException e) {
                    LOGGER.warn("Gameloop never started");
                } finally {
                    LOGGER.info("Chiusura del gioco");
                    System.exit(0);
                }
                break;
            case "resolution -big":
                // TODO
                break;
            default:
                break;
        }

    }

    private void onEveryFrame() {
        this.gameModel.update(evaluateDeltaTime());
        UpdateInfoDto dto;
        try {
            dto = gameModel.toDto();
            SwingUtilities.invokeLater(() -> {
                    if (dto != null) {
                        callViewUpdate(dto);
                    }
            });

        } catch (ModelExecutionException e) {
            handleError("Error while updating the game", Optional.of(e));
        }

    }

    private void handleError(String message, Optional<Exception> ex) {

        try {
            gameLoop.stop();
        } catch (NotStartedException e) {
            LOGGER.info("The safe thread interruption wasn't necessary");
        } finally {
            errorMessage(message, ex);
        }

    }

    private void callViewUpdate(UpdateInfoDto dto) {
        try {
            this.view.update(dto);
        } catch (NotStartedViewException | ExecutionWithIllegalThreadException e) {
            handleError("Error while updating the view", Optional.of(e));
        }
    }

    private void errorMessage(String message, Optional<Exception> e) {
        ErrorMessageView.ShowError(message);
        if (e.isPresent()) {
            LOGGER.error(message, e);
        } else {
            LOGGER.error(message);
        }
    }

    private void gameResume() {
        try {
            gameModel.resume();
            gameLoop.resume();
        } catch (NotOnPauseException | NotStartedException | InvalidModelMethodInvocationException e) {
            handleError("Error while resuming the game", Optional.of(e));
        }
    }

    private void gamePause() {
        try {
            gameLoop.pause();
            gameModel.pause();
        } catch (InvalidGameLoopStatusException | InvalidModelMethodInvocationException e) {
            handleError("Error while resuming the thread", Optional.of(e));
        }
    }

    private void gameRestart() {
        try {
            this.gameLoop.start();
            this.gameModel.restart();
        } catch (InvalidGameLoopStatusException | InvalidGameLoopConfigurationException
                | InvalidModelMethodInvocationException | ModelExecutionException e) {
            handleError("Error while restarting the match", Optional.of(e));
        }
    }

    @Override
    public void update(final ModelEvent event) {
        switch (event.getType()) {
            case VICTORY:
                view.changeView(ViewScene.START_MENU);
                try {
                    this.gameLoop.stop();
                } catch (NotStartedException e) {
                    ErrorMessageView.ShowError("Errore durante l'update della partita");
                }
                break;
            case GAMEOVER:
                break;
            default:
                break;
        }
    }

    @Override
    public GameModel getModel() {
        return this.gameModel;
    }

    @Override
    public InputHandler getInputHandler() {
        return this.inputHandler;
    }

    private void startLevel() {
        try {
            gameModel.start(this.levelName);
            gameLoop.start();
        } catch (InvalidGameLoopStatusException | InvalidGameLoopConfigurationException | ModelExecutionException
                | InvalidModelMethodInvocationException e) {
            handleError(levelName, Optional.of(e));
        }
    }

    @Override
    public View getView() {
        return this.view;
    }

    @Override
    public void start() {
        this.view.changeView(ViewScene.START_MENU);
    }

}
