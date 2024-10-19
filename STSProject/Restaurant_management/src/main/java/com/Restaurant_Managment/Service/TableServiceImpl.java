package com.Restaurant_Managment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant_Managment.Dao.TableDao; // Make sure to create this DAO
import com.Restaurant_Managment.entities.Tablee;

@Service
public class TableServiceImpl implements TableService {

    @Autowired    
    private TableDao tableDao;

    @Override
    public List<Tablee> getTables() {
        return tableDao.findAll();  // Correct usage
    }

    @Override
    public Tablee getTable(String tableId) {
        // Using findById to fetch table by ID
        Optional<Tablee> optionalTable = tableDao.findById(tableId);
        // Return the table if found, or throw an exception or handle it as needed
        return optionalTable.orElseThrow(() -> new RuntimeException("Table not found with ID: " + tableId));
    }

    @Override
    public Tablee addTable(Tablee table) {
        tableDao.save(table);  // Saving new table
        return table;
    }

    @Override
    public Tablee updateTable(Tablee table) {
        tableDao.save(table);  // Updating existing table
        return table;
    }

    @Override
    public void deleteTable(String tableId) {
        // Using findById to check if table exists
        Optional<Tablee> optionalTable = tableDao.findById(tableId);
        Tablee table = optionalTable.orElseThrow(() -> new RuntimeException("Table not found with ID: " + tableId));
        tableDao.delete(table);  // Deleting the table
    }
}
