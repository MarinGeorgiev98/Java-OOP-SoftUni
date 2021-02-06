package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private static final int BASE_EXPERIENCE = 10;

    @Test
    public void shouldReceiveExperienceIfDummyDies() {
        Weapon axe = new Axe(10,10);
        Target dummy = new Dummy(10,10);
        Hero hero = new Hero("dfd", BASE_EXPERIENCE, axe);

        hero.attack(dummy);
        Assert.assertEquals(BASE_EXPERIENCE + 10, hero.getExperience());
    }

    @Test
    public void shouldReceiveRootAfterKillingTarget() {
        Axe mockAxe = Mockito.mock(Axe.class);
        Mockito.when(mockAxe.getAttackPoints()).thenReturn(10);
        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.getLoot()).thenReturn(mockAxe);
        Mockito.when(mockTarget.isDead()).thenReturn(true);

        Hero hero = new Hero("kede", 0, mockAxe);
        hero.attack(mockTarget);

        Assert.assertEquals(hero.getInventory().size(), 1);
        Assert.assertTrue(hero.getInventory().contains(mockAxe));
    }
}