package uk.co.ashleyfrieze.testfolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for persisting and reading a bunch of strings
 */
public class ReaderWriter {
    /**
     * Writes the lines of the list to the target filename in the directory
     * @param directory target directory
     * @param filename target filename
     * @param lines lines of the file
     * @return the file path of what was written
     * @throws IOException on error
     */
    public static File write(File directory, String filename, List<String> lines) throws IOException {
        File file = new File(directory, filename);
        try (FileWriter writer = new FileWriter(file)) {
            for(String line:lines) {
                writer.write(line + "\n");
            }
        }
        return file;
    }

    /**
     * Reads the lines of a given file to a list
     * @param file the file to read
     * @return the lines of the file
     * @throws IOException on error
     */
    public static List<String> read(File file) throws IOException {
        return Files.lines(file.toPath())
                .collect(Collectors.toList());
    }
}
