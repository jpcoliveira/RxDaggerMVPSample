package jafreela.com.br.rxdaggermvpsample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import jafreela.com.br.rxdaggermvpsample.home.HomeActivity;

/**
 * Created by joliveira on 20/12/17.
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity>
            mActivityRule = new ActivityTestRule<>(HomeActivity.class, false, true);

    @Test
    public void whenActivityIsLaunched_shouldDisplayInitialState() {
        new HomeActivityRobot()
                .checkProgress()
                .checkList()
                .clickFirstElementList();
    }
}
