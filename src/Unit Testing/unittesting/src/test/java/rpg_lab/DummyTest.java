package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_EXPERIENCE = 10;
    private Dummy dummy;

    public void setupAliveDummy() {
        this.dummy = new Dummy(BASE_HEALTH, BASE_EXPERIENCE);
    }

    public void setupDeadDummy() {
        this.dummy = new Dummy(-BASE_HEALTH, BASE_EXPERIENCE);
    }

    @Test
    public void checkIfLosesHealth() {
        setupAliveDummy();

        dummy.takeAttack(5);
        Assert.assertEquals(BASE_HEALTH - 5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowEx() {
        setupDeadDummy();

        dummy.takeAttack(10);
    }

    @Test
    public void shouldGiveXP() {
        setupDeadDummy();

        dummy.giveExperience();
        Assert.assertEquals(BASE_EXPERIENCE, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExIfGiveXP() {
        setupAliveDummy();

        dummy.giveExperience();
    }
}