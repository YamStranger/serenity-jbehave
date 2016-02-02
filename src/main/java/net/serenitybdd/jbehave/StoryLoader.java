package net.serenitybdd.jbehave;

import org.apache.commons.io.IOUtils;
import org.jbehave.core.io.InvalidStoryResource;
import org.jbehave.core.io.LoadFromClasspath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StoryLoader extends LoadFromClasspath {

    private final Charset charset;

    public StoryLoader(final Charset charset) {
        super();
        this.charset = charset;
    }

    public String loadResourceAsText(String resourcePath) {
        InputStream stream = resourceAsStream(resourcePath);
        try {
            return IOUtils.toString(stream, this.charset);
        } catch (IOException e) {
            throw new InvalidStoryResource(resourcePath, stream, e);
        }
    }
}
