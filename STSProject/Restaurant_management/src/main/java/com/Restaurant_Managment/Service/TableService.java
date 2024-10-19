package com.Restaurant_Managment.Service;

import java.util.List;
import com.Restaurant_Managment.entities.Tablee;

public interface TableService {
    List<Tablee> getTables();
    Tablee getTable(String tableId);
    Tablee addTable(Tablee table);
    Tablee updateTable(Tablee table);
    void deleteTable(String tableId);
}
