package org.example.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.example.contract.CSVBean;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVUtils {

    private CSVUtils() {
    }

    /***
     * Writes beans to CSV file
     * @param path - where to write
     * @param beans - what to write
     * @param <T> - type of CSVBean (see {@link CSVBean})
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

    /***
     * Returns a Set of java beans read from a csv-file
     * @param path - path to csv
     * @param clazz - type of bean
     * @return - Set of beans read from a file
     * @param <T> - type parameter for bean class
     * @throws IOException - if reading failed
     */
    public static <T extends CSVBean> Set<T> readBeansFromCSV(Path path, Class<T> clazz) throws IOException {
        CsvToBean<T> cb;
        try (Reader reader = Files.newBufferedReader(path)) {
            cb = new CsvToBeanBuilder<T>(reader)
                    .withSeparator(';')
                    .withType(clazz)
                    .build();
        }
        return new HashSet<>(cb.parse());
    }
}
