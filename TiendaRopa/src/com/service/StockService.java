package com.service;

import com.entity.Stock;
import com.repository.Stock.IStockRepository;
import com.repository.Stock.StockRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StockService {
    private final IStockRepository repository;

    public StockService(StockRepository stockRepository) {
        this.repository = new StockRepository();
    }
    
    public void add(Stock stock) throws SQLException {
        repository.save(stock);
    }

    public Optional<Stock> findById(int id) throws SQLException {
        return repository.findById(id);
    }

    public List<Stock> findAll()  throws SQLException {
        return repository.findAll();
    }

    public void delete(int id)  throws SQLException {
        repository.delete(id);
    }
}
