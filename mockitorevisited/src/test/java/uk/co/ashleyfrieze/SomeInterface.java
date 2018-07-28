package uk.co.ashleyfrieze;

import java.io.IOException;
import java.util.List;

public interface SomeInterface {
    int getMatchingSize(int x, int y);

    void receiveList(List<String> list);

    boolean isFileValid(String filename) throws IOException;
}
