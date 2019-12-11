package mgmt.utils;

import java.io.File;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static java.lang.System.currentTimeMillis;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class ProcessUtilTest {
    @Test
    void waitTerminationOrLogMarkerShouldReadTerminationMarker() {
        assertTimeoutPreemptively(ofSeconds(3), () -> {
            File log = new File("src\\test\\resources\\waitTerminationOrLogMarkerTest.log");

            ProcessUtil.waitTerminationOrLogMarker(
                    ProcessHandle.current(),
                    log,
                    Set.of("Guardian control mock started on"),
                    currentTimeMillis(),
                    3
            );
        });
    }
}