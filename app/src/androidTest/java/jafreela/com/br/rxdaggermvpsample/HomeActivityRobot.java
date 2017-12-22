package jafreela.com.br.rxdaggermvpsample;

import android.content.res.Resources;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.internal.matchers.TypeSafeMatcher;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.view.View.FIND_VIEWS_WITH_TEXT;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by joliveira on 20/12/17.
 */

public class HomeActivityRobot {
    HomeActivityRobot clickLastElement() throws InterruptedException {
        Thread.sleep(3000);
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.list)));
        recyclerView.perform(actionOnItemAtPosition(5, click()));
        return this;
    }

    HomeActivityRobot checkItem() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.city), withText("Paris"), isDisplayed()));
        textView.check(matches(withText("Paris")));
        return this;
    }
}
