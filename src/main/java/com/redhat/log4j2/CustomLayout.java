package com.redhat.log4j2;

import java.nio.charset.Charset;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;

@Plugin(name = "CustomLayout", category = Core.CATEGORY_NAME, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class CustomLayout extends AbstractStringLayout {

    private static String prefix;

    protected CustomLayout(Charset charset) {
        super(charset);
    }

    public String toSerializable(LogEvent event) {
        return prefix + ":" + event.getMessage() + System.lineSeparator();
    }

    @PluginFactory
    public static CustomLayout createLayout(
            @PluginAttribute(value = "prefix", defaultString = "DefaultPrefix") String prefix,
            @PluginAttribute(value = "charset", defaultString = "UTF-8") Charset charset) {
        CustomLayout.prefix = prefix;
        return new CustomLayout(charset);
    }
}
