package watchers;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import utilS.ScreenS;

public class WikiPaggeWatcher extends TestWatcher {
    @Override
    protected void succeeded(Description description) {
        ScreenS.takeScreenShot(description.getMethodName());
    }

    @Override
    protected void failed(Throwable e, Description description) {
        ScreenS.takeScreenShot(description.getMethodName());
    }
}
