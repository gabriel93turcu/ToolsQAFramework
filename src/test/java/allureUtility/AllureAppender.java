package allureUtility;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.appender.AbstractAppender;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@Plugin(name = "AllureAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class AllureAppender extends AbstractAppender {

    protected AllureAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @PluginFactory
    public static AllureAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {

        if (name == null) {
            LOGGER.error("No name provided for AllureAppender");
            return null;
        }

        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }

        return new AllureAppender(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent event) {
        byte[] bytes = getLayout().toByteArray(event);
        String formattedMessage = new String(bytes, StandardCharsets.UTF_8);
        Allure.step(formattedMessage.trim());
    }
}
