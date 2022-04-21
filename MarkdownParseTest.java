import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    void assertMarkdown(Path path, List<String> expected) {
        final String content;
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final var links = MarkdownParse.getLinks(content);
        assertArrayEquals(expected.toArray(), links.toArray());
    }

    @Test
    public void testTestFile() {
        assertMarkdown(Path.of("test-file.md"), List.of("https://something.com", "some-thing.html"));
    }
}