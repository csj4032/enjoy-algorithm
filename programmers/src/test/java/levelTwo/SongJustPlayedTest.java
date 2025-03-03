package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SongJustPlayedTest {

    @Test
    public void test() {
        SongJustPlayed songJustPlayed = new SongJustPlayed();
//        Assertions.assertEquals("HELLO", songJustPlayed.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        Assertions.assertEquals("FOO", songJustPlayed.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
//        Assertions.assertEquals("WORLD", songJustPlayed.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        Assertions.assertEquals("(None)", songJustPlayed.solution("CDE", new String[]{"12:00,12:04,FIRST,ABCDEF"}));
//        Assertions.assertEquals("TWO", songJustPlayed.solution("ABC", new String[]{"12:00,12:04,ONE,ABCD", "12:10,12:20,TWO,ABCDE", "12:30,12:40,THREE,ABCDE"}));
//        Assertions.assertEquals("ONE", songJustPlayed.solution("DD#EFF#", new String[]{"12:00,12:10,ONE,CC#DD#EFF#GG#AA#", "12:20,12:30,TWO,CC#DD#EFF#GG#AA#"}));
//        Assertions.assertEquals("ONE", songJustPlayed.solution("DD#", new String[]{"12:00,12:04,ONE,CC#DD#EFF#GG#AA#", "12:04,12:08,TWO,CC#DD#EFF#GG#AA#"}));
//        Assertions.assertEquals("ONE", songJustPlayed.solution("DD#", new String[]{"12:00,12:04,ONE,DD#EFF#GG#AA#", "12:00,12:02,TWO,DD#"}));
//        Assertions.assertEquals("SING", songJustPlayed.solution("A", new String[]{"12:00,12:01,SING,A", "12:00,12:01,SONG,A"}));
//        Assertions.assertEquals("SONG", songJustPlayed.solution("A", new String[]{"12:00,12:01,SING,A", "12:00,12:02,SONG,A"}));
//        Assertions.assertEquals("SONG", songJustPlayed.solution("A", new String[]{"12:00,12:01,SING,A", "12:00,13:00,SONG,A"}));
//        Assertions.assertEquals("(None)", songJustPlayed.solution("BA", new String[]{"12:00,12:02,SING,AB"}));
//        Assertions.assertEquals("SING", songJustPlayed.solution("BA", new String[]{"12:00,12:03,SING,AB"}));
//        Assertions.assertEquals("(None)", songJustPlayed.solution("A", new String[]{"12:00,12:01,SING,BA"}));
//        Assertions.assertEquals("(None)", songJustPlayed.solution("BA", new String[]{"12:00,12:04,SING,A#B"}));
        Assertions.assertEquals("(None)", songJustPlayed.solution("A", new String[]{"12:00,12:01,SING,A#"}));
        Assertions.assertEquals("SONG", songJustPlayed.solution("A#", new String[]{"12:00,12:01,SONG,A#"}));
    }
    //"A", ["12:00,12:01,Song,A#"] -> "(None)"
}