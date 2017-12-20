package jafreela.com.br.rxdaggermvpsample;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by joliveira on 20/12/17.
 */

public class HomeActivityRobot {

    HomeActivityRobot checkProgress() {
        onView(withId(R.id.progress)).check(matches(isDisplayed()));
        return this;
    }

    HomeActivityRobot checkList() {
        onView(withId(R.id.list)).check(matches(withId(R.id.list)));
        return this;
    }

    HomeActivityRobot clickFirstElementList() {
        onView(allOf(withId(R.id.list),hasSibling(withText("Jakarta")) ))
                .perform(click());
        return this;
    }
}
