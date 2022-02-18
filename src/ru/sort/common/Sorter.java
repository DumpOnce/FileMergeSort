package ru.sort.common;

import java.io.*;

public abstract class Sorter {
    private String oFile;
    private String[] iFiles;
    private boolean sortType = true;

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os;
        os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    private void clearFile(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
    public Sorter(String oFile,String[] iFiles) {
        this.oFile = oFile;
        this.iFiles = iFiles;
    }

    public abstract void sortCouple(File write,File f1,File f2) throws IOException;
    public void sort() throws IOException {
        if (sortType == true) {
            File f = new File(oFile);
            if (iFiles.length == 1) {
                copyFileUsingStream(new File(iFiles[0]),f);
                return;
            }
            sortCouple(f, new File(iFiles[0]), new File(iFiles[1]));
            int count = 2;
            while (count < iFiles.length) {
                sortCouple(new File("C:\\Users\\Admin\\IdeaProjects\\newone\\auxillary.txt"), f, new File(iFiles[count]));
                clearFile(f);
                copyFileUsingStream(new File("C:\\Users\\Admin\\IdeaProjects\\newone\\auxillary.txt"),f);
                clearFile(new File("C:\\Users\\Admin\\IdeaProjects\\newone\\auxillary.txt"));
                count++;
            }
        }
    }
}
