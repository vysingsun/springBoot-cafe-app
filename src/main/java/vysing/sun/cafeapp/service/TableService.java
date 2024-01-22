package vysing.sun.cafeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vysing.sun.cafeapp.exception.DrinkNotFoundException;
import vysing.sun.cafeapp.model.Tables_management;
import vysing.sun.cafeapp.repo.TableRepo;

@Service
public class TableService {
    private final TableRepo tableRepo;

    @Autowired
    public TableService(TableRepo tableRepo) {
        this.tableRepo = tableRepo;
    }

    public Tables_management addTable(Tables_management tables_management){
        return tableRepo.save(tables_management);
    }

    public List<Tables_management> findAllTable(){
        return tableRepo.findAll();
    }

    public Tables_management updateTable(Tables_management tables_management){
        return tableRepo.save(tables_management);
    }

    public Tables_management findTableById(Long id){
        return tableRepo.findTablesById(id).orElseThrow(() -> new DrinkNotFoundException("Drink by id " + id + " was not found."));
    }

    public void deleteTablesById(Long id){
        tableRepo.deleteTablesById(id);
    }
}
