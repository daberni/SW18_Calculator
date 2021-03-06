package calculator.tugraz.at.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("calculator.tugraz.at.calculator", appContext.getPackageName());
    }

    @Test
    public void testButtons() {
        for (int i = 0; i <= 9; i++) {
            onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("+")).perform(click());
        onView(withText("-")).perform(click());
        onView(withText("*")).perform(click());
        onView(withText("/")).perform(click());
        onView(withText("=")).perform(click());
        onView(withText("C")).perform(click());
    }

    @Test
    public void testInputField() {
        for (int i = 9; i >= 0; i--) {
            onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("9876543210")).check(matches(isDisplayed()));
    }

    @Test
    public void testClearButton() {
        onView(withText("3")).perform(click());
        onView(withText("C")).perform(click());
        onView(withId(R.id.txt_input)).check(matches(withText("0")));
    }

    @Test
    public void testMinusCalculation() {
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.button_minus)).perform(click());
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.button_equal)).perform(click());
        onView(withId(R.id.txt_input)).check(matches(withText("1")));
    }

}
