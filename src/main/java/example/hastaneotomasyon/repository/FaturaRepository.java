package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Fatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FaturaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Fatura> findAll() {
        String sql = "SELECT * FROM fatura";
        return jdbcTemplate.query(sql, new FaturaRowMapper());
    }

    public Fatura findById(int faturaId) {
        String sql = "SELECT * FROM fatura WHERE fatura_id = ?";
        return jdbcTemplate.queryForObject(sql, new FaturaRowMapper(), faturaId);
    }

    public int save(Fatura fatura) {
        String sql = "INSERT INTO fatura (fatura_id,tutar, hasta_id) VALUES (?, ?,?)";
        return jdbcTemplate.update(sql, fatura.getFaturaId(),fatura.getTutar(), fatura.getHastaId());
    }

    public int update(Fatura fatura) {
        String sql = "UPDATE fatura SET tutar = ?, hasta_id = ? WHERE fatura_id = ?";
        return jdbcTemplate.update(sql, fatura.getTutar(), fatura.getHastaId(), fatura.getFaturaId());
    }

    public int delete(int faturaId) {
        String sql = "DELETE FROM fatura WHERE fatura_id = ?";
        return jdbcTemplate.update(sql, faturaId);
    }

    private static class FaturaRowMapper implements RowMapper<Fatura> {
        @Override
        public Fatura mapRow(ResultSet rs, int rowNum) throws SQLException {
            Fatura fatura = new Fatura();
            fatura.setFaturaId(rs.getInt("fatura_id"));
            fatura.setTutar(rs.getDouble("tutar"));
            fatura.setHastaId(rs.getInt("hasta_id"));
            return fatura;
        }
    }
}
