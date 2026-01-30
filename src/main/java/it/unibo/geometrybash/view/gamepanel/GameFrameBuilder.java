package it.unibo.geometrybash.view.gamepanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import it.unibo.geometrybash.view.utilities.GameResolution;
import it.unibo.geometrybash.view.utilities.TerminalColor;

public class GameFrameBuilder {

    private String title = "Default-Game-Title";
    private GameResolution gameResolution = GameResolution.BIG;
    private Runnable runnable;
    private JPanel mainPanel;
    private Color backGroundColor = TerminalColor.BACKGROUND;
    private boolean isResizable = false;

    public GameFrameBuilder() {
    }

    private void addCustomizableOnCLoseOperation(JFrame frame, Runnable runnable) {
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        runnable.run();
                    }
                });
    }

    public GameFrameBuilder setGameTitle(final String title) {
        this.title = title;
        return this;
    }

    public GameFrameBuilder setResolution(final GameResolution gameResolution) {
        this.gameResolution = gameResolution;
        return this;
    }

    public GameFrameBuilder setOnCloseAction(final Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    public GameFrameBuilder setMainPanel(final JPanel mainPanel) {
        this.mainPanel = mainPanel;
        return this;
    }

    public GameFrameBuilder setBackGroundColor(final Color color) {
        this.backGroundColor = color;
        return this;
    }

    public GameFrameBuilder setResizable(final boolean isResizable) {
        this.isResizable = isResizable;
        return this;
    }

    public JFrame build() {
        JFrame mainFrame = new JFrame(this.title);
        mainFrame.setSize(new Dimension(gameResolution.getViewPortWidth(), gameResolution.getViewPortHeight()));
        mainFrame.setBackground(backGroundColor);
        if (runnable == null) {
            mainFrame.setDefaultCloseOperation(
                    WindowConstants.EXIT_ON_CLOSE);
        } else {
            addCustomizableOnCLoseOperation(mainFrame, runnable);
        }

        mainFrame.setResizable(isResizable);
        mainFrame.setLayout(new BorderLayout());
        if (mainPanel != null) {
            mainFrame.add(mainPanel, BorderLayout.CENTER);
        }

        mainFrame.setLocationRelativeTo(null);

        return mainFrame;

    }

}
