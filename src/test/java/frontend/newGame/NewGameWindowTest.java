package frontend.newGame;

import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frontend.interfaces.Game;

import static org.mockito.Mockito.mock;

public class NewGameWindowTest {

    private FrameFixture window;
    private NewGameWindow frame;
    private Game newgame;
    private ComponentFinder finder;

    @Before
    public void setUp() {
        newgame = mock(Game.class);
        frame = new NewGameWindow(newgame);
        window = new FrameFixture(frame);
        window.show();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testDefaultData() {
        window.spinner("moves").requireValue(20);
        window.spinner("rows").requireValue(4);
        window.spinner("columns").requireValue(4);
    }

    @Test
    public void testDecremating() {
        window.spinner("moves").decrement(20);
        window.spinner("rows").decrement(20);
        window.spinner("columns").decrement(20);

        window.spinner("moves").requireValue(5);
        window.spinner("rows").requireValue(3);
        window.spinner("columns").requireValue(3);

    }

    @Test
    public void testIncremanting() {
        window.spinner("moves").increment(20);
        window.spinner("rows").increment(20);
        window.spinner("columns").increment(20);

        window.spinner("moves").requireValue(40);
        window.spinner("rows").requireValue(9);
        window.spinner("columns").requireValue(9);
    }

    @Test
    public void testOneIncrement() {
        window.spinner("moves").increment();
        window.spinner("rows").increment();
        window.spinner("columns").increment();

        window.spinner("moves").requireValue(21);
        window.spinner("rows").requireValue(5);
        window.spinner("columns").requireValue(5);

    }

    @Test
    public void testOneDecrement() {
        window.spinner("moves").decrement();
        window.spinner("rows").decrement();
        window.spinner("columns").decrement();

        window.spinner("moves").requireValue(19);
        window.spinner("rows").requireValue(3);
        window.spinner("columns").requireValue(3);

    }

    @Test
    public void testButtonOK() {
        window.button("start").click();
        window.requireNotVisible();
    }
}
