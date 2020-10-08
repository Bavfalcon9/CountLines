package com.bavfalcon9;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Counter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

    // simulate a fake arr
    private static final String[] skipExtDefault = { ".md", "." };
    // List of files, this is empty to begin with.
    private final ArrayList<File> current = new ArrayList<File>();

    private File path;
    private String[] skipExtensions;

    public Counter(File path) {
        new Counter(path, skipExtDefault);
    }

    public Counter(File path, String[] excludes) {
        this.path = path;
        this.skipExtensions = excludes;
    }

    private File[] getFiles() {
        ArrayList<File> currentFiles = new ArrayList<File>();

        if (path.isDirectory()) {
            // directory!!!
            File[] entries = path.listFiles();

            if (entries == null) {
                // something bad happend we can return here
                return new File[]{};
            } else {
                // recursiveness begins here.
                for (final File entry : entries) {
                    if (entry.isDirectory()) {
                        // get our files
                        File[] foundFiles = getFiles();
                        continue;
                    }
                }
                return entries;
            }
        } else {
            // its a single file, how disappointing....
            File[] entries = { path };
            return new File[]{ path };
        }
    }

    private File[] getFiles(File path) {
        // alias for getfiles
        return getFiles(path, new ArrayList<File>());
    }

    private File[] getFiles(File path, ArrayList<File> currentFiles) {
        if (path.isDirectory()) {
            File[] entries = path.listFiles();
            if (entries == null) {
                return new File[]{};
            }
            for (final File entry : entries) {
                if (entry.isDirectory()) {
                    // get our files
                    File[] foundFiles = getFiles(entry);
                    Collections.addAll(currentFiles, foundFiles);
                } else {
                    currentFiles.add(entry);
                }
            }

            return currentFiles.toArray(new File[]{});
        } else {
            return new File[]{ path };
        }
    }

    public int countAllLines(boolean includeComments, boolean output) {
        return 0;
    }
}
