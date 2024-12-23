package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Oda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OdaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Oda oda) {
        String sql = "INSERT INTO oda (oda_id,hasta_id, oda_no) VALUES (?, ?,?)";
        return jdbcTemplate.update(sql, oda.getOdaId(),oda.getHastaId(), oda.getOdaNo());
    }

    public Oda findById(int odaId) {
        String sql = "SELECT * FROM oda WHERE oda_id = ?";
        return jdbcTemplate.queryForObject(sql, new OdaRowMapper(), odaId);
    }

    public List<Oda> findAll() {
        String sql = "SELECT * FROM oda";
        return jdbcTemplate.query(sql, new OdaRowMapper());
    }

    public int update(Oda oda) {
        String sql = "UPDATE oda SET hasta_id = ?, oda_no = ? WHERE oda_id = ?";
        return jdbcTemplate.update(sql, oda.getHastaId(), oda.getOdaNo(), oda.getOdaId());
    }

    public int delete(int odaId) {
        String sql = "DELETE FROM oda WHERE oda_id = ?";
        return jdbcTemplate.update(sql, odaId);
    }

    private static class OdaRowMapper implements RowMapper<Oda> {
        @Override
        public Oda mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Oda oda = new Oda();
            oda.setOdaId(rs.getInt("oda_id"));
            oda.setHastaId(rs.getInt("hasta_id"));
            oda.setOdaNo(rs.getInt("oda_no"));
            return oda;
        }
    }
}
