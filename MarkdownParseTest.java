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
    public void testFile1() {
        assertMarkdown(Path.of("test-file.md"), List.of("https://something.com", "some-thing.html"));
    }

    @Test
    public void testFile2() {
        assertMarkdown(Path.of("test-file2.md"), List.of("https://something.com", "some-page.html"));
    }

    @Test
    public void testFile3() {
        assertMarkdown(Path.of("test-file3.md"), List.of());
    }

    @Test
    public void testFile4() {
        assertMarkdown(Path.of("test-file4.md"), List.of());
    }

    @Test
    public void testFile5() {
        assertMarkdown(Path.of("test-file5.md"), List.of());
    }

    @Test
    public void testFile6() {
        assertMarkdown(Path.of("test-file6.md"), List.of());
    }

    @Test
    public void testFile7() {
        assertMarkdown(Path.of("test-file7.md"), List.of());
    }

    @Test
    public void testFile8() {
        assertMarkdown(Path.of("test-file8.md"), List.of("a link on the first line"));
    }
}