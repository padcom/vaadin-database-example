package com.vaadin.example.components;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

import com.vaadin.example.data.entity.Movie;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.DomEventListener;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

@JsModule("./src/hello-world.ts")
@Tag("hello-world")
public class HelloWorld extends Component {
    protected JsonValue createColumn(String id) {
        JsonObject result = Json.createObject();
        result.put("id", id);

        return result;
    }

    protected JsonArray createColumns() throws IntrospectionException {
        JsonArray result = Json.createArray();
        BeanInfo beanInfo = Introspector.getBeanInfo(Movie.class);
        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(column -> {
            result.set(result.length(), createColumn(column.getName()));
        });

        return result;
    }

    public void setColumns(String columns) throws IntrospectionException {
        getElement().setPropertyJson("columns", createColumns());
    }

    public void setItems(JsonArray items) {
        getElement().setPropertyJson("data", items);
    }

    public void addClickListener(DomEventListener listener) {
        this.getElement().addEventListener("click", listener);
    }
}
