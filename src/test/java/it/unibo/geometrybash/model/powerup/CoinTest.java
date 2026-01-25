package it.unibo.geometrybash.model.powerup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.unibo.geometrybash.model.geometry.Vector2;
import it.unibo.geometrybash.model.player.Player;
import it.unibo.geometrybash.model.player.PlayerImpl;

/**
 * Test for {@link Coin}.
 */
class CoinTest {

    private static final Vector2 POS = new Vector2(10, 10);

    @Test
    void testCreation() {
        final Coin coin = new Coin(POS);
        assertEquals(POS, coin.getPosition());
        assertEquals(PowerUpType.COIN, coin.getPowerUpType());
        assertEquals(Coin.DEFAULT_VALUE, coin.getValue());
        assertTrue(coin.isActive());
    }

    @Test
    void testCopy() {
        final Coin coin = new Coin(POS);
        final Coin copy = coin.copy();
        assertNotSame(coin, copy);
        assertEquals(coin.getPosition(), copy.getPosition());
        assertEquals(coin.isActive(), copy.isActive());
    }

    @Test
    void testOnCollision() {
        final Coin coin = new Coin(POS);
        final Player<?> player = new PlayerImpl(new Vector2(0, 0), null);
        assertEquals(0, player.getCoins());
        assertTrue(coin.isActive());
        coin.onCollision(player);
        assertEquals(Coin.DEFAULT_VALUE, player.getCoins());
        assertFalse(coin.isActive());

    }
}
