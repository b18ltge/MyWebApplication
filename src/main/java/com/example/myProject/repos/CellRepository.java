package com.example.myProject.repos;

import java.util.List;

import com.example.myProject.models.Cell;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository("JDBCRepository")
public class CellRepository extends JDBCRepository<Cell> {
    @Override
    public int insert(Cell cell) {
        return jdbcTemplate.update("INSERT INTO Cells (health, max_health, radius, regen) VALUES(?,?,?,?)",
                cell.getHealth(), cell.getMax_health(), cell.getRadius(), cell.getRegen());
    }

    @Override
    public int update(Cell cell) {
        return jdbcTemplate.update("UPDATE Cells SET health=?, max_health=?, radius=?, regen=? WHERE id=?",
                cell.getHealth(), cell.getMax_health(), cell.getRadius(), cell.getRegen());
    }

    @Override
    public Cell findById(Integer id) {
        try {
            Cell cell = jdbcTemplate.queryForObject("SELECT * FROM Cells WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Cell.class), id);

            return cell;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("DELETE FROM Cells WHERE id=?", id);
    }

    @Override
    public List<Cell> findAll() {
        return jdbcTemplate.query("SELECT * from Cells", BeanPropertyRowMapper.newInstance(Cell.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE from Cells");
    }
}