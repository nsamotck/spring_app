package org.example;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

public class CSVUtils {

    private CSVUtils() {
    }

    /***
     * Writes beans to CSV file
     * @param path - where to write
     * @param beans - what to write
     * @param <T> - type of CSVBean (see {@link org.example.CSVBean})
     * @throws Exception
     */
    public static <T extends CSVBean> void writeBeansToCsv(Path path, List<T> beans) throws Exception {
        try (Writer writer = new FileWriter(path.toString())) {
            StatefulBeanToCsv<T> beanWriter = new StatefulBeanToCsvBuilder<T>(writer)
                    .withSeparator(';')
                    .build();
            beanWriter.write(beans);
        }
    }
}
