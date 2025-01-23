package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VideoPlayerTest {

    @Test
    public void test() {
        VideoPlayer videoPlayer = new VideoPlayer();
        Assertions.assertEquals("13:00", videoPlayer.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        Assertions.assertEquals("06:55", videoPlayer.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        Assertions.assertEquals("04:17", videoPlayer.solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
    }
}