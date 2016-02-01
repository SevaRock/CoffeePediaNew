package com.sevarock.coffeepedia;

/**
 * Created by Seva Powerman on 28.01.2016.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.espresso.ViewAssertion;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;
import android.support.test.espresso.ViewFinder;
import android.support.test.espresso.*;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.ViewAction;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import com.sevarock.coffeepedia.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AboutScreenTestActivity {

    @Rule
    public ActivityTestRule<About> mActivityRule = new ActivityTestRule(About.class);

    @Test
    public void isAllItemsDisplayed ()  {

        //Checking Title View
        onView(withId(R.id.aboutTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.aboutTitle)).check(matches(withText("CoffeePedia - the coffee Encyclopedia")));

        //Checking Created Field
        onView(withId(R.id.createdField)).check(matches(isDisplayed()));
        onView(withId(R.id.createdField)).check(matches(withText("Created by Seva Powerman")));

        //Checking image Presented
        onView(withId(R.id.aboutImage)).check(matches(isDisplayed()));

        //Checking Email is Presented And Clickable
        onView(withId(R.id.emailField)).check(matches(isDisplayed())).check(matches(isClickable()));


    }


}
