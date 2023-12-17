package com.vladproduction.model;

import java.util.Objects;

public class Table {

    private final String id;
    private final int tableCapacity;

    public Table(String id, int tableCapacity) {
        this.id = id;
        this.tableCapacity = tableCapacity;
    }

    public String getId() {
        return id;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Table table = (Table) object;
        return tableCapacity == table.tableCapacity && Objects.equals(id, table.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + tableCapacity;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
