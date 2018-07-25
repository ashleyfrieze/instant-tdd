package uk.co.ashleyfrieze.springcontext.service;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataSource {
    private List<String> data = new LinkedList<>();

    public List<String> getAll() {
        return Collections.unmodifiableList(data);
    }

    public void add(String item) {
        data.add(item);
    }
}
