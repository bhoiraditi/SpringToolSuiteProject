package com.Restaurant_Managment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant_Managment.Service.TableService;
import com.Restaurant_Managment.entities.Tablee;

@RestController
public class TableController {

    @Autowired
    private TableService tableService;

    // Get the list of tables
    @GetMapping("/Table")
    public List<Tablee> getTables() {
        return this.tableService.getTables();
    }

    // Get a table by ID
    @GetMapping("/Table/{id}")
    public Tablee getTable(@PathVariable String id) {
        return this.tableService.getTable(id);
    }

    // Add a new table
    @PostMapping("/Table")
    public Tablee addTable(@RequestBody Tablee table) {
        return this.tableService.addTable(table);
    }

    // Update an existing table by ID
    @PutMapping("/Table/{id}")
    public ResponseEntity<Tablee> updateTable(@PathVariable String id, @RequestBody Tablee table) {
        try {
            // Ensure that the correct tableId is set
            table.setTableId(id);
            Tablee updatedTable = this.tableService.updateTable(table);
            return new ResponseEntity<>(updatedTable, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a table by ID
    @DeleteMapping("/Table/{id}")
    public ResponseEntity<HttpStatus> deleteTable(@PathVariable String id) {
        try {
            this.tableService.deleteTable(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
