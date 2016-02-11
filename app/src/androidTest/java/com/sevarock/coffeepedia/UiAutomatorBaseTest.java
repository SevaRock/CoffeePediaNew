package com.sevarock.coffeepedia;

//import android.support.test.espresso.R;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
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
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import com.sevarock.coffeepedia.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Seva Powerman on 19.01.2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UiAutomatorBaseTest {

    private UiDevice mDevice;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void startMainActivityFromHomeScreen() throws RemoteException {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.wakeUp();

    }

    @Test
    public void findButtonListDrinks() {
        onView(withText("List Of Coffee Drinks")).check(matches(isDisplayed()));
    }

    @Test
    public void buttonsListDrinksTest() {
        //Finfing Button List Of Drinks in Main Activity
        onView(withText("List Of Coffee Drinks")).check(matches(isDisplayed()));
        //Press Nav.Drawer Button
        onView(withContentDescription("Open navigation drawer")).perform(click());
        //Check Nav.Drawer is Displayed
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
        pressBack();
        //Preform click on List Button
        onView(withText("List Of Coffee Drinks")).perform(click());
        //Click on Capuccino Button
        onView(withId(R.id.capuccino)).perform(click());
        onView(withId(R.id.ArticleHeaderText)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleHeaderImage)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleBody)).check(matches(isDisplayed()));
        pressBack();
        //Click on Americano Button
        onView(withId(R.id.americano)).perform(click());
        onView(withId(R.id.ArticleHeaderText)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleHeaderImage)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleBody)).check(matches(isDisplayed()));
        pressBack();
        //Click on Espresso Button
        onView(withId(R.id.Espresso)).perform(click());
        onView(withId(R.id.ArticleHeaderText)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleHeaderImage)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleBody)).check(matches(isDisplayed()));
        pressBack();
        //Click on Macchiato Button
        onView(withId(R.id.Macchiato)).perform(scrollTo(), click());
        onView(withId(R.id.ArticleHeaderText)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleHeaderImage)).check(matches(isDisplayed()));
        onView(withId(R.id.ArticleBody)).check(matches(isDisplayed()));
        pressBack();
    }

    @Test
    public void navDraverMenuTest () {

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Take Coffee Foto")).check(matches(isDisplayed()));
        onView(withText("Coffee Art Gallery")).check(matches(isDisplayed()));
        onView(withText("Slideshow")).check(matches(isDisplayed()));
        onView(withText("Tools")).check(matches(isDisplayed()));
        onView(withText("About")).check(matches(isDisplayed()));

    }



}




